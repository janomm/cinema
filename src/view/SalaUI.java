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
            try{
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
                        System.err.println("Opção inválida..");
                }
            }
            catch(Exception ex){
                System.err.println("Opção inválida.");
                opcao= -1;
            }
        } while (opcao != SalaMenu.OP_VOLTAR);
    }
    
    /**
     * Interface que executa a inserção de uma sala
     */
    public void insereSala(){
        try{
            int assentos = Console.scanInt("Assentos: ");
            if(assentos > 0){
                if(lista.addSala(assentos)){
                    System.out.println("Sala cadastrada.");
                } else {
                    System.err.println("Sala não cadastrada.");
                }
            } else {
                System.err.println("Quantidade de assentos inválida.");
            }
        } catch (Exception e){
            System.err.println("Quantidade Inválida.");
        }
    }
    
    /**
     * Interface que executa a remoção de uma sala
     */
    public void removeSala(){
        listaSala();
        try{
            Integer numero = Console.scanInt("Número: ");
            if(!lista.salaExiste(numero)){
                System.err.println("Sala não Cadastrada.");
            } else {
                if(!lista.deletaSala(numero)){
                    System.err.println("Sala não Removida.");
                } else {
                    System.out.println("Sala Removida.");
                }
            }
        } catch(Exception ex){
            System.err.println("Quantidade Inválida.");
        }
    }
    
    /**
     * Interface que lista todas ass salas
     */
    public void listaSala(){
        System.out.println("-----------------------------\n");
        System.out.println(String.format("%-10s", "NÚMERO") + "\t"
                         + String.format("%-10s", "|ASSENTOS"));
        for (Sala sala : lista.getListaSalas()){
            System.out.println(String.format("%-10s", sala.getNumero()) + "\t"
            + String.format("%-10s", "|" + sala.getAssentos()));
        }
    }
    
    /**
     * Interface que lista a sala por numero
     * @param numero 
     */
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
    
    /**
     * Interface que executa a edição de uma sala
     */
    public void editaSala(){
        listaSala();
        try{
            int numero = Console.scanInt("Numero: ");
            if(!lista.salaExiste(numero)){
                System.err.println("Sala não Cadastrada.");
            } else {
                Sala s = lista.retornaSala(numero);
                int assentos = Console.scanInt("Assentos: ");
                if(assentos > 0){
                    if(lista.alteraAssentos(s, assentos)){
                        System.out.println("Assentos Alterado.");
                    } else {
                        System.err.println("Alteração não Realizada.");
                    }
                } else {
                    System.err.println("Quantidade de assentos inválida. Alteração não Realizada.");
                }
            }
        } catch (Exception e){
            System.err.println("Número inválido.");
        }
    }
    
    /**
     * Interface que consulta e lista a sala informada
     */
    public void consultaSala(){
        try{
            Integer numero = Console.scanInt("Número: ");
            if(!lista.salaExiste(numero)){
                System.err.println("Sala não Cadastrada.");
            } else {
                listaSala(numero);
            }
        } catch (Exception e){
            System.err.println("Número inválido.");
        }
    }
    
    /**
     * Método que retorna se existe pelo menos uma sala cadastrada no arraylist
     * @return 
     */
    public boolean existeSala(){
        return (!lista.equals(null));
    }
    
    /**
     * Método que retorna o objeto da sala com o código igual ao informado
     * @param numero
     * @return 
     */
    public Sala buscaSala(int numero){
        for (Sala sala : lista.getListaSalas()){
            if(sala.getNumero().equals(numero)){
                return sala;
            }
        }
        return null;
    }
}
