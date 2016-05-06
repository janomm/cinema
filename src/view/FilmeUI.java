/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import com.sun.org.apache.xalan.internal.xsltc.runtime.BasisLibrary;
import model.Filme;
import repositorio.RepositorioFilme;
import util.Console;
import view.menu.FilmeMenu;
/**
 *
 * @author Julliano
 */
public class FilmeUI {
    private RepositorioFilme lista;
    
    public FilmeUI(RepositorioFilme lista) {
        this.lista = lista;
    }

    public void executar(){
        int opcao = 0;
        do {
            try{
                System.out.println(FilmeMenu.getOpcoes());
                opcao = Console.scanInt("Digite sua opção:");
                switch (opcao) {
                    case FilmeMenu.OP_NOVO:
                        insereFilme();
                        break;
                    case FilmeMenu.OP_REMOVER:
                        removeFilme();
                        break;
                    case FilmeMenu.OP_EDITAR:
                        editaFilme();
                        break;
                    case FilmeMenu.OP_LISTAR:
                        listaFilmes();
                        break;
                    case FilmeMenu.OP_CONSULTAR:
                        consultaFilme();
                        break;
                    case FilmeMenu.OP_VOLTAR:
                        System.out.println("Retornando ao menu principal..");
                        break;
                    default:
                        System.err.println("Opção inválida.");
                }
            }
            catch(Exception ex){
                System.err.println("Opção inválida.");
                opcao= -1;
            }
        } while (opcao != FilmeMenu.OP_VOLTAR);
    }
    
    public void insereFilme(){
        String nome = Console.scanString("Nome: ");
        if(lista.filmeExiste(nome)){
            System.err.println("Filme já cadastrado.");
        } else {
            String genero = Console.scanString("Gênero: ");
            String sinopse = Console.scanString("Sinopse: ");
            lista.addFilme(nome,genero,sinopse);
        }
    }
    
    public void removeFilme(){
        listaFilmes();
        try{
            int codigo = Console.scanInt("Código: ");
            if(!lista.filmeExiste(codigo)){
                System.err.println("Filme não cadastrado.");
            } else {
                if(lista.deletaFilme(codigo) != true){
                    System.err.println("Filme não Removido.");
                } else {
                    System.out.println("Filme Removido.");
                }
            }
        } catch (Exception ex){
            System.err.println("Código inválido");
        }
    }
    
    public void editaFilme(){
        listaFilmes();
        try{
            int codigo = Console.scanInt("Código: ");
            if(!lista.filmeExiste(codigo)){
                System.err.println("Filme não cadastrado.");
            } else {
                Filme f = lista.retornaFilme(codigo);
                selecionaAlteracao(f);
            }
        } catch (Exception ex){
            System.err.println("Código inválido");
        }
    }
    
    public void listaFilme(int codigo){
        for (Filme filme : lista.getListaFilmes()){
            if(filme.getCodigo().equals(codigo)){
                System.out.println("-----------------------------\n");
                System.out.println(String.format("%-10s", "CÓDIGO") + "\t"
                + String.format("%-20s", "|NOME") + "\t"
                + String.format("%-20s", "|GÊNERO") + "\t"
                + String.format("%-20s", "|SINOPSE"));
                System.out.println(String.format("%-10s", filme.getCodigo()) + "\t"
                + String.format("%-20s", "|" + filme.getNome()) + "\t"
                + String.format("%-20s", "|" + filme.getGenero()) + "\t"
                + String.format("%-20s", "|" + filme.getSinopse()));
                
            }
        }
    }
    
    public void listaFilme(String nome){
        for (Filme filme : lista.getListaFilmes()){
            if(filme.getNome().equalsIgnoreCase(nome)){
                System.out.println("-----------------------------\n");
                System.out.println(String.format("%-10s", "CÓDIGO") + "\t"
                + String.format("%-20s", "|NOME") + "\t"
                + String.format("%-20s", "|GÊNERO") + "\t"
                + String.format("%-20s", "|SINOPSE"));
                System.out.println(String.format("%-10s", filme.getCodigo()) + "\t"
                + String.format("%-20s", "|" + filme.getNome()) + "\t"
                + String.format("%-20s", "|" + filme.getGenero()) + "\t"
                + String.format("%-20s", "|" + filme.getSinopse()));
                
            }
        }
    }
    
    public void listaFilmes(){
        System.out.println("-----------------------------\n");
        System.out.println(String.format("%-10s", "CÓDIGO") + "\t"
        + String.format("%-20s", "|NOME") + "\t"
        + String.format("%-20s", "|GÊNERO") + "\t"
        + String.format("%-20s", "|SINOPSE"));
        for (Filme filme : lista.getListaFilmes()){
            System.out.println(String.format("%-10s", filme.getCodigo()) + "\t"
            + String.format("%-20s", "|" + filme.getNome()) + "\t"
            + String.format("%-20s", "|" + filme.getGenero()) + "\t"
            + String.format("%-20s", "|" + filme.getSinopse()));
        }
    }
    
    public void consultaFilme(){
        String nome = Console.scanString("Nome: ");
        if(!lista.filmeExiste(nome)){
            System.err.println("Filme não Cadastrado.");
        } else {
            listaFilme(nome);
        }
    }
    
    public void selecionaAlteracao(Filme filme){
        int opcao = 0;
        do {
            System.out.println(FilmeMenu.getOpcoesAlteracao());
            opcao = Console.scanInt("Digite sua opção:");
            switch (opcao) {
                case FilmeMenu.OP_ALTERAGENERO:
                    String genero = Console.scanString("Gênero: ");
                    if(lista.alteraGenero(filme, genero)){
                        System.out.println("Gênero Alterado.");
                    } else {
                        System.err.println("Alteração não Realizada.");
                    }
                    break;
                case FilmeMenu.OP_ALTERASINOPSE:
                    String sinopse = Console.scanString("Sinopse: ");
                    if(lista.alteraSinopse(filme, sinopse)){
                        System.out.println("Sinopse Alterada.");
                    } else{
                        System.out.println("Alteração não Realizada.");
                    }
                    break;
                case FilmeMenu.OP_VOLTAR:
                    System.out.println("Retornando ao menu principal..");
                    break;
                default:
                    System.err.println("Opção inválida..");
            }
        } while (opcao != FilmeMenu.OP_VOLTAR);
    }
    
    public boolean existeFilme(){
        return (!lista.equals(null));
    }
    
    public Filme buscaFilme(int codigo){
        for (Filme filme : lista.getListaFilmes()){
            if(filme.getCodigo().equals(codigo)){
                return filme;
            }
        }
        return null;
    }
}
