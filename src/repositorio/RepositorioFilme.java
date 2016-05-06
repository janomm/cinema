/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorio;

import java.util.ArrayList;
import java.util.List;
import model.Filme;

/**
 *
 * @author Julliano
 */
public class RepositorioFilme {
   private List<Filme> listaFilmes;
    
    public RepositorioFilme(){
        listaFilmes = new ArrayList<Filme>();
    }
    
    public List<Filme> getListaFilmes() {
        return listaFilmes;
    }

    /**
     * Faz a inclusão do Filme no Arraylist
     * @param nome
     * @param genero
     * @param sinopse
     * @return 
     */
    public boolean addFilme(String nome, String genero, String sinopse){
        Filme filme = new Filme(retornaCodigo(), nome, genero, sinopse);
        return (listaFilmes.add(filme));
    }

    /**
     * Função de controle que retorna o código do próximo filme no arrayLyst
     * @return 
     */
    public int retornaCodigo(){
        int codigo = 0;
        for (Filme filme : listaFilmes){
            if(filme.getCodigo() > codigo){
                codigo = filme.getCodigo();
            }
        }
        codigo++;
        return codigo;
    }
    
    /**
     * É informado o código do filme e se encontrar o filme, retorna o mesmo.
     * @param codigo
     * @return 
     */
    public Filme retornaFilme(int codigo){
        Filme f = new Filme();
        for (Filme filme : listaFilmes){
            if(filme.getCodigo().equals(codigo)){
                f = filme;
                break;
            }
        }
        return f;
    }
    
    /**
     * Retorna se existe um filme no arraylist com o nome informado
     * @param nome
     * @return 
     */
    public boolean filmeExiste(String nome){
        for (Filme filme : listaFilmes) {
            if (filme.getNome().equalsIgnoreCase(nome)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Retorna se existe um filme no arraylist com o código informado
     * @param codigo
     * @return 
     */
    public boolean filmeExiste(int codigo){
        for (Filme filme : listaFilmes) {
            if (filme.getCodigo().equals(codigo)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Executa a exclusão do filme no arraylist igual ao código informado
     * @param codigo
     * @return 
     */
    public boolean deletaFilme(int codigo){
        for (Filme filme : listaFilmes){
            if(filme.getCodigo().equals(codigo)){
                listaFilmes.remove(filme);
                return true; 
            }
        }
        return false;
    }
    
    /**
     * Executa a alteração do gênero do filme
     * @param f
     * @param genero
     * @return 
     */
    public boolean alteraGenero(Filme f, String genero){
        for (Filme filme : listaFilmes){
            if(filme.equals(f)){
                filme.setGenero(genero);
                return true;
            }
        }
        return false;
    }
    
    /**
     * Executa a alteração da sinópse do filme
     * @param f
     * @param sinopse
     * @return 
     */
    public boolean alteraSinopse(Filme f, String sinopse){
        for (Filme filme : listaFilmes){
            if(filme.equals(f)){
                filme.setSinopse(sinopse);
                return true;
            }
        }
        return false;
    }
    
    /**
     * Retorna a quantidade de filmes cadastrados no array
     * @return 
     */
    public Integer quantidadeFilmes(){
        int cont = 0;
        for (Filme filme : listaFilmes){
            cont++;
        }
        return cont;
    }
}
