package com.demo.restfulwebservices.movie;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("mysql")
public class MySqlDaoImpl implements MovieDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private static class MovieRowMapper implements RowMapper<Movie>{

		@Override
		public Movie mapRow(ResultSet rs, int rowNum) throws SQLException {
			Movie movie = new Movie();
			movie.setId(rs.getInt("id"));
			movie.setMovieTitle(rs.getString("movieTitle"));
			movie.setMovieLang(rs.getString("movieLang"));
			movie.setMovieGenre(rs.getString("movieGenre"));
			movie.setMovieYear(rs.getInt("movieYear"));
			movie.setMovieRating(rs.getDouble("movieRating"));
			return movie;
		}
	}
	
	@Override
	public List<Movie> findAll(){
		final String sqlquery = "select * from Movies";
		List<Movie> movies = jdbcTemplate.query(
				sqlquery, new MovieRowMapper()
		);
		return movies;
	}

	@Override
	public Movie findById(long id) {
		final String sql = "Select * from Movies where id = ?";
		Movie movie = jdbcTemplate.queryForObject(sql, new MovieRowMapper(), id);
		return movie;
	}

	@Override
	public void deleteById(long id) {
		final String sql = "Delete From Movies where id = ?";
		jdbcTemplate.update(sql, id);
	}

	@Override
	public void updateMovie(Movie movie) {
		final String sql = "UPDATE Movies SET movieTitle = ?, movieLang=?, movieGenre=?, movieYear=?, movieRating=? WHERE id=?";
		final long id = movie.getId();
		final String title = movie.getMovieTitle();
		final String lang = movie.getMovieLang();
		final String genre = movie.getMovieGenre();
		final int year = movie.getMovieYear();
		final double rating = movie.getMovieRating();
		jdbcTemplate.update(sql, new Object[] {title, lang, genre, year, rating, id});
	}

	@Override
	public void createMovie(Movie movie) {
		final String sql = "Insert into Movies (movieTitle, movieLang, movieGenre, movieYear, movieRating) values (?,?,?,?,?)";
		final String title = movie.getMovieTitle();
		final String lang = movie.getMovieLang();
		final String genre = movie.getMovieGenre();
		final int year = movie.getMovieYear();
		final double rating = movie.getMovieRating();
		jdbcTemplate.update(sql, new Object[] {title, lang, genre, year, rating});
		
	}
	
	

}
