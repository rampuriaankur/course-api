package com.ank.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ank.dao.entities.CategoryEntity;

public interface CategoryRepo extends JpaRepository<CategoryEntity, String> {

}
