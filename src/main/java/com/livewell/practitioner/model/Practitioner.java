package com.livewell.practitioner.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Practitioner {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String firstName;
    private String lastName;
    private String practitionerId;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPractitionerId() {
        return practitionerId;
    }

    public Practitioner() {
    }

    public Practitioner(String firstName, String lastName, String practitionerId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.practitionerId = practitionerId;
    }
}
