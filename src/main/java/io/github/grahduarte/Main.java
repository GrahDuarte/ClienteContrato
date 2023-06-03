package io.github.grahduarte;

import io.github.grahduarte.dao.cliente.ClienteDAO;
import io.github.grahduarte.dao.contrato.ContratoDAO;
import io.github.grahduarte.entidades.cliente.Cliente;
import io.github.grahduarte.entidades.contrato.Contrato;

import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        //<editor-fold desc="Clientes e Contratos" defaultstate="collapsed">

        //<editor-fold desc="Cliente: Ana Zaira" defaultstate="collapsed">
        Cliente cliente1 = new Cliente();
        cliente1.setNome("Ana Zaira");
        cliente1.setCpf(11929826303L);

        //<editor-fold desc="Contratos: Ana Zaira" defaultstate="collapsed">

        Contrato contrato1 = new Contrato();
        contrato1.setRedacao("Contrato por tempo determinado");
        contrato1.setUltimaAtualizacao(java.sql.Date.valueOf("2023-5-21"));

        Contrato contrato2 = new Contrato();
        contrato2.setRedacao("Contrato por tempo indeterminado");
        contrato2.setUltimaAtualizacao(java.sql.Date.valueOf("2023-5-01"));

        Contrato contrato3 = new Contrato();
        contrato3.setRedacao("Contrato de trabalho eventual");
        contrato3.setUltimaAtualizacao(java.sql.Date.valueOf("2023-5-26"));
        //</editor-fold>

        //</editor-fold>

        //<editor-fold desc="Cliente: Beatriz Yana" defaultstate="collapsed">
        Cliente cliente2 = new Cliente();
        cliente2.setNome("Beatriz Yana");
        cliente2.setCpf(26752965030L);

        //<editor-fold desc="Contratos: Beatriz Yana" defaultstate="collapsed">

        Contrato contrato4 = new Contrato();
        contrato4.setRedacao("Contrato de estágio");
        contrato4.setUltimaAtualizacao(java.sql.Date.valueOf("2023-10-15"));

        Contrato contrato5 = new Contrato();
        contrato5.setRedacao("Contrato de experiência");
        contrato5.setUltimaAtualizacao(java.sql.Date.valueOf("2023-9-16"));

        Contrato contrato6 = new Contrato();
        contrato6.setRedacao("Contrato de teletrabalho");
        contrato6.setUltimaAtualizacao(java.sql.Date.valueOf("2023-8-17"));

        Contrato contrato7 = new Contrato();
        contrato7.setRedacao("Contrato intermitente");
        contrato7.setUltimaAtualizacao(java.sql.Date.valueOf("2023-7-15"));

        //</editor-fold>

        //</editor-fold>

        //</editor-fold>

        //<editor-fold desc="Testes de salvar" defaultstate="collapsed">

        //<editor-fold desc="Salvar cliente Ana Zaira" defaultstate="collapsed">
        long idCliente1 = new ClienteDAO().salvar(cliente1);
        cliente1.setId(idCliente1);

        //<editor-fold desc="Salvar contratos de Ana Zaira" defaultstate="collapsed">
        contrato1.setIdCliente(cliente1.getId());
        contrato2.setIdCliente(cliente1.getId());
        contrato3.setIdCliente(cliente1.getId());

        System.out.println("contrato01: " + contrato1);
        System.out.println("cliente1: " + cliente1);
        long contratoID = new ContratoDAO().salvar(contrato1);
        contrato1.setId(contratoID);
        contratoID = new ContratoDAO().salvar(contrato2);
        contrato2.setId(contratoID);
        contratoID = new ContratoDAO().salvar(contrato3);
        contrato3.setId(contratoID);
        //</editor-fold>

        //</editor-fold>

        //<editor-fold desc="Salvar cliente Beatriz Yana" defaultstate="collapsed">
        long idCliente2 = new ClienteDAO().salvar(cliente2);
        cliente2.setId(idCliente2);

        //<editor-fold desc="Salvar contratos de Beatriz Yana" defaultstate="collapsed">
        contrato4.setIdCliente(cliente2.getId());
        contrato5.setIdCliente(cliente2.getId());
        contrato6.setIdCliente(cliente2.getId());
        contrato7.setIdCliente(cliente2.getId());

        contratoID = new ContratoDAO().salvar(contrato4);
        contrato4.setId(contratoID);
        contratoID = new ContratoDAO().salvar(contrato5);
        contrato5.setId(contratoID);
        contratoID = new ContratoDAO().salvar(contrato6);
        contrato6.setId(contratoID);
        contratoID = new ContratoDAO().salvar(contrato7);
        contrato7.setId(contratoID);
        //</editor-fold>


        //</editor-fold>

        //</editor-fold>

        //<editor-fold desc="Testes de editar" defaultstate="collapsed">

        //<editor-fold desc="Editar cliente Ana Zaira" defaultstate="collapsed">
        cliente1.setNome("Ana Zaira da Silva");
        new ClienteDAO().salvar(cliente1);
        //</editor-fold>

        //<editor-fold desc="Editar contrato Ana Zaira" defaultstate="collapsed">

        contrato1.setRedacao("Contrato por tempo indeterminado");
        new ContratoDAO().salvar(contrato1);

        //</editor-fold>

        //</editor-fold>

        //<editor-fold desc="Testes de localizar" defaultstate="collapsed">

        //<editor-fold desc="Localizar todos os clientes" defaultstate="collapsed">

        List<Cliente> clientes = new ClienteDAO().localizarTodos();

        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }

        //</editor-fold>

        //<editor-fold desc="Localizar cliente Ana Zaira" defaultstate="collapsed">

        Cliente clienteID1 = new ClienteDAO().localizarPorId(cliente1.getId());
        System.out.println("clienteID1: " + clienteID1);

        //</editor-fold>

        //<editor-fold desc="Localizar cliente Beatriz Yana" defaultstate="collapsed">

        Cliente clienteID2 = new ClienteDAO().localizarPorId(cliente2.getId());
        System.out.println("clienteID2: " + clienteID2);

        //</editor-fold>

        //</editor-fold>

        //<editor-fold desc="Testes de apagar" defaultstate="collapsed">

        //<editor-fold desc="Apagar contratos Ana Zaira" defaultstate="collapsed">

        new ContratoDAO().excluir(contrato1);
        new ContratoDAO().excluir(contrato2);
        new ContratoDAO().excluir(contrato3);

        //</editor-fold

        //<editor-fold desc="Apagar cliente Ana Zaira" defaultstate="collapsed">

        new ClienteDAO().excluir(cliente1);

        //</editor-fold>

        //</editor-fold>

    }
}