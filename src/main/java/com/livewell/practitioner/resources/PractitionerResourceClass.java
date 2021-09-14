package com.livewell.practitioner.resources;

import com.livewell.practitioner.model.Practitioner;
import com.livewell.practitioner.repo.PractitionerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/practitioner")
public class PractitionerResourceClass {
    @Autowired // This means to get the bean called userRepository
    private PractitionerRepository practitionerRepository;

    public PractitionerResourceClass(PractitionerRepository practitionerRepository) {
        this.practitionerRepository = practitionerRepository;
        List<Practitioner> practitioners = new ArrayList<>();
        practitioners.add(new Practitioner("Dean", "Jones", "Practitioner1"));
        practitioners.add(new Practitioner("Seema", "Gupta", "Practitioner2"));
        practitioners.add(new Practitioner("Daniel", "Cheema", "Practitioner3"));
        practitionerRepository.saveAll(practitioners);
    }

    @RequestMapping("/{practitionerId}")
    public @ResponseBody Practitioner Practitioner(@PathVariable("practitionerId") String practitionerId) {

        return practitionerRepository.getPractitionerByPractitionerId(practitionerId);
    }



}
