/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recreations.model;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Milan
 */
@Entity
@Getter
public class Relationship implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "osoba_1_id")
    private Person person_1_id;

    @Id
    @ManyToOne
    @JoinColumn(name = "osoba_2_id")
    private Person person_2_id;

    private int status;

    @Id
    @ManyToOne
    @JoinColumn(name = "akcija_osoba_id")
    private Person akcija_person_id;

    public Relationship() {
    }

    public Relationship(Person person_1_id, Person person_2_id, int status, Person akcija_person_id) {
        this.person_1_id = person_1_id;
        this.person_2_id = person_2_id;
        this.status = status;
        this.akcija_person_id = akcija_person_id;
    }

    public void setPerson_1_id(Person person_1_id) {
        this.person_1_id = person_1_id;
    }

    public void setPerson_2_id(Person person_2_id) {
        this.person_2_id = person_2_id;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setAkcija_person_id(Person akcija_person_id) {
        this.akcija_person_id = akcija_person_id;
    }

    @Override
    public String toString() {
        return "Relationship{" + "person_1_id=" + person_1_id + ", person_2_id=" + person_2_id + ", status=" + status + ", akcija_person_id=" + akcija_person_id + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.person_1_id);
        hash = 47 * hash + Objects.hashCode(this.person_2_id);
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
        final Relationship other = (Relationship) obj;
        if (!Objects.equals(this.person_1_id, other.person_1_id)) {
            return false;
        }
        return Objects.equals(this.person_2_id, other.person_2_id);
    }
    
    
    public interface Status {
        int NOT_FRIENDS = 0;
        int FRIENDS = 1;
        int PENDDING = 2;
    }
}
