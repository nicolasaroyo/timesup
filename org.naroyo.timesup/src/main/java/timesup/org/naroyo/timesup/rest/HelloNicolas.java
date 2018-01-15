package timesup.org.naroyo.timesup.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/hello")
public class HelloNicolas {
	@GET
	@Produces("application/xml")
	public String getXml() {
		System.err.println("Service Bonjour Nicolas pingé");
		return "<bonjour>Bonjour Nicolas </bonjour>";
	}
}
