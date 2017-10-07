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
public class Veiculo {
    private String numeroPlaca;
    private Modelo modelo;
    private String numeroChassi;
    private String numeroRenavan;
    private Integer anoModelo;
    private Integer anoFabricacao;
    private Double capacidadeEmTonelada;
    private Integer quantidadeDeEixo;
    private Double autonomia;
    private Double consumoPorKm;

    public Veiculo() {
    }

    public Veiculo(String numeroPlaca, Modelo modelo, String numeroChassi, String numeroRenavan, Integer anoModelo, Integer anoFabricacao, Double capacidadeEmTonelada, Integer quantidadeDeEixo, Double autonomia, Double consumoPorKm) {
        this.numeroPlaca = numeroPlaca;
        this.modelo = modelo;
        this.numeroChassi = numeroChassi;
        this.numeroRenavan = numeroRenavan;
        this.anoModelo = anoModelo;
        this.anoFabricacao = anoFabricacao;
        this.capacidadeEmTonelada = capacidadeEmTonelada;
        this.quantidadeDeEixo = quantidadeDeEixo;
        this.autonomia = autonomia;
        this.consumoPorKm = consumoPorKm;
    }

    public String getNumeroPlaca() {
        return numeroPlaca;
    }

    public void setNumeroPlaca(String numeroPlaca) {
        this.numeroPlaca = numeroPlaca;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public String getNumeroChassi() {
        return numeroChassi;
    }

    public void setNumeroChassi(String numeroChassi) {
        this.numeroChassi = numeroChassi;
    }

    public String getNumeroRenavan() {
        return numeroRenavan;
    }

    public void setNumeroRenavan(String numeroRenavan) {
        this.numeroRenavan = numeroRenavan;
    }

    public Integer getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(Integer anoModelo) {
        this.anoModelo = anoModelo;
    }

    public Integer getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(Integer anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public Double getCapacidadeEmTonelada() {
        return capacidadeEmTonelada;
    }

    public void setCapacidadeEmTonelada(Double capacidadeEmTonelada) {
        this.capacidadeEmTonelada = capacidadeEmTonelada;
    }

    public Integer getQuantidadeDeEixo() {
        return quantidadeDeEixo;
    }

    public void setQuantidadeDeEixo(Integer quantidadeDeEixo) {
        this.quantidadeDeEixo = quantidadeDeEixo;
    }

    public Double getAutonomia() {
        return autonomia;
    }

    public void setAutonomia(Double autonomia) {
        this.autonomia = autonomia;
    }

    public Double getConsumoPorKm() {
        return consumoPorKm;
    }

    public void setConsumoPorKm(Double consumoPorKm) {
        this.consumoPorKm = consumoPorKm;
    }

    @Override
    public String toString() {
        return "Veiculo{" + "numeroPlaca=" + numeroPlaca + ", modelo=" + modelo + ", numeroChassi=" + numeroChassi + ", numeroRenavan=" + numeroRenavan + ", anoModelo=" + anoModelo + ", anoFabricacao=" + anoFabricacao + ", capacidadeEmTonelada=" + capacidadeEmTonelada + ", quantidadeDeEixo=" + quantidadeDeEixo + ", autonomia=" + autonomia + ", consumoPorKm=" + consumoPorKm + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.numeroPlaca);
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
        final Veiculo other = (Veiculo) obj;
        if (!Objects.equals(this.numeroPlaca, other.numeroPlaca)) {
            return false;
        }
        return true;
    }
    
    
}
