package com.naroyo.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

//http://localhost:8080/api/rest/message/hello%20world
@Path("/message")
public class MessageRestService {

	@GET
	@Path("/{param}")
	public Response printMessage(@PathParam("param") final String msg) {

		final String result = "Restful example : " + msg;
		System.err.println("Bonjour Nicolas");

		return Response.status(200).entity(result).build();

	}

}