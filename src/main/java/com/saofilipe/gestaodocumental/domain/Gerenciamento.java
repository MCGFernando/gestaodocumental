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
public class Gerenciamento {
     private Long id;
    private Date dataHora;
    private String descricaoGerenciamento;
    private String resposavelGerenciamento;
    private String resultadoAccao;
    private String ipOrigem;
    private Long professoresIdProfessores;
    private Long relatorioIdRelatorio;

    public Gerenciamento() {
    }

    public Gerenciamento(Long id, Date dataHora, String descricaoGerenciamento, String resposavelGerenciamento, String resultadoAccao, String ipOrigem, Long professoresIdProfessores, Long relatorioIdRelatorio) {
        this.id = id;
        this.dataHora = dataHora;
        this.descricaoGerenciamento = descricaoGerenciamento;
        this.resposavelGerenciamento = resposavelGerenciamento;
        this.resultadoAccao = resultadoAccao;
        this.ipOrigem = ipOrigem;
        this.professoresIdProfessores = professoresIdProfessores;
        this.relatorioIdRelatorio = relatorioIdRelatorio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public String getDescricaoGerenciamento() {
        return descricaoGerenciamento;
    }

    public void setDescricaoGerenciamento(String descricaoGerenciamento) {
        this.descricaoGerenciamento = descricaoGerenciamento;
    }

    public String getResposavelGerenciamento() {
        return resposavelGerenciamento;
    }

    public void setResposavelGerenciamento(String resposavelGerenciamento) {
        this.resposavelGerenciamento = resposavelGerenciamento;
    }

    public String getResultadoAccao() {
        return resultadoAccao;
    }

    public void setResultadoAccao(String resultadoAccao) {
        this.resultadoAccao = resultadoAccao;
    }

    public String getIpOrigem() {
        return ipOrigem;
    }

    public void setIpOrigem(String ipOrigem) {
        this.ipOrigem = ipOrigem;
    }

    public Long getProfessoresIdProfessores() {
        return professoresIdProfessores;
    }

    public void setProfessoresIdProfessores(Long professoresIdProfessores) {
        this.professoresIdProfessores = professoresIdProfessores;
    }

    public Long getRelatorioIdRelatorio() {
        return relatorioIdRelatorio;
    }

    public void setRelatorioIdRelatorio(Long relatorioIdRelatorio) {
        this.relatorioIdRelatorio = relatorioIdRelatorio;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.id);
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
        final Gerenciamento other = (Gerenciamento) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Gerenciamento{" + "id=" + id + ", dataHora=" + dataHora + ", descricaoGerenciamento=" + descricaoGerenciamento + ", resposavelGerenciamento=" + resposavelGerenciamento + ", resultadoAccao=" + resultadoAccao + ", ipOrigem=" + ipOrigem + ", professoresIdProfessores=" + professoresIdProfessores + ", relatorioIdRelatorio=" + relatorioIdRelatorio + '}';
    }
    
}
