package domain;

import org.springframework.context.annotation.Description;

import javax.persistence.Entity;

@Entity
@Description(value = "dvd")
public class Book extends Product{

    private String isbn;

    protected Book(){}
    public Book(String name, String description, double price, String isbn) {
        super(name, description, price);
        this.isbn = isbn;
    }
}
