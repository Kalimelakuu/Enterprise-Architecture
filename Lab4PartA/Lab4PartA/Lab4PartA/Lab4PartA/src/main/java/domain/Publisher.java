package domain;

import jakarta.persistence.*;
@Entity
public class Publisher {

    @Id
    @GeneratedValue
    private long id;
    private String name;


    protected  Publisher(){

    }

    public Publisher(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "name='" + name + '\'' +
                '}';
    }
}
