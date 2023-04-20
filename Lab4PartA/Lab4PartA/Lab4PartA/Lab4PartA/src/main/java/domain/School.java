package domain;


import jakarta.persistence.*;

import java.util.HashMap;
import java.util.Map;

@Entity
public class School {

    @Id
    @GeneratedValue

    private long id;
    private String name;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "school_id")
    @MapKey(name = "studentid")
    private Map<Long, Student> studentMap = new HashMap<>();


    protected School(){}

    public School(String name) {
        this.name = name;

    }

    @Override
    public String toString() {
        return "School{" +
                "name='" + name + '\'' +
                ", studentMap=" + studentMap +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Long, Student> getStudentMap() {
        return studentMap;
    }

    public void put(Long key, Student student) {
       studentMap.put(key, student);
    }
}
