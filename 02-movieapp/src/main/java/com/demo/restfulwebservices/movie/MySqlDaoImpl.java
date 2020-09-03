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
				sqlquery, new RowMapper<Movie>(){
					@Override
					public Movie mapRow(ResultSet rs, int rowNum) throws SQLException {
						Movie movie = new Movie();
						movie.setId(rs.getInt("id"));
						movie.setMovieTitle(rs.getString("movieTitle"));
						movie.setMovieLang(rs.getString("movieLang"));
						movie.setMovieGenre(rs.getString("movieGenre"));
						movie.setMovieYear(rs.getInt("movieYear"));
						movie.setMovieRating(rs.getDouble("movieRating"));
						final String sqlquery = "Select Cast.actorName from Cast inner join Movies on Cast.movieTitle = Movies.movieTitle where Movies.movieTitle = ?;";
						List<String> actors = jdbcTemplate.query(
								sqlquery, new RowMapper<String>() {
									@Override
									public String mapRow(ResultSet rs, int rowNum) throws SQLException {
										return rs.getNString("actorName");
									}
								}, new Object[] {movie.getMovieTitle()}
						); // END OF INNER QUERY
						movie.setMovieActors(actors);
						return movie;
					} // End of mapRow METHOD
				} // End of RowMapper Method
		);
		return movies;
	}

	@Override
	public Movie findById(long id) {
		final String sql = "Select * from Movies where id = ?";
		Movie movie = jdbcTemplate.queryForObject(sql, new RowMapper<Movie>(){
			@Override
			public Movie mapRow(ResultSet rs, int rowNum) throws SQLException {
				Movie movie = new Movie();
				movie.setId(rs.getInt("id"));
				movie.setMovieTitle(rs.getString("movieTitle"));
				movie.setMovieLang(rs.getString("movieLang"));
				movie.setMovieGenre(rs.getString("movieGenre"));
				movie.setMovieYear(rs.getInt("movieYear"));
				movie.setMovieRating(rs.getDouble("movieRating"));
				final String sqlquery = "Select Cast.actorName from Cast inner join Movies on Cast.movieTitle = Movies.movieTitle where Movies.movieTitle = ?;";
				List<String> actors = jdbcTemplate.query(
						sqlquery, new RowMapper<String>() {
							@Override
							public String mapRow(ResultSet rs, int rowNum) throws SQLException {
								return rs.getNString("actorName");
							}
						}, new Object[] {movie.getMovieTitle()}
				); // END OF INNER QUERY
				movie.setMovieActors(actors);
				return movie;
			} // End of mapRow METHOD			
		}, id);
		return movie;
	}

	@Override
	public void deleteById(long id) {
		Movie movie = findById(id);
		final String sql2 = "Delete From Cast where movieTitle = ?";
		jdbcTemplate.update(sql2, movie.getMovieTitle());
		final String sql = "Delete From Movies where id = ?";
		jdbcTemplate.update(sql, id);
	}

	@Override
	public void updateMovie(Movie movie) {
		Movie oldMovie = findById(movie.getId());
		final String sql2 = "Delete From Cast where movieTitle = ?";
		jdbcTemplate.update(sql2, oldMovie.getMovieTitle());
		// Deleted old Movie Cast
		final String sql = "UPDATE Movies SET movieTitle = ?, movieLang=?, movieGenre=?, movieYear=?, movieRating=? WHERE id=?";
		final long id = movie.getId();
		final String title = movie.getMovieTitle();
		final String lang = movie.getMovieLang();
		final String genre = movie.getMovieGenre();
		final int year = movie.getMovieYear();
		final double rating = movie.getMovieRating();
		jdbcTemplate.update(sql, new Object[] {title, lang, genre, year, rating, id});
		// Updating Movie Actors
		final String sql3 = "Insert into Cast (actorName, movieTitle) values (?,?)";
		for (String name: movie.getMovieActors()) {
			jdbcTemplate.update(sql3, new Object[] {name,title});
		}
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
		
		//creating new movie's actors
		final String sql2 = "Insert into Cast (actorName, movieTitle) values (?,?)";
		for (String name: movie.getMovieActors()) {
			jdbcTemplate.update(sql2, new Object[] {name,title});
		}
	}
	
	
	
	
	// ACTOR METHODS
	@Override
	public List<String> findAllActors(){
		final String sqlquery = "Select Cast.actorName from Cast inner join Movies on Cast.movieTitle = Movies.movieTitle;";
		List<String> actors = jdbcTemplate.query(
				sqlquery, new RowMapper<String>() {

					@Override
					public String mapRow(ResultSet rs, int rowNum) throws SQLException {
						return rs.getNString("actorName");
					}
					
				}
		);
		return actors;
	}
	
	
	
	
	
	
	//FINDALL METHODS
	@Override
	public List<Movie> findAllByYear(String view){
//		final String sqlquery = "select * from Movies Order By ?";
		List<Movie> movies = jdbcTemplate.query(
				String.format("select * from Movies Order By (%s)", view), new MovieRowMapper()
		);
		return movies;
	}
	
	
}
