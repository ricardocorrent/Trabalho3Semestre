/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rcorrent.model;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author rcorrent
 */
public class Diesel {
    private Date dataPreco;
    private double valorDiesel;

    public Diesel() {
    }

    public Diesel(Date dataPreco, double valorDiesel) {
        this.dataPreco = dataPreco;
        this.valorDiesel = valorDiesel;
    }

    public Date getDataPreco() {
        return dataPreco;
    }

    public void setDataPreco(Date dataPreco) {
        this.dataPreco = dataPreco;
    }

    public double getValorDiesel() {
        return valorDiesel;
    }

    public void setValorDiesel(double valorDiesel) {
        this.valorDiesel = valorDiesel;
    }

    @Override
    public String toString() {
        return "PrecoDiesel{" + "dataPreco=" + dataPreco + ", valorDiesel=" + valorDiesel + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.dataPreco);
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
        final Diesel other = (Diesel) obj;
        if (!Objects.equals(this.dataPreco, other.dataPreco)) {
            return false;
        }
        return true;
    }
    
    
}
