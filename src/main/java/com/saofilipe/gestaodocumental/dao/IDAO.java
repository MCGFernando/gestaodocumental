/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.saofilipe.gestaodocumental.dao;

import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author mfernando
 */
public interface IDAO <T>{
    T salvar(T objeto);
    T atualizar(T objeto);
    void excluir(Long id);
    T obterPorId(Long id);
    List<T> listarTodos();
    T deResultsetParaObject(ResultSet resultSet);
}
