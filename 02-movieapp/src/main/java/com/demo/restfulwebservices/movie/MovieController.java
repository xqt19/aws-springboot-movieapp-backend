package com.demo.restfulwebservices.movie;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;



@RestController
//@CrossOrigin(origins="http://xqpoc.s3-website-ap-southeast-1.amazonaws.com")
@CrossOrigin(origins = {"http://localhost:4200", "http://xqpoc.s3-website-ap-southeast-1.amazonaws.com", "https://d1sjwk1lmcwu57.cloudfront.net", "https://q7z7wqfyjf.execute-api.ap-southeast-1.amazonaws.com/xqpoc"})
public class MovieController {
	
	@Autowired
	private MovieService movieService;
	
	@RequestMapping(method=RequestMethod.GET, path="/movies")
	public List<Movie> findAll(){
		return movieService.findAll();
	}
	@RequestMapping(method=RequestMethod.GET, path="/movies/{id}")
	public Movie findById(@PathVariable long id){
		return movieService.findById(id);
	}
	@RequestMapping(method=RequestMethod.DELETE, path="/movies/{id}")
	public void deleteById(@PathVariable long id){
		movieService.deleteById(id);
	}
	
	@RequestMapping(method=RequestMethod.PUT, path="/movies")
	public void updateMovie(@RequestBody Movie movie){
		movieService.updateMovie(movie);
	}
	@RequestMapping(method=RequestMethod.POST, path="/movies")
	public void createMovie(@RequestBody Movie movie){
		movieService.createMovie(movie);
	}
	
	
	
	//ACTORS METHODS
	@RequestMapping(method=RequestMethod.GET, path="/actors")
	public List<String> findAllActors(){
		return movieService.findAllActors();
	}
	
	
	
	
	//FINDALL METHODS
	@RequestMapping(method=RequestMethod.GET, path="/index/{view}")
	public List<Movie> findAllByYear(@PathVariable String view){
		return movieService.findAllByYear(view);
	}
	
	
//	@RequestMapping(method=RequestMethod.POST, path="/movies")
//	public ResponseEntity<Void> createMovie
//	(@RequestBody Movie movie){
//		Movie newMovie = movieService.createMovie(movie);
//		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/").buildAndExpand(newMovie.getId()).toUri();
//		return ResponseEntity.created(uri).build();
//	}
//	
//	@RequestMapping(method=RequestMethod.DELETE,path="/movies/{id}")
//	public ResponseEntity<Void>deleteMovie(@PathVariable long id){
//		Movie movie = movieService.deleteById(id);
//		if (movie != null) {
//			return ResponseEntity.noContent().build();
//		}
//		return ResponseEntity.notFound().build();
//	}


}

