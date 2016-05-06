/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorio;

import java.util.ArrayList;
import java.util.List;
import javax.swing.text.StyledEditorKit;
import model.Secao;
import model.Venda;

/**
 *
 * @author Julliano
 */
public class RepositorioVenda {
    private List<Venda> listaVendas;

    public RepositorioVenda() {
        listaVendas = new ArrayList<>();
    }
    
    public List<Venda> getListaVendas() {
        return listaVendas;
    }

    public boolean addVenda(Secao secao, Integer quantidade){
        Venda v = new Venda(secao, quantidade);
        return (listaVendas.add(v));
    }
    
    public boolean alteraVenda(Secao secao, Integer q){
        for (Venda v : listaVendas){
            if(v.getSecao().equals(secao)){
                v.setQuantidade(v.getQuantidade() + q);
                return true;
            }
        }
        return false;
    }
    
    public boolean existeVenda(Integer numero){
        for (Venda v : listaVendas){
            if(v.getSecao().getNumero().equals(numero)){
                return true;
            }
        }
        return false;
    }
    

    
    
    
}
