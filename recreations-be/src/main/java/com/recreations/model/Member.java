/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recreations.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/** @author Milan */
@Entity
@Getter
@DiscriminatorValue("C")
public class Member extends Person implements Serializable {
  @Column(name = "imeroditelja")
  private String imeRoditelja;

  @Column(name = "godinaupisa")
  private int godinaUpisa;

  @Transient private boolean promenjen = false;

  public Member() {}

  public Member(String ime, String prezime, LocalDate datumRodjenja, char pol, City city) {
    super(ime, prezime, datumRodjenja, pol, city);
  }

  @JsonIgnoreProperties("clanovi")
  @ManyToMany(mappedBy = "clanovi")
  private List<Training> trainings = new ArrayList<>();

  public Member(
      String imeRoditelja,
      int godinaUpisa,
      String ime,
      String prezime,
      LocalDate datumRodjenja,
      char pol,
      City city) {
    super(ime, prezime, datumRodjenja, pol, city);
    this.imeRoditelja = imeRoditelja;
    this.godinaUpisa = godinaUpisa;
  }

  public boolean isPromenjen() {
    return promenjen;
  }

  public void setPromenjen(boolean promenjen) {
    this.promenjen = promenjen;
  }

  @Override
  public String toString() {
    return super.toString();
  }

  public void setImeRoditelja(String imeRoditelja) {
    this.imeRoditelja = imeRoditelja;
  }

  public void setGodinaUpisa(int godinaUpisa) {
    this.godinaUpisa = godinaUpisa;
  }

  @Override
  public int hashCode() {
    int hash = 5;
    hash = Integer.parseInt(97 * hash + this.idOsoba);
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
    return super.equals(obj);
  }
}
