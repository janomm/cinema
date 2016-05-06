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
            try{
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
                        listaSecao();
                        break;
                    case SecaoMenu.OP_CONSULTAR:
                        consultaSecao();
                        break;
                    case SecaoMenu.OP_VOLTAR:
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
        } while (opcao != SecaoMenu.OP_VOLTAR);
    }
    
    public boolean insereSecao(){
        Filme filme;
        Sala sala;
        Date hora;
        FilmeUI filmeUI = new FilmeUI(listaFilmes);
        SalaUI salaUI = new SalaUI(listaSalas);
        
        if(listaSalas.quantidadeSala().equals(0)){
            System.err.println("Salas não cadastradas.");
            return false;
        }
        if(listaFilmes.quantidadeFilmes().equals(0)){
            System.err.println("Salas não cadastradas.");
            return false;
        }
        try{
            filmeUI.listaFilmes();
            int codigo = Console.scanInt("Selecione o código do filme: ");
            filme = new FilmeUI(listaFilmes).buscaFilme(codigo);
            if (filme.equals(null)){
                System.err.println("Código do Filme não cadastrado.");
                return false;
            }
        } catch (Exception ex){
            System.err.println("Código inválido.");
            return false;
        }
        try{
            salaUI.listaSala();
            int numero = Console.scanInt("Selecione o número da sala: ");
            sala = new SalaUI(listaSalas).buscaSala(numero);
            if(sala.equals(null)){
                System.err.println("Número da sala não cadastrado.");
                return false;
            }
        } catch(Exception ex){
            System.err.println("Número inválido.");
            return false;
        }
        try{
            String h = Console.scanString("Digite a Hora: ");
            hora = DateUtil.stringToHour(h);
        } catch (Exception ex){
            System.err.println("Hora Inválida.");
            return false;
        }
        if(listaSecao.addSecao(filme, sala, hora)){
            System.out.println("Seção inserida.");
            return true;
        } else{
            System.err.println("Seção não inserida.");
            return false;
        }
    }
    
    
    public boolean removeSecao(){
        if (listaSecao.equals(null)) {
            System.err.println("Nenhuma seção cadastrada.");
            return false;
        }
        listaSecao();
        try{
            Integer numero = Console.scanInt("Número: ");
            if(!listaSecao.secaoExiste(numero)){
                System.err.println("Seção não cadastrada.");
            } else {
                if(!listaSecao.deletaSecao(numero)){
                    System.err.println("Seção não Removida.");
                } else {
                    System.out.println("Seção Removida.");
                }
            }
            return true;
        } catch (Exception e){
            System.out.println("Número inválido.");
            return false;
        }
    }
    
    public void listaSecao(){
        System.out.println("-----------------------------\n");
        System.out.println(String.format("%-10s", "SEÇÃO") + "\t"
                         + String.format("%-20s", "|FILME") + "\t"
                         + String.format("%-10s", "|SALA") + "\t"
                         + String.format("%-10s", "|HORÁRIO") + "\t");
        for (Secao secao : listaSecao.getListaSecoes()){
            System.out.println(String.format("%-10s", secao.getNumero()) + "\t"
            + String.format("%-20s", "|" + secao.getFilme().getNome()) + "\t"
            + String.format("%-10s", "|" + secao.getSala().getNumero()) + "\t"
            + String.format("%-10s", "|" + DateUtil.hourToString(secao.getHorario())) + "\t");
        }
    }
    
    public void listaSecaoFilme(int codigo){
        System.out.println("-----------------------------\n");
        System.out.println(String.format("%-10s", "SEÇÃO") + "\t"
                         + String.format("%-20s", "|FILME") + "\t"
                         + String.format("%-10s", "|SALA") + "\t"
                         + String.format("%-10s", "|HORÁRIO") + "\t");
        for (Secao secao : listaSecao.getListaSecoes()){
            if(secao.getFilme().getCodigo().equals(codigo)){
                System.out.println(String.format("%-10s", secao.getNumero()) + "\t"
                + String.format("%-20s", "|" + secao.getFilme().getNome()) + "\t"
                + String.format("%-10s", "|" + secao.getSala().getNumero()) + "\t"
                + String.format("%-10s", "|" + DateUtil.hourToString(secao.getHorario())) + "\t");
            }
        }
    }
    
    public void listaSecaoSala(int numero){
        System.out.println("-----------------------------\n");
        System.out.println(String.format("%-10s", "SEÇÃO") + "\t"
                         + String.format("%-20s", "|FILME") + "\t"
                         + String.format("%-10s", "|SALA") + "\t"
                         + String.format("%-10s", "|HORÁRIO") + "\t");
        for (Secao secao : listaSecao.getListaSecoes()){
            if(secao.getSala().getNumero().equals(numero)){
                System.out.println(String.format("%-10s", secao.getNumero()) + "\t"
                + String.format("%-20s", "|" + secao.getFilme().getNome()) + "\t"
                + String.format("%-10s", "|" + secao.getSala().getNumero()) + "\t"
                + String.format("%-10s", "|" + DateUtil.hourToString(secao.getHorario())) + "\t");
            }
        }
    }
    
    public void editaSecao(){
        listaSecao();
        try{
            int numero = Console.scanInt("Código: ");
            if(!listaSecao.secaoExiste(numero)){
                System.err.println("Seção não cadastrada.");
            } else {
                selecionaAlteracao(numero);
            }
        } catch (Exception ex){
            System.err.println("Número inválido.");
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
    
    public void selecionaAlteracao(int numero){
        int opcao = 0;
        do {
            try{
                System.out.println(SecaoMenu.getOpcoesAlteracao());
                opcao = Console.scanInt("Digite sua opção:");
                switch (opcao) {
                    case SecaoMenu.OP_ALTERAFILME:
                        if(!alteraFilme(numero)){
                            System.out.println("Filme da Seção não Alterado.");
                        }
                        break;
                    case SecaoMenu.OP_ALTERASALA:
                        if(!alteraSala(numero)){
                            System.out.println("Sala da Seção não Alterada.");
                        }
                        break;
                    case SecaoMenu.OP_ALTERAHORA:
                        if(!alteraHora(numero)){
                            System.out.println("Hora da Seção não Alterada.");
                        }
                        break;
                    case SecaoMenu.OP_VOLTAR:
                        System.out.println("Retornando ao menu principal..");
                        break;
                    default:
                        System.err.println("Opção inválida..");
                }
            } catch(Exception ex){
                System.err.println("Opção inválida.");
                opcao= -1;
            }
        } while (opcao != SecaoMenu.OP_VOLTAR);
    }
    
    public boolean alteraFilme(int numero){
        try{
            new FilmeUI(listaFilmes).listaFilmes();
            Integer codigo = Console.scanInt("Digite Código do Filme: ");
            Filme filme = listaFilmes.retornaFilme(codigo);
            for(Secao secao : listaSecao.getListaSecoes()){
                if(secao.getNumero().equals(numero)){
                    secao.setFilme(filme);
                    return true;
                }
            }
            return false;
        } catch(Exception e){
            System.err.println("Código inválido.");
            return false;
        }
    }
    
    public boolean alteraSala(int numero){
        try{
            new SalaUI(listaSalas).listaSala();
            int numSala = Console.scanInt("Digite o numero da Sala: ");
            Sala sala = listaSalas.retornaSala(numSala);
            for(Secao secao : listaSecao.getListaSecoes()){
                if(secao.getNumero().equals(numero)){
                    secao.setSala(sala);
                    return true;
                }
            }
            return false;
        } catch (Exception e){
            System.err.println("Código inválido.");
            return false;
        }
    }
    
    public boolean alteraHora(int numero){
        try{
            String hr = Console.scanString("Digite a Hora: ");
            Date h = DateUtil.stringToHour(hr);
            for(Secao secao : listaSecao.getListaSecoes()){
                if(secao.getNumero().equals(numero)){
                    secao.setHorario(h);
                    return true;
                }
            }
            return false;
        } catch (Exception ex){
            System.err.println("Hora Inválida.");
            return false;
        }
    }
    
    public void consultaSecao(){
        int opcao = 0;
        do {
            try{
                System.out.println(SecaoMenu.getOpcoesConsulta());
                opcao = Console.scanInt("Digite sua opção:");
                switch (opcao) {
                    case SecaoMenu.OP_CONSULTAFILME:
                        consultaFilme();
                        break;
                    case SecaoMenu.OP_CONSULTASALA:
                        consultaSala();
                        break;
                    case SecaoMenu.OP_CONSULTAHORA:
                        consultaHora();
                        break;
                    case SecaoMenu.OP_VOLTAR:
                        System.out.println("Retornando ao menu principal..");
                        break;
                    default:
                        System.err.println("Opção inválida..");
                }
            } catch(Exception ex){
                System.err.println("Opção inválida.");
                opcao= -1;
            }
            
        } while (opcao != SecaoMenu.OP_VOLTAR);
    }
    
    public void consultaFilme(){
        try{
            int codigo = Console.scanInt("Codigo do Filme: ");
            System.out.println(String.format("%-10s", "SEÇÃO") + "\t"
                             + String.format("%-20s", "|FILME") + "\t"
                             + String.format("%-10s", "|SALA") + "\t"
                             + String.format("%-10s", "|HORÁRIO") + "\t");
            for (Secao secao : listaSecao.getListaSecoes()){
                if(secao.getFilme().getCodigo().equals(codigo)){
                    System.out.println(String.format("%-10s", secao.getNumero()) + "\t"
                    + String.format("%-20s", "|" + secao.getFilme().getNome()) + "\t"
                    + String.format("%-10s", "|" + secao.getSala().getNumero()) + "\t"
                    + String.format("%-10s", "|" + DateUtil.hourToString(secao.getHorario())) + "\t");
                }
            }
        } catch (Exception e){
            System.err.println("Código Inválido.");
        }
    }
    
    public void consultaSala(){
        try{
            int numero = Console.scanInt("Número da Sala: ");
            System.out.println(String.format("%-10s", "SEÇÃO") + "\t"
                             + String.format("%-20s", "|FILME") + "\t"
                             + String.format("%-10s", "|SALA") + "\t"
                             + String.format("%-10s", "|HORÁRIO") + "\t");
            for (Secao secao : listaSecao.getListaSecoes()){
                if(secao.getSala().getNumero().equals(numero)){
                    System.out.println(String.format("%-10s", secao.getNumero()) + "\t"
                    + String.format("%-20s", "|" + secao.getFilme().getNome()) + "\t"
                    + String.format("%-10s", "|" + secao.getSala().getNumero()) + "\t"
                    + String.format("%-10s", "|" + DateUtil.hourToString(secao.getHorario())) + "\t");
                }
            }
        } catch (Exception e){
            System.err.println("Código Inválido.");
        }
    }
    
    public void consultaHora(){
        try{
            String h = Console.scanString("Hora: ");
            Date hora = DateUtil.stringToHour(h);
            System.out.println("-----------------------------\n");
            System.out.println(String.format("%-10s", "SEÇÃO") + "\t"
                             + String.format("%-20s", "|FILME") + "\t"
                             + String.format("%-10s", "|SALA") + "\t"
                             + String.format("%-10s", "|HORÁRIO") + "\t");
            for (Secao secao : listaSecao.getListaSecoes()){
                if(secao.getHorario().equals(hora)){
                    System.out.println(String.format("%-10s", secao.getNumero()) + "\t"
                    + String.format("%-20s", "|" + secao.getFilme().getNome()) + "\t"
                    + String.format("%-10s", "|" + secao.getSala().getNumero()) + "\t"
                    + String.format("%-10s", "|" + DateUtil.hourToString(secao.getHorario())) + "\t");
                }
            }

        } catch (Exception e){
            System.err.println("Horário inválido.");
        }
    }
    
    public boolean achaSecao(int numero){
        for (Secao secao : listaSecao.getListaSecoes()){
            if(secao.getNumero().equals(numero)){
                return true;
            }
        }
        return false;
    }
    
    public Secao retornaSecao(int numero){
        for (Secao secao : listaSecao.getListaSecoes()){
            if(secao.getNumero().equals(numero)){
                return secao;
            }
        }
        Secao s = new Secao();
        return s;
    }
    
    public boolean relatorioFilmeSecoes(){
        try {
            FilmeUI filmeUi = new FilmeUI(listaFilmes);
            Filme filme = new Filme();
            filmeUi.listaFilmes();
            int codigo = Console.scanInt("Código do filme");
            if(listaFilmes.filmeExiste(codigo)){
                filme = filmeUi.buscaFilme(codigo);
                
                listaFilmeSecoes(filme);
                return true;
            } else{
                System.err.println("Filme não encontrado.");
                return false;
            }
            
        } catch (Exception e) {
            System.err.println("Seção Inválida.");
            return false;
        }
    }
    
    public void listaFilmeSecoes(Filme filme){
        System.out.println(String.format("%-10s", "SEÇÃO") + "\t"
                            + String.format("%-20s", "|FILME") + "\t"
                            + String.format("%-10s", "|SALA") + "\t"
                            + String.format("%-10s", "|HORÁRIO") + "\t");
        for (Secao secao : listaSecao.getListaSecoes()){
            if(secao.getFilme().equals(filme)){
                System.out.println(String.format("%-10s", secao.getNumero()) + "\t"
                + String.format("%-20s", "|" + secao.getFilme().getNome()) + "\t"
                + String.format("%-10s", "|" + secao.getSala().getNumero()) + "\t"
                + String.format("%-10s", "|" + DateUtil.hourToString(secao.getHorario())) + "\t");
            }
        }
    }
    
    public Integer quantidadeSala(Sala sala){
        int q = 0;
        for (Secao secao : listaSecao.getListaSecoes()){
            if(secao.getSala().equals(sala)){
                q++;
            }
        }
        return q;
    }

}
