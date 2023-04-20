package domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Department {

    @Id
    @GeneratedValue

    private long id;

    private String name;
    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)

    private List<Employee> employeeList = new ArrayList<Employee>();

    protected  Department(){}
    public Department( String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    private void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void addEmployee(Employee employee) {
        employeeList.add(employee);
        System.out.println(employeeList);
    }


    @Override
    public String toString() {

        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", employeeList=" + employeeList +
                '}';
    }
}
