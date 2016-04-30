/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import repositorio.RepositorioFilme;
import repositorio.RepositorioSala;
import repositorio.RepositorioSecao;
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
    
    public MainUI() {
        listaFilmes = new RepositorioFilme();
        listaSecoes = new RepositorioSecao();
        listaSalas  = new RepositorioSala();
    }
    
    public void executar() {
        int opcao = 0;
        do {
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
                    new SecaoUI(listaSecoes).executar();
                    break;
                case MainMenu.OP_VENDA:
                    //new VendaUI(listaSecoes,listaFilmes,listaSalas).executar();
                    break;
                case MainMenu.OP_RELATORIOS:
                    //new ConsultaUI(listaPacientes,listaMedicamentos,listaConsultas).executar();
                    break;
                case MainMenu.OP_SAIR:
                    System.out.println("Aplicação finalizada!!!");
                    break;
                default:
                    System.out.println("Opção inválida..");

            }
        } while (opcao != MainMenu.OP_SAIR);
    }
}
