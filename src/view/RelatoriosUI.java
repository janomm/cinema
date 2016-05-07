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
import model.Venda;
import repositorio.RepositorioFilme;
import repositorio.RepositorioSala;
import repositorio.RepositorioSecao;
import repositorio.RepositorioVenda;
import util.Console;
import util.DateUtil;
import view.menu.RelatorioMenu;

/**
 *
 * @author Julliano
 */
public class RelatoriosUI {
    private RepositorioVenda listaVendas;
    private RepositorioSecao listaSecoes;
    private RepositorioSala listaSalas;
    private RepositorioFilme listaFilmes;

    public RelatoriosUI(RepositorioVenda listaVenda,RepositorioSecao listaSecao, RepositorioSala listaSala, RepositorioFilme listaFilme) {
        this.listaVendas = listaVenda;
        this.listaSecoes = listaSecao;
        this.listaSalas = listaSala;
        this.listaFilmes = listaFilme;
    }

    public RepositorioVenda getListaVendas() {
        return listaVendas;
    }

    public RepositorioSecao getListaSecoes() {
        return listaSecoes;
    }

    public RepositorioSala getListaSalas() {
        return listaSalas;
    }

    public RepositorioFilme getListaFilmes() {
        return listaFilmes;
    }
    
    public void executar(){
        int opcao = 0;
        do {
            try{
                System.out.println(RelatorioMenu.getOpcoes());
                opcao = Console.scanInt("Digite sua opção:");
                switch (opcao) {
                    case RelatorioMenu.OP_VENDAFILME:
                        relatorioVendaFilme();
                        break;
                    case RelatorioMenu.OP_VENDAHORARIO:
                        relatorioVendaHorario();
                        break;
                    case RelatorioMenu.OP_VENDASALA:
                        relatorioVendaSala();
                        break;
                    case RelatorioMenu.OP_VENDASECOES:
                        relatorioVendaSecoes();
                        break;
                    case RelatorioMenu.OP_FILMESECOES:
                        new SecaoUI(listaSecoes, listaSalas, listaFilmes).relatorioFilmeSecoes();
                        break;
                    case RelatorioMenu.OP_SALAMAISUTILIZADAS:
                        relatorioSalaMaisUtilizada();
                        break;
                    default:
                        System.err.println("Opção inválida..");
                }
            }
            catch(Exception ex){
                System.err.println("Opção inválida.");
                opcao= -1;
            }
        } while (opcao != RelatorioMenu.OP_VOLTAR);
    }
    
    /**
     * Interface que lista o relatório de vendas para um filme
     * @return 
     */
    public boolean relatorioVendaFilme(){
        try {
            FilmeUI f = new FilmeUI(listaFilmes);
            Filme filme = new Filme();
            f.listaFilmes();
            int codigo = Console.scanInt("Digite o código:");
            System.out.println(listaFilmes.filmeExiste(codigo));
            if(listaFilmes.filmeExiste(codigo)){
                filme = f.buscaFilme(codigo);
                listaVendaFilme(filme);
                return true;
            } else {
                System.err.println("Filme não encontrado.");
                return false;
            }
        } catch (Exception e) {
            System.err.println("Código Inválido.");
            return false;
        }
    }
    
    /**
     * Lista todas as vendas de ingressos por filme
     * @param filme 
     */
    public void listaVendaFilme(Filme filme){
        Integer q = 0;
        for (Venda venda : listaVendas.getListaVendas()){
            if(venda.getSecao().getFilme().equals(filme)){
                q = q + venda.getQuantidade();
            }
        }        
        System.out.println("-----------------------------\n");
        System.out.println(String.format("%-20s", "|FILME") + "\t"
        + String.format("%-15s", "|QUANT. VENDIDOS") + "\t");
        if(q > 0) {
            System.out.println(String.format(String.format("%-20s", "|" + filme.getNome()) + "\t"
                            + String.format("%-15s", "|" + q)) + "\t");
        }
    }
    
    /**
     * Interface que lista o relatório de vendas por horário de seção
     * @return 
     */
    public boolean relatorioVendaHorario(){
        try{
            String h = Console.scanString("Digite a Hora: ");
            Date hora = DateUtil.stringToHour(h);
            listaVendaHorario(hora);
            return true;
        } catch (Exception ex){
            System.err.println("Hora Inválida.");
            return false;
        }
        
    }
    
    /**
     * Lista todas as vendas para a hora informada
     * @param hora 
     */
    public void listaVendaHorario(Date hora){
        System.out.println("-----------------------------\n");
        System.out.println(String.format("%-10s", "HORÁRIO") + "\t"
                         + String.format("%-10s", "|SEÇÃO") + "\t"
                         + String.format("%-20s", "|FILME") + "\t"
                         + String.format("%-10s", "|SALA") + "\t"
                         + String.format("%-15s", "|QUANT. VENDIDOS") + "\t");
        for (Venda venda : listaVendas.getListaVendas()){
            if(venda.getSecao().getHorario().equals(hora)){
                System.out.println(String.format("%-10s", DateUtil.hourToString(hora)) + "\t"
                + String.format("%-10s", "|" + venda.getSecao().getNumero()) + "\t"
                + String.format("%-20s", "|" + venda.getSecao().getFilme().getNome()) + "\t"
                + String.format("%-10s", "|" + venda.getSecao().getSala().getNumero()) + "\t"
                + String.format("%-15s", "|" + venda.getQuantidade()) + "\t");
            }
        }
    }
    
