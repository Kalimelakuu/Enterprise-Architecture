package domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Passenger {

    @Id
    @GeneratedValue
    private long id;
    private String name;

    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable(name="p_id")
    @OrderColumn(name = "sequence")
    private List<Flights> flightList  = new ArrayList<>();

    protected  Passenger(){}
    public Passenger(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Flights> getFlightList() {
        return flightList;
    }

    public void addFlightList(Flights flight) {
        flightList.add(flight);
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "name='" + name + '\'' +
                ", flightList=" + flightList +
                '}';
    }
}
