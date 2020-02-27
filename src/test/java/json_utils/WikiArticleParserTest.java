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
        assertEquals('{',json.charAt(0));
    }

    @Test
    void testJsonImporterThrowsIoException() {
        String json = WikiArticleParser.parseWikiArticleToJson("s s p p o i f f d");
        assertEquals("IOException String (non-json)",json);
    }


}