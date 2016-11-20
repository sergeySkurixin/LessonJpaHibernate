package ru.sbt.crm.dao;

import ru.sbt.crm.entity.Customer;

public interface CustomerDao {
    Customer get(Long id);
    Customer update(Customer t);
    Customer create(Customer t);
    void delete(Long id);
}
