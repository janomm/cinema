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
    private Secao secao;
    private Integer quantidade;

    public Venda() {
    }

    public Venda(Secao secao, Integer quantidade) {
        this.secao = secao;
        this.quantidade = quantidade;        
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
