package com.recreations.repository;

import com.recreations.model.Member;
import com.recreations.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberDAO extends JpaRepository<Member, String> {}
