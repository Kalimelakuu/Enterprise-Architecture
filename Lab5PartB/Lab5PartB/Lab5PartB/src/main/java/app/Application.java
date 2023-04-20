package app;

import domain.Appointment;
import domain.Doctor;
import domain.Patient;
import domain.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import repositories.AppointementRepositories;
import repositories.DoctorRepositories;
import repositories.PatientRepositories;

@SpringBootApplication
@EnableJpaRepositories("repositories")
@EntityScan("domain") 
public class Application implements CommandLineRunner{
	

	@Autowired
	AppointementRepositories appointementRepositories;

	@Autowired
	DoctorRepositories doctorRepositories;

	@Autowired
	PatientRepositories patientRepositories;


	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Doctor doctor1 = new Doctor("Chirurg", "Frank", "Brown");
		Doctor doctor2 = new Doctor("Nurse", "Mary", "Jones");

		doctorRepositories.save(doctor1);
		doctorRepositories.save(doctor2);

		Payment payment1 = new Payment("10-10-2008", 12.50);
		Payment payment2 = new Payment("11-10-2008", 45.00);
		Payment payment3 = new Payment("12-10-2008", 99.60);
		Payment payment4 = new Payment("13-10-2008", 55.80);

		Patient patient1 = new Patient("Jerry Lewis", "34 4th avenue",
				"13221", "New York");
		Patient patient2 = new Patient("Frank Moore", "34 Mainstret",
				"13221", "New York");
		Patient patient3 = new Patient("Sam ruby", "105 N Street", "13221",
				"New York");

		patientRepositories.save(patient1);
		patientRepositories.save(patient2);
		patientRepositories.save(patient3);

		Appointment appointment1 = new Appointment("11-11-2008", patient1,
				payment1, doctor1);
		Appointment appointment2 = new Appointment("12-11-2008", patient2,
				payment2, doctor2);
		Appointment appointment3 = new Appointment("13-11-2008", patient3,
				payment3, doctor2);
		Appointment appointment4 = new Appointment("14-11-2008", patient1,
				payment4, doctor1);

		appointementRepositories.save(appointment1);
		appointementRepositories.save(appointment2);
		appointementRepositories.save(appointment3);
		appointementRepositories.save(appointment4);
		// fetch all books
		System.out.println("Appointment found with findAll():");
		System.out.println("-------------------------------");
//		for (Appointment appointment : appointementRepositories.findAll()) {
//			System.out.println(appointment);
//		}
		System.out.println();

	}


}
