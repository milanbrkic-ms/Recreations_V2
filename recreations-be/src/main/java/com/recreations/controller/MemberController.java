package com.recreations.controller;

import com.recreations.service.MemberService;
import com.recreations.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
@CrossOrigin(origins = "http://localhost:2000")
public class MemberController {

  @Autowired private MemberService service;

  @GetMapping("/all")
  public @ResponseBody Object getAll() {
    return ResponseEntity.ok().body(service.getAll());
  }

  @GetMapping("/{id}")
  public @ResponseBody Object get(@PathVariable String id)  {
    return ResponseEntity.ok().body(service.get(id));
  }

  @GetMapping("/{id}/trainings")
  public @ResponseBody Object getTrainigs(@PathVariable String id) {
    return ResponseEntity.ok().body(service.getTrainings(id));
  }
}
