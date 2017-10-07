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
public class Frete {
    private Long codigoFrete;
    private Veiculo veiculo;
    private Diesel precoDiesel;
    private Endereco enderecoOrigem;
    private Endereco enderecoDestino;
    private Date dataFrete;
    private String descricaoProduto;
    private Double quantidadeProduto;
    private Double valorPeso;
    private Double valorFrete;
    private Double distancia;

    public Frete() {
    }

    public Frete(Long codigoFrete, Veiculo veiculo, Date dataFrete, Double valorPeso, Diesel precoDiesel, Endereco enderecoOrigem, Endereco enderecoDestino) {
        this.codigoFrete = codigoFrete;
        this.veiculo = veiculo;
        this.dataFrete = dataFrete;
        this.valorPeso = valorPeso;
        this.precoDiesel = precoDiesel;
        this.enderecoOrigem = enderecoOrigem;
        this.enderecoDestino = enderecoDestino;
    }

    public Double getDistancia() {
        return distancia;
    }

    public void setDistancia(Double distancia) {
        this.distancia = distancia;
    }
    
    
    public Double getQuantidadeProduto() {
        return quantidadeProduto;
    }

    public void setQuantidadeProduto(Double quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }
    
    
    public Double getValorFrete() {
        return valorFrete;
    }

    public void setValorFrete(Double valorFrete) {
        this.valorFrete = valorFrete;
    }
    
    
    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }
    
    
    public Long getCodigoFrete() {
        return codigoFrete;
    }

    public void setCodigoFrete(Long codigoFrete) {
        this.codigoFrete = codigoFrete;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Date getDataFrete() {
        return dataFrete;
    }

    public void setDataFrete(Date dataFrete) {
        this.dataFrete = dataFrete;
    }

    public Double getValorPeso() {
        return valorPeso;
    }

    public void setValorPeso(Double valorPeso) {
        this.valorPeso = valorPeso;
    }

    public Diesel getPrecoDiesel() {
        return precoDiesel;
    }

    public void setPrecoDiesel(Diesel precoDiesel) {
        this.precoDiesel = precoDiesel;
    }

    public Endereco getEnderecoOrigem() {
        return enderecoOrigem;
    }

    public void setEnderecoOrigem(Endereco enderecoOrigem) {
        this.enderecoOrigem = enderecoOrigem;
    }

    public Endereco getEnderecoDestino() {
        return enderecoDestino;
    }

    public void setEnderecoDestino(Endereco enderecoDestino) {
        this.enderecoDestino = enderecoDestino;
    }

    @Override
    public String toString() {
        return "Frete{" + "codigoFrete=" + codigoFrete + ", veiculo=" + veiculo + ", dataFrete=" + dataFrete + ", valorPeso=" + valorPeso + ", precoDiesel=" + precoDiesel + ", enderecoOrigem=" + enderecoOrigem + ", enderecoDestino=" + enderecoDestino + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.codigoFrete);
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
        final Frete other = (Frete) obj;
        if (!Objects.equals(this.codigoFrete, other.codigoFrete)) {
            return false;
        }
        return true;
    }
    
    
    
}
