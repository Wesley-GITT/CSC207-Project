package entity;

import java.util.Set;

public class Book {

    private String id;
    private String imageUrl;
    private String title;
    private Set<String> authorIds;
    private Set<String> translatorIds;
    private String lang;
    private String publishers;
    private String description;
    private String sampleUrl;

    public Book(
            String id, String imageUrl, String title, Set<String> authorIds, Set<String> translatorIds, String lang,
            String publishers, String description, String sampleUrl) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.title = title;
        this.authorIds = authorIds;
        this.translatorIds = translatorIds;
        this.lang = lang;
        this.publishers = publishers;
        this.description = description;
        this.sampleUrl = sampleUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<String> getAuthorIds() {
        return authorIds;
    }

    public void setAuthorIds(Set<String> authorIds) {
        this.authorIds = authorIds;
    }

    public Set<String> getTranslatorIds() {
        return translatorIds;
    }

    public void setTranslatorIds(Set<String> translatorIds) {
        this.translatorIds = translatorIds;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getPublishers() {
        return publishers;
    }

    public void setPublishers(String publishers) {
        this.publishers = publishers;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSampleUrl() {
        return sampleUrl;
    }

    public void setSampleUrl(String sampleUrl) {
        this.sampleUrl = sampleUrl;
    }
}
