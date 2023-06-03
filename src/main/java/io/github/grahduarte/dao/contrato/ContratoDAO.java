package io.github.grahduarte.dao.contrato;

import io.github.grahduarte.dao.dao.Dao;
import io.github.grahduarte.entidades.contrato.Contrato;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ContratoDAO extends Dao<Contrato, Long> {
    @Override
    public String obterSentencaInsert() {
        return "INSERT INTO contrato (cliente_id, redacao, ultima_atualizacao) VALUES (?, ?, ?);";
    }

    @Override
    public String obterSentencaUpdate() {
        return "UPDATE contrato SET ultima_atualizacao = ?, redacao = ? WHERE id = ?;";
    }

    @Override
    public String obterSentencaDelete() {
        return "DELETE FROM contrato WHERE id = ?;";
    }

    @Override
    public void montarDeclaracao(PreparedStatement pstmt, Contrato contrato) {
        try {
            pstmt.setLong(1, contrato.getIdCliente());
            pstmt.setString(2, contrato.getRedacao());
            pstmt.setDate(3, contrato.getUltimaAtualizacao());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void montarDeclaracaoDelete(PreparedStatement pstmt, Contrato contrato) {
        try{
            pstmt.setLong(1, contrato.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String obterSentencaLocalizarPorId() {
        return "SELECT * FROM contrato WHERE id = ?;";
    }

    @Override
    public Contrato extrairObjeto(ResultSet resultSet) {
        Contrato contrato = new Contrato();
        try {
            contrato.setId(resultSet.getLong("id"));
            contrato.setIdCliente(resultSet.getLong("cliente_id"));
            contrato.setRedacao(resultSet.getString("redacao"));
            contrato.setUltimaAtualizacao(resultSet.getDate("ultima_atualizacao"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return contrato;
    }

    @Override
    public String obterSentencaLocalizarTodos() {
        return "SELECT * FROM contrato;";
    }

    @Override
    public List<Contrato> extrairObjetos(ResultSet rs) {
        ArrayList<Contrato> contratos = new ArrayList<>();
        try {
            while (rs.next()) {
                Contrato contrato = new Contrato();
                contrato.setId(rs.getLong("id"));
                contrato.setIdCliente(rs.getLong("cliente_id"));
                contrato.setUltimaAtualizacao(rs.getDate("ultima_atualizacao"));
                contrato.setRedacao(rs.getString("redacao"));
                contratos.add(contrato);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return contratos;
    }
}
