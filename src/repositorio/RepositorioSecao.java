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
    
    public boolean addSecao(Filme filme, Sala sala, Date hora){
        Secao secao = new Secao(sala, hora, filme, retornaCodigo());
        return (listaSecoes.add(secao));
    }
    
    public int retornaCodigo(){
        int numero = 0;
        for (Secao secao : listaSecoes){
            if(secao.getNumero()> numero){
                numero = secao.getNumero();
            }
        }
        numero++;
        return numero;
    }
    
    public boolean secaoExiste(Integer numero){
        for (Secao secao : listaSecoes){
            if(secao.getNumero().equals(numero))
                return true;
        }
        return false;
    }
    
    public boolean deletaSecao(Integer numero){
        for (Secao secao : listaSecoes){
            if (secao.getNumero().equals(numero)){
                listaSecoes.remove(secao);
                return true;
            }
        }
        return false;
    }
    
    public Secao retornaSecao(int numero){
        Secao s = new Secao();
        for (Secao secao : listaSecoes){
            if(secao.getNumero().equals(numero)){
                s = secao;
                break;
            }
        }
        return s;
    }
    
    public boolean alteraSecao(Secao secao, int numero){
        for(Secao s : listaSecoes){
            if(s.getNumero().equals(numero)){
                s.setFilme(secao.getFilme());
                s.setHorario(secao.getHorario());
                s.setSala(secao.getSala());
                return true;
            }
        }
        return false;
    }
    
    public boolean achouSecaoFilme(int codigo){
        for (Secao s : listaSecoes){
            System.out.println(s.getFilme().getCodigo() + " - " + codigo);
            if(s.getFilme().getCodigo().equals(codigo)){
                return true;
            }
        }
        return false;
    }
    
    public boolean achouSecaoSala(int numero){
        for (Secao s : listaSecoes){
            if(s.getSala().getNumero().equals(numero)){
                return true;
            }
        }
        return false;
    }
    
    public boolean achouSecaoHora(Date horario){
        for (Secao s : listaSecoes){
            if(s.getHorario().equals(horario)){
                return true;
            }
        }
        return false;
    }
}
