package Service;

import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class xmlRead {

    static final String FILE = "C:\\Users\\koppa\\Desktop\\MoviePicker\\" +
            "src\\main\\java\\Resources\\movies.xml";

    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

    //Reads xml to JSONArray
    public JSONArray Read() {

        JSONArray movies = new JSONArray();

        try {
            DocumentBuilder builder = dbf.newDocumentBuilder();
            File f = new File(FILE);
            Document xml = builder.parse(f);
            xml.normalize();

            //Saving movies by node
            NodeList nodeList = xml.getElementsByTagName("movie");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                Element movie = (Element) node;
                JSONObject movieObj = new JSONObject();

                readXml(movieObj, movie);
                movies.put(movieObj);
            }

        } catch (ParserConfigurationException | IOException | SAXException e) {
            throw new RuntimeException(e);
        }
        return movies;
    }

    //Returns random JSONObject from db
    public JSONObject getRandomMovie() throws ParserConfigurationException {

        JSONObject movieObj = new JSONObject();

        try {
            DocumentBuilder builder = dbf.newDocumentBuilder();
            File f = new File(FILE);
            Document xml = builder.parse(f);
            xml.normalize();

            NodeList nodeList = xml.getElementsByTagName("movie");
            Random random = new Random();

            Node node = nodeList.item(random.nextInt(nodeList.getLength()));
            Element movie = (Element) node;

            readXml(movieObj, movie);

        } catch (IOException | SAXException e) {
            throw new RuntimeException(e);
        }
        return movieObj;
    }

    //Loops trough xml and gives back JSONObject
    private void readXml(JSONObject movieObj, Element movie) {
        String title = movie.getElementsByTagName("title").item(0).getTextContent();
        Integer rating = Integer.valueOf(movie.getElementsByTagName("rating").item(0).getTextContent());
        Integer year = Integer.valueOf(movie.getElementsByTagName("year").item(0).getTextContent());
        String director = movie.getElementsByTagName("director").item(0).getTextContent();
        String genre = movie.getElementsByTagName("genre").item(0).getTextContent();

        movieObj.put("title", title);
        movieObj.put("rating", rating);
        movieObj.put("year", year);
        movieObj.put("director", director);
        movieObj.put("genre", genre);
    }
}
