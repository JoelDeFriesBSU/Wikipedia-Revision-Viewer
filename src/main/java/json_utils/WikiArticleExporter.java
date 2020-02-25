package json_utils;

import com.google.gson.*;
import exceptions.StringIsNotJsonException;
import wikipedia.WikiArticleEdits;

import java.io.*;
import java.util.Map;

public class WikiArticleExporter {


    public static JsonArray exportArticleEditInfo(String json) throws StringIsNotJsonException {
        if(json.charAt(0)=='{') {
            JsonParser parser = new JsonParser();
            InputStream inputStream = WikiArticleExporter.class.getClassLoader().getResourceAsStream(json);
            Reader reader = new InputStreamReader(inputStream);
            JsonElement rootElement = parser.parse(reader);
            JsonObject rootObject = rootElement.getAsJsonObject();
            JsonObject pages = rootObject.getAsJsonObject("query").getAsJsonObject("pages");
            JsonArray array = null;
            for (Map.Entry<String,JsonElement> entry : pages.entrySet()){
                JsonObject entryObject = entry.getValue().getAsJsonObject();
                array = entryObject.getAsJsonArray("revisions");
            }
            return array;
        }else{
            throw new StringIsNotJsonException();
        }
    }
}
