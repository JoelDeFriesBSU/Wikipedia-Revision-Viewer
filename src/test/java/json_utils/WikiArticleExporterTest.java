package json_utils;

import exceptions.StringIsNotJsonException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WikiArticleExporterTest {

    @Test
    void testArticleExporterThrowsException() {
        String wrong = "_(#WT*FHVSGUIHWSG";
        assertThrows(StringIsNotJsonException.class, () -> {
            var p = WikiArticleExporter.exportArticleEditInfo(wrong);
        });
    }


}