/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.saofilipe.gestaodocumental.dao.impl;

import com.saofilipe.gestaodocumental.conexao.Conexao;
import com.saofilipe.gestaodocumental.dao.IDAO;
import com.saofilipe.gestaodocumental.domain.AcessoPermissao;
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
public class AcessoPermissaoDAO implements IDAO<AcessoPermissao> {

    private Connection conexao;

    public AcessoPermissaoDAO(Conexao conexao) throws SQLException {
        this.conexao = conexao.getConexao();
    }

    @Override
    public AcessoPermissao salvar(AcessoPermissao objeto) {
        String sql = "INSERT INTO sua_tabela (dataHoraAcesso, nivelDeAcesso, tipoAccao, ipOrigem, historicoAcesso) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmt.setTimestamp(1, new java.sql.Timestamp(objeto.getDataHoraAcesso().getTime()));
            stmt.setString(2, objeto.getNivelDeAcesso());
            stmt.setString(3, objeto.getTipoAccao());
            stmt.setString(4, objeto.getIpOrigem());
            stmt.setTimestamp(5, (objeto.getHistoricoAcesso() != null)
                    ? new java.sql.Timestamp(objeto.getHistoricoAcesso().getTime()) : null);

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
    public AcessoPermissao atualizar(AcessoPermissao objeto) {
        String sql = "UPDATE sua_tabela SET dataHoraAcesso=?, nivelDeAcesso=?, tipoAccao=?, ipOrigem=?, historicoAcesso=? WHERE id=?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setTimestamp(1, new java.sql.Timestamp(objeto.getDataHoraAcesso().getTime()));
            stmt.setString(2, objeto.getNivelDeAcesso());
            stmt.setString(3, objeto.getTipoAccao());
            stmt.setString(4, objeto.getIpOrigem());
            stmt.setTimestamp(5, (objeto.getHistoricoAcesso() != null)
                    ? new java.sql.Timestamp(objeto.getHistoricoAcesso().getTime()) : null);
            stmt.setLong(6, objeto.getId());

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
    public AcessoPermissao obterPorId(Long id) {
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
    public List<AcessoPermissao> listarTodos() {
        List<AcessoPermissao> listaAcessoPermissao = new ArrayList<>();
        String sql = "SELECT * FROM sua_tabela";
        try (PreparedStatement stmt = conexao.prepareStatement(sql); ResultSet resultSet = stmt.executeQuery()) {
            while (resultSet.next()) {
                listaAcessoPermissao.add(deResultsetParaObject(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Trate a exceção apropriadamente em um ambiente real
        }
        return listaAcessoPermissao;
    }

    @Override
    public AcessoPermissao deResultsetParaObject(ResultSet resultSet) {
        AcessoPermissao acessoPermissao = new AcessoPermissao();
        try {
            acessoPermissao.setId(resultSet.getLong("id"));
            acessoPermissao.setDataHoraAcesso(resultSet.getTimestamp("dataHoraAcesso"));
            acessoPermissao.setNivelDeAcesso(resultSet.getString("nivelDeAcesso"));
            acessoPermissao.setTipoAccao(resultSet.getString("tipoAccao"));
            acessoPermissao.setIpOrigem(resultSet.getString("ipOrigem"));
            acessoPermissao.setHistoricoAcesso(resultSet.getTimestamp("historicoAcesso"));

        } catch (SQLException ex) {
            Logger.getLogger(DocumentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return acessoPermissao;
    }

}
