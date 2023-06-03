package io.github.grahduarte.entidades.cliente;

import io.github.grahduarte.entidades.contrato.Contrato;
import io.github.grahduarte.entidades.entidade.Entidade;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Entidade {

    //<editor-fold desc="Atributos" defaultstate="collapsed">
    private String nome;
    private long cpf;
    //</editor-fold>

    //<editor-fold desc="Construtores" defaultstate="collapsed">

    public Cliente() {
    }

    public Cliente(String nome, long cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    //</editor-fold>

    //<editor-fold desc="Getters e Setters" defaultstate="collapsed">

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }
    //</editor-fold>

    //<editor-fold desc="toString" defaultstate="collapsed">

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + getId() +
                ", nome='" + nome + '\'' +
                ", cpf=" + cpf +
                '}';
    }

    //</editor-fold>

}
