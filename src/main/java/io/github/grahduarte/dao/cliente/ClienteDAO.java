package io.github.grahduarte.dao.cliente;

import io.github.grahduarte.dao.dao.Dao;
import io.github.grahduarte.entidades.cliente.Cliente;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO extends Dao<Cliente, Long> {
    @Override
    public String obterSentencaInsert() {
        return "INSERT INTO cliente (nome, cpf) VALUES (?, ?);";
    }

    @Override
    public String obterSentencaUpdate() {
        return "UPDATE cliente SET nome = ?, cpf = ? WHERE id = ?;";
    }

    @Override
    public String obterSentencaDelete() {
        return "DELETE FROM cliente WHERE id = ?;";
    }

    @Override
    public void montarDeclaracao(PreparedStatement pstmt, Cliente cliente) {
        try {
            pstmt.setString(1, cliente.getNome());
            pstmt.setLong(2, cliente.getCpf());
            if (cliente.getId() != 0) {
                pstmt.setLong(3, cliente.getId());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void montarDeclaracaoDelete(PreparedStatement pstmt, Cliente cliente) {
        try {
            if (cliente.getId() != 0) {
                pstmt.setLong(1, cliente.getId());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String obterSentencaLocalizarPorId() {
        return "SELECT * FROM cliente WHERE id = ?;";
    }

    @Override
    public Cliente extrairObjeto(ResultSet resultSet) {
        Cliente cliente = new Cliente();
        try {
            cliente.setId(resultSet.getLong("id"));
            cliente.setNome(resultSet.getString("nome"));
            cliente.setCpf(resultSet.getLong("cpf"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cliente;
    }

    @Override
    public String obterSentencaLocalizarTodos() {
        return "SELECT * FROM cliente;";
    }

    @Override
    public List<Cliente> extrairObjetos(ResultSet rs) {
        ArrayList<Cliente> clientes = new ArrayList<>();
        try {
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getLong("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getLong("cpf"));
                clientes.add(cliente);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return clientes;
    }
}
