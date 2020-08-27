package com.demo.restfulwebservices.movie;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

	@Autowired
	@Qualifier("mysql")
	private MovieDao movieDao;
	
	public List<Movie> findAll(){
		return movieDao.findAll();
	}
	public Movie findById(long id) {
		return movieDao.findById(id);
	}
	public void deleteById(long id) {
		movieDao.deleteById(id);
	}
	public void updateMovie(Movie movie) {
		movieDao.updateMovie(movie);
	}
	public void createMovie(Movie movie) {
		movieDao.createMovie(movie);
	}
}

