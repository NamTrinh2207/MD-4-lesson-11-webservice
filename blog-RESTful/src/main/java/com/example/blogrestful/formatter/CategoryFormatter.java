package com.example.blogrestful.formatter;

import com.example.blogrestful.model.Category;
import com.example.blogrestful.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;
import java.util.Optional;
@Component
public class CategoryFormatter implements Formatter<Category> {
    @Autowired
    private ICategoryService categoryService;

    public CategoryFormatter(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public Category parse(String text, Locale locale) throws ParseException {
        Optional<Category> category = categoryService.findById(Long.parseLong(text));
        return category.orElse(null);
    }

    @Override
    public String print(Category object, Locale locale) {
        return object.getId() + object.getName();
    }
}
