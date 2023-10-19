package Utilities;

import io.restassured.path.json.JsonPath;

public class DataParser {

    public static JsonPath JsonParsing(String response){
        JsonPath js=new JsonPath(response);
        return js;
    }
}
