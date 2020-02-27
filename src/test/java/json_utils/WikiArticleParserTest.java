package json_utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WikiArticleParserTest {

    @Test
    void testJsonImporterReturnsRealString() {
        String json = WikiArticleParser.parseWikiArticleToJson("ball");
        assertTrue(!json.isEmpty());
    }

    @Test
    void testJsonImporterIsJsonString() {
        String json = WikiArticleParser.parseWikiArticleToJson("ball");
        System.out.println(json);
        assertEquals('{',json.charAt(0));
    }


}