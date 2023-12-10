/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.saofilipe.gestaodocumental.dao.impl;

import com.saofilipe.gestaodocumental.conexao.Conexao;
import com.saofilipe.gestaodocumental.dao.IDAO;
import com.saofilipe.gestaodocumental.domain.Documento;
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
public class DocumentoDAO implements IDAO<Documento> {

    private Connection conexao;

    public DocumentoDAO(Conexao conexao) throws SQLException {
        this.conexao = conexao.getConexao();
    }

    @Override
    public Documento salvar(Documento objeto) {
        String sql = "INSERT INTO documentos (nomeDocumento, tipoDocumento, dataCriacaoDocumento, descricaoDocumento) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, objeto.getNomeDocumento());
            stmt.setString(2, objeto.getTipoDocumento());
            stmt.setDate(3, new java.sql.Date(objeto.getDataCriacaoDocumento().getTime()));
            stmt.setString(4, objeto.getDescricaoDocumento());

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
    public Documento atualizar(Documento objeto) {
        String sql = "UPDATE documentos SET nomeDocumento=?, tipoDocumento=?, dataCriacaoDocumento=?, descricaoDocumento=? WHERE id=?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, objeto.getNomeDocumento());
            stmt.setString(2, objeto.getTipoDocumento());
            stmt.setDate(3, new java.sql.Date(objeto.getDataCriacaoDocumento().getTime()));
            stmt.setString(4, objeto.getDescricaoDocumento());
            stmt.setLong(5, objeto.getId());

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
        String sql = "DELETE FROM documentos WHERE id=?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Trate a exceção apropriadamente em um ambiente real
        }
    }

    @Override
    public Documento obterPorId(Long id) {
        String sql = "SELECT * FROM documentos WHERE id=?";
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
    public List<Documento> listarTodos() {
        List<Documento> listaDocumentos = new ArrayList<>();
        String sql = "SELECT * FROM documentos";
        try (PreparedStatement stmt = conexao.prepareStatement(sql); ResultSet resultSet = stmt.executeQuery()) {
            while (resultSet.next()) {
                listaDocumentos.add(deResultsetParaObject(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Trate a exceção apropriadamente em um ambiente real
        }
        return listaDocumentos;
    }

    @Override
    public Documento deResultsetParaObject(ResultSet resultSet) {
        Documento documento = new Documento();
        try {
            documento.setId(resultSet.getLong("id"));
            documento.setNomeDocumento(resultSet.getString("nomeDocumento"));
            documento.setTipoDocumento(resultSet.getString("tipoDocumento"));
            documento.setDataCriacaoDocumento(resultSet.getDate("dataCriacaoDocumento"));
            documento.setDescricaoDocumento(resultSet.getString("descricaoDocumento"));
        } catch (SQLException ex) {
            Logger.getLogger(DocumentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return documento;
    }
}
