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
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/** @author Milan */
@Entity
@Getter
public class Training implements Serializable {

  @JsonIgnoreProperties("trainings")
  @ManyToMany(fetch = FetchType.LAZY)
  // @LazyCollection(LazyCollectionOption.FALSE)
  @JoinTable(
    name = "tclan",
    joinColumns = {@JoinColumn(name = "treningid", referencedColumnName = "treningid")},
    inverseJoinColumns = {@JoinColumn(name = "clanid", referencedColumnName = "idosoba")}
  )
  private List<Member> clanovi;

  @JsonIgnoreProperties("trainings")
  @ManyToMany(fetch = FetchType.LAZY)
  // @LazyCollection(LazyCollectionOption.FALSE)
  @JoinTable(
    name = "tt",
    joinColumns = @JoinColumn(name = "treningid", referencedColumnName = "treningid"),
    inverseJoinColumns = @JoinColumn(name = "trenerid", referencedColumnName = "idosoba")
  )
  private List<Trainer> treneri;

  @Column(name = "vremeod")
  private LocalTime vremeOd;

  @Column(name = "vremedo")
  private LocalTime vremeDo;

  @Column(name = "datum")
  private LocalDate datum;

  @ManyToOne
  @JoinColumn(name = "sport")
  private Sport sport;

  @Id
  @Column(name = "treningid")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int treningId;

  @Column(name = "nazivtreninga")
  private String nazivTreninga;

  public Training() {
    clanovi = new ArrayList<>();
    treneri = new ArrayList<>();
  }

  public Training(int treningId) {
    this.treningId = treningId;
  }

  public Training(LocalTime vremeOd, LocalTime vremeDo, LocalDate datum, String nazivTreninga) {
    this.vremeOd = vremeOd;
    this.vremeDo = vremeDo;
    this.datum = datum;
    this.nazivTreninga = nazivTreninga;
  }

  public Training(LocalTime vremeOd, LocalTime vremeDo, LocalDate datum) {
    this.vremeOd = vremeOd;
    this.vremeDo = vremeDo;
    this.datum = datum;
  }

  public Training(LocalTime vremeOd, LocalTime vremeDo, LocalDate datum, int treningId) {
    this.vremeOd = vremeOd;
    this.vremeDo = vremeDo;
    this.datum = datum;
    this.treningId = treningId;
  }

  @Override
  public String toString() {
    return "----- SPORT: "
        + this.sport
        + " Datum: "
        + datum
        + " Vreme od: "
        + vremeOd
        + " vreme do: "
        + vremeDo
        + "\n clanovi: "
        + clanovi
        + "\n treneri: "
        + treneri;
  }

  public void setClanovi(List<Member> clanovi) {
    this.clanovi = clanovi;
  }

  public void setTreneri(List<Trainer> treneri) {
    this.treneri = treneri;
  }

  public void setVremeOd(LocalTime vremeOd) {
    this.vremeOd = vremeOd;
  }

  public void setVremeDo(LocalTime vremeDo) {
    this.vremeDo = vremeDo;
  }

  public void setDatum(LocalDate datum) {
    this.datum = datum;
  }

  public void setTreningId(int treningId) {
    this.treningId = treningId;
  }

  public void setSport(Sport sport) {
    this.sport = sport;
  }

  public void setNazivTreninga(String nazivTreninga) {
    this.nazivTreninga = nazivTreninga;
  }

  @Override
  public int hashCode() {
    int hash = 7;
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
    final Training other = (Training) obj;

    //        postavi uslov za jednakost!!
    //        if (this.vremeDo - other.vremeOd > 0 && this.vremeOd - other.vremeDo < 0) {
    //            return false;
    //        }
    return true;
  }
}
