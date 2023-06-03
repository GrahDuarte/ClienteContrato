package io.github.grahduarte.dao.dao;

import io.github.grahduarte.dao.conectabd.ConectaBD;
import io.github.grahduarte.entidades.entidade.Entidade;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public abstract class Dao<E, K> implements IDao<E, K> {

    public static final String DB = "clientecontrato";
    @Override
    public K salvar(E e) {

        Long id = 0L;

        // TODO id==0 não distingue se uma pessoa física é nova ou se deve ser atualizada devido ao CPF sempre ser obrigatório
        if (((Entidade) e).getId() == 0) {
            // Inserir novo registro

            try (PreparedStatement preparedStatement
                         = ConectaBD
                    .getConexao()
                    .prepareStatement(
                            obterSentencaInsert(),
                            Statement.RETURN_GENERATED_KEYS)) {

                // montar a declaração sql com os dados (->?)
                montarDeclaracao(preparedStatement, e);
                System.out.println("SQL INSERT: " + preparedStatement);
                preparedStatement.executeUpdate();

                ResultSet resultSet = preparedStatement.getGeneratedKeys();

                if (resultSet.next()) {
                    id = resultSet.getLong(1);
                }

            } catch (Exception ex) {
                System.out.println(">> " + ex);
            }

        } else {
            // Atualizar registro existente
            try (PreparedStatement preparedStatement
                         = ConectaBD
                    .getConexao()
                    .prepareStatement(
                            obterSentencaUpdate())) {

                // montar a declaração sql com os dados (->?)
                montarDeclaracao(preparedStatement, e);
                System.out.println("SQL UPDATE: " + preparedStatement);
                preparedStatement.executeUpdate();

            } catch (Exception ex) {
                System.out.println(">> " + ex);
            }
        }

        System.out.println("ID: " + id);
        return (K) id;
    }

    /**
     * Localização de um objeto por Id no banco de dados, para se retornado para
     * a memória
     *
     * @param id id do objeto a ser buscado
     * @return se encontrado, objeto será retornado, caso contrário retorna null
     */
    public E localizarPorId(K id) {
        try (PreparedStatement preparedStatement
                     = ConectaBD
                .getConexao()
                .prepareStatement(
                        obterSentencaLocalizarPorId())) {
            preparedStatement.setLong(1, (Long) id);

            ResultSet rs = preparedStatement.executeQuery();
            System.out.println("SQL: " + preparedStatement);
            if (rs.next()) {
                return extrairObjeto(rs);
            }
        } catch (Exception ex) {
            System.out.println(">> " + ex);
        }
        return null;
    }

    public List<E> localizarTodos() {
        try (PreparedStatement preparedStatement
                     = ConectaBD
                .getConexao()
                .prepareStatement(
                        obterSentencaLocalizarTodos())) {
            ResultSet rs = preparedStatement.executeQuery();
            System.out.println("SQL: " + preparedStatement);
            if (rs.next()) {
                return extrairObjetos(rs);
            }
        } catch (Exception ex) {
            System.out.println(">> " + ex);
        }
        return null;
    }

    public void excluir(E e) {
        try (PreparedStatement preparedStatement
                     = ConectaBD
                .getConexao()
                .prepareStatement(
                        obterSentencaDelete())) {
            montarDeclaracaoDelete(preparedStatement, e);
            System.out.println("SQL: " + preparedStatement);
            preparedStatement.executeUpdate();
        } catch (Exception ex) {
            System.out.println(">> " + ex);
        }
    }

    /**
     * Sentença SQL específica para cada tipo de objeto a ser persistido no
     * banco de dados.
     *
     * @return Sentença SQL de inserção.
     */
    public abstract String obterSentencaInsert();

    /**
     * Monta a declaração SQL com os valores contidos no objeto recebido.
     *
     * @param pstmt Consulta a ser preparada.
     * @param e     Objeto com valores a serem embutidos na consulta.
     */
    public abstract String obterSentencaDelete();
    public abstract String obterSentencaUpdate();
    public abstract void montarDeclaracao(PreparedStatement pstmt, E e);
    public abstract void montarDeclaracaoDelete(PreparedStatement pstmt, E e);
    public abstract String obterSentencaLocalizarPorId();
    public abstract E extrairObjeto(ResultSet resultSet);
    public abstract String obterSentencaLocalizarTodos();
    public abstract List<E> extrairObjetos(ResultSet rs);
}
