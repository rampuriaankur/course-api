package com.ank.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ank.dao.entities.CategoryEntity;
import com.ank.dao.entities.CourseEntity;
import com.ank.dao.repo.AuthorRepo;
import com.ank.dao.repo.CategoryRepo;
import com.ank.dao.repo.CourseRepo;
import com.ank.model.Course;
import com.ank.util.Utility;

@RestController()
public class CourseController {

	@Autowired
	private CourseRepo courseRepo;

	@Autowired
	private AuthorRepo authorRepo;

	@Autowired
	private CategoryRepo categoryRepo;

	@GetMapping(value = "/courses", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Course>> getCourse() {
		List<Course> courseList = new ArrayList<Course>();
		List<CourseEntity> courseEntityList = courseRepo.findAll();
		courseList = Utility.mapCourseEntityList(courseEntityList);
		return ResponseEntity.status(HttpStatus.OK).body(courseList);
	}

	@GetMapping(value = "/courses/{courseId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Course> getCourseByCourseId(@PathVariable("courseId") String courseId) {

		CourseEntity courseEntity = courseRepo.findById(courseId).orElse(null);
		Course course = Utility.mapCourseEntity(courseEntity);
		return ResponseEntity.status(HttpStatus.OK).body(course);
	}

	@PostMapping(value = "/courses", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Course> createCourse(@RequestBody Course course) {
		CourseEntity savedCourseEntity = new CourseEntity();
		try {
			CourseEntity entity = new CourseEntity();
			entity.setAuthor(
					authorRepo.findById(course.getAuthorId()).orElseThrow(() -> new Exception("Author Id is invalid")));

			entity.setCategory(categoryRepo.findById(course.getCategoryId())
					.orElseThrow(() -> new Exception("Category Id is Invalid")));
			entity.setTitle(course.getTitle());
			entity.setSlug(course.getSlug());
			savedCourseEntity = courseRepo.save(entity);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return ResponseEntity.status(HttpStatus.CREATED).body(Utility.mapCourseEntity(savedCourseEntity));

	}

	@PutMapping(value = "/courses/{courseId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Course> updateCourse(@PathVariable("courseId") String courseId, @RequestBody Course course) {
		CourseEntity savedCourseEntity = new CourseEntity();
		try {
			CourseEntity entity = new CourseEntity();
			entity.setAuthor(
					authorRepo.findById(course.getAuthorId()).orElseThrow(() -> new Exception("Author Id is invalid")));

			entity.setCategory(categoryRepo.findById(course.getCategoryId())
					.orElseThrow(() -> new Exception("Category Id is Invalid")));
			entity.setTitle(course.getTitle());
			entity.setSlug(course.getSlug());
			entity.setCourseId(courseId);

			// entity.setCategory(course.getCategoryName());
			savedCourseEntity = courseRepo.saveAndFlush(entity);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(Utility.mapCourseEntity(savedCourseEntity));

	}

	@DeleteMapping(value = "/course/{courseId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Course> deleteCourse(@PathVariable("courseId") String courseId) {
		try {
			courseRepo.deleteById(courseId);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ResponseEntity.status(HttpStatus.OK).build();

	}
}
