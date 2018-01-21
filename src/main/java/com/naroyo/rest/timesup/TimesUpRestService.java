package com.naroyo.rest.timesup;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import com.naroyo.controller.timesup.TimesUpController;

@Path("/timesup")
public class TimesUpRestService {

	private final TimesUpController controller = new TimesUpController();
	private final ObjectMapper objectMapper = new ObjectMapper();

	@GET
	@Produces("application/json")
	@Path("/")
	public Response getWords() throws JsonProcessingException {
		// TODO à passer dans les paramètres du service.
		final List<Tag> includes = Lists.newArrayList(Tag.FILM, Tag.MUSIQUE);
		final List<Tag> excludes = Lists.newArrayList(Tag.DISNEY);
		final int nbMax = 30;
		// Fin TODO
		final List<Mot> mots = this.controller.recupererListeMots(includes, excludes, nbMax);
		final String reponse = this.objectMapper.writeValueAsString(mots);
		return Response.status(Status.OK).entity(reponse).build();
	}

}
