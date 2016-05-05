/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Julliano
 */
public class Venda {
    private Integer numero;
    private Secao secao;
    private Integer quantidade;

    public Venda() {
    }

    public Venda(Integer numero, Secao secao, Integer quantidade) {
        this.numero = numero;
        this.secao = secao;
        this.quantidade = quantidade;        
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Secao getSecao() {
        return secao;
    }

    public void setSecao(Secao secao) {
        this.secao = secao;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    
    
}
