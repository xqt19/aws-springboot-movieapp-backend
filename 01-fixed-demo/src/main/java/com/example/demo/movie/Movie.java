package com.example.demo.movie;

import java.util.List;

public class Movie {
	private long id;
	private String movieTitle;
	private String movieLang;
	private String movieGenre;
	private int movieYear;
	private double movieRating;
	private List<String> movieActors;

	
	
	public Movie(long id, String movieTitle, String movieLang, String movieGenre, int movieYear, double movieRating, List<String> movieActors) {
		super();
		this.id = id;
		this.movieTitle = movieTitle;
		this.movieLang = movieLang;
		this.movieGenre = movieGenre;
		this.movieYear = movieYear;
		this.movieRating = movieRating;
		this.movieActors = movieActors;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	public String getMovieTitle() {
		return movieTitle;
	}
	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}
	public String getMovieLang() {
		return movieLang;
	}
	public void setMovieLang(String movieLang) {
		this.movieLang = movieLang;
	}
	public String getMovieGenre() {
		return movieGenre;
	}
	public void setMovieGenre(String movieGenre) {
		this.movieGenre = movieGenre;
	}
	public int getMovieYear() {
		return movieYear;
	}
	public void setMovieYear(int movieYear) {
		this.movieYear = movieYear;
	}
	public double getMovieRating() {
		return movieRating;
	}
	public void setMovieRating(double movieRating) {
		this.movieRating = movieRating;
	}
	public List<String> getMovieActors() {
		return movieActors;
	}
	public void setMovieActors(List<String> movieActors) {
		this.movieActors = movieActors;
	}	

}
