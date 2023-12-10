/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.saofilipe.gestaodocumental.dao.impl;

import com.saofilipe.gestaodocumental.conexao.Conexao;
import com.saofilipe.gestaodocumental.dao.IDAO;
import com.saofilipe.gestaodocumental.domain.Utilizador;
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
public class UtilizadorDAO implements IDAO<Utilizador>{
private Connection conexao;

    public UtilizadorDAO(Conexao conexao) throws SQLException {
        this.conexao = conexao.getConexao();
    }
    @Override
    public Utilizador salvar(Utilizador objeto) {
        String sql = "INSERT INTO sua_tabela (nomeUtilizador, funcaoUtilizador, senhaUtilizador, emailUtilizador, historicoActividadeUtilizador, contactoUtilizador) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, objeto.getNomeUtilizador());
            stmt.setString(2, objeto.getFuncaoUtilizador());
            stmt.setString(3, objeto.getSenhaUtilizador());
            stmt.setString(4, objeto.getEmailUtilizador());
            stmt.setDate(5, new java.sql.Date(objeto.getHistoricoActividadeUtilizador().getTime()));
            stmt.setString(6, objeto.getContactoUtilizador());
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
    public Utilizador atualizar(Utilizador objeto) {
        String sql = "UPDATE sua_tabela SET nomeUtilizador=?, funcaoUtilizador=?, senhaUtilizador=?, emailUtilizador=?, historicoActividadeUtilizador=?, contactoUtilizador=? WHERE id=?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, objeto.getNomeUtilizador());
            stmt.setString(2, objeto.getFuncaoUtilizador());
            stmt.setString(3, objeto.getSenhaUtilizador());
            stmt.setString(4, objeto.getEmailUtilizador());
            stmt.setDate(5, new java.sql.Date(objeto.getHistoricoActividadeUtilizador().getTime()));
            stmt.setString(6, objeto.getContactoUtilizador());
            stmt.setLong(7, objeto.getId());

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
    public Utilizador obterPorId(Long id) {
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
    public List<Utilizador> listarTodos() {
        List<Utilizador> listaUtilizadores = new ArrayList<>();
        String sql = "SELECT * FROM sua_tabela";
        try (PreparedStatement stmt = conexao.prepareStatement(sql); ResultSet resultSet = stmt.executeQuery()) {
            while (resultSet.next()) {
                listaUtilizadores.add(deResultsetParaObject(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Trate a exceção apropriadamente em um ambiente real
        }
        return listaUtilizadores;
    }

    @Override
    public Utilizador deResultsetParaObject(ResultSet resultSet) {
        Utilizador utilizador = new Utilizador();
        try {
            utilizador.setId(resultSet.getLong("id"));
        utilizador.setNomeUtilizador(resultSet.getString("nomeUtilizador"));
        utilizador.setFuncaoUtilizador(resultSet.getString("funcaoUtilizador"));
        utilizador.setSenhaUtilizador(resultSet.getString("senhaUtilizador"));
        utilizador.setEmailUtilizador(resultSet.getString("emailUtilizador"));
        utilizador.setHistoricoActividadeUtilizador(resultSet.getDate("historicoActividadeUtilizador"));
        utilizador.setContactoUtilizador(resultSet.getString("contactoUtilizador"));

        } catch (SQLException ex) {
            Logger.getLogger(DocumentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return utilizador;
    }
    
}
