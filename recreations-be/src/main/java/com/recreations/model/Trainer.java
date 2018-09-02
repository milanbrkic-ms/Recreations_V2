/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recreations.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/** @author Milan */
@Entity
@Getter
@AllArgsConstructor
@DiscriminatorValue("T")
@Table(name = "trainer")
public class Trainer extends Person implements Serializable {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "trenerid")
  private int trenerID;

  @Column(name = "godinerada")
  private int godineRada;

  @Column(name = "kratakcv")
  private String kratakCV;

  @ManyToOne
  @JoinColumn(name = "sportid")
  private Sport sport;

  @ManyToMany(mappedBy = "treneri")
  @JsonIgnoreProperties("treneri")
  private List<Training> trainings = new ArrayList<>();


  public Trainer() {
    super();
  }

  public Trainer(String ime, String prezime, LocalDate datumRodjenja, char pol, City city) {
    super(ime, prezime, datumRodjenja, pol, city);
  }

  public void setTrenerID(int trenerID) {
    this.trenerID = trenerID;
  }

  public void setGodineRada(int godineRada) {
    this.godineRada = godineRada;
  }

  public void setKratakCV(String kratakCV) {
    this.kratakCV = kratakCV;
  }

  public void setSport(Sport sport) {
    this.sport = sport;
  }

  @Override
  public String toString() {
    return trenerID + " " + super.toString();
  }
}
