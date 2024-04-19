package ObservationTest.models;

import java.io.FileReader;
import java.io.IOException;
import org.json.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonParser {
    String fileName = "C:\\Users\\rfvis\\OneDrive\\School\\Periode 10\\praktijk\\ObservationTest\\src\\main\\webapp\\WEB-INF\\data\\ekstersAlmelo.json";

    void init() {
        JSONParser parser = new JSONParser();


    }

    public static void main(String[] args) {
        JsonParser myClass = new JsonParser();

        myClass.init();
    }
}
