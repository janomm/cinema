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
 *
 * @author Julliano
 */
public class RepositorioSala {
    private List<Sala> listaSalas;
    
    public RepositorioSala(){
        listaSalas = new ArrayList<Sala>();
    }

    public List<Sala> getListaSalas() {
        return listaSalas;
    }
    
    public boolean addSala(int assento){
        Sala sala = new Sala(retornaNumero(), assento);
        return (listaSalas.add(sala));
    }
    
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
    
    public boolean salaExiste(int numero){
        for (Sala sala : listaSalas) {
            if (sala.getNumero().equals(numero)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean deletaSala(int numero){
        for (Sala sala : listaSalas){
            if(sala.getNumero().equals(numero)){
                listaSalas.remove(sala);
                return true; 
            }
        }
        return false;
    }
    
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
    
    public boolean alteraAssentos(Sala s, int assentos){
        for (Sala sala : listaSalas){
            if(sala.equals(s)){
                sala.setAssentos(assentos);
                return true;
            }
        }
        return false;
    }
    
    public Integer quantidadeSala(){
        int cont = 0;
        for (Sala sala : listaSalas){
            cont++;
        }
        return cont;
    }
    
}
