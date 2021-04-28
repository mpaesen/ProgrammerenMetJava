package com.crm.miniCRM.model.persistence;

import com.crm.miniCRM.model.Event;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface EventRepository extends CrudRepository<Event, Long> {

    List<Event> findByDescription(String description);
    List<Event> findByDate(LocalDate date);

    Event findById(long id);
}