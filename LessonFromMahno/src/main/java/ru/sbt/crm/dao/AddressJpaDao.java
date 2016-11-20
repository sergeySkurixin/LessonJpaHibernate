package ru.sbt.crm.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.sbt.crm.common.GenericJpaDao;
import ru.sbt.crm.entity.Address;


@Repository
public class AddressJpaDao extends GenericJpaDao<Address, Long> implements AddressDao {
}
