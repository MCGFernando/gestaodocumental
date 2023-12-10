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
public class AcessoPermissao {
    private Long id;
    private Date dataHoraAcesso;
    private String nivelDeAcesso;
    private String tipoAccao;
    private String ipOrigem;
    private Date historicoAcesso;

    public AcessoPermissao() {
    }

    public AcessoPermissao(Long id, Date dataHoraAcesso, String nivelDeAcesso, String tipoAccao, String ipOrigem, Date historicoAcesso) {
        this.id = id;
        this.dataHoraAcesso = dataHoraAcesso;
        this.nivelDeAcesso = nivelDeAcesso;
        this.tipoAccao = tipoAccao;
        this.ipOrigem = ipOrigem;
        this.historicoAcesso = historicoAcesso;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataHoraAcesso() {
        return dataHoraAcesso;
    }

    public void setDataHoraAcesso(Date dataHoraAcesso) {
        this.dataHoraAcesso = dataHoraAcesso;
    }

    public String getNivelDeAcesso() {
        return nivelDeAcesso;
    }

    public void setNivelDeAcesso(String nivelDeAcesso) {
        this.nivelDeAcesso = nivelDeAcesso;
    }

    public String getTipoAccao() {
        return tipoAccao;
    }

    public void setTipoAccao(String tipoAccao) {
        this.tipoAccao = tipoAccao;
    }

    public String getIpOrigem() {
        return ipOrigem;
    }

    public void setIpOrigem(String ipOrigem) {
        this.ipOrigem = ipOrigem;
    }

    public Date getHistoricoAcesso() {
        return historicoAcesso;
    }

    public void setHistoricoAcesso(Date historicoAcesso) {
        this.historicoAcesso = historicoAcesso;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.id);
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
        final AcessoPermissao other = (AcessoPermissao) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "AcessoPermissao{" + "id=" + id + ", dataHoraAcesso=" + dataHoraAcesso + ", nivelDeAcesso=" + nivelDeAcesso + ", tipoAccao=" + tipoAccao + ", ipOrigem=" + ipOrigem + ", historicoAcesso=" + historicoAcesso + '}';
    }
    
    
}
