package com.ank.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ank.dao.entities.AuthorEntity;

public interface AuthorRepo extends JpaRepository<AuthorEntity, String> {

}
