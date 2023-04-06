package edu.miu.EA_Lab2_A;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("mock")
public class CustomerDAOMock implements ICustomerDAO{

    private ILogger logger ;

    @Autowired
    public  CustomerDAOMock (ILogger logger){
        this.logger = logger;
    }

    public void save(Customer customer) {
        // simple sleep
        try {
            Thread.sleep(350);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("CustomerDAO Mock: saving customer "+customer.getName());
        logger.log("Customer Mock is saved in the DB: "+ customer.getName() );
    }
}
