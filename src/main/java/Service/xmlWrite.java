import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.IOException;


public abstract class xmlWrite {

    public static Movies unMarshaling() throws JAXBException
    {
        JAXBContext jaxbContext = JAXBContext.newInstance(Movies.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        Movies movies = (Movies) jaxbUnmarshaller.unmarshal( new File("C:\\Users\\koppa\\Desktop\\MoviePicker\\" +
                "src\\main\\java\\Resources\\moviesTest.xml") );

        Movies movieList = new Movies();
        movieList.setMovies(new ArrayList<Movie>());

        for(Movie movie : movies.getMovies())
        {
            movieList.getMovies().add(movie);
        }
        /*for(Movie movie : movieList.getMovies()){
            System.out.println(movie.getTitle());
        }*/
        return movieList;
    }
    public static void marshaling(Movie movieToAdd) throws JAXBException
    {
        JAXBContext jaxbContext = JAXBContext.newInstance(Movies.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        Movies movies = unMarshaling();
        movies.getMovies().add(movieToAdd);

        //Marshal the movieList list in console
        jaxbMarshaller.marshal(movies, System.out);

        //Marshal the movieList in file
        jaxbMarshaller.marshal(movies, new File("C:\\Users\\koppa\\Desktop\\MoviePicker\\src\\" +
                "main\\java\\Resources\\moviesTest.xml"));
    }
}




