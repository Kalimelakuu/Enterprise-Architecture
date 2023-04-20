package domain;
import jakarta.persistence.*;

import java.util.Date;

@Entity
//@Table(name = "flights")
public class Flights {

    @Id

    @GeneratedValue
    private long id;
    private int flightnumber;
    @Column(name = "flyFrom")
    private String from;
    @Column(name = "toFly")
    private String to;
    private Date date;

    public Flights(){}

    public Flights( int flightnumber, String from, String to, Date date) {

        this.flightnumber = flightnumber;
        this.from = from;
        this.to = to;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Flights{" +
                "flightnumber=" + flightnumber +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", date=" + date +
                '}';
    }

    public int getFlightnumber() {
        return flightnumber;
    }

    public void setFlightnumber(int flightnumber) {
        this.flightnumber = flightnumber;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
