package ru.sbt.crm.dao;

import org.springframework.stereotype.Repository;
import ru.sbt.crm.entity.Customer;

@Repository
public interface CustomerDao {
    Customer get(Long id);
    Customer create(Customer t);
    Customer update(Customer t);
    void delete(Long id);
}
