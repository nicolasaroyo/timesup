package timesup.org.naroyo.timesup.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/hello")
@Consumes({ "application/json" })
@Produces({ "application/json" })
public class HelloNicolas {

	@GET
	@Path("/nicolas")
	public String getHelloNicolas() {
		System.err.println("Service Bonjour Nicolas pingé");
		return "{'value':'Bonjour Nicolas'}";
	}
}
