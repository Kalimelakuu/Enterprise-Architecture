package domain;


import javax.persistence.*;
import javax.swing.*;

@Entity
public class Appointment {

	@Id
	@GeneratedValue
	private long id;
	private String appdate;

	@Embedded
	@AttributeOverrides( {
			@AttributeOverride(name="PAYDATE", column=@Column(name="payDate")),
			@AttributeOverride(name="AMOUNT", column=@Column(name="amount")),

	})
	private Payment payment;

	@ManyToOne()
	@JoinColumn(name = "PATIENT", referencedColumnName = "ID")
	private Patient patient;
	@ManyToOne()
	@JoinColumn(name = "DOCTOR", referencedColumnName = "ID")
    private Doctor doctor;

	public Appointment() {
	}

	public Appointment(String appdate, Patient patient, Payment payment,
			Doctor doctor) {
		this.appdate = appdate;
		this.patient = patient;
		this.payment = payment;
		this.doctor = doctor;
	}


	public String getAppdate() {
		return appdate;
	}

	public void setAppdate(String appdate) {
		this.appdate = appdate;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	@Override
	public String toString() {
		return "Appointment{" +
				"appdate='" + appdate + '\'' +
				", payment=" + payment +
				", patient=" + patient +
				", doctor=" + doctor +
				'}';
	}
}
