package com.ank.dao.repo;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ank.dao.entities.CourseEntity;

public interface CourseRepo extends JpaRepository<CourseEntity, String>  {

	/*
	Page<CourseEntity> findByAuthorId(int authorId, Pageable pageable);
    Optional<CourseEntity> findByIdAndAuthorId(int id, int AuthorId);
	


	Page<CourseEntity> findByCategoryId(int categoryId, Pageable pageable);
    Optional<CourseEntity> findByIdAndCategoryId(int id, int CategoryId);
*/
}
