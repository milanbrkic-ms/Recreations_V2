package com.recreations.controller;

import com.recreations.model.City;
import com.recreations.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/city")
@RestController
@CrossOrigin(origins = "http://localhost:2000")
public class CityController {

  @Autowired private CityService service;

  @GetMapping("/all")
  public @ResponseBody Object getAll() {
    return ResponseEntity.ok().body(service.getAll());
  }

  @GetMapping("/{id}")
  public @ResponseBody Object get(@PathVariable Integer id)  {
    return ResponseEntity.ok().body(service.get(id));
  }

  @PostMapping("/add")
  public @ResponseBody Object add(@RequestBody City city) {
    return ResponseEntity.ok().body(service.add(city));
  }

  @DeleteMapping("/{id}")
  public @ResponseBody Object remove(@PathVariable int id) {
    return ResponseEntity.ok().body(service.remove(id));
  }
}
