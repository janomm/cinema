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
public class Sala {
    private Integer numero;
    private Integer assentos;

    public Sala() {
    }

    public Sala(Integer numero, Integer assentos) {
        this.numero = numero;
        this.assentos = assentos;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getAssentos() {
        return assentos;
    }

    public void setAssentos(Integer assentos) {
        this.assentos = assentos;
    }
    
    
    
    
}
