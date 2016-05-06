/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.Secao;
import model.Venda;
import repositorio.RepositorioFilme;
import repositorio.RepositorioSala;
import repositorio.RepositorioSecao;
import repositorio.RepositorioVenda;
import util.Console;
import util.DateUtil;
import view.menu.VendaMenu;

/**
 *
 * @author Julliano
 */
public class VendaUI {
    private RepositorioVenda listaVendas;
    private RepositorioSecao listaSecoes;
    private RepositorioSala listaSalas;
    private RepositorioFilme listaFilmes;

    public VendaUI(RepositorioVenda listaVenda,RepositorioSecao listaSecao, RepositorioSala listaSala, RepositorioFilme listaFilme) {
        this.listaVendas = listaVenda;
        this.listaSecoes = listaSecao;
        this.listaSalas = listaSala;
        this.listaFilmes = listaFilme;
    }
    
    public RepositorioSecao getListaSecao() {
        return listaSecoes;
    }
    
    public RepositorioSala getListaSala(){
        return listaSalas;
    }
    
    public RepositorioFilme getListaFilme(){
        return listaFilmes;
    }
    
    public RepositorioVenda getListaVendas(){
        return listaVendas;
    }
    
    public void executar(){
        int opcao = 0;
        do {
            System.out.println(VendaMenu.getOpcoes());
            opcao = Console.scanInt("Digite sua opção:");
            switch (opcao) {
                case VendaMenu.OP_VENDA:
                    vendaSecao();
                    break;
                case VendaMenu.OP_LISTAVENDA:
                    listaVenda();
                    break;
                case VendaMenu.OP_VOLTAR:
                    System.out.println("Retornando ao menu principal..");
                    break;
                default:
                    System.err.println("Opção inválida..");
            }
        } while (opcao != VendaMenu.OP_VOLTAR);
    }
    
    public boolean vendaSecao(){
        try{
            listaSecaoAssentos();
            int numero = Console.scanInt("Numero da Seção:");
            if(!listaSecoes.secaoExiste(numero)){
                System.err.println("Seção Inválida.");
                return false;
            }
            
            int ingDisp = ingressosDisponiveis(numero);
            if(ingDisp == 0){
                System.err.println("Seção esgotada.");
                return false;
            }

            int ingVenda = Console.scanInt("Quantidade: ");
            if(ingVenda > ingDisp){
                System.err.println("Quantidade informada maior que a disponível.");
                return false;
            }
            
            if(listaVendas.existeVenda(numero)){
                if(listaVendas.alteraVenda(listaSecoes.retornaSecao(numero), ingVenda)){
                    System.out.println("Venda Efetivada.");
                    return true;
                } else{
                    System.err.println("Venda não Efetivada.");
                    return false;
                }
            } else {
                if(listaVendas.addVenda(listaSecoes.retornaSecao(numero), ingVenda)){
                    System.out.println("Venda Efetivada.");
                    return true;
                } else{
                    System.err.println("Venda não Efetivada.");
                    return false;
                }
            }
        } catch (Exception e){
            System.err.println("Valor inválido.");
            return false;
        }
    }
    
    public Integer ingressosDisponiveis(Integer numero){
        Integer aDisp = 0;
        for (Secao secao : listaSecoes.getListaSecoes()){
            if(secao.getNumero().equals(numero)){
                aDisp = secao.getSala().getAssentos();
                break;
            }
        }
        
        for (Venda v : listaVendas.getListaVendas()){
            if(v.getSecao().getNumero().equals(numero)){
                aDisp = aDisp - v.getQuantidade();
                break;
            }
        }
        return aDisp;
    }
    
    public void listaVenda(){
        System.out.println("-----------------------------\n");
        System.out.println(String.format("%-10s", "SEÇÃO") + "\t"
                         + String.format("%-20s", "|FILME") + "\t"
                         + String.format("%-10s", "|SALA") + "\t"
                         + String.format("%-10s", "|HORÁRIO") + "\t"
                         + String.format("%-10s", "|VENDIDOS") + "\t");
        for (Venda venda : listaVendas.getListaVendas()){
            System.out.println(String.format("%-10s", venda.getSecao().getNumero()) + "\t"
            + String.format("%-20s", "|" + venda.getSecao().getFilme().getNome()) + "\t"
            + String.format("%-10s", "|" + venda.getSecao().getSala().getNumero()) + "\t"
            + String.format("%-10s", "|" + DateUtil.hourToString(venda.getSecao().getHorario())) + "\t"
            + String.format("%-10s", "|" + venda.getQuantidade()) + "\t");
        }
    }
    
    public void listaSecaoAssentos(){
        System.out.println("-----------------------------\n");
        System.out.println(String.format("%-10s", "SEÇÃO") + "\t"
                         + String.format("%-20s", "|FILME") + "\t"
                         + String.format("%-10s", "|SALA") + "\t"
                         + String.format("%-10s", "|HORÁRIO") + "\t"
                         + String.format("%-10s", "|DISPONÍVEL") + "\t");
        for (Secao secao : listaSecoes.getListaSecoes()){
            System.out.println(String.format("%-10s", secao.getNumero()) + "\t"
            + String.format("%-20s", "|" + secao.getFilme().getNome()) + "\t"
            + String.format("%-10s", "|" + secao.getSala().getNumero()) + "\t"
            + String.format("%-10s", "|" + DateUtil.hourToString(secao.getHorario())) + "\t"
            + String.format("%-10s", "|" + ingressosDisponiveis(secao.getNumero())) + "\t");
        }
    }
}
