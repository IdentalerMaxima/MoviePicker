package Controller;

import Service.xmlRead;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import javax.xml.parsers.ParserConfigurationException;

@Path("/resources")
public class HelloResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("read")
    public Response read() {
        return Response.ok(new xmlRead().Read().toString()).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getRandom")
    public Response getRandom() throws ParserConfigurationException {
        return Response.ok(new xmlRead().getRandomMovie().toString()).build();
    }
}