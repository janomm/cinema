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
public class VendaMenu {
    public static final int OP_VENDA = 1;
    public static final int OP_VOLTAR = 0;
    
    public static final int OP_VENDASECAO = 1;
    public static final int OP_VENDAFILME = 2;
    public static final int OP_VENDASALA = 3;
    public static final int OP_VENDAHORARIO = 4;
    
    public static String getOpcoes(){
        return("\n--------------------------------------\n"
                + "1- Incluir Venda\n"
                + "0- Voltar"
                + "\n--------------------------------------");
    }
    
    public static String getOpcoesVenda(){
        return("\n--------------------------------------\n"
                + "1- Venda por Seção\n"
                + "2- Venda por Filme\n"
                + "3- Venda por Sala\n"
                + "4- Venda por Horário\n"
                + "0- Voltar"
                + "\n--------------------------------------");
    }
}
