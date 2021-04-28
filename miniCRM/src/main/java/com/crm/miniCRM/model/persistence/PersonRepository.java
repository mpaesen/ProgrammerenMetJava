package com.crm.miniCRM.model.persistence;


import com.crm.miniCRM.model.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Long> {

    List<Person> findByLastName(String lastName);

    Person findById(long id);
}