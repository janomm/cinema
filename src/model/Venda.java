/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 * Classe Venda
 * @author Julliano
 */
public class Venda {
    private Secao secao;
    private Integer quantidade;

    /**
     * Método Construtor sem parâmetro
     */
    public Venda() {
    }

    /**
     * Método Construtor
     * @param secao
     * @param quantidade 
     */
    public Venda(Secao secao, Integer quantidade) {
        this.secao = secao;
        this.quantidade = quantidade;        
    }

    /**
     * Método getSecao
     * @return 
     */
    public Secao getSecao() {
        return secao;
    }

    /**
     * Método setSecao
     * @param secao 
     */
    public void setSecao(Secao secao) {
        this.secao = secao;
    }

    /**
     * Método getQuantidade
     * @return 
     */
    public Integer getQuantidade() {
        return quantidade;
    }

    /**
     * Método setQuantidade
     * @param quantidade 
     */
    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
