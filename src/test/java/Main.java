import BusinessTest.Genre;
import BusinessTest.Movie;
import DB.xmlWriteT;
import jakarta.xml.bind.JAXBException;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws JAXBException, IOException {
        /*xmlWriteT.readXmlToList(new Movie("Title", 1, 2001,
                "idk", Genre.valueOf("action")));*/
        xmlWriteT.marshaling(new Movie("Title", 1, 2001,
                "idk", Genre.valueOf("action")));
    }
}
