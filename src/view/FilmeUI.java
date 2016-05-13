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
 * Classe Interface de Filmes
 * @author Julliano
 */
public class FilmeUI {
    private RepositorioFilme lista;
    
    /**
     * Método Construtor
     * @param lista 
     */
    public FilmeUI(RepositorioFilme lista) {
        this.lista = lista;
    }

    /**
     * Método de inicialização da interface
     */
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
    
    /**
     * Interface que executa a inclusão de um Filme
     */
    public boolean insereFilme(){
        String nome = Console.scanString("Nome: ");
        if(lista.filmeExiste(nome)){
            System.err.println("Filme já cadastrado.");
            return false;
        } else {
            String genero = Console.scanString("Gênero: ");
            String sinopse = Console.scanString("Sinopse: ");
            if(nome.equals("") || genero.equals("") || sinopse.equals("")){
                System.err.println("Valores em branco.");
                return false;
            }
            lista.addFilme(nome,genero,sinopse);
            return true;
        }
        
    }
    
    /**
     * Interface que executa a exclusão de um filme
     */
    public boolean removeFilme(){
        listaFilmes();
        try{
            int codigo = Console.scanInt("Código: ");
            if(!lista.filmeExiste(codigo)){
                System.err.println("Filme não cadastrado.");
                return false;
            } else {
                if(lista.deletaFilme(codigo) != true){
                    System.err.println("Filme não Removido.");
                    return false;
                } else {
                    System.out.println("Filme Removido.");
                    return true;
                }
            }
        } catch (Exception ex){
            System.err.println("Código inválido");
            return false;
        }
    }
    
    /**
     * Interface que executa a edição de um filme
     */
    public boolean editaFilme(){
        listaFilmes();
        try{
            int codigo = Console.scanInt("Código: ");
            if(!lista.filmeExiste(codigo)){
                System.err.println("Filme não cadastrado.");
                return false;
            } else {
                Filme f = lista.retornaFilme(codigo);
                return selecionaAlteracao(f);
            }
        } catch (Exception ex){
            System.err.println("Código inválido");
            return false;
        }
    }
    
    /**
     * Método que lista um filme pelo código do mesmo
     * @param codigo 
     */
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
    
    /**
     * Método que lista um filpe pelo nome do mesmo
     * @param nome 
     */
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
    
    /**
     * Método que lista todos os filmes
     */
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
    
    /**
     * Método que faz a consulta e listagem de um filme
     */
    public void consultaFilme(){
        String nome = Console.scanString("Nome: ");
        if(!lista.filmeExiste(nome)){
            System.err.println("Filme não Cadastrado.");
        } else {
            listaFilme(nome);
        }
    }
    
    public boolean selecionaAlteracao(Filme filme){
        int opcao = 0;
        do {
            System.out.println(FilmeMenu.getOpcoesAlteracao());
            opcao = Console.scanInt("Digite sua opção:");
            switch (opcao) {
                case FilmeMenu.OP_ALTERAGENERO:
                    String genero = Console.scanString("Gênero: ");
                    if(!genero.equals("")){
                        if(lista.alteraGenero(filme, genero)){
                            System.out.println("Gênero Alterado.");
                        } else {
                            System.err.println("Alteração não Realizada.");
                        }
                    } else {
                        System.err.println("Gênero em branco.");
                    }
                    break;
                case FilmeMenu.OP_ALTERASINOPSE:
                    String sinopse = Console.scanString("Sinopse: ");
                    if(!sinopse.equals("")){
                        if(lista.alteraSinopse(filme, sinopse)){
                            System.out.println("Sinopse Alterada.");
                        } else{
                            System.out.println("Alteração não Realizada.");
                        }
                    } else {
                        System.err.println("Sinópse em branco.");
                    }
                    break;
                case FilmeMenu.OP_VOLTAR:
                    System.out.println("Retornando ao menu principal..");
                    break;
                default:
                    System.err.println("Opção inválida..");
            }
        } while (opcao != FilmeMenu.OP_VOLTAR);
        return true;
    }
    
    /**
     * Interface que retorna se o arraylist contem pelo menos um filme cadastrado
     * @return 
     */
    public boolean existeFilme(){
        return (!lista.equals(null));
    }
    
    
    
    /**
     * Método que retorna o objeto filme igual ao código informado
     * @param codigo
     * @return 
     */
    public Filme buscaFilme(int codigo){
        for (Filme filme : lista.getListaFilmes()){
            if(filme.getCodigo().equals(codigo)){
                return filme;
            }
        }
        return null;
    }
}
