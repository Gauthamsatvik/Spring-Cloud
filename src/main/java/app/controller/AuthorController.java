package app.controller;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import app.model.Author;
import app.repository.AuthorRepository;

@EnableCircuitBreaker
@RestController
@EnableHystrix
@EnableHystrixDashboard
@RequestMapping("/author")
public class AuthorController {
	
  private static final Logger LOG = Logger.getLogger(AuthorController.class.getName());

  @Autowired
  private AuthorRepository authorRepository;
/*  @Autowired
  private AuthorService authorService;*/

  @RequestMapping(method = RequestMethod.POST)
  public Map<String, Object> createAuthor(@RequestBody Map<String, Object> authorMap){
	  
    Author author = new Author(authorMap.get("name").toString(),
    		authorMap.get("mobile").toString(),
    		authorMap.get("email").toString(),
        Integer.parseInt(authorMap.get("rating").toString()));

    authorRepository.save(author);
    Map<String, Object> response = new LinkedHashMap<String, Object>();
    response.put("message", "Author created successfully");
    response.put("author", author);
    LOG.log(Level.INFO, "/Create - &gt; " + response);
    return response;
  }

  @RequestMapping(method = RequestMethod.GET, value="/{authorId}")
  public Author getAuthorDetails(@PathVariable("authorId") String authorId){
    Author author = authorRepository.findOne(authorId);
    LOG.log(Level.INFO, "/Get - &gt; " + author);
    return author;
  }
  
  
/*  @RequestMapping(method = RequestMethod.GET, value="/{authorName}")
  public List<Author> getAuthorByName(@PathVariable String authorName){
    //return bookRepository.findOne(bookId);
	  return authorService.getAuthorsByName(authorName);
  }*/

}
