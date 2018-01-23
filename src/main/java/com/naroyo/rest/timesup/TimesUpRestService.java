package com.naroyo.rest.timesup;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import com.naroyo.controller.timesup.TimesUpController;

@Path("/timesup")
@Consumes(MediaType.APPLICATION_JSON + ";charset=UTF-8")
@Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
public class TimesUpRestService {

	private final TimesUpController controller = new TimesUpController();
	private final ObjectMapper objectMapper = new ObjectMapper();

	@GET
	@Path("/")
	public Response getWords(@QueryParam("includes") final List<Tag> includes,
			@QueryParam("excludes") final List<Tag> excludes, @QueryParam("nbMax") final int nbMax)
			throws JsonProcessingException {
		final List<Mot> mots = this.controller.recupererListeMots(includes, excludes, nbMax);
		final String reponse = this.objectMapper.writeValueAsString(mots);
		return Response.status(Status.OK).entity(reponse).build();
	}

	@POST
	@Path("/")
	public Response addWord(@QueryParam("mot") final String mot, @QueryParam("tags") final List<Tag> tags) {
		final boolean done = this.controller.ajouterMot(new Mot(mot, tags));
		return Response.status(done ? Status.CREATED : Status.INTERNAL_SERVER_ERROR).build();
	}

	@GET
	@Path("/all")
	public Response getAll() throws JsonProcessingException {
		final List<Mot> mots = this.controller.recupererTousLesMots();
		final String reponse = this.objectMapper.writeValueAsString(mots);
		return Response.status(Status.OK).entity(reponse).build();
	}

	@GET
	@Path("/tags")
	public Response getTags() throws JsonProcessingException {
		final List<Tag> tags = Lists.newArrayList(Tag.values());
		final String reponse = this.objectMapper.writeValueAsString(tags);
		return Response.status(Status.OK).entity(reponse).build();
	}

}
