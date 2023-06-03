package io.github.grahduarte.entidades.entidade;

public abstract class Entidade {

    //<editor-fold desc="Atributos" defaultstate="collapsed">
    private long id;
    //</editor-fold>

    //<editor-fold desc="Construtores" defaultstate="collapsed">

    public Entidade() {
    }

    public Entidade(long id) {
        this.id = id;
    }

    //</editor-fold>

    //<editor-fold desc="Getters e Setters" defaultstate="collapsed">

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    //</editor-fold>

}
