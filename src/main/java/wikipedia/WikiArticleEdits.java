package wikipedia;

public class WikiArticleEdits {

    private int pageid;
    private String title;
    private String revisions;

    public WikiArticleEdits(int pageid, String title, String revisions) {
        this.pageid = pageid;
        this.title = title;
        this.revisions = revisions;
    }

    @Override
    public String toString() {
        return "Edits to the Wikipedia article: {" + "\n" +
                "Page ID:'" + pageid + '\'' + "\n" +
                "Article Title:'" + title  + '\'' + "\n" +
                "Revisions:'" + revisions + '\'' +
                '}';
    }

    public int getPageID() {
        return pageid;
    }

    public String getTitle() {
        return title;
    }

    public String getRevisions() {
        return revisions;
    }
}
