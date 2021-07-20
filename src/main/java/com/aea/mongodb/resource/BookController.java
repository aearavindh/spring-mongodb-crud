package com.aea.mongodb.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aea.mongodb.model.Book;
import com.aea.mongodb.repository.BookRepository;

@RestController
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	private BookRepository repository;
	
	@PostMapping("/add")
	public String saveBook(@RequestBody Book book) {
		repository.save(book);
		return "Added book with id : " + book.getId();
	}
	
	@GetMapping("/findAll")
	public List<Book> getBooks() {
		return repository.findAll();
	}
	
	@GetMapping("/find/{id}")
	public Optional<Book> getBook(@PathVariable int id) {
		return repository.findById(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteBook(@PathVariable int id) {
		repository.deleteById(id);
		return "Deleted book with id : " + id;
	}
}
