/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author Julliano
 */
public class Secao {
    
    private Sala sala;
    private Date horario;
    private Filme filme;
    private Integer numero;
    
    public Secao() {
    }

    public Secao(Sala sala, Date horario, Filme filme, Integer numero) {
        this.sala = sala;
        this.horario = horario;
        this.filme = filme;
        this.numero = numero;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public Date getHorario() {
        return horario;
    }

    public void setHorario(Date horario) {
        this.horario = horario;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }
    
    public void setNumer(Integer numero){
        this.numero = numero;
    }
    
    public Integer getNumero(){
        return numero;
    }
    
    
    
}
