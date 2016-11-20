package ru.sbt.crm.dao;

import org.springframework.stereotype.Repository;
import ru.sbt.crm.common.GenericDao;
import ru.sbt.crm.entity.Address;

@Repository
public interface AddressDao extends GenericDao<Address, Long> {
}
