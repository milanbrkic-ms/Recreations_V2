package com.recreations.repository;

import com.recreations.model.Sport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SportDAO extends JpaRepository<Sport, Integer> {}
