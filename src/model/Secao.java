/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 * Classe Seção
 * @author Julliano
 */
public class Secao {
    
    private Sala sala;
    private Date horario;
    private Filme filme;
    private Integer numero;
    
    /**
     * Método Construtor sem parâmetro
     */
    public Secao() {
    }

    /**
     * Método Contrutor
     * @param sala
     * @param horario
     * @param filme
     * @param numero 
     */
    public Secao(Sala sala, Date horario, Filme filme, Integer numero) {
        this.sala = sala;
        this.horario = horario;
        this.filme = filme;
        this.numero = numero;
    }

    /**
     * Método getSala
     * @return 
     */
    public Sala getSala() {
        return sala;
    }

    /**
     * Método setSala
     * @param sala 
     */
    public void setSala(Sala sala) {
        this.sala = sala;
    }

    /**
     * Método getHorario
     * @return 
     */
    public Date getHorario() {
        return horario;
    }

    /**
     * Método setHorario
     * @param horario 
     */
    public void setHorario(Date horario) {
        this.horario = horario;
    }

    /**
     * Método getFilme
     * @return 
     */
    public Filme getFilme() {
        return filme;
    }

    /**
     * Método setFilme
     * @param filme 
     */
    public void setFilme(Filme filme) {
        this.filme = filme;
    }
    
    /**
     * Método setNumero
     * @param numero 
     */
    public void setNumero(Integer numero){
        this.numero = numero;
    }
    
    /**
     * Método getNumero
     * @return 
     */
    public Integer getNumero(){
        return numero;
    }
    
    
    
}
