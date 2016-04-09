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
    

    public static final int OP_PACIENTES = 1;
    public static final int OP_MEDICAMENTOS = 2;
    public static final int OP_CONSULTA = 3;
    public static final int OP_AGENDA = 4;
    public static final int OP_HISTORICO = 5;
    public static final int OP_SAIR = 0;

    public static String getOpcoes() {
        return ("\n--------------------------------------\n"
                + "1- Menu Pacientes\n"
                + "2- Menu Medicamentos\n"
                + "3- Menu Consulta\n"
                + "4- Menu Agenda\n"
                + "5- Menu Histórico\n"
                + "0- Sair da Aplicação"
                + "\n--------------------------------------");
    }
}


