package com.crm.miniCRM.model.persistence;


import com.crm.miniCRM.model.Address;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AddressRepository extends CrudRepository<Address, Long> {

    List<Address> findByStreet(String street);

    Address findById(long id);
}