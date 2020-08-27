package com.demo.restfulwebservices.movie;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MovieHardcodedService {

	private static List<Movie> movies = new ArrayList<Movie>();
	private static int idCounter = 0;
	
	static {
		List<String> myList = new ArrayList<String>();
		myList.add("Robbie Ashworth");
		myList.add("Claire McCaskill");
		Movie movie = new Movie(++idCounter,"Robbie & The Book of Tales", "English", "Action", 1992, 4.5, myList );
		movies.add(movie);
		List<String> myList2 = new ArrayList<String>();
		myList2.add("Al Gore");
		myList2.add("Sean O'Malley");
		Movie movie2 = new Movie(++idCounter,"An Inconvenient Truth", "Chinese", "Romance", 2001, 3.5, myList2 );
		movies.add(movie2);
	}
	
	public List<Movie> findAll(){
		return movies;
	}
	public Movie createMovie(Movie movie) {
		movie.setId(++idCounter);
		movies.add(movie);
		return movie;
	}
	public Movie deleteById(long id) {
		Movie movie = findById(id);
		if (movies.remove(movie)) {
			return movie;
		}
		return null;
	}
	private Movie findById(long id) {
		for (Movie movie:movies) {
			if (movie.getId() == id) {
				return movie;
			}
		}
		return null;
	}
}

