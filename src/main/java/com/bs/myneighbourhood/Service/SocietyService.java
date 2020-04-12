package com.bs.myneighbourhood.Service;

import com.bs.myneighbourhood.dto.Society;
import com.bs.myneighbourhood.dynamodb.model.SocietyDocument;
import com.bs.myneighbourhood.repository.SocietyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SocietyService {

    @Autowired
    SocietyRepository repository;


    public Society getSocietyByName(String name, String city) {
        SocietyDocument document = repository.load(name, city).get();
        Society societyDB = new Society();

        societyDB.setName(document.getName());
        societyDB.setCity(document.getCity());

        societyDB.setContactNumber(document.getContactNumber());
        societyDB.setContactPerson(document.getContactPerson());
        societyDB.setName(document.getName());
        societyDB.setId(document.getId());
        return societyDB;
    }

    public Society addSociety(Society document) {
        SocietyDocument societyDB = new SocietyDocument();
        societyDB.setCity(document.getCity());
        societyDB.setContactNumber(document.getContactNumber());
        societyDB.setContactPerson(document.getContactPerson());
        societyDB.setName(document.getName());
        societyDB.setId(document.getId());
        repository.save(societyDB);
        return getSocietyByName(document.getName(), document.getCity());
    }
}
