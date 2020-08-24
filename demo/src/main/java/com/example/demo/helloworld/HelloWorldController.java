package com.example.demo.helloworld;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class HelloWorldController {
	
	@RequestMapping(method=RequestMethod.GET, path="/hello-world")
	public String helloWorld(){
		return "Goodbye World";
	}
	
	//hello-world-bean
	@RequestMapping(method=RequestMethod.GET, path="/hello-world-bean")
	public HelloWorldBean helloWorldBean(){
		return new HelloWorldBean("Hello World");
	}
	
	@RequestMapping(method=RequestMethod.GET, path="/hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name){
//		throw new RuntimeException("Sum Ting Wong");
		return new HelloWorldBean("Hello World, " + name);
	}

}
