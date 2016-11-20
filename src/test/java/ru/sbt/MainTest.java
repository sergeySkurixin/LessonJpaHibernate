package ru.sbt;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import ru.sbt.crm.entity.Customer;
import ru.sbt.crm.dao.CustomerDao;

@ContextConfiguration(locations = {"/applicationContext.xml"})
//@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
public class MainTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private CustomerDao customerDao;

    @Test
    public void testCustomer() throws Exception {
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        CustomerDao customerDao = context.getBean(CustomerDao.class);

//        Customer getCustomer = customerDao.get(1L);
//        Assert.assertNull(getCustomer);

        Customer customer = new Customer();
        customer.setEmail("email");
        customer.setFirstName("firstName");
        customer.setLastName("lastName");
        customer.setPhone("1235443");
        Customer createdCustomer = customerDao.create(customer);

        Customer getCustomer = customerDao.get(createdCustomer.getId());
        Assert.assertNotNull(getCustomer);

        customerDao.delete(getCustomer.getId());
//        Customer deletedCustomer = customerDao.get(createdCustomer.getId());
//        Assert.assertNotNull(deletedCustomer);


    }
}
