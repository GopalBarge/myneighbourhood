package com.bs.myneighbourhood.controller;

import com.bs.myneighbourhood.Service.SocietyService;
import com.bs.myneighbourhood.dto.Society;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("society")
public class SocietyController {

    @Autowired
    SocietyService service;

   /* @GetMapping("/all")
    public ResponseEntity<Society> getAll() {
        return new ResponseEntity<Society>(service.getAllSocieties(), HttpStatus.OK);
    }
*/

    @GetMapping("/{id}")
    public ResponseEntity<Society> get(@PathVariable(value = "id") Integer id) {
        return new ResponseEntity<Society>(service.getSocietyById(id), HttpStatus.OK);    }
    @GetMapping("/add")
    public ResponseEntity<Society> add() {
        return new ResponseEntity<Society>(service.addSociety(), HttpStatus.OK);    }
}

