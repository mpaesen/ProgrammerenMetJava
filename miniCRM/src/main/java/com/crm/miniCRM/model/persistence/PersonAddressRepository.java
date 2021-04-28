package com.crm.miniCRM.model.persistence;


import com.crm.miniCRM.model.PersonAddress;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PersonAddressRepository extends CrudRepository<PersonAddress, PersonAddressID> {

    Optional<PersonAddress> findById(PersonAddressID personAddressID);

}