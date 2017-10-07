package br.com.rcorrent.model;

import java.util.Objects;

/**
 *
 * @author rcorrent
 */
public class Marca{
    private Long codigoMarca;
    private String nomeMarca;
    private String abreviaturaMarca;

    public Marca() {
    }

    public Marca(Long codigoMarca, String nomeMarca, String abreviaturaMarca) {
        this.codigoMarca = codigoMarca;
        this.nomeMarca = nomeMarca;
        this.abreviaturaMarca = abreviaturaMarca;
    }

    public Long getCodigoMarca() {
        return codigoMarca;
    }

    public void setCodigoMarca(Long codigoMarca) {
        this.codigoMarca = codigoMarca;
    }

    public String getNomeMarca() {
        return nomeMarca;
    }

    public void setNomeMarca(String nomeMarca) {
        this.nomeMarca = nomeMarca;
    }

    public String getAbreviaturaMarca() {
        return abreviaturaMarca;
    }

    public void setAbreviaturaMarca(String abreviaturaMarca) {
        this.abreviaturaMarca = abreviaturaMarca;
    }

    @Override
    public String toString() {
        return nomeMarca;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.codigoMarca);
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
        final Marca other = (Marca) obj;
        if (!Objects.equals(this.codigoMarca, other.codigoMarca)) {
            return false;
        }
        return true;
    }

    
    
    
}
