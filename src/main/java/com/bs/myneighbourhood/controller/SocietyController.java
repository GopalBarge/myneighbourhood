package com.bs.myneighbourhood.controller;

import com.bs.myneighbourhood.Service.SocietyService;
import com.bs.myneighbourhood.dto.Society;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{city}/{name}")
    public ResponseEntity<Society> get(@PathVariable(value = "name") String name, @PathVariable(value = "city") String city) {
        return new ResponseEntity<Society>(service.getSocietyByName(name,city), HttpStatus.OK);    }

    @PostMapping("/add")
    public ResponseEntity<Society> add(@RequestBody Society society) {
        return new ResponseEntity<Society>(service.addSociety(society), HttpStatus.OK);    }
}

