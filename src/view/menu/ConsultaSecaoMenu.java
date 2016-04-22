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
public class ConsultaSecaoMenu {
    public static final int OP_SALA = 1;
    public static final int OP_HORARIO = 2;
    public static final int OP_FILME = 3;
    public static final int OP_VOLTAR = 0;
    
    public static String getOpcoes(){
        return("\n--------------------------------------\n"
                + "1- Consultar Seção por Sala\n"
                + "2- Consultar Seção por Horário\n"
                + "3- Consultar Seção por Filme\n"
                + "0- Voltar"
                + "\n--------------------------------------");
        
    }
}
