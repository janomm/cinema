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
public class SalaMenu {
    public static final int OP_NOVO = 1;
    public static final int OP_REMOVER = 2;
    public static final int OP_EDITAR = 3;
    public static final int OP_LISTAR = 4;
    public static final int OP_CONSULTAR = 5;
    public static final int OP_VOLTAR = 0;
    
    public static String getOpcoes(){
        return("\n--------------------------------------\n"
                + "1- Incluir Sala\n"
                + "2- Remover Sala\n"
                + "3- Editar Sala\n"
                + "4- Listar Salas\n"
                + "5- Consultar Sala por Número\n"
                + "0- Voltar"
                + "\n--------------------------------------");
        
    }
}
