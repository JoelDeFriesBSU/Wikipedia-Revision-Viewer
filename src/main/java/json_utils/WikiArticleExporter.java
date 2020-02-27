package json_utils;

import com.google.gson.*;
import exceptions.StringIsNotJsonException;
import wikipedia.WikiArticleEdits;

import java.io.*;
import java.util.Map;

public class WikiArticleExporter {


    public static WikiArticleEdits exportArticleEditInfo(String json) throws StringIsNotJsonException {
        if(json.charAt(0)=='{') {

            JsonParser jsonParser = new JsonParser();
            JsonElement rootElement = jsonParser.parse(json);
            JsonObject rootObject = rootElement.getAsJsonObject();
            var query = rootObject.getAsJsonObject("query");
            var pages = query.getAsJsonObject("pages");
            var pageIdUpper = ((Map.Entry<String, JsonElement>) pages.entrySet().toArray()[0]).getValue();

            var title = pageIdUpper.getAsJsonObject().getAsJsonPrimitive("title").getAsString();
            var revisions = pageIdUpper.getAsJsonObject().getAsJsonArray("revisions");

            String realRevisions = null;
            for(JsonElement e : revisions) {
                String additive = e.toString();
                realRevisions += additive;
                realRevisions += "\n";
            }
            return new WikiArticleEdits(title,realRevisions);
        }else{
            throw new StringIsNotJsonException();
        }
    }
}
