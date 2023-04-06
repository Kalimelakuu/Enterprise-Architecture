package customers;
@Service
public class CustomerService implements ICustomerService {
	ICustomerDAO customerDAO;
	IEmailSender emailSender;

	@Autowired
	public void setCustomerDAO(ICustomerDAO iCustomerDAO){
		this.customerDAO = iCustomerDAO;
	}

	@Autowired
	public void setEmailSender(IEmailSender iEmailSender){
		this.emailSender = iEmailSender;
	}

	public void addCustomer(String name, String email, String street,
			String city, String zip) {
		Customer customer = new Customer(name, email);
		Address address = new Address(street, city, zip);
		customer.setAddress(address);
		customerDAO.save(customer);
		emailSender.sendEmail(email, "Welcome To This " + name + " as a new customer");
	}
}
