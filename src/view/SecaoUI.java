/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.Date;
import model.Filme;
import model.Sala;
import model.Secao;
import repositorio.RepositorioFilme;
import repositorio.RepositorioSala;
import repositorio.RepositorioSecao;
import util.Console;
import util.DateUtil;
import view.menu.SecaoMenu;

/**
 *
 * @author Julliano
 */
public class SecaoUI {
    private RepositorioSecao listaSecao;
    private RepositorioSala listaSalas;
    private RepositorioFilme listaFilmes;

    public SecaoUI(RepositorioSecao listaSecao, RepositorioSala listaSala, RepositorioFilme listaFilme) {
        this.listaSecao = listaSecao;
        this.listaSalas = listaSala;
        this.listaFilmes = listaFilme;
    }

    public RepositorioSecao getListaSecao() {
        return listaSecao;
    }
    
    public RepositorioSala getListaSala(){
        return listaSalas;
    }
    
    public RepositorioFilme getListaFilme(){
        return listaFilmes;
    }
    
    public void executar(){
        int opcao = 0;
        do {
            System.out.println(SecaoMenu.getOpcoes());
            opcao = Console.scanInt("Digite sua opção:");
            switch (opcao) {
                case SecaoMenu.OP_NOVO:
                    insereSecao();
                    break;
                case SecaoMenu.OP_REMOVER:
                    removeSecao();
                    break;
                case SecaoMenu.OP_EDITAR:
                    editaSecao();
                    break;
                case SecaoMenu.OP_LISTAR:
                    //listaSala();
                    break;
                case SecaoMenu.OP_CONSULTAR:
                    //consultaSala();
                    break;
                case SecaoMenu.OP_VOLTAR:
                    System.out.println("Retornando ao menu principal..");
                    break;
                default:
                    System.out.println("Opção inválida..");
            }
        } while (opcao != SecaoMenu.OP_VOLTAR);
    }
    
    public boolean insereSecao(){
        Filme filme;
        Sala sala;
        Date hora;
        FilmeUI filmeUI = new FilmeUI(listaFilmes);
        SalaUI salaUI = new SalaUI(listaSalas);
        
        if(listaSalas.quantidadeSala().equals(0)){
            System.out.println("Salas não cadastradas.");
            return false;
        }
        if(listaFilmes.quantidadeFilmes().equals(0)){
            System.out.println("Salas não cadastradas.");
            return false;
        }
        try{
            filmeUI.listaFilmes();
            int codigo = Console.scanInt("Selecione o código do filme: ");
            filme = new FilmeUI(listaFilmes).buscaFilme(codigo);
            if (filme.equals(null)){
                System.out.println("Código do Filme não cadastrado.");
                return false;
            }
        } catch (Exception ex){
            System.out.println("Código inválido.");
            return false;
        }
        try{
            salaUI.listaSala();
            int numero = Console.scanInt("Selecione o número da sala: ");
            sala = new SalaUI(listaSalas).buscaSala(numero);
            if(sala.equals(null)){
                System.out.println("Número da sala não cadastrado.");
                return false;
            }
        } catch(Exception ex){
            System.out.println("Número inválido.");
            return false;
        }
        try{
            String h = Console.scanString("Digite a Hora: ");
            hora = DateUtil.stringToHour(h);
        } catch (Exception ex){
            System.out.println("Hora Inválida.");
            return false;
        }
        if(listaSecao.addSecao(filme, sala, hora)){
            System.out.println("Seção inserida.");
            return true;
        } else{
            System.out.println("Seção não inserida.");
            return false;
        }
    }
    
    
    public boolean removeSecao(){
        if (listaSecao.equals(null)) {
            System.out.println("Nenhuma seção cadastrada.");
            return false;
        }
        listaSecao();
        Integer numero = Console.scanInt("Número: ");
        if(!listaSecao.secaoExiste(numero)){
            System.out.println("Seção não cadastrada.");
        } else {
            if(!listaSecao.deletaSecao(numero)){
                System.out.println("Seção não Removida.");
            } else {
                System.out.println("Seção Removida.");
            }
        }
        
        return true;
    }
    
    public void listaSecao(){
        System.out.println("-----------------------------\n");
        System.out.println(String.format("%-10s", "NÚMERO") + "\t"
                         + String.format("%-20s", "|FILME") + "\t"
                         + String.format("%-10s", "|SALA") + "\t"
                         + String.format("%-10s", "|HORÁRIO") + "\t");
        for (Secao secao : listaSecao.getListaSecoes()){
            System.out.println(String.format("%-10s", secao.getNumero()) + "\t"
            + String.format("%-20s", "|" + secao.getFilme().getNome()) + "\t"
            + String.format("%-10s", "|" + secao.getSala().getNumero()) + "\t"
            + String.format("%-10s", "|" + secao.getHorario()) + "\t");
        }
    }
    
    public void editaSecao(){
        listaSecao();
        int numero = Console.scanInt("Código: ");
        if(!listaSecao.secaoExiste(numero)){
            System.out.println("Seção não cadastrada.");
        } else {
            Secao s = listaSecao.retornaSecao(numero);
            Secao secao = selecionaAlteracao(s);
        }
    }
    
    public boolean secaoExiste(Integer numero){
        for (Secao secao : listaSecao.getListaSecoes()){
            if (secao.getNumero().equals(numero)){
                return true;
            }
        }
        return false;
    }
    
    public Secao selecionaAlteracao(Secao secao){
        int opcao = 0;
        do {
            System.out.println(SecaoMenu.getOpcoesAlteracao());
            opcao = Console.scanInt("Digite sua opção:");
            switch (opcao) {
                case SecaoMenu.OP_ALTERAFILME:
                    /*if(listaSecao.alteraFilme(filme, genero)){
                        System.out.println("Filme Alterado.");
                    } else {
                        System.out.println("Alteração não Realizada.");
                    }*/
                    break;
                case SecaoMenu.OP_ALTERASALA:
                    /*String sinopse = Console.scanString("Sinopse: ");
                    if(listaSalas.alteraSala(filme, sinopse)){
                        System.out.println("Sala Alterada.");
                    } else{
                        System.out.println("Alteração não Realizada.");
                    }*/
                    break;
                case SecaoMenu.OP_ALTERAHORA:
                    /*if(listaSecao.alteraHora(filme, sinopse)){
                        System.out.println("Hora Alterada.");
                    } else{
                        System.out.println("Alteração não Realizada.");
                    }*/
                    break;
                case SecaoMenu.OP_VOLTAR:
                    System.out.println("Retornando ao menu principal..");
                    break;
                default:
                    System.out.println("Opção inválida..");
            }
        } while (opcao != SecaoMenu.OP_VOLTAR);
        
        return null;
    }
    
    
}