    /**
     * Interface que lista o relatório de vendas por sala
     * @return 
     */
    public boolean relatorioVendaSala(){
        try {
            SalaUI salaUi = new SalaUI(listaSalas);
            Sala sala = new Sala();
            salaUi.listaSala();
            int numero = Console.scanInt("Selecione o número: ");
            if(listaSalas.salaExiste(numero)){
                sala = salaUi.buscaSala(numero);
                listaVendaSala(sala);
                return true;
            } else {
                System.err.println("Sala não encontrada.");
                return false;
            }
        } catch (Exception e) {
            System.err.println("Número Inválido.");
            return false;
        }
    }
    
    /**
     * Lista a quantidade de ingressos vendidos para uma sala
     * @param sala 
     */
    public void listaVendaSala(Sala sala){
        int q = 0;
        for (Venda venda : listaVendas.getListaVendas()){
            if(venda.getSecao().getSala().equals(sala)){
                q = q + venda.getQuantidade();
            }
        }
        System.out.println("-----------------------------\n");
        System.out.println(String.format("%-10s", "SALA") + "\t"
        + String.format("%-10s", "|ASSENTOS") + "\t"
        + String.format("%-15s", "|QUANT. VENDIDOS") + "\t");
        if(q > 0) {
            System.out.println(String.format("%-10s", sala.getNumero()) + "\t"
                               + String.format("%-10s", "|" + sala.getAssentos()) + "\t"
                                + String.format("%-15s", "|" + q) + "\t");
        }
    }
    
    /**
     * Interface que lista o relatório de vendas para uma seção
     * @return 
     */
    public boolean relatorioVendaSecoes(){
        try {
            SecaoUI secaoUi = new SecaoUI(listaSecoes, listaSalas, listaFilmes);
            Secao secao = new Secao();
            secaoUi.listaSecao();
            int numero = Console.scanInt("Selecione a seção: ");
            if(listaSecoes.secaoExiste(numero)){
                secao = secaoUi.retornaSecao(numero);
                listaVendaSecao(secao);
                return true;
            } else {
                System.err.println("Seção não encontrada.");
                return false;
            }
        } catch (Exception e) {
            System.err.println("Seção Inválida.");
            return false;
        }
    }
    
    /**
     * lista as vendas de uma seção
     * @param secao 
     */
    public void listaVendaSecao(Secao secao){
        int q = 0;
        for(Venda venda : listaVendas.getListaVendas()){
            if(venda.getSecao().equals(secao)){
                q = q + venda.getQuantidade();
            }
        }
        System.out.println("-----------------------------\n");
        System.out.println(String.format("%-10s", "|SEÇÃO") + "\t"
                         + String.format("%-20s", "|FILME") + "\t"
                         + String.format("%-10s", "|SALA") + "\t"
                         + String.format("%-10s", "|HORÁRIO") + "\t"
                         + String.format("%-15s", "|QUANT. VENDIDOS") + "\t");
        if(q > 0){
            System.out.println(String.format("%-10s", secao.getNumero()) + "\t"
            + String.format("%-20s", "|" + secao.getFilme().getNome()) + "\t"
            + String.format("%-10s", "|" + secao.getSala().getNumero()) + "\t"
            + String.format("%-10s", "|" + DateUtil.hourToString(secao.getHorario())) + "\t"
            + String.format("%-15s", "|" + q) + "\t");
        }
    }
    
    /**
     * Retorna a sala mais utilizada nas seções
     * @return 
     */
    public boolean relatorioSalaMaisUtilizada(){
        Sala sala = retornaSalaMaisUtilizada();
        if(sala.equals(null)){
            System.err.println("Nenhuma Sala encontrada.");
            return false;
        } else {
            System.out.println("A sala mais utilizada é a " + sala.getNumero() 
                    + ", com " + sala.getAssentos() + " assentos.");
            return true;
        }
    }
    
    /**
     * Retorna o objeto da sala mais utilizada
     * @return 
     */
    public Sala retornaSalaMaisUtilizada(){
        int q = 0;
        Sala s = new Sala();
        SecaoUI sUi = new SecaoUI(listaSecoes, listaSalas, listaFilmes);
        for (Secao secao : listaSecoes.getListaSecoes()){
            if(sUi.quantidadeSala(secao.getSala()) > q){
                s = secao.getSala();
                q = sUi.quantidadeSala(secao.getSala());
            }
        }
        return s;
    }
}
