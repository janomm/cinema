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
public class SecaoMenu {
    public static final int OP_NOVO = 1;
    public static final int OP_REMOVER = 2;
    public static final int OP_EDITAR = 3;
    public static final int OP_LISTAR = 4;
    public static final int OP_CONSULTAR = 5;
    public static final int OP_VOLTAR = 0;
    
    public static String getOpcoes(){
        return("\n--------------------------------------\n"
                + "1- Incluir Seção\n"
                + "2- Remover Seção\n"
                + "3- Editar Seção\n"
                + "4- Listar Seções\n"
                + "5- Consultar Seção\n"
                + "0- Voltar"
                + "\n--------------------------------------");
        
    }
    
}
