package Service;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class createXML {
    public static void main(String[] args) {
        try{
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();

            //root
            Element rootElement = doc.createElement("Movies");
            doc.appendChild(rootElement);

            //movie element
            Element movie = doc.createElement("movie");
            rootElement.appendChild(movie);

            //elements
            Element title = doc.createElement("title");
            title.appendChild(doc.createTextNode("Grownups"));
            movie.appendChild(title);

            Element rating = doc.createElement("rating");
            rating.appendChild(doc.createTextNode(String.valueOf(5)));
            movie.appendChild(rating);


            //write into xml
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("C:\\Users\\koppa\\" +
                    "Desktop\\MoviePicker\\src\\main\\java\\Resources\\movies.xml"));
            transformer.transform(domSource, result);

            } catch (ParserConfigurationException | TransformerException e) {
            throw new RuntimeException(e);
            }
    }

}
