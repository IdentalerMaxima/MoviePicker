package Controller;

import Business.Genre;
import Business.Movie;
import Service.xmlRead;
import Service.xmlWrite;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.xml.bind.JAXBException;

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

    @POST
    @Path("addMovie")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public void postMovie(Movie movie) throws JAXBException {
        xmlWrite.marshaling(movie);
    }
}