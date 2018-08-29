/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recreations.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import lombok.Setter;

/** @author Milan */
@Entity
@Getter
@Setter
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tip")
@DiscriminatorValue("N/A")
public class Person implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "idosoba")
  protected int idOsoba;

  protected String ime;
  protected String prezime;

  @Column(name = "datumrodjenja")
  @NotNull
  protected LocalDate datumRodjenja;
  @Column(name = "profileimage")
  protected String profileImage;
  protected char pol;
  protected double height;
  protected double weight;
  protected double rating;
  protected double stamina;

  @ManyToOne
  @JoinColumn(name = "mesto")
  protected City city;

  public Person(int idOsoba) {
    this.idOsoba = idOsoba;
  }

  public Person(String ime, String prezime, LocalDate datumRodjenja, char pol, City city) {
    this.ime = ime;
    this.prezime = prezime;
    this.datumRodjenja = datumRodjenja;
    this.pol = pol;
    this.city = city;
  }

  @Override
  public String toString() {
    return "" + idOsoba;
  }

  public String getName() {
    return this.ime + " " + this.prezime;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 67 * hash + this.idOsoba;
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
    final Person other = (Person) obj;
    return this.idOsoba == other.idOsoba;
  }
}
