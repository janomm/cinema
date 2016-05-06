/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.Filme;
import repositorio.RepositorioFilme;
import repositorio.RepositorioSala;
import repositorio.RepositorioSecao;
import repositorio.RepositorioVenda;
import view.menu.MainMenu;

import util.Console;

/**
 *
 * @author Julliano
 */
public class MainUI {
    private RepositorioFilme listaFilmes;
    private RepositorioSecao listaSecoes;
    private RepositorioSala listaSalas;
    private RepositorioVenda listaVendas;
    
    public MainUI() {
        listaFilmes = new RepositorioFilme();
        listaSecoes = new RepositorioSecao();
        listaSalas  = new RepositorioSala();
        listaVendas = new RepositorioVenda();
        
        listaFilmes.addFilme("Cemitério Maldito", "Terror", "Animais voltam amaldiçoados");
        listaFilmes.addFilme("Batman", "Ação", "Batman");
        listaSalas.addSala(150);
        listaSalas.addSala(130);
        
    }
    
    public void executar() {
        int opcao = 0;
        do {
            try{
                System.out.println(MainMenu.getOpcoes());
                opcao = Console.scanInt("Digite sua opção:");
                switch (opcao) {
                    case MainMenu.OP_FILME:
                        new FilmeUI(listaFilmes).executar();
                        break;
                    case MainMenu.OP_SALA:
                        new SalaUI(listaSalas).executar();
                        break;
                    case MainMenu.OP_SECAO:
                        new SecaoUI(listaSecoes,listaSalas,listaFilmes).executar();
                        break;
                    case MainMenu.OP_VENDA:
                        new VendaUI(listaVendas,listaSecoes,listaSalas,listaFilmes).executar();
                        break;
                    case MainMenu.OP_RELATORIOS:
                        new RelatoriosUI(listaVendas,listaSecoes,listaSalas,listaFilmes).executar();
                        break;
                    case MainMenu.OP_SAIR:
                        System.out.println("Aplicação finalizada!!!");
                        break;
                    default:
                        System.err.println("Opção inválida..");

                }
            }
            catch(Exception ex){
                System.err.println("Opção inválida.");
                opcao= -1;
            }
        } while (opcao != MainMenu.OP_SAIR);
    }
}
