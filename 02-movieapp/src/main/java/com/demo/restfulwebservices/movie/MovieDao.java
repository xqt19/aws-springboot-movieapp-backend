package com.demo.restfulwebservices.movie;

import java.util.List;

public interface MovieDao {

	List<Movie> findAll();
	Movie findById(long id);
	void deleteById(long id);
	void updateMovie(Movie movie);
	void createMovie(Movie movie);
//
	
//
	

}