/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.saofilipe.gestaodocumental.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author mfernando
 */
public class Documento {
    private Long id;
    private String nomeDocumento;
    private String tipoDocumento;
    private Date dataCriacaoDocumento;
    private String descricaoDocumento;
    private List<String> referencias = new ArrayList<>();

    public Documento() {
    }

    public Documento(Long id, String nomeDocumento, String tipoDocumento, Date dataCriacaoDocumento, String descricaoDocumento) {
        this.id = id;
        this.nomeDocumento = nomeDocumento;
        this.tipoDocumento = tipoDocumento;
        this.dataCriacaoDocumento = dataCriacaoDocumento;
        this.descricaoDocumento = descricaoDocumento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeDocumento() {
        return nomeDocumento;
    }

    public void setNomeDocumento(String nomeDocumento) {
        this.nomeDocumento = nomeDocumento;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public Date getDataCriacaoDocumento() {
        return dataCriacaoDocumento;
    }

    public void setDataCriacaoDocumento(Date dataCriacaoDocumento) {
        this.dataCriacaoDocumento = dataCriacaoDocumento;
    }

    public String getDescricaoDocumento() {
        return descricaoDocumento;
    }

    public void setDescricaoDocumento(String descricaoDocumento) {
        this.descricaoDocumento = descricaoDocumento;
    }

    public List<String> getReferencias() {
        return referencias;
    }

    public void setReferencias(List<String> referencias) {
        this.referencias = referencias;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final Documento other = (Documento) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Documento{" + "id=" + id + ", nomeDocumento=" + nomeDocumento + ", tipoDocumento=" + tipoDocumento + ", dataCriacaoDocumento=" + dataCriacaoDocumento + ", descricaoDocumento=" + descricaoDocumento + ", referencias=" + referencias + '}';
    }
    
    
}
