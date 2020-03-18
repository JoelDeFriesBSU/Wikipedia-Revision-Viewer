import java.util.Scanner;

import com.google.gson.JsonArray;
import exceptions.StringIsNotJsonException;
import json_utils.WikiArticleExporter;
import json_utils.WikiArticleParser;
import wikipedia.WikiArticleEdits;

public class Main {

    public static void main(String[] args) throws StringIsNotJsonException {

        while(true){
            System.out.println("Type a Wiki article (type 'quitprogram' to quit):");
            Scanner s = new Scanner(System.in);
            String word = s.nextLine();

            if(word.equals("quitprogram")){
                System.out.println("Quitting...");
                break;
            }else{
                String wordJson = WikiArticleParser.parseWikiArticleToJson(word);
                WikiArticleEdits articleEdits = WikiArticleExporter.exportArticleEditInfo(wordJson);

                System.out.println(articleEdits);
            }
        }
    }
}
