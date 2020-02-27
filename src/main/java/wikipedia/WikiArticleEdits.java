package wikipedia;

public class WikiArticleEdits {

    private int pageid;
    private String title;
    private String revisions;

    public WikiArticleEdits(String title, String revisions) {
        this.title = title;
        this.revisions = revisions;
    }

    @Override
    public String toString() {
        return "WikiArticleEdits{" +
                "article title='" + title + '\'' +
                ", revisions='" + revisions + '\'' +
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
