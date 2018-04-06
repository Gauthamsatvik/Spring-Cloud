package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import app.model.Author;
import app.repository.AuthorRepository;

@Service
public class AuthorService {

  @Autowired
  private AuthorRepository authorRepository;
  
  @HystrixCommand(fallbackMethod = "reliable")
  public Author getAuthorDetails(String authorId){
    throw new RuntimeException(); 
  }
  
  public List<Author> getAuthorsByName(String authorName){
	    return authorRepository.findByName(authorName); 
	  }

  public Author reliable(String authorId) {
	//Book book = new Book("Power of Java","12345","Sun",200);
    return authorRepository.findOne(authorId);
  }

}