package domain;

import org.springframework.context.annotation.Description;

import javax.persistence.Entity;

@Entity
@Description(value = "dvd")
public class CD extends  Product{

    private String artist;

    protected  CD(){}

    public CD(String name, String description, double price, String artist) {
        super(name, description, price);
        this.artist = artist;
    }
}
