package com.example.blogrestful.controller;

import com.example.blogrestful.model.Category;
import com.example.blogrestful.service.blog.IBlogService;
import com.example.blogrestful.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> showAll() {
        List<Category> categoryList = (List<Category>) categoryService.fidAll();
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }
}
