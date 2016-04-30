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
public class FilmeMenu {
    public static final int OP_NOVO = 1;
    public static final int OP_REMOVER = 2;
    public static final int OP_EDITAR = 3;
    public static final int OP_LISTAR = 4;
    public static final int OP_CONSULTAR = 5;
    public static final int OP_VOLTAR = 0;
    
    public static final int OP_ALTERAGENERO = 1;
    public static final int OP_ALTERASINOPSE = 2;
    
    public static String getOpcoes(){
        return("\n--------------------------------------\n"
                + "1- Incluir Filme\n"
                + "2- Remover Filme\n"
                + "3- Editar Filme\n"
                + "4- Listar Filmes\n"
                + "5- Consultar Filme por Nome\n"
                + "0- Voltar"
                + "\n--------------------------------------");
        
    }
    public static String getOpcoesAlteracao(){
        return("\n--------------------------------------\n"
                + "1- Altera Gênero\n"
                + "2- Altera Sinopse\n"
                + "0- Voltar"
                + "\n--------------------------------------");
    }
    
}
