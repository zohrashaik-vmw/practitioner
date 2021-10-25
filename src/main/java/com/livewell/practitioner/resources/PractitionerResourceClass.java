package com.livewell.practitioner.resources;

import com.livewell.practitioner.model.Practitioner;
import com.livewell.practitioner.repo.PractitionerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        practitioners.add(new Practitioner("Dean Jones"));
        practitioners.add(new Practitioner("Seema Gupta"));
        practitioners.add(new Practitioner("Daniel Cheema"));
        practitionerRepository.saveAll(practitioners);
    }

    @RequestMapping ("/list")
    public Iterable<Practitioner> getPractitioner()
    {
        return practitionerRepository.findAll();
    }

    @RequestMapping("/getPractitionerIdByName")
    public int  getPractitionerIdByName(@RequestParam("name") String name) {

        Practitioner practitioner = practitionerRepository.findByName(name);
        if (practitioner != null) {
            return practitioner.getId();
        }

        return 0;
    }
}
