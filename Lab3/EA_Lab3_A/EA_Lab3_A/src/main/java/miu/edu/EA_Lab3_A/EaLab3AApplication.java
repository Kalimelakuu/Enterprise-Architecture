package miu.edu.EA_Lab3_A;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EaLab3AApplication implements CommandLineRunner {
	@Autowired
	private CustomerDAO customerDao;

	@Autowired
	private ProductDAO productDAO;

	public static void main(String[] args) {
		SpringApplication.run(EaLab3AApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		customerDao.clearDB();
		Customer customer = new Customer(101,"John doe", "johnd@acme.com", "0622341678");
		CreditCard creditCard = new CreditCard("12324564321", "Visa", "11/23");
		customer.setCreditCard(creditCard);
		customerDao.save(customer);
		customer = new Customer(66,"James Johnson", "jj123@acme.com", "068633452");
		creditCard = new CreditCard("99876549876", "MasterCard", "01/24");
		customer.setCreditCard(creditCard);
		customerDao.save(customer);
		System.out.println(customerDao.getCustomer(101));
		System.out.println(customerDao.getCustomer(66));
		System.out.println("-----------All customers ----------------");
		System.out.println(customerDao.getAllCustomers());

		Product product1 = new Product(1, "Amazon Product", 200);
		Product product2 = new Product(2, "Google Product", 300);
		Product product3 = new Product(3, "Microsoft Product", 400);

		productDAO.clearDB();
		productDAO.save(product1);
		productDAO.save(product2);
		productDAO.save(product3);
		System.out.println(productDAO.getProductByNumber(2));
		System.out.println(productDAO.getProductByName("Microsoft Product"));
		System.out.println("-----------All products ----------------");
		System.out.println(productDAO.getAllProduct());
		productDAO.removeProductByName("Microsoft Product");
		System.out.println("-----------All products ----------------");
		System.out.println(productDAO.getAllProduct());
	}

}
