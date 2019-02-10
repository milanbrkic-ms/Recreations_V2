/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recreations.model;

import lombok.Getter;

import javax.persistence.*;
import java.io.Serializable;

/** @author Milan */
@Entity
@Getter
public class User implements Serializable {

  @Id
  @Basic(optional = false)
  private String username;

  private String password;

  @JoinColumn(name = "osoba", referencedColumnName = "idosoba")
  @ManyToOne(cascade = CascadeType.ALL)
  private Person person;

  public User() {
    person = new Person();
  }

  public User(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public User(String username, String password, Person person) {
    this.username = username;
    this.password = password;
    this.person = person;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setPerson(Person person) {
    this.person = person;
  }

  @Override
  public String toString() {
    return "@" + username + " - " + person;
  }

  public static final String ADMIN = "admin";
  public static final String NORMAL = "normal";
}
