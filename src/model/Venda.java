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
    private Integer assentos;

    public Venda() {
    }

    public Venda(Secao secao, Integer assentos) {
        this.secao = secao;
        this.assentos = assentos;
    }

    public Secao getSecao() {
        return secao;
    }

    public void setSecao(Secao secao) {
        this.secao = secao;
    }

    public Integer getAssentos() {
        return assentos;
    }

    public void setAssentos(Integer assentos) {
        this.assentos = assentos;
    }
    
    public Integer assentosRestantes(){
        return secao.getSala().getAssentos() - assentos;
    }
    
}
