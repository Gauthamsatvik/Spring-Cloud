package app.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import app.model.Author;

public interface AuthorRepository extends MongoRepository<Author, String>{
	public List<Author> findByName(String name);
}
