package com.aea.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.aea.mongodb.model.Book;

@Repository
public interface BookRepository extends MongoRepository<Book, Integer> {

}
