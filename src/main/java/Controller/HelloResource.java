package Controller;

import Business.Genre;
import Business.Movie;
import Service.xmlRead;
import jakarta.ws.rs.*;
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

    @POST
    @Path("addMovie")
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public Response postMovie(){
        Movie movie1 = new Movie("New movie", 3, 2001, "idk", Genre.horror);
        return Response.ok(movie1.toString()).build();
    }

}