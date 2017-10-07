package br.com.rcorrent.model;

import java.util.Objects;

/**
 *
 * @author rcorrent
 */
public class Cidade {
    private Long codigoCidade;
    private String nomeCidade;
    private Uf uf;

    public Cidade() {
    }

    public Cidade(Long codigoCidade, String nomeCidade, Uf uf) {
        this.codigoCidade = codigoCidade;
        this.nomeCidade = nomeCidade;
        this.uf = uf;
    }

    public Long getCodigoCidade() {
        return codigoCidade;
    }

    public void setCodigoCidade(Long codigoCidade) {
        this.codigoCidade = codigoCidade;
    }

    public String getNomeCidade() {
        return nomeCidade;
    }

    public void setNomeCidade(String nomeCidade) {
        this.nomeCidade = nomeCidade;
    }

    public Uf getUf() {
        return uf;
    }

    public void setUf(Uf uf) {
        this.uf = uf;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.codigoCidade);
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
        final Cidade other = (Cidade) obj;
        if (!Objects.equals(this.codigoCidade, other.codigoCidade)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nomeCidade;
    }
    
    
    
}
