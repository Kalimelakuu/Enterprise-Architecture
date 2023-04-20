package domain;

import jakarta.persistence.*;

@Entity
public class Employee {
    @Id

    private String employeenumber;
    private String name;
    @ManyToOne()
    @JoinColumn(name = "department_id")
    private Department department;

    protected  Employee(){}
    public Employee(String employeenumbesr ,String name) {

        this.employeenumber = employeenumbesr;
        this.name = name;

    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeenumber=" + employeenumber +
                ", name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
