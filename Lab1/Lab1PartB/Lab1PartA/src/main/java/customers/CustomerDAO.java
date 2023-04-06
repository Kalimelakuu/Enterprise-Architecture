package customers;
@Service
public class CustomerDAO implements ICustomerDAO{
	private ILogger logger;

	@Autowired
	public CustomerDAO(ILogger iLogger){
		this.logger = iLogger;
	}
	
	public void save(Customer customer) {
		// simple sleep
		try {
			Thread.sleep(350);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("CustomerDAO: saving customer "+customer.getName());
		logger.log("Customer is saved in the DB: "+ customer.getName() );
	}

}
