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
public class PrazoRetencao {
    private Long id;
    private Date prazoRetencao;
    private String justificativa;
    private String politicaArmazenamento;
    private String politicaDescarte;
    private String responsavelCumprimento;
    private String statusPrazo;
    private Date dataCriacao;
    private Date historicoAlteracao;

    public PrazoRetencao() {
    }

    public PrazoRetencao(Long id, Date prazoRetencao, String justificativa, String politicaArmazenamento, String politicaDescarte, String responsavelCumprimento, String statusPrazo, Date dataCriacao, Date historicoAlteracao) {
        this.id = id;
        this.prazoRetencao = prazoRetencao;
        this.justificativa = justificativa;
        this.politicaArmazenamento = politicaArmazenamento;
        this.politicaDescarte = politicaDescarte;
        this.responsavelCumprimento = responsavelCumprimento;
        this.statusPrazo = statusPrazo;
        this.dataCriacao = dataCriacao;
        this.historicoAlteracao = historicoAlteracao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getPrazoRetencao() {
        return prazoRetencao;
    }

    public void setPrazoRetencao(Date prazoRetencao) {
        this.prazoRetencao = prazoRetencao;
    }

    public String getJustificativa() {
        return justificativa;
    }

    public void setJustificativa(String justificativa) {
        this.justificativa = justificativa;
    }

    public String getPoliticaArmazenamento() {
        return politicaArmazenamento;
    }

    public void setPoliticaArmazenamento(String politicaArmazenamento) {
        this.politicaArmazenamento = politicaArmazenamento;
    }

    public String getPoliticaDescarte() {
        return politicaDescarte;
    }

    public void setPoliticaDescarte(String politicaDescarte) {
        this.politicaDescarte = politicaDescarte;
    }

    public String getResponsavelCumprimento() {
        return responsavelCumprimento;
    }

    public void setResponsavelCumprimento(String responsavelCumprimento) {
        this.responsavelCumprimento = responsavelCumprimento;
    }

    public String getStatusPrazo() {
        return statusPrazo;
    }

    public void setStatusPrazo(String statusPrazo) {
        this.statusPrazo = statusPrazo;
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
        hash = 67 * hash + Objects.hashCode(this.id);
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
        final PrazoRetencao other = (PrazoRetencao) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "PrazoRetencao{" + "id=" + id + ", prazoRetencao=" + prazoRetencao + ", justificativa=" + justificativa + ", politicaArmazenamento=" + politicaArmazenamento + ", politicaDescarte=" + politicaDescarte + ", responsavelCumprimento=" + responsavelCumprimento + ", statusPrazo=" + statusPrazo + ", dataCriacao=" + dataCriacao + ", historicoAlteracao=" + historicoAlteracao + '}';
    }
    
    
}
