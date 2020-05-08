package com.bs.myneighbourhood.api.endpoint.graphql;

import com.bs.myneighbourhood.Service.person.GetPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/person")
public class Controller {
    @Autowired
    GetPerson personService;

    @GetMapping("/all")
    public Collection getPeople() {
      return personService.all(10);
    }

}
