/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recreations.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/** @author Milan */
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class City implements Serializable {
  @Id private int ptt;

  @Column(name = "nazivmesta")
  private String name;

  public City(int ptt) {
    this.ptt = ptt;
  }

  public void setPtt(int ptt) {
    this.ptt = ptt;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return this.name;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 59 * hash + this.ptt;
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final City other = (City) obj;
    return this.ptt == other.ptt;
  }
}
