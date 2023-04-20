package domain;


import javax.persistence.*;

@Entity
public class Doctor {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private long doctor_id;

	@Column(name = "TYPE")
	private String doctorType;
	@Column(name = "FIRSTNAME")
	private String firstName;
	@Column(name = "LASTNAME")
	private String lastName;



	public Doctor() {
	}

	public Doctor(String doctorType, String firstName, String lastName) {
		this.doctorType = doctorType;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Doctor{" +
				"doctorType='" + doctorType + '\'' +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				'}';
	}

	public String getDoctorType() {
		return doctorType;
	}

	public void setDoctorType(String doctorType) {
		this.doctorType = doctorType;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
