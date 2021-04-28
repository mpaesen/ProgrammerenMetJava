package com.crm.miniCRM.model.persistence;

import com.crm.miniCRM.model.Community;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommunityRepository extends CrudRepository<Community, Long> {

    List<Community> findByDescription(String description);

    Community findById(long id);
}