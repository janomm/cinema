/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.Sala;
import repositorio.RepositorioSala;
import util.Console;
import view.menu.SalaMenu;
/**
 *
 * @author Julliano
 */
public class SalaUI {
    private RepositorioSala lista;

    public SalaUI(RepositorioSala lista) {
        this.lista = lista;
    }
    
    public void executar(){
        int opcao = 0;
        do {
            System.out.println(SalaMenu.getOpcoes());
            opcao = Console.scanInt("Digite sua opção:");
            switch (opcao) {
                case SalaMenu.OP_NOVO:
                    insereSala();
                    break;
                case SalaMenu.OP_REMOVER:
                    removeSala();
                    break;
                case SalaMenu.OP_EDITAR:
                    editaSala();
                    break;
                case SalaMenu.OP_LISTAR:
                    listaSala();
                    break;
                case SalaMenu.OP_CONSULTAR:
                    consultaSala();
                    break;
                case SalaMenu.OP_VOLTAR:
                    System.out.println("Retornando ao menu principal..");
                    break;
                default:
                    System.out.println("Opção inválida..");
            }
        } while (opcao != SalaMenu.OP_VOLTAR);
    }
    
    public void insereSala(){
        try{
            int assentos = Console.scanInt("Assentos: ");
            if(assentos > 0){
                if(lista.addSala(assentos)){
                    System.out.println("Sala cadastrada.");
                } else {
                    System.out.println("Sala não cadastrada.");
                }
            } else {
                System.out.println("Quantidade de assentos inválida.");
            }
        } catch (Exception e){
            System.out.println("Quantidade de assentos inválida.");
        }
    }
    
    public void removeSala(){
        listaSala();
        Integer numero = Console.scanInt("Número: ");
        if(!lista.salaExiste(numero)){
            System.out.println("Sala não Cadastrada.");
        } else {
            if(!lista.deletaSala(numero)){
                System.out.println("Sala não Removida.");
            } else {
                System.out.println("Sala Removida.");
            }
        }
    }
    
    public void listaSala(){
        System.out.println("-----------------------------\n");
        System.out.println(String.format("%-10s", "NÚMERO") + "\t"
                         + String.format("%-10s", "|ASSENTOS"));
        for (Sala sala : lista.getListaSalas()){
            System.out.println(String.format("%-10s", sala.getNumero()) + "\t"
            + String.format("%-10s", "|" + sala.getAssentos()));
        }
    }
    
    public void listaSala(Integer numero){
        System.out.println("-----------------------------\n");
        System.out.println(String.format("%-10s", "NÚMERO") + "\t"
                         + String.format("%-10s", "|ASSENTOS"));
        for (Sala sala : lista.getListaSalas()){
            if(sala.getNumero().equals(numero)){
                System.out.println(String.format("%-10s", sala.getNumero()) + "\t"
                + String.format("%-10s", "|" + sala.getAssentos()));
            }
        }
    }
    
    public void editaSala(){
        listaSala();
        int numero = Console.scanInt("Numero: ");
        if(!lista.salaExiste(numero)){
            System.out.println("Sala não Cadastrada.");
        } else {
            Sala s = lista.retornaSala(numero);
            int assentos = Console.scanInt("Assentos: ");
            if(assentos > 0){
                if(lista.alteraAssentos(s, assentos)){
                    System.out.println("Assentos Alterado.");
                } else {
                    System.out.println("Alteração não Realizada.");
                }
            } else {
                System.out.println("Quantidade de assentos inválida. Alteração não Realizada.");
            }
        }
    }
    
    public void consultaSala(){
        Integer numero = Console.scanInt("Número: ");
        if(!lista.salaExiste(numero)){
            System.out.println("Sala não Cadastrada.");
        } else {
            listaSala(numero);
        }
    }
}
