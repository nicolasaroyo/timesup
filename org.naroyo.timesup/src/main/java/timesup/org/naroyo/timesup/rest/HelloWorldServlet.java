package timesup.org.naroyo.timesup.rest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * A simple servlet taking advantage of features added in 3.0.
 * </p>
 * 
 * <p>
 * The servlet is registered and mapped to /HelloServlet using the
 * {@linkplain WebServlet
 * 
 * @HttpServlet}. The {@link HelloService} is injected by CDI.
 *                </p>
 * 
 * @author Pete Muir
 * 
 */
@SuppressWarnings("serial")
@WebServlet("/HelloWorld")
public class HelloWorldServlet extends HttpServlet {

	static String PAGE_HEADER = "<html><head><title>helloworld</title></head><body>";

	static String PAGE_FOOTER = "</body></html>";

	@Inject
	private HelloService helloService;

	@Override
	protected void doGet(final HttpServletRequest req, final HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html");
		final PrintWriter writer = resp.getWriter();
		writer.println(PAGE_HEADER);
		writer.println("<h1>" + this.helloService.createHelloMessage("World") + "</h1>");
		writer.println(PAGE_FOOTER);
		writer.close();
	}

}