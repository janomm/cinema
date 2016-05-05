/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorio;

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
        this.listaVendas = listaVendas;
    }

    public List<Venda> getListaVendas() {
        return listaVendas;
    }
    
    public boolean adicionaVenda(Secao secao, Integer quantidade){
        Venda v = new Venda(retornaNumero(), secao, quantidade);
        return listaVendas.add(v);
    }
    
    public int retornaNumero(){
        int numero = 0;
        for (Venda venda : listaVendas){
            if(venda.getNumero() > numero){
                numero = venda.getNumero();
            }
        }
        numero++;
        return numero;
    }
    
    
    
}
