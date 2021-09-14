package com.livewell.practitioner.repo;


import com.livewell.practitioner.model.Practitioner;
import org.springframework.data.repository.CrudRepository;

public interface PractitionerRepository extends CrudRepository<Practitioner, Integer> {
    Practitioner getPractitionerByPractitionerId(String practitionerId);
}
