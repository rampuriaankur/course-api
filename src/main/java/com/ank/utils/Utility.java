package com.ank.utils;

import java.util.ArrayList;
import java.util.List;

import com.ank.dao.entities.AuthorEntity;
import com.ank.dao.entities.CategoryEntity;
import com.ank.dao.entities.CourseEntity;
import com.ank.model.Author;
import com.ank.model.Course;

public class Utility {

	public static List<Course> mapCourseEntityList(List<CourseEntity> courseEntityList) {

		List<Course> courseList = new ArrayList<>();

		if (courseEntityList == null || courseEntityList.size() <= 0)
			return courseList;

		courseEntityList.forEach(entity -> {
			Course course = new Course();
			course.setId(entity.getCourseId());
			course.setSlug(entity.getSlug());
			course.setTitle(entity.getTitle());
			AuthorEntity author = entity.getAuthor();
			if (author != null) {
				course.setAuthorId(author.getAuthorId());
				course.setAuthorName(author.getAuthorName());
			}
			CategoryEntity category = entity.getCategory();
			if (category != null) {
				course.setCategoryId(category.getCategoryId());
				course.setCategoryName(category.getCategoryName());
			}

			courseList.add(course);
		});

		return courseList;
	}

	public static Course mapCourseEntity(CourseEntity entity) {
		if (entity == null)
			return null;
		Course course = new Course();
		course.setId(entity.getCourseId());
		course.setSlug(entity.getSlug());
		course.setTitle(entity.getTitle());
		AuthorEntity author = entity.getAuthor();
		if (author != null) {
			course.setAuthorId(author.getAuthorId());
			course.setAuthorName(author.getAuthorName());
		}
		CategoryEntity category = entity.getCategory();
		if (category != null) {
			course.setCategoryId(category.getCategoryId());
			course.setCategoryName(category.getCategoryName());
		}

		return course;
	}

	public static List<Author> mapAuthorEntityList(List<AuthorEntity> authorEntityList) {
		List<Author> authorList = new ArrayList<>();
		if (authorEntityList == null || authorEntityList.size() <= 0)
			return authorList;
		authorEntityList.forEach(entity -> {
			Author author = new Author();
			author.setId(entity.getAuthorId());
			author.setAuthorName(entity.getAuthorName());
			authorList.add(author);
		});

		return authorList;

	}

}
