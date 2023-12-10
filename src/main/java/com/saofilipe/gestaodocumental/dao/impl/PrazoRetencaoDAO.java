/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.saofilipe.gestaodocumental.dao.impl;

import com.saofilipe.gestaodocumental.conexao.Conexao;
import com.saofilipe.gestaodocumental.dao.IDAO;
import com.saofilipe.gestaodocumental.domain.PrazoRetencao;
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
public class PrazoRetencaoDAO implements IDAO<PrazoRetencao>{
private Connection conexao;

    public PrazoRetencaoDAO(Conexao conexao) throws SQLException {
        this.conexao = conexao.getConexao();
    }
    @Override
    public PrazoRetencao salvar(PrazoRetencao objeto) {
        String sql = "INSERT INTO sua_tabela (prazoRetencao, justificativa, politicaArmazenamento, politicaDescarte, responsavelCumprimento, statusPrazo, dataCriacao, historicoAlteracao) " +
               "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmt.setDate(1, new java.sql.Date(objeto.getPrazoRetencao().getTime()));
            stmt.setString(2, objeto.getJustificativa());
            stmt.setString(3, objeto.getPoliticaArmazenamento());
            stmt.setString(4, objeto.getPoliticaDescarte());
            stmt.setString(5, objeto.getResponsavelCumprimento());
            stmt.setString(6, objeto.getStatusPrazo());
            stmt.setDate(7, new java.sql.Date(objeto.getDataCriacao().getTime()));
            stmt.setDate(8, new java.sql.Date(objeto.getHistoricoAlteracao().getTime()));
            
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
    public PrazoRetencao atualizar(PrazoRetencao objeto) {
        String sql = "UPDATE sua_tabela SET prazoRetencao=?, justificativa=?, politicaArmazenamento=?, politicaDescarte=?, responsavelCumprimento=?, statusPrazo=?, dataCriacao=?, historicoAlteracao=? "
                + "WHERE id=?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setDate(1, new java.sql.Date(objeto.getPrazoRetencao().getTime()));
            stmt.setString(2, objeto.getJustificativa());
            stmt.setString(3, objeto.getPoliticaArmazenamento());
            stmt.setString(4, objeto.getPoliticaDescarte());
            stmt.setString(5, objeto.getResponsavelCumprimento());
            stmt.setString(6, objeto.getStatusPrazo());
            stmt.setDate(7, new java.sql.Date(objeto.getDataCriacao().getTime()));
            stmt.setDate(8, new java.sql.Date(objeto.getHistoricoAlteracao().getTime()));
            stmt.setLong(9, objeto.getId());

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
    public PrazoRetencao obterPorId(Long id) {
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
    public List<PrazoRetencao> listarTodos() {
        List<PrazoRetencao> listaPrazoRetencao = new ArrayList<>();
        String sql = "SELECT * FROM sua_tabela";
        try (PreparedStatement stmt = conexao.prepareStatement(sql); ResultSet resultSet = stmt.executeQuery()) {
            while (resultSet.next()) {
                listaPrazoRetencao.add(deResultsetParaObject(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Trate a exceção apropriadamente em um ambiente real
        }
        return listaPrazoRetencao;
    }

    @Override
    public PrazoRetencao deResultsetParaObject(ResultSet resultSet) {
        PrazoRetencao prazoRetencao = new PrazoRetencao();
        try {
            prazoRetencao.setId(resultSet.getLong("id"));
        prazoRetencao.setPrazoRetencao(resultSet.getTimestamp("prazoRetencao"));
        prazoRetencao.setJustificativa(resultSet.getString("justificativa"));
        prazoRetencao.setPoliticaArmazenamento(resultSet.getString("politicaArmazenamento"));
        prazoRetencao.setPoliticaDescarte(resultSet.getString("politicaDescarte"));
        prazoRetencao.setResponsavelCumprimento(resultSet.getString("responsavelCumprimento"));
        prazoRetencao.setStatusPrazo(resultSet.getString("statusPrazo"));
        prazoRetencao.setDataCriacao(resultSet.getDate("dataCriacao"));
        prazoRetencao.setHistoricoAlteracao(resultSet.getDate("historicoAlteracao"));

        } catch (SQLException ex) {
            Logger.getLogger(DocumentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return prazoRetencao;
    }
    
}
