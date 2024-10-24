package com.example.springdatarestissue.repository;

import com.example.springdatarestissue.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository
    extends JpaRepository<Book, Long> {

}
