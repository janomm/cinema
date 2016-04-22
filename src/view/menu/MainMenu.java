/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.menu;

/**
 *
 * @author Julliano
 */
public class MainMenu {
    

    public static final int OP_CADASTROS = 1;
    public static final int OP_VENDA = 2;
    public static final int OP_RELATORIOS = 3;
    public static final int OP_SAIR = 0;

    public static String getOpcoes() {
        return ("\n--------------------------------------\n"
                + "1- Menu Cadastros\n"
                + "2- Menu Venda\n"
                + "3- Menu Relatórios\n"
                + "0- Sair da Aplicação"
                + "\n--------------------------------------");
    }
}


