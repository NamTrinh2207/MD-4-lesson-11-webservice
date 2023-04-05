package com.example.blogrestful.repository;

import com.example.blogrestful.model.Blog;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BloggerRepository extends PagingAndSortingRepository<Blog, Long> {
}
