/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recreations.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 *
 * @author Milan
 */
@Entity
@Getter
@AllArgsConstructor
public class Sport implements Serializable, Comparable<Sport> {
    @Id
    @Column(name = "sportid")
    private int sportID;
    @Column(name = "nazivsporta")
    private String naziv;
    @Column(name = "maxbrclanova")
    private int maxBrClanova;

    public Sport() {
    }

    public Sport(int sportID) {
        this.sportID = sportID;
    }

    public void setSportID(int sportID) {
        this.sportID = sportID;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public void setMaxBrClanova(int maxBrClanova) {
        this.maxBrClanova = maxBrClanova;
    }

    @Override
    public String toString() {
        return naziv;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Sport other = (Sport) obj;
        return this.sportID == other.sportID;
    }

    @Override
    public int compareTo(Sport o) {
        return Integer.compare(this.sportID, o.sportID);
    }
    
    
}
