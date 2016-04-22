/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import view.menu.MainMenu;

import util.Console;

/**
 *
 * @author Julliano
 */
public class MainUI {
    public void executar() {
        int opcao = 0;
        do {
            System.out.println(MainMenu.getOpcoes());
            opcao = Console.scanInt("Digite sua opção:");
            switch (opcao) {
                case MainMenu.OP_CADASTROS:
                    //new PacienteUI(listaPacientes).executar();
                    break;
                case MainMenu.OP_VENDA:
                    //new MedicamentoUI(listaMedicamentos).executar();
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
