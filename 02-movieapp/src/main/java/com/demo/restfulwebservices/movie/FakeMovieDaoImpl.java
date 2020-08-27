package com.demo.restfulwebservices.movie;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("fakedata")
public class FakeMovieDaoImpl implements MovieDao {

	private static List<Movie> movies = new ArrayList<Movie>();
	private static int idCounter = 0;


	
	@Override
	public List<Movie> findAll(){
		return movies;
	}

	@Override
	public Movie findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(long id) {
		// TODO Auto-generated method stub
	}
	@Override
	public void updateMovie(Movie movie) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createMovie(Movie movie) {
		// TODO Auto-generated method stub
		
	}
	
	
//	static {
//		List<String> myList = new ArrayList<String>();
//		myList.add("Robbie Ashworth");
//		myList.add("Claire McCaskill");
//		Movie movie = new Movie(++idCounter,"Robbie & The Book of Tales", "English", "Action", 1992, 4.5, myList );
//		movies.add(movie);
//		List<String> myList2 = new ArrayList<String>();
//		myList2.add("Al Gore");
//		myList2.add("Sean O'Malley");
//		Movie movie2 = new Movie(++idCounter,"An Inconvenient Truth", "Chinese", "Romance", 2001, 3.5, myList2 );
//		movies.add(movie2);
//	}	
	
//	@Override
//	public Movie createMovie(Movie movie) {
//		movie.setId(++idCounter);
//		movies.add(movie);
//		return movie;
//	}
//	@Override
//	public Movie deleteById(long id) {
//		Movie movie = findById(id);
//		if (movies.remove(movie)) {
//			return movie;
//		}
//		return null;
//	}
//	@Override
//	public Movie findById(long id) {
//		for (Movie movie:movies) {
//			if (movie.getId() == id) {
//				return movie;
//			}
//		}
//		return null;
//	}
}
