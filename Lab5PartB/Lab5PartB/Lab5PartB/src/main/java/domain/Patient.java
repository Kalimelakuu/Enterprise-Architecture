package domain;

import javax.persistence.*;

@Entity
@SecondaryTable(name = "Address", pkJoinColumns = {
		@PrimaryKeyJoinColumn(name = "PATIENT_ID", referencedColumnName = "ID"),

})
public class Patient {
	@Id
	@GeneratedValue

	@Column(name = "ID")
	private long patient_id;

	@Column(name = "Name")
	private String name;

	@Column(name = "STREET", table = "Address")
	private String street;
	@Column(name = "ZIP", table = "Address")
	private String zip;
	@Column(name = "CITY", table = "Address")
	private String city;

	public Patient() {
	}

	@Override
	public String toString() {
		return "Patient{" +
				"patient_id=" + patient_id +
				", name='" + name + '\'' +
				", street='" + street + '\'' +
				", zip='" + zip + '\'' +
				", city='" + city + '\'' +
				'}';
	}

	public Patient(String name, String street, String zip, String city) {
		this.name = name;
		this.street = street;
		this.zip = zip;
		this.city = city;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
}
