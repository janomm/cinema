/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Filme;
import model.Sala;
import model.Secao;

/**
 *
 * @author Julliano
 */
public class RepositorioSecao {
    private List<Secao> listaSecoes;
    
    public RepositorioSecao(){
        listaSecoes = new ArrayList<>();
    }

    public List<Secao> getListaSecoes() {
        return listaSecoes;
    }
    
    private boolean addSecao(Filme filme, Sala sala, Date hora){
        return true;
    }
}
