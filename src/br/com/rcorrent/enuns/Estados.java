/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rcorrent.enuns;

/**
 *
 * @author rcorrent
 */
public enum Estados {
    
    padrao(0),insercao(1),alteracao(2);
    
    private Integer estado;

    private Estados(Integer estado) {
        this.estado = estado;
    }

    public static Estados getPadrao() {
        return padrao;
    }

    public static Estados getInsercao() {
        return insercao;
    }

    public static Estados getAlteracao() {
        return alteracao;
    }

    public Integer getEstado() {
        return estado;
    }
    
}
