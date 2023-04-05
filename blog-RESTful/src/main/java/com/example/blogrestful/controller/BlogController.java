package com.example.blogrestful.controller;

import com.example.blogrestful.model.Blog;
import com.example.blogrestful.model.Category;
import com.example.blogrestful.service.blog.IBlogService;
import com.example.blogrestful.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/blogger")
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;

    @ModelAttribute("category")
    public Iterable<Category> showAllCategory() {
        return categoryService.fidAll();
    }

    @GetMapping
    private ResponseEntity<Iterable<Blog>> showAll() {
        List<Blog> blogList = (List<Blog>) blogService.fidAll();
        if (blogList == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(blogList, HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Blog> viewByBlogger(@PathVariable Long id){
        Optional<Blog> optionalBlog = blogService.findById(id);
        return optionalBlog.map(blog -> new ResponseEntity<>(blog, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @PostMapping
    public ResponseEntity<Blog> create(@RequestBody Blog blog) {
        Blog blog1 = blogService.save(blog);
        return new ResponseEntity<>(blog1, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Blog> create(@PathVariable Long id, @RequestBody Blog blog) {
        Optional<Blog> blogOptional = blogService.findById(id);
        if (!blogOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        blog.setId(blogOptional.get().getId());
        Blog blog1 = blogService.save(blog);
        return new ResponseEntity<>(blog1, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Blog> delete(@PathVariable Long id) {
        Optional<Blog> blogOptional = blogService.findById(id);
        if (!blogOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        blogService.delete(id);
        return new ResponseEntity<>(blogOptional.get(), HttpStatus.NO_CONTENT);
    }

}
