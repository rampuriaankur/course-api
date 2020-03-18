package com.ank.util;

import java.util.ArrayList;
import java.util.List;

import com.ank.dao.entities.AuthorEntity;
import com.ank.dao.entities.CategoryEntity;
import com.ank.dao.entities.CourseEntity;
import com.ank.model.Course;

public class Utility {

	public static List<Course> mapCourseEntityList(List<CourseEntity> courseEntityList) {
		List<Course> courseList = new ArrayList<>();
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

	public static  Course mapCourseEntity(CourseEntity entity) {
		Course course = new Course();
		course.setId(entity.getCourseId());
		course.setSlug(entity.getSlug());
		course.setTitle(entity.getTitle());
		AuthorEntity author = entity.getAuthor();
		if (author != null) {
			course.setAuthorId(author.getAuthorId());
			course.setAuthorName(author.getAuthorName());
		}
		if (author != null) {
			course.setAuthorId(author.getAuthorId());
			course.setAuthorName(author.getAuthorName());
		}
		CategoryEntity category = entity.getCategory();
		if (category != null) {
			course.setCategoryId(category.getCategoryId());
			course.setAuthorName(category.getCategoryName());
		}

		return course;
	}

}
