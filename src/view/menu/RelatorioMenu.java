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
public class RelatorioMenu {
    public static final int OP_VENDAFILME = 1;
    public static final int OP_VENDAHORARIO = 2;
    public static final int OP_VENDASALA = 3;
    public static final int OP_VENDASECOES = 4;
    public static final int OP_FILMESECOES = 5;
    public static final int OP_SALAMAISUTILIZADAS = 6;
    public static final int OP_VOLTAR = 0;
    
    public static String getOpcoes(){
        return("\n--------------------------------------\n"
                + "1- Listar Vendas por Filme\n"
                + "2- Listar Vendas por Horário\n"
                + "3- Listar Vendas por Sala\n"
                + "4- Listar Vendas por Seções\n"
                + "5- Listar Filmes em mais Seções\n"
                + "6- Listar Salas mais Utilizadas\n"
                + "0- Voltar"
                + "\n--------------------------------------");
    }
    
}
