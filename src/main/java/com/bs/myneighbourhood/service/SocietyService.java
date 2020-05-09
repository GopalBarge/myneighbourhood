package com.bs.myneighbourhood.service;

import com.bs.myneighbourhood.dto.Society;
import com.bs.myneighbourhood.entity.SocietyDocument;
import com.bs.myneighbourhood.mapper.SocietyMapper;
import com.bs.myneighbourhood.repository.SocietyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SocietyService {

    @Autowired
    SocietyRepository repository;

    @Autowired
    SocietyMapper societyMapper;

    public List<Society> getAllSocieties() {
        List<SocietyDocument> societyDocuments =  repository.getAllSocietyDetails();

//        repository.findAll().forEach(society -> societyDocuments.add(society));
        return societyDocuments.stream().map(societyMapper::toDto).collect(Collectors.toList());
    }

    public Society getSocietyById(Integer societyId) {
      return societyMapper.toDto(repository.getSocietyById(societyId));
    }

    public Society addSociety(Society society) {
        repository.addSociety(societyMapper.toEntity(society));
        SocietyDocument societyDoc = repository.getSocietyDetails(society.getCity(), society.getName());
        return  societyMapper.toDto(societyDoc);
    }

    public Society updateSociety(Society society) {
        repository.updateSociety(societyMapper.toEntity(society));
        SocietyDocument societyDoc = repository.getSocietyDetails(society.getCity(), society.getName());
        return  societyMapper.toDto(societyDoc);
    }
}
