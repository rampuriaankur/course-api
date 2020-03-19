package com.ank.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ank.dao.entities.AuthorEntity;
import com.ank.dao.repo.AuthorRepo;
import com.ank.model.Author;
import com.ank.util.Utility;

@RestController
public class AuthorController {

	@Autowired
	AuthorRepo authorRepo;

	@GetMapping(value = "/authors")
	public ResponseEntity<List<Author>> getAuthorList() {

		List<Author> authorList = new ArrayList<Author>();
		List<AuthorEntity> authorEntityList = authorRepo.findAll();
		authorList = Utility.mapAuthorEntityList(authorEntityList);
		return ResponseEntity.status(HttpStatus.OK).body(authorList);

	}

}
