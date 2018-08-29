package com.recreations.controller;

import com.recreations.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/city")
@RestController
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
}
