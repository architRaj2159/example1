package com.lti.resource;

import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

@Path("/hello")
public class HelloResource {

	/*@GET
	public String hello() {
		return "hello from JAX-RS";
	}*/
	
	/*@GET
	public String hello(@QueryParam("name") String name) {
		return "Hello "+name+". Welcome to JAX-RS";
	}*/
	
	
	
	//http://localhost:8181/RESTApp/api/hello/Archit
	/*@Path("/{name}")
	@GET
	public String hello(@QueryParam("name") String name) {
		return "Hello "+name+". Welcome to JAX-RS";
	}*/
	
	
	
	//http://localhost:8181/RESTApp/api/hello;name=Archit
	@GET
	public String hello(@MatrixParam("name") String name) {
		return "Hello "+name+". Welcome to JAX-RS";
	}
}
