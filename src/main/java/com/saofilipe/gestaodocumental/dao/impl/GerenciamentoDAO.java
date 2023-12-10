/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.saofilipe.gestaodocumental.dao.impl;

import com.saofilipe.gestaodocumental.conexao.Conexao;
import com.saofilipe.gestaodocumental.dao.IDAO;
import com.saofilipe.gestaodocumental.domain.Gerenciamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mfernando
 */
public class GerenciamentoDAO implements IDAO<Gerenciamento>{
private Connection conexao;

    public GerenciamentoDAO(Conexao conexao) throws SQLException {
        this.conexao = conexao.getConexao();
    }
    @Override
    public Gerenciamento salvar(Gerenciamento objeto) {
        String sql = "INSERT INTO sua_tabela (dataHora, descricaoGerenciamento, responsavelGerenciamento, resultadoAccao, ipOrigem, professoresIdProfessores, relatorioIdRelatorio) " +
               "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmt.setDate(1, new java.sql.Date(objeto.getDataHora().getTime()));
            stmt.setString(2, objeto.getDescricaoGerenciamento());
            stmt.setString(3, objeto.getResposavelGerenciamento());
            stmt.setString(4, objeto.getResultadoAccao());
            stmt.setString(5, objeto.getIpOrigem());
            stmt.setLong(6, objeto.getProfessoresIdProfessores());
            stmt.setLong(7, objeto.getRelatorioIdRelatorio());

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        objeto.setId(generatedKeys.getLong(1));
                    }
                }
            }

            return objeto;
        } catch (SQLException e) {
            e.printStackTrace(); // Trate a exceção apropriadamente em um ambiente real
            return null;
        }
    }

    @Override
    public Gerenciamento atualizar(Gerenciamento objeto) {
        String sql = "UPDATE sua_tabela SET dataHora=?, descricaoGerenciamento=?, responsavelGerenciamento=?, resultadoAccao=?, ipOrigem=?, professoresIdProfessores=?, relatorioIdRelatorio=? "
                + "WHERE id=?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setDate(1, new java.sql.Date(objeto.getDataHora().getTime()));
            stmt.setString(2, objeto.getDescricaoGerenciamento());
            stmt.setString(3, objeto.getResposavelGerenciamento());
            stmt.setString(4, objeto.getResultadoAccao());
            stmt.setString(5, objeto.getIpOrigem());
            stmt.setLong(6, objeto.getProfessoresIdProfessores());
            stmt.setLong(7, objeto.getRelatorioIdRelatorio());
            stmt.setLong(8, objeto.getId());

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                return objeto;
            } else {
                return null; // Documento não encontrado
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Trate a exceção apropriadamente em um ambiente real
            return null;
        }
    }

    @Override
    public void excluir(Long id) {
        String sql = "DELETE FROM sua_tabela WHERE id=?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Trate a exceção apropriadamente em um ambiente real
        }
    }

    @Override
    public Gerenciamento obterPorId(Long id) {
        String sql = "SELECT * FROM sua_tabela WHERE id=?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setLong(1, id);
            try (ResultSet resultSet = stmt.executeQuery()) {
                if (resultSet.next()) {
                    return deResultsetParaObject(resultSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Trate a exceção apropriadamente em um ambiente real
        }
        return null;
    }

    @Override
    public List<Gerenciamento> listarTodos() {
        List<Gerenciamento> listaGerenciamento = new ArrayList<>();
        String sql = "SELECT * FROM sua_tabela";
        try (PreparedStatement stmt = conexao.prepareStatement(sql); ResultSet resultSet = stmt.executeQuery()) {
            while (resultSet.next()) {
                listaGerenciamento.add(deResultsetParaObject(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Trate a exceção apropriadamente em um ambiente real
        }
        return listaGerenciamento;
    }

    @Override
    public Gerenciamento deResultsetParaObject(ResultSet resultSet) {
        Gerenciamento gerenciamento = new Gerenciamento();
        try {
            gerenciamento.setId(resultSet.getLong("id"));
        gerenciamento.setDataHora(resultSet.getTimestamp("dataHora"));
        gerenciamento.setDescricaoGerenciamento(resultSet.getString("descricaoGerenciamento"));
        gerenciamento.setResposavelGerenciamento(resultSet.getString("responsavelGerenciamento"));
        gerenciamento.setResultadoAccao(resultSet.getString("resultadoAccao"));
        gerenciamento.setIpOrigem(resultSet.getString("ipOrigem"));
        gerenciamento.setProfessoresIdProfessores(resultSet.getLong("professoresIdProfessores"));
        gerenciamento.setRelatorioIdRelatorio(resultSet.getLong("relatorioIdRelatorio"));

        } catch (SQLException ex) {
            Logger.getLogger(DocumentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return gerenciamento;
    }
    
}
