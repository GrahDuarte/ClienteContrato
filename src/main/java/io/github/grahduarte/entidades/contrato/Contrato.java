package io.github.grahduarte.entidades.contrato;

import io.github.grahduarte.entidades.entidade.Entidade;

import java.sql.Date;
import java.time.LocalDate;

public class Contrato extends Entidade {

    //<editor-fold desc="Atributos" defaultstate="collapsed">
    private long idCliente;
    private String redacao;
    private Date ultimaAtualizacao;
    //</editor-fold>

    //<editor-fold desc="Construtores" defaultstate="collapsed">

    public Contrato() {
    }

    public Contrato(long idCliente, String redacao, Date ultimaAtualizacao) {
        this.idCliente = idCliente;
        this.redacao = redacao;
        this.ultimaAtualizacao = ultimaAtualizacao;
    }
    //</editor-fold>

    //<editor-fold desc="Getters e Setters" defaultstate="collapsed">

    public long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(long idCliente) {
        this.idCliente = idCliente;
    }
    public String getRedacao() {
        return redacao;
    }

    public void setRedacao(String redacao) {
        this.redacao = redacao;
    }

    public Date getUltimaAtualizacao() {
        return ultimaAtualizacao;
    }

    public void setUltimaAtualizacao(Date ultimaAtualizacao) {
        this.ultimaAtualizacao = ultimaAtualizacao;
    }

    //</editor-fold>

    //<editor-fold desc="toString" defaultstate="collapsed">

    @Override
    public String toString() {
        return "Contrato{" +
                "idCliente=" + idCliente +
                ", redacao='" + redacao + '\'' +
                ", ultimaAtualizacao=" + ultimaAtualizacao +
                '}';
    }


    //</editor-fold>
}
