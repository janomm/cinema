/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import repositorio.RepositorioSala;
import repositorio.RepositorioSecao;
import util.Console;
import view.menu.SecaoMenu;

/**
 *
 * @author Julliano
 */
public class SecaoUI {
    private RepositorioSecao lista;

    public SecaoUI(RepositorioSecao lista) {
        this.lista = lista;
    }

    public RepositorioSecao getLista() {
        return lista;
    }
    
    public void executar(){
        int opcao = 0;
        do {
            System.out.println(SecaoMenu.getOpcoes());
            opcao = Console.scanInt("Digite sua opção:");
            switch (opcao) {
                case SecaoMenu.OP_NOVO:
                    //insereSala();
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
}
