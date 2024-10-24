package com.example.springdatarestissue.repository;

import com.example.springdatarestissue.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository
    extends JpaRepository<Author, Long> {

}
