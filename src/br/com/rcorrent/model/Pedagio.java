/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rcorrent.model;

import java.util.Objects;

/**
 *
 * @author rcorrent
 */
public class Pedagio {
    private Long codigoPedagio;
    private Frete frete;
    private Double valorPedagio;
    private Long quantidadePedagio;

    public Pedagio() {
    }

    public Pedagio(Long codigoPedagio, Frete frete, Double valorPedagio, Long quantidadePedagio) {
        this.codigoPedagio = codigoPedagio;
        this.frete = frete;
        this.valorPedagio = valorPedagio;
        this.quantidadePedagio = quantidadePedagio;
    }

    public Long getCodigoPedagio() {
        return codigoPedagio;
    }

    public void setCodigoPedagio(Long codigoPedagio) {
        this.codigoPedagio = codigoPedagio;
    }

    public Frete getFrete() {
        return frete;
    }

    public void setFrete(Frete frete) {
        this.frete = frete;
    }

    public Double getValorPedagio() {
        return valorPedagio;
    }

    public void setValorPedagio(Double valorPedagio) {
        this.valorPedagio = valorPedagio;
    }

    public Long getQuantidadePedagio() {
        return quantidadePedagio;
    }

    public void setQuantidadePedagio(Long quantidadePedagio) {
        this.quantidadePedagio = quantidadePedagio;
    }

    @Override
    public String toString() {
        return "Pedagio{" + "codigoPedagio=" + codigoPedagio + ", frete=" + frete + ", valorPedagio=" + valorPedagio + ", quantidadePedagio=" + quantidadePedagio + '}';
    }
    
    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.codigoPedagio);
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
        final Pedagio other = (Pedagio) obj;
        if (!Objects.equals(this.codigoPedagio, other.codigoPedagio)) {
            return false;
        }
        return true;
    }
    
    
}
