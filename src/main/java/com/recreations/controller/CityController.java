package com.recreations.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.recreations.service.CityService;

@RequestMapping("/city")
@RestController
public class CityController {

    @Autowired
    private CityService service;

    @GetMapping("/all")
    public @ResponseBody Object getAll() {
        return ResponseEntity.ok().body(service.getAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Object get(@PathVariable Integer id) {
        return ResponseEntity.ok().body(service.get(id));
    }

}
