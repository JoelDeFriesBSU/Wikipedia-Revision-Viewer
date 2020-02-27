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

            var pageid = pageIdUpper.getAsJsonObject().getAsJsonPrimitive("pageid").getAsInt();
            var title = pageIdUpper.getAsJsonObject().getAsJsonPrimitive("title").getAsString();
            var revisions = pageIdUpper.getAsJsonObject().getAsJsonArray("revisions");

            String realRevisions = null;
            for(JsonElement e : revisions) {
                String additive = e.toString();
                realRevisions += additive;
                realRevisions += "\n";
            }
            return new WikiArticleEdits(pageid,title,realRevisions);
        }else if(json.equals("IOException String (non-json)")){
            String errorString = "An IOException was found." + "\n" +
                    "You may not be connected to the internet, or Wikipedia couldn't redirect you to your desired article." + "\n" +
                    "Please try again." + "\n";
            return new WikiArticleEdits(-1,null,errorString);
        }else{
            throw new StringIsNotJsonException();
        }
    }
}
