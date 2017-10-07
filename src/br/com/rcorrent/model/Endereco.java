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
public class Endereco {
    private Long codigoEndereco;
    private Cidade cidade;
    private String cep;
    private String numero;
    private String logradouro;
    private String bairro;
    private String complemento;

    public Endereco() {
    }

    public Endereco(Long codigoEndereco, String cep, String numero, String logradouro, String bairro, String complemento, Cidade cidade) {
        this.codigoEndereco = codigoEndereco;
        this.cep = cep;
        this.numero = numero;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.complemento = complemento;
        this.cidade = cidade;
    }

    public Long getCodigoEndereco() {
        return codigoEndereco;
    }

    public void setCodigoEndereco(Long codigoEndereco) {
        this.codigoEndereco = codigoEndereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return "Endereco{" + "codigoEndereco=" + codigoEndereco + ", cep=" + cep + ", numero=" + numero + ", logradouro=" + logradouro + ", bairro=" + bairro + ", complemento=" + complemento + ", cidade=" + cidade + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.codigoEndereco);
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
        final Endereco other = (Endereco) obj;
        if (!Objects.equals(this.codigoEndereco, other.codigoEndereco)) {
            return false;
        }
        return true;
    }
    
    
}
