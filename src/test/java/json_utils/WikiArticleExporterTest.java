package json_utils;

import exceptions.StringIsNotJsonException;
import org.junit.jupiter.api.Test;
import wikipedia.WikiArticleEdits;

import static org.junit.jupiter.api.Assertions.*;

class WikiArticleExporterTest {

    @Test
    void testArticleExporterThrowsException() {
        String wrong = "_(#WT*FHVSGUIHWSG";
        assertThrows(StringIsNotJsonException.class, () -> {
            var p = WikiArticleExporter.exportArticleEditInfo(wrong);
        });
    }

    @Test
    void testArticleExporterGetsAttributes() throws StringIsNotJsonException {
        String json = WikiArticleParser.parseWikiArticleToJson("word");
        WikiArticleEdits wikiEdits = WikiArticleExporter.exportArticleEditInfo(json);
        assertFalse(wikiEdits.getPageID()==-1);
        assertTrue(wikiEdits.getTitle().equals("Word"));
        assertFalse(wikiEdits.getRevisions().isEmpty());
    }


}