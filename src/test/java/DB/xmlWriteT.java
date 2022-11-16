package DB;
import BusinessTest.Movie;
import BusinessTest.Movies;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public abstract class xmlWriteT {

    static String FILE = "C:\\Users\\koppa\\Desktop\\MoviePicker\\" +
            "src\\main\\java\\Resources\\movies.xml";

    static DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

    protected xmlWriteT() throws JAXBException {
    }

    public static void readXmlToList(Movie movieToAdd) throws JAXBException, IOException {

        /*Movies movies = new Movies();
        movies.setMovies(new ArrayList<Movie>());

        try{
            DocumentBuilder builder = dbf.newDocumentBuilder();
            File f = new File(FILE);
            Document xml = builder.parse(f);
            xml.normalize();
            NodeList nodeList = xml.getElementsByTagName("movie");

            //Getting current data
            for(int i = 0; i < nodeList.getLength(); i++){
                Node node = nodeList.item(i);
                Element movie = (Element) node;
                Movie movieObj = new Movie();

                String title = movie.getElementsByTagName("title").item(0).getTextContent();
                movieObj.setTitle(title);
                Integer rating = Integer.valueOf(movie.getElementsByTagName("rating").item(0).getTextContent());
                movieObj.setRating(rating);
                Integer year = Integer.valueOf(movie.getElementsByTagName("year").item(0).getTextContent());
                movieObj.setYear(year);
                String director = movie.getElementsByTagName("director").item(0).getTextContent();
                movieObj.setDirector(director);
                String genre = movie.getElementsByTagName("genre").item(0).getTextContent();
                movieObj.setGenre(Genre.valueOf(genre));

                movies.getMovies().add(movieObj);
            }

        } catch (ParserConfigurationException | IOException | SAXException e) {
            throw new RuntimeException(e);
        }*/


        //We had written this file in marshalling example
        /*Employees emps = (Employees) jaxbUnmarshaller.unmarshal( new File("c:/temp/employees.xml") );

        for(Employee emp : emps.getEmployees())
        {
            System.out.println(emp.getId());
            System.out.println(emp.getFirstName());
        }
    }

        JAXBContext context = JAXBContext.newInstance(Movies.class);
        Unmarshaller unmarshaler = context.createUnmarshaller();
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        marshaller.marshal(movies, new FileWriter("C:\\Users\\koppa\\Desktop\\MoviePicker\\" +
                "src\\main\\java\\Resources\\moviesTest.xmlC:\\" +
                "Users\\koppa\\Desktop\\MoviePicker\\src\\main\\java\\Resources\\moviesTest.xml"));
    }*/

    /*public static void marshalingList() throws JAXBException
    {
        JAXBContext jaxbContext = JAXBContext.newInstance();
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        //Marshal to console
        jaxbMarshaller.marshal(readXmlToList(new Movie("Title", 1, 2001,
                "idk", Genre.valueOf("action"))), System.out);

        //Marshal the movies list in file
        jaxbMarshaller.marshal(readXmlToList(new Movie("Title", 1, 2001,
                "idk", Genre.valueOf("action"))), new File("C:\\Users\\koppa\\Desktop\\MoviePicker\\" +
                "src\\main\\java\\Resources\\moviesTest.xml"));
    }*/
    }
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




