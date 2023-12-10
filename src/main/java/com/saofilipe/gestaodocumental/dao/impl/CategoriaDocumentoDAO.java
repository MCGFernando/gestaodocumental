/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.saofilipe.gestaodocumental.dao.impl;

import com.saofilipe.gestaodocumental.conexao.Conexao;
import com.saofilipe.gestaodocumental.dao.IDAO;
import com.saofilipe.gestaodocumental.domain.CategoriaDocumento;
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
public class CategoriaDocumentoDAO implements IDAO<CategoriaDocumento> {

    private Connection conexao;

    public CategoriaDocumentoDAO(Conexao conexao) throws SQLException {
        this.conexao = conexao.getConexao();
    }

    @Override
    public CategoriaDocumento salvar(CategoriaDocumento objeto) {
        String sql = "INSERT INTO sua_tabela (nomeCategoria, atributosAssociados, politicasAcesso, responsavelCategoria, statusCategoria, dataCriacao, historicoAlteracao) " +
               "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, objeto.getNomeCategoria());
            stmt.setString(2, objeto.getAtributosAssociados());
            stmt.setString(3, objeto.getPoliticasAcesso());
            stmt.setString(4, objeto.getResponsavelCategoria());
            stmt.setString(5, objeto.getStatusCategoria());
            stmt.setDate(6, new java.sql.Date(objeto.getDataCriacao().getTime()));
            stmt.setDate(7, new java.sql.Date(objeto.getHistoricoAlteracao().getTime()));

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
    public CategoriaDocumento atualizar(CategoriaDocumento objeto) {
        String sql = "UPDATE sua_tabela SET nomeCategoria=?, atributosAssociados=?, politicasAcesso=?, responsavelCategoria=?, statusCategoria=?, dataCriacao=?, historicoAlteracao=? "
                + "WHERE id=?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, objeto.getNomeCategoria());
            stmt.setString(2, objeto.getAtributosAssociados());
            stmt.setString(3, objeto.getPoliticasAcesso());
            stmt.setString(4, objeto.getResponsavelCategoria());
            stmt.setString(5, objeto.getStatusCategoria());
            stmt.setDate(6, new java.sql.Date(objeto.getDataCriacao().getTime()));
            stmt.setDate(7, new java.sql.Date(objeto.getHistoricoAlteracao().getTime()));
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
    public CategoriaDocumento obterPorId(Long id) {
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
    public List<CategoriaDocumento> listarTodos() {
        List<CategoriaDocumento> listaCategoriaDocumento = new ArrayList<>();
        String sql = "SELECT * FROM sua_tabela";
        try (PreparedStatement stmt = conexao.prepareStatement(sql); ResultSet resultSet = stmt.executeQuery()) {
            while (resultSet.next()) {
                listaCategoriaDocumento.add(deResultsetParaObject(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Trate a exceção apropriadamente em um ambiente real
        }
        return listaCategoriaDocumento;
    }

    @Override
    public CategoriaDocumento deResultsetParaObject(ResultSet resultSet) {
        CategoriaDocumento categoriaDocumento = new CategoriaDocumento();
        try {
            categoriaDocumento.setId(resultSet.getLong("id"));
            categoriaDocumento.setNomeCategoria(resultSet.getString("nomeCategoria"));
            categoriaDocumento.setAtributosAssociados(resultSet.getString("atributosAssociados"));
            categoriaDocumento.setPoliticasAcesso(resultSet.getString("politicasAcesso"));
            categoriaDocumento.setResponsavelCategoria(resultSet.getString("responsavelCategoria"));
            categoriaDocumento.setStatusCategoria(resultSet.getString("statusCategoria"));
            categoriaDocumento.setDataCriacao(resultSet.getDate("dataCriacao"));
            categoriaDocumento.setHistoricoAlteracao(resultSet.getDate("historicoAlteracao"));

        } catch (SQLException ex) {
            Logger.getLogger(DocumentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return categoriaDocumento;
    }

}
