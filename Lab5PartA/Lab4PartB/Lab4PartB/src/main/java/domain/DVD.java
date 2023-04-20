package domain;

import org.springframework.context.annotation.Description;

import javax.persistence.*;

@Entity
@Description(value = "dvd")
public class DVD extends  Product{

    private  String genere;
    protected DVD(){}
    public DVD(String name, String description, double price, String genere) {
        super(name, description, price);
        this.genere = genere;
    }
}
