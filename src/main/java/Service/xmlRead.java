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

public class xmlRead {
    public JSONArray Read(){

        JSONArray movies = new JSONArray();

        try{
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dbf.newDocumentBuilder();
            File f = new File("movies.xml");
            Document xml = builder.parse(f);
            xml.normalize();
            NodeList nodeList = xml.getElementsByTagName("movie");

            for(int i = 0; i < nodeList.getLength(); i++){
                Node node = nodeList.item(i);
                Element movie = (Element) node;
                JSONObject movieObj = new JSONObject();

                String nev = movie.getElementsByTagName("title").item(0).getTextContent();
                Integer rating = Integer.valueOf(movie.getElementsByTagName("rating").item(0).getTextContent());
                Integer year = Integer.valueOf(movie.getElementsByTagName("year").item(0).getTextContent());
                String director = movie.getElementsByTagName("director").item(0).getTextContent();
                String genre = movie.getElementsByTagName("genre").item(0).getTextContent();
                movies.put(movieObj);
            }

        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }
        return movies;
    }
}
