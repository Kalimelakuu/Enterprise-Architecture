package domain;

import jakarta.persistence.*;
@Entity
public class Student {

    @Id
    @GeneratedValue

    private  long id;

    private long studentid;
    private String firstname;
    private String lastname;

    protected  Student(){}

    public Student(long studentid, String firstname, String lastname) {
        this.studentid = studentid;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentid=" + studentid +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }

    public long getStudentid() {
        return studentid;
    }

    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
