/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.saofilipe.gestaodocumental.dao.impl;

import com.saofilipe.gestaodocumental.conexao.Conexao;
import com.saofilipe.gestaodocumental.dao.IDAO;
import com.saofilipe.gestaodocumental.domain.Protocolo;
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
public class ProtocoloDAO implements IDAO<Protocolo> {

    private Connection conexao;

    public ProtocoloDAO(Conexao conexao) throws SQLException {
        this.conexao = conexao.getConexao();
    }

    @Override
    public Protocolo salvar(Protocolo objeto) {
        String sql = "INSERT INTO sua_tabela (nomeProtocolo, tipoProtocolo, descricaoProtocolo) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, objeto.getNomeProtocolo());
            stmt.setString(2, objeto.getTipoProtocolo());
            stmt.setString(3, objeto.getDescricaoProtocolo());
            
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
    public Protocolo atualizar(Protocolo objeto) {
        String sql = "UPDATE sua_tabela SET nomeProtocolo=?, tipoProtocolo=?, descricaoProtocolo=? WHERE id=?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, objeto.getNomeProtocolo());
            stmt.setString(2, objeto.getTipoProtocolo());
            stmt.setString(3, objeto.getDescricaoProtocolo());
            stmt.setLong(4, objeto.getId());

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
    public Protocolo obterPorId(Long id) {
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
    public List<Protocolo> listarTodos() {
        List<Protocolo> listaProtocolos = new ArrayList<>();
        String sql = "SELECT * FROM sua_tabela";
        try (PreparedStatement stmt = conexao.prepareStatement(sql); ResultSet resultSet = stmt.executeQuery()) {
            while (resultSet.next()) {
                listaProtocolos.add(deResultsetParaObject(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Trate a exceção apropriadamente em um ambiente real
        }
        return listaProtocolos;
    }

    @Override
    public Protocolo deResultsetParaObject(ResultSet resultSet) {
        Protocolo protocolo = new Protocolo();
        try {
            protocolo.setId(resultSet.getLong("id"));
            protocolo.setNomeProtocolo(resultSet.getString("nomeProtocolo"));
            protocolo.setTipoProtocolo(resultSet.getString("tipoProtocolo"));
            protocolo.setDescricaoProtocolo(resultSet.getString("descricaoProtocolo"));

        } catch (SQLException ex) {
            Logger.getLogger(DocumentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return protocolo;
    }

}
