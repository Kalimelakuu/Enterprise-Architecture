package customers;
@Service
public class EmailSender implements IEmailSender {
	String outgoingMailServer = "smtp.acme.com";
	private ILogger logger;

	@Autowired
	public EmailSender(ILogger iLogger){
		this.logger = iLogger;
	}


	public String getOutgoingMailServer() {
		return outgoingMailServer;
	}

	public void sendEmail (String email, String message){
		System.out.println("EmailSender: sending '"+message+"' to "+email );
		logger.log("Email is sent: message= "+message +" , emailaddress ="+ email  );
	}
}
