/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorio;

import java.util.ArrayList;
import java.util.List;
import model.Sala;

/**
 * Classe RepositorioSala
 * @author Julliano
 */
public class RepositorioSala {
    private List<Sala> listaSalas;
    
    /**
     * Método Construtor
     */
    public RepositorioSala(){
        listaSalas = new ArrayList<Sala>();
    }

    /**
     * Método getListaSalas
     * @return 
     */
    public List<Sala> getListaSalas() {
        return listaSalas;
    }
    
    /**
     * Adiciona uma sala
     * @param assento
     * @return 
     */
    public boolean addSala(int assento){
        Sala sala = new Sala(retornaNumero(), assento);
        return (listaSalas.add(sala));
    }
    
    /**
     * Função de controle que retorna o código da prósima sala no arrayLyst
     * @return 
     */
    public int retornaNumero(){
        int numero = 0;
        for (Sala sala : listaSalas){
            if(sala.getNumero() > numero){
                numero = sala.getNumero();
            }
        }
        numero++;
        return numero;
    }
    
    /**
     * Função que retorna se existe uma sala com o número informado.
     * @param numero
     * @return 
     */
    public boolean salaExiste(int numero){
        for (Sala sala : listaSalas) {
            if (sala.getNumero().equals(numero)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Exclui a Sala do ArrayList
     * @param numero
     * @return 
     */
    public boolean deletaSala(int numero){
        for (Sala sala : listaSalas){
            if(sala.getNumero().equals(numero)){
                listaSalas.remove(sala);
                return true; 
            }
        }
        return false;
    }
    
    /**
     * Função que retorna a sala igual ao código informado
     * @param numero
     * @return 
     */
    public Sala retornaSala(int numero){
        Sala s = new Sala();
        for (Sala sala : listaSalas){
            if(sala.getNumero().equals(numero)){
                s = sala;
                break;
            }
        }
        return s;
    }
    
    /**
     * Altera a quantidade de assentos na sala
     * @param s
     * @param assentos
     * @return 
     */
    public boolean alteraAssentos(Sala s, int assentos){
        for (Sala sala : listaSalas){
            if(sala.equals(s)){
                sala.setAssentos(assentos);
                return true;
            }
        }
        return false;
    }
    
    /**
     * Retorna a quantidade de salas cadastradas no array
     * @return 
     */
    public Integer quantidadeSala(){
        int cont = 0;
        for (Sala sala : listaSalas){
            cont++;
        }
        return cont;
    }
    
}
