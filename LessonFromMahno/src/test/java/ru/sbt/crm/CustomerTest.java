package ru.sbt.crm;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.transaction.annotation.Transactional;
import ru.sbt.crm.dao.AddressDao;
import ru.sbt.crm.dao.CustomerDao;
import ru.sbt.crm.entity.Address;
import ru.sbt.crm.entity.Customer;

@ContextConfiguration(locations = {"/applicationContext.xml"})
@Rollback(false)
@Transactional(transactionManager = "transactionManager")
public class CustomerTest extends AbstractTransactionalJUnit4SpringContextTests {
    @Autowired
    private AddressDao addressDao;
    @Autowired
    private CustomerDao customerDao;

    @Test
    public void testGetCustomer() throws Exception {
        Customer getCustomer = customerDao.get(1L);
        Assert.assertNotNull(getCustomer);
        Assert.assertNotNull(getCustomer.getAddress());
        Assert.assertNotNull(getCustomer.getAddress().getCountry());
    }

    @Test
    public void testCreateCustomer() {
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        AddressDao addressDao = context.getBean(AddressDao.class);
//        CustomerDao customerDao = context.getBean(CustomerDao.class);

        Customer customer = new Customer();
        customer.setFirstName("Иван");
        customer.setLastName("Иванов");
        customer.setPhone("+70000000001");
        customer.setEmail("test@test.ru");
        customer.setAddress(new Address(1L));
        customer = customerDao.create(customer);

        Customer createdCustomer = customerDao.get(customer.getId());
        Assert.assertNotNull(createdCustomer);
        Assert.assertEquals("Иван", createdCustomer.getFirstName());
        Assert.assertEquals("Иванов", createdCustomer.getLastName());
        // и т.д.
    }

    @Test
    public void testDeleteCustomer() {
        Customer customer = customerDao.get(2L);
        Assert.assertNotNull(customer);

        customerDao.delete(customer.getId());

        Customer deletedCustomer = customerDao.get(customer.getId());
        Assert.assertNull(deletedCustomer);
    }

}
