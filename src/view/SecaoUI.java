/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.Date;
import model.Filme;
import model.Sala;
import repositorio.RepositorioFilme;
import repositorio.RepositorioSala;
import repositorio.RepositorioSecao;
import util.Console;
import util.DateUtil;
import view.menu.SecaoMenu;

/**
 *
 * @author Julliano
 */
public class SecaoUI {
    private RepositorioSecao listaSecao;
    private RepositorioSala listaSalas;
    private RepositorioFilme listaFilmes;

    public SecaoUI(RepositorioSecao listaSecao, RepositorioSala listaSala, RepositorioFilme listaFilme) {
        this.listaSecao = listaSecao;
        this.listaSalas = listaSala;
        this.listaFilmes = listaFilme;
    }

    public RepositorioSecao getListaSecao() {
        return listaSecao;
    }
    
    public RepositorioSala getListaSala(){
        return listaSalas;
    }
    
    public RepositorioFilme getListaFilme(){
        return listaFilmes;
    }
    
    public void executar(){
        int opcao = 0;
        do {
            System.out.println(SecaoMenu.getOpcoes());
            opcao = Console.scanInt("Digite sua opção:");
            switch (opcao) {
                case SecaoMenu.OP_NOVO:
                    insereSecao();
                    break;
                case SecaoMenu.OP_REMOVER:
                    //removeSala();
                    break;
                case SecaoMenu.OP_EDITAR:
                    //editaSala();
                    break;
                case SecaoMenu.OP_LISTAR:
                    //listaSala();
                    break;
                case SecaoMenu.OP_CONSULTAR:
                    //consultaSala();
                    break;
                case SecaoMenu.OP_VOLTAR:
                    System.out.println("Retornando ao menu principal..");
                    break;
                default:
                    System.out.println("Opção inválida..");
            }
        } while (opcao != SecaoMenu.OP_VOLTAR);
    }
    
    public boolean insereSecao(){
        
        if(!new SalaUI(listaSalas).existeSala()){
            System.out.println("Salas não cadastradas.");
            return false;
        }
        
        if(!new FilmeUI(listaFilmes).existeFilme()){
            System.out.println("Salas não cadastradas.");
            return false;
        }
        
        try{
            int codigo = Console.scanInt("Selecione o código do filme: ");
            Filme filme = new FilmeUI(listaFilmes).buscaFilme(codigo);
            if (filme.equals(null)){
                System.out.println("Código do Filme não cadastrado.");
                return false;
            }
        } catch (Exception ex){
            System.out.println("Código inválido.");
            return false;
        }
        
        try{
            int numero = Console.scanInt("Selecione o número da sala: ");
            Sala sala = new SalaUI(listaSalas).buscaSala(numero);
            if(sala.equals(null)){
                System.out.println("Número da sala não cadastrado.");
                return false;
            }
        } catch(Exception ex){
            System.out.println("Número inválido.");
            return false;
        }
        
        try{
            String h = Console.scanString("Digite a Hora: ");
            Date hora = DateUtil.stringToHour(h);
        } catch (Exception ex){
            System.out.println("Hora Inválida.");
        }
        
        
        
        
        
        return true;
    }
}
