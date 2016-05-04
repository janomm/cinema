/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import repositorio.RepositorioFilme;
import repositorio.RepositorioSala;
import repositorio.RepositorioSecao;
import repositorio.RepositorioVenda;
import util.Console;
import view.menu.VendaMenu;

/**
 *
 * @author Julliano
 */
public class VendaUI {
    private RepositorioVenda listaVendas;
    private RepositorioSecao listaSecoes;
    private RepositorioSala listaSalas;
    private RepositorioFilme listaFilmes;


    public VendaUI(RepositorioVenda listaVenda,RepositorioSecao listaSecao, RepositorioSala listaSala, RepositorioFilme listaFilme) {
        this.listaVendas = listaVenda;
        this.listaSecoes = listaSecao;
        this.listaSalas = listaSala;
        this.listaFilmes = listaFilme;
    }
    
    public void executar(){
        int opcao = 0;
        do {
            System.out.println(VendaMenu.getOpcoes());
            opcao = Console.scanInt("Digite sua opção:");
            switch (opcao) {
                case VendaMenu.OP_VENDA:
                    iniciaVenda();
                    break;
                case VendaMenu.OP_VOLTAR:
                    System.out.println("Retornando ao menu principal..");
                    break;
                default:
                    System.out.println("Opção inválida..");
            }
        } while (opcao != VendaMenu.OP_VOLTAR);
    }
    
    public void iniciaVenda(){
        int opcao = 0;
        do {
            System.out.println(VendaMenu.getOpcoesVenda());
            opcao = Console.scanInt("Digite sua opção:");
            switch (opcao) {
                case VendaMenu.OP_VENDASECAO:
                    //vendaSecao();
                    break;
                case VendaMenu.OP_VENDAFILME:
                    vendaFilme();
                    break;
                case VendaMenu.OP_VOLTAR:
                    System.out.println("Retornando ao menu principal..");
                    break;
                default:
                    System.out.println("Opção inválida..");
            }
        } while (opcao != VendaMenu.OP_VOLTAR);
    }
    
    public boolean vendaFilme(){
        try{
            new FilmeUI(listaFilmes).listaFilmes();
            int codigo = Console.scanChar("Código do filme: ");
            if(listaSecoes.achouSecaoFilme(codigo)){
                new SecaoUI(listaSecoes, listaSalas, listaFilmes).listaSecaoFilme(codigo);
                return true;
                
            } else{
                System.out.println("Filme não encontrado");
                return false;
            }
            
        } catch(Exception e){
            System.err.println("Código inválido.");
            return false;
        }
    }
}
