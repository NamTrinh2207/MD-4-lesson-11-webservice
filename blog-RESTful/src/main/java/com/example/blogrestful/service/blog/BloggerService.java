package com.example.blogrestful.service.blog;

import com.example.blogrestful.model.Blog;
import com.example.blogrestful.repository.BloggerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BloggerService implements IBlogService {
    @Autowired
    private BloggerRepository bloggerRepository;

    @Override
    public Iterable<Blog> fidAll() {
        return bloggerRepository.findAll();
    }

    @Override
    public Optional<Blog> findById(Long id) {
        return bloggerRepository.findById(id);
    }

    @Override
    public Blog save(Blog blog) {
        return bloggerRepository.save(blog);
    }

    @Override
    public void delete(Long id) {
        bloggerRepository.deleteById(id);
    }
}
