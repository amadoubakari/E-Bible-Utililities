/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import java.util.Comparator;

/**
 *
 * @author AMADOU
 */
public class Verset implements Comparable<Verset>, Comparator<Verset> {

    private Integer numero;
    private String description;

    public Verset() {
    }

    public Verset(Integer numero, String description) {
        this.numero = numero;
        this.description = description;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Verset{" + "numero=" + numero + ", description=" + description + '}';
    }

    @Override
    public int compareTo(Verset o) {
        return this.getNumero().compareTo(o.getNumero());
    }

    @Override
    public int compare(Verset o1, Verset o2) {
        return o2.getNumero() - o1.getNumero();
    }

}
