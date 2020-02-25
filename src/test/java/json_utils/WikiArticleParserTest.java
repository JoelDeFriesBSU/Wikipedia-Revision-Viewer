package json_utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WikiArticleParserTest {

    @Test
    void testJsonParserReturnsRealString() {
        String json = WikiArticleParser.parseWikiArticleToJson("Barack Obama");
        assertTrue(!json.isEmpty());
    }
}