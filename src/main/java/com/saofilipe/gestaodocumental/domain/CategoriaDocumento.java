/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.saofilipe.gestaodocumental.domain;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author mfernando
 */
public class CategoriaDocumento {
    private Long id;
    private String nomeCategoria;
    private String atributosAssociados;
    private String politicasAcesso;
    private String responsavelCategoria;
    private String statusCategoria;
    private Date dataCriacao;
    private Date historicoAlteracao;

    public CategoriaDocumento() {
    }

    public CategoriaDocumento(Long id, String nomeCategoria, String atributosAssociados, String politicasAcesso, String responsavelCategoria, String statusCategoria, Date dataCriacao, Date historicoAlteracao) {
        this.id = id;
        this.nomeCategoria = nomeCategoria;
        this.atributosAssociados = atributosAssociados;
        this.politicasAcesso = politicasAcesso;
        this.responsavelCategoria = responsavelCategoria;
        this.statusCategoria = statusCategoria;
        this.dataCriacao = dataCriacao;
        this.historicoAlteracao = historicoAlteracao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public String getAtributosAssociados() {
        return atributosAssociados;
    }

    public void setAtributosAssociados(String atributosAssociados) {
        this.atributosAssociados = atributosAssociados;
    }

    public String getPoliticasAcesso() {
        return politicasAcesso;
    }

    public void setPoliticasAcesso(String politicasAcesso) {
        this.politicasAcesso = politicasAcesso;
    }

    public String getResponsavelCategoria() {
        return responsavelCategoria;
    }

    public void setResponsavelCategoria(String responsavelCategoria) {
        this.responsavelCategoria = responsavelCategoria;
    }

    public String getStatusCategoria() {
        return statusCategoria;
    }

    public void setStatusCategoria(String statusCategoria) {
        this.statusCategoria = statusCategoria;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getHistoricoAlteracao() {
        return historicoAlteracao;
    }

    public void setHistoricoAlteracao(Date historicoAlteracao) {
        this.historicoAlteracao = historicoAlteracao;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CategoriaDocumento other = (CategoriaDocumento) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "CategoriaDocumento{" + "id=" + id + ", nomeCategoria=" + nomeCategoria + ", atributosAssociados=" + atributosAssociados + ", politicasAcesso=" + politicasAcesso + ", responsavelCategoria=" + responsavelCategoria + ", statusCategoria=" + statusCategoria + ", dataCriacao=" + dataCriacao + ", historicoAlteracao=" + historicoAlteracao + '}';
    }
    
    
    
}
