package com.ank.services;

import com.ank.dao.entities.CategoryEntity;
import com.ank.dao.repo.CategoryRepo;
import com.ank.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    public List<Category> getCategories() {
        List<CategoryEntity> categoryEntities = categoryRepo.findAll();

        if (categoryEntities == null || categoryEntities.size() <= 0)
            return new ArrayList<Category>();

        List<Category> categories = categoryEntities.stream().map(entity -> {
            return new Category(entity.getCategoryId(), entity.getCategoryName());
        }).collect(Collectors.toList());

        return categories;
    }
}
