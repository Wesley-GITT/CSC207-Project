package use_case.book.search;

public class SearchInputData {

    final private String keyword;
    final private String title;
    final private String author;
    final private String subject;
    final private String isbn;
    final private int startIndex;
    final private int maxResults;

    public SearchInputData(String keyword, String title, String author, String subject, String isbn, int startIndex, int maxResults) {
        this.keyword = keyword;
        this.title = title;
        this.author = author;
        this.subject = subject;
        this.isbn = isbn;
        this.startIndex = startIndex;
        this.maxResults = maxResults;
    }

    public String getKeyword() {
        return keyword;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getSubject() {
        return subject;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public int getMaxResults() {
        return maxResults;
    }
}
