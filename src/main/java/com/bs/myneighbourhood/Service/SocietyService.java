package com.bs.myneighbourhood.Service;

import com.bs.myneighbourhood.document.SocietyDocument;
import com.bs.myneighbourhood.dto.Address;
import com.bs.myneighbourhood.dto.Society;
import com.bs.myneighbourhood.repository.SocietyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class SocietyService {

    @Autowired
    SocietyRepository repository;

    public Society getSocietyById(Integer id) {
        Society society = new Society();
        society.setId(id);
        society.setContactNumber("987654321");
        society.setContactPerson("Mukesh Saral Singh");
        society.setName("Oxy Evolve");
        Address address = new Address();
        address.setAddress("Domkhel road near raisoni Engg College Wagholi");
        address.setCity("Pune");
        address.setPinCde("410027");
        society.setAddress(address);

        return society;

    }

    public Society addSociety() {
        SocietyDocument society = new SocietyDocument();
        society.setContactNumber("987654321");
        society.setContactPerson("Mukesh Saral Singh");
        society.setName("Oxy Evolve");
        society.setId(new Random().nextInt());
        SocietyDocument document  = repository.save(society);
        Society societyDB = new Society();
        societyDB.setContactNumber(document.getContactNumber());
        societyDB.setContactPerson(document.getContactPerson());
        societyDB.setName(document.getName());
        societyDB.setId(document.getId());
        return societyDB;
    }
}
