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
public class Filme {
    private Integer codigo;
    private String nome;
    private String genero;
    private String sinopse;

    public Filme() {
    }

    public Filme(Integer codigo, String nome, String genero, String sinopse) {
        this.codigo = codigo;
        this.nome = nome;
        this.genero = genero;
        this.sinopse = sinopse;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }
    
    public void imprimeFilme(){
        System.out.println("Código: " + this.codigo
                           + "\nNome: " + this.nome 
                           + "\nGênero: " + this.genero
                           + "\nSinopse: " + this.sinopse);
    }
    
}
