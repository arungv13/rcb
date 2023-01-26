package utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadJSON {
    /**
     * @Author: Arun G v
     * Method to read the JSON file
     */
    public JSONObject fetchJsonData() throws Exception {
        Path path = Paths.get(System.getProperty("user.dir"), "src", "main", "resources");
        String jsonFilePath = path.toString().concat("\\TeamRCB.json");
        FileReader reader = new FileReader(jsonFilePath);
        JSONParser jsonParser = new JSONParser();
        // Read JSON file
        Object obj = jsonParser.parse(reader);
        JSONObject jsonData = (JSONObject) obj;
        return jsonData;
    }
}
