package timesup.org.naroyo.timesup.rest;

import java.net.URI;

import javax.ws.rs.core.UriBuilder;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

/**
 * Hello world!
 *
 */
public class App {

	private static final String URL_LOCALE = "http://192.168.1.10/rest/";
	private static final String URL_OPENSHIFT = "http://times-up-times-up.7e14.starter-us-west-2.openshiftapps.com/rest/";

	public static final URI BASE_URI = getBaseURI();

	private static URI getBaseURI() {
		return UriBuilder.fromUri(URL_OPENSHIFT).port(9991).build();
	}

	public static void main2(final String[] args) {
		final ResourceConfig rc = new ResourceConfig();
		rc.packages("timesup.org.naroyo.timesup.rest");
		try {
			final HttpServer server = GrizzlyHttpServerFactory.createHttpServer(BASE_URI, rc);
			server.start();

			System.out.println(String.format(
					"Jersey app started with WADL available at " + "%sapplication.wadl\nHit enter to stop it...",
					BASE_URI, BASE_URI));
			System.in.read();
			server.shutdownNow();
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(final String[] args) {
		System.err.println("Bonjour Nicolas");
	}
}
