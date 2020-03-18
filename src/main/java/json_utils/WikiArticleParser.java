package json_utils;

import java.io.*;
import java.net.*;
import java.util.*;

public class WikiArticleParser {

    public static String parseWikiArticleToJson(String word){
        try {
            URL url = new URL("https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles="+word+"&rvprop=timestamp|user&rvlimit=30&redirects");
            URLConnection connection = url.openConnection();
            connection.setRequestProperty("User-Agent", "Revision Tracker/0.1 (http://www.cs.bsu.edu/; jtdefries@bsu.edu)");
            InputStream in = connection.getInputStream();
            Scanner scanner = new Scanner(in);
            String result = scanner.nextLine();

            return result;
        }catch(IOException e){
            return "IOException String (non-json)";
        }
    }
}
