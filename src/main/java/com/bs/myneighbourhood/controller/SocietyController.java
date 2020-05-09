package com.bs.myneighbourhood.controller;

import com.bs.myneighbourhood.dto.Society;
import com.bs.myneighbourhood.service.SocietyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("society")
public class SocietyController {

    @Autowired
    private SocietyService service;

    @GetMapping("/all")
    public ResponseEntity<List<Society>> getAll() {
        return new ResponseEntity(service.getAllSocieties(), HttpStatus.OK);
    }

/*


    @GetMapping("/{city}/{name}")
    public ResponseEntity<Society> getSocietyByCityAndName(@PathVariable(value = "name") String name, @PathVariable(value = "city") String city) {
        return new ResponseEntity<Society>(service.getSocietyByCityAndName(name, city), HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<Society>> getSocietyByName(@PathVariable(value = "name") String name) {
        return new ResponseEntity(service.getSocietyByName(name), HttpStatus.OK);
    }

    @GetMapping("/{city}")
    public ResponseEntity<List<Society>> getSocietyByCity(@PathVariable(value = "city") String city) {
        return new ResponseEntity(service.getSocietyByCity(city), HttpStatus.OK);
    }
*/

    @GetMapping("/{societyId}")
    public ResponseEntity<Society> get(@PathVariable(value = "societyId") Integer societyId) {
        return new ResponseEntity<Society>(service.getSocietyById(societyId), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Society> add(@RequestBody Society society) {
        return new ResponseEntity<Society>(service.addSociety(society), HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<Society> update(@RequestBody Society society) {
        return new ResponseEntity<Society>(service.updateSociety(society), HttpStatus.OK);
    }
  /*  @PostMapping("/delete/{societyId}")
    public ResponseEntity<Society> delete((@PathVariable(value = "societyId") Integer societyId) {
        return new ResponseEntity<Society>(service.deleteSociety(society), HttpStatus.OK);
    }
*/


}

