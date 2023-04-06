package edu.miu.EA_Lab2_A;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EaLab2AApplication implements CommandLineRunner {

	@Autowired
	ICustomerService customerService;

	public static void main(String[] args) {
		SpringApplication.run(EaLab2AApplication.class, args);
	}


	public void run(String... args) throws  Exception{
		customerService.addCustomer("Frank Brown", "fbrown@acme.com",
				"mainstreet 5", "Chicago", "60613");
	}

}
