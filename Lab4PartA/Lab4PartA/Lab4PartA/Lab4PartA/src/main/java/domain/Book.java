package domain;

import jakarta.persistence.*;


@Entity
public class Book {

    @Id
    @GeneratedValue
    private long id;
    private long isbn;
    private String title;
    private String author;
    @ManyToOne(optional = false)

//    @JoinTable(name="pub_book")

    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    protected Book(){}


    public Book(long isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;

    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn=" + isbn +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publisher=" + publisher +
                '}';
    }

    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }
}
