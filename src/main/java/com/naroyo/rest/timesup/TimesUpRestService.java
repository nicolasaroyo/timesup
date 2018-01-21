package com.naroyo.rest.timesup;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.naroyo.controller.timesup.TimesUpController;

@Path("/timesup")
@Consumes("application/json")
@Produces("application/json")
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

}
