package com.bs.myneighbourhood.api.dto;


import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;
import java.util.Set;

public final class PersonDTO {
    
    private final String uuid;
    
    private final String firstname;
    
    private final String lastname;
    
    private final String birthName;
    
    private final LocalDate birthdate;
    
    private final Gender gender;
    
    private PersonDTO mother;
    
    private PersonDTO father;
    
    private PersonDTO spouse;
    
    private final Set siblings;
    
    private final Set friends;

    
    public final String getUuid() {
        return this.uuid;
    }

    
    public final String getFirstname() {
        return this.firstname;
    }

    
    public final String getLastname() {
        return this.lastname;
    }

    
    public final String getBirthName() {
        return this.birthName;
    }

    
    public final LocalDate getBirthdate() {
        return this.birthdate;
    }

    
    public final Gender getGender() {
        return this.gender;
    }

    
    public final PersonDTO getMother() {
        return this.mother;
    }

    public final void setMother( PersonDTO var1) {
        this.mother = var1;
    }

    
    public final PersonDTO getFather() {
        return this.father;
    }

    public final void setFather( PersonDTO var1) {
        this.father = var1;
    }

    
    public final PersonDTO getSpouse() {
        return this.spouse;
    }

    public final void setSpouse( PersonDTO var1) {
        this.spouse = var1;
    }

    
    public final Set getSiblings() {
        return this.siblings;
    }

    
    public final Set getFriends() {
        return this.friends;
    }

    public PersonDTO( String uuid,  String firstname,  String lastname,  String birthName,  LocalDate birthdate,  Gender gender,  PersonDTO mother,  PersonDTO father,  PersonDTO spouse,  Set<PersonDTO> siblings,  Set<PersonDTO> friends) {

        this.uuid = uuid;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthName = birthName;
        this.birthdate = birthdate;
        this.gender = gender;
        this.mother = mother;
        this.father = father;
        this.spouse = spouse;
        this.siblings = siblings;
        this.friends = friends;
    }

    public boolean equals( Object var1) {
        if (this != var1) {
            if (var1 instanceof PersonDTO) {
                PersonDTO var2 = (PersonDTO) var1;
                if (StringUtils.equals(this.uuid, var2.uuid) && StringUtils.equals(this.firstname, var2.firstname) && StringUtils.equals(this.lastname, var2.lastname) && StringUtils.equals(this.birthName, var2.birthName) && this.birthdate.equals(var2.birthdate) && this.gender.equals(var2.gender) && this.mother.equals(var2.mother) && this.father.equals(var2.father) && this.spouse.equals(var2.spouse) && this.siblings.equals(var2.siblings) && this.friends.equals(var2.friends)) {
                    return true;
                }
            }

            return false;
        } else {
            return true;
        }
    }
}
