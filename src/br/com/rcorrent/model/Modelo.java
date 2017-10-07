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
public class Modelo {
    
    private Long codigoModelo;
    private String nomeModelo;
    private Marca marca;

    public Modelo() {
    }

    public Modelo(Long codigoModelo, String nomeModelo, Marca marca) {
        this.codigoModelo = codigoModelo;
        this.nomeModelo = nomeModelo;
        this.marca = marca;
    }

    public Long getCodigoModelo() {
        return codigoModelo;
    }

    public void setCodigoModelo(Long codigoModelo) {
        this.codigoModelo = codigoModelo;
    }

    public String getNomeModelo() {
        return nomeModelo;
    }

    public void setNomeModelo(String nomeModelo) {
        this.nomeModelo = nomeModelo;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    @Override
    public String toString() {
        return nomeModelo;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.codigoModelo);
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
        final Modelo other = (Modelo) obj;
        if (!Objects.equals(this.codigoModelo, other.codigoModelo)) {
            return false;
        }
        return true;
    }
    
    
}
