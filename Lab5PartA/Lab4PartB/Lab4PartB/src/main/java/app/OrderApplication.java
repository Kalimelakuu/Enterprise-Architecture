package app;

import domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import repositories.OrderRepositories;

@SpringBootApplication
@EnableJpaRepositories("repositories")
@EntityScan("domain") 
public class OrderApplication implements CommandLineRunner{




	@Autowired
	private OrderRepositories orderRepositories;

	public static void main(String[] args) {
		SpringApplication.run(OrderApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Product product = new DVD("dvd1", "it is a dvd", 90, "Adventure");

		OrderLine ol1 = new OrderLine(2, product);

		Product product2 = new CD("cd1", "it is a cd", 80, "Selena Gomez");

		OrderLine ol2 = new OrderLine(4, product2);

		Product product3 = new Book("book", "it is a book", 100, "123-234-2323");

		OrderLine ol3 = new OrderLine(3, product3);

		Order o1 = new Order("234743", "12/10/06", "open");
		o1.addOrderLine(ol1);
		o1.addOrderLine(ol2);
		o1.addOrderLine(ol3);

		Customer c1 = new Customer("Frank", "Brown", "Mainstreet 1",
				"New york", "43221");
		c1.addOrder(o1);

		o1.setCustomer(c1);

		orderRepositories.save(o1);


		printOrder(o1);
	}

	public static void printOrder(Order order) {
		System.out.println("Order with orderNumber: " + order.getOrdernr());
		System.out.println("Order date: " + order.getDate());
		System.out.println("Order status: " + order.getStatus());
		Customer cust = order.getCustomer();
		System.out.println("Customer: " + cust.getFirstname() + " "
				+ cust.getLastname());
		for (OrderLine orderline : order.getOrderlines()) {
			System.out.println("Order line: quantity= "
					+ orderline.getQuantity());
			Product product = orderline.getProduct();
			System.out.println("Product: " + product.getName() + " "
					+ product.getDescription() + " " + product.getPrice());
		}

	}
}
