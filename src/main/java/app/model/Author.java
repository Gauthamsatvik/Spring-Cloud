package app.model;

import org.springframework.data.annotation.Id;

public class Author {

  @Id
  private String id;
  private String name;
  private String mobile;
  private String email;
  private int rating;


  public Author(){}

  public Author(String name, String mobile, String email, int rating){
    this.name = name;
    this.mobile = mobile;
    this.email = email;
    this.rating = rating;
  }

/**
 * @return the id
 */
public String getId() {
	return id;
}

/**
 * @param id the id to set
 */
public void setId(String id) {
	this.id = id;
}

/**
 * @return the name
 */
public String getName() {
	return name;
}

/**
 * @param name the name to set
 */
public void setName(String name) {
	this.name = name;
}

/**
 * @return the mobile
 */
public String getMobile() {
	return mobile;
}

/**
 * @param mobile the mobile to set
 */
public void setMobile(String mobile) {
	this.mobile = mobile;
}

/**
 * @return the email
 */
public String getEmail() {
	return email;
}

/**
 * @param email the email to set
 */
public void setEmail(String email) {
	this.email = email;
}

/**
 * @return the rating
 */
public int getRating() {
	return rating;
}

/**
 * @param rating the rating to set
 */
public void setRating(int rating) {
	this.rating = rating;
}


}

