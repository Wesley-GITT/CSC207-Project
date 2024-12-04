package entity;

import java.util.HashSet;
import java.util.Set;

/**
 * The Presenter for the Login Use Case.
 */
public class BookFactory {

    /**
     * The Presenter for the Login Use Case.
     * @param authors :
     * @param description :
     * @param publisher :
     * @param id :
     * @param imageUrl :
     * @param language :
     * @param title :
     * @param publishedDate :
     * @return :
     */
    public Book create(String id, String imageUrl, String title, Set<String> authors, String publisher,
                       String publishedDate, String description, String language) {

        return new Book(id, imageUrl, title, authors, publisher, publishedDate, description, language);
    }

    /**
     * The Presenter for the Login Use Case.
     * @param title :
     * @param id :
     * @return :
     */
    public Book create(String id, String title) {
        return new Book(id, "", title,
                new HashSet<>(), "", "", "", "");
    }
}
