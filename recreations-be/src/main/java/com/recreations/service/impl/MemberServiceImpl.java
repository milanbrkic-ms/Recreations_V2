package com.recreations.service.impl;

import com.recreations.model.Member;
import com.recreations.model.Person;
import com.recreations.model.Training;
import com.recreations.repository.MemberDAO;
import com.recreations.repository.PersonDAO;
import com.recreations.service.MemberService;
import com.recreations.service.PersonService;
import com.recreations.service.exception.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {
  @Autowired private MemberDAO personRepository;

  @Override
  public List<Member> getAll() {
    return personRepository.findAll();
  }

  @Override
  public Member get(String id)  {
    return Optional.ofNullable(personRepository.findOne(id)).orElseThrow(EntityNotFoundException::new);
  }

  @Override
  public Member add(Member newPerson) {
    return personRepository.save(newPerson);
  }

  @Override
  public Member remove(String obj) {
    Member member = get(obj);
    personRepository.delete(member);
    return member;
  }

  @Override
  public void update(Member person) {
    personRepository.saveAndFlush(person);
  }

  @Override
  public List<Training> getTrainings(String id) {
    Member m = Optional.ofNullable(personRepository.findOne(id)).orElseThrow(EntityNotFoundException::new);
    List<Training> trainings = m.getTrainings();

    return trainings;
  }
}
