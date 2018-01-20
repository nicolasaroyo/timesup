package com.naroyo.rest.test;

import java.sql.SQLException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.naroyo.db.test.Test;
import com.naroyo.db.test.TestRepository;

@Path("/message")
public class MessageRestService {

	@GET
	@Path("/{param}")
	public Response printMessage(@PathParam("param") final String msg) {

		final String result = "Restful example : " + msg;
		System.err.println("Bonjour Nicolas");

		return Response.status(200).entity(result).build();

	}

	@GET
	@Path("/testbdd")
	public Response testBdd() throws SQLException {

		final TestRepository testRepository = new TestRepository();
		final Test test = testRepository.getTextValue();

		return Response.status(200).entity(test.getText()).build();

	}

}