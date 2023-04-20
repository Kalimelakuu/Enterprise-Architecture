package app.Lab4PartA;

import domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import repositories.*;

import java.util.Date;
import java.util.Optional;

@SpringBootApplication
@EnableJpaRepositories("repositories")
@EntityScan("domain")
public class Lab4PartAApplication implements CommandLineRunner {

	@Autowired
	private DepartmentRepositories departmentRepositories;

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private BookRepositories bookRepositories;

	@Autowired
	private PublisherRepository publisherRepository;

	@Autowired
	private PassengerRepositories passengerRepositories;
	@Autowired
	private FlightRepositories flightRepositories;

	@Autowired
	private SchoolRepositories schoolRepositories;

	public static void main(String[] args) {
		SpringApplication.run(Lab4PartAApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

		Department software = new Department ("Software");

		Employee employee1 = new Employee("1253","Kalkidan");
		Employee employee2 = new Employee("245","Betelehem");
		Employee employee3 = new Employee("345","Kalkidan2");
		Employee employee4 = new Employee("456","Kalkidan3");

		employee1.setDepartment(software);
		employee2.setDepartment(software);
		employee3.setDepartment(software);
		employee4.setDepartment(software);

		software.addEmployee(employee1);
		software.addEmployee(employee2);
		software.addEmployee(employee3);
		software.addEmployee(employee4);

		//employeeRepository.save(employee1);
//		employeeRepository.save(employee2);
//		employeeRepository.save(employee3);
//		employeeRepository.save(employee4);

		departmentRepositories.save(software);
		// fetch an individual customer by ID
		System.out.println("Fetch Customer  with findById(1L):");
		Optional<Department> dptOpt = departmentRepositories.findById(1L);
		Department department2 = dptOpt.get();
		System.out.println("Department found with findById(1L):");
		System.out.println("--------------------------------");
		System.out.println(department2);
		System.out.println();

		Publisher publisher1 = new Publisher("Dn.Henock");

		Book Hmamat = new Book(234,"Himamat","Dn.Henok");
		Hmamat.setPublisher(publisher1);
		Book  yeBirhaneEnat = new Book(2334,"yeBirhaneEnat","Dn.Henok");
		yeBirhaneEnat.setPublisher(publisher1);
		Book  yeEphratiusWenz = new Book(2134,"yeEphratiusWenz","Dn.Henok");
		yeEphratiusWenz.setPublisher(publisher1);


		publisherRepository.save(publisher1);


		bookRepositories.save(Hmamat);
		bookRepositories.save(yeBirhaneEnat);
		bookRepositories.save(yeEphratiusWenz);



		// fetch all books
		System.out.println("Books found with findAll():");
		System.out.println("-------------------------------");
		for (Book book : bookRepositories.findAll()) {
			System.out.println(book);
		}


		// fetch all publisher
		System.out.println("Publisher found with findAll():");
		System.out.println("-------------------------------");
		for (Publisher publisher : publisherRepository.findAll()) {
			System.out.println(publisher);
		}

		Passenger passenger = new Passenger("Hailesh");
		Flights flight1 = new Flights(1, "AA", "USA", new Date());
		Flights flight2 = new Flights(2, "USA", "Italy", new Date());
		Flights flight3 = new Flights(3, "Italy", "AA", new Date());


		passenger.addFlightList(flight1);
		passenger.addFlightList(flight2);
		passenger.addFlightList(flight3);


		passengerRepositories.save(passenger);

		// fetch all passenger
		System.out.println("Passenger found with findAll():");
		System.out.println("-------------------------------");
		for (Passenger passengerr : passengerRepositories.findAll()) {
			System.out.println(passengerr);
		}

		School MIU = new School("Miu");

		Student kal = new Student(12, "Kalkidan", "Hailemariam");
		Student betty = new Student(19, "Betelhem", "Gebersilasse");
		Student yosi = new Student(21, "Yoseph", "Mekonnen");

		MIU.put(kal.getStudentid(), kal);
		MIU.put(betty.getStudentid(), betty);
		MIU.put(yosi.getStudentid(), yosi);

		schoolRepositories.save(MIU);

		// fetch all passenger
		System.out.println("School found with findAll():");
		System.out.println("-------------------------------");
		for (School school : schoolRepositories.findAll()) {
			System.out.println(school);
		}



	}


}
