/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.saofilipe.gestaodocumental.domain;

import java.util.Objects;

/**
 *
 * @author mfernando
 */
public class Protocolo {
    private Long id;
    private String nomeProtocolo;
    private String tipoProtocolo;
    private String descricaoProtocolo;

    public Protocolo() {
    }

    public Protocolo(Long id, String nomeProtocolo, String tipoProtocolo, String descricaoProtocolo) {
        this.id = id;
        this.nomeProtocolo = nomeProtocolo;
        this.tipoProtocolo = tipoProtocolo;
        this.descricaoProtocolo = descricaoProtocolo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeProtocolo() {
        return nomeProtocolo;
    }

    public void setNomeProtocolo(String nomeProtocolo) {
        this.nomeProtocolo = nomeProtocolo;
    }

    public String getTipoProtocolo() {
        return tipoProtocolo;
    }

    public void setTipoProtocolo(String tipoProtocolo) {
        this.tipoProtocolo = tipoProtocolo;
    }

    public String getDescricaoProtocolo() {
        return descricaoProtocolo;
    }

    public void setDescricaoProtocolo(String descricaoProtocolo) {
        this.descricaoProtocolo = descricaoProtocolo;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.id);
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
        final Protocolo other = (Protocolo) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Protocolo{" + "id=" + id + ", nomeProtocolo=" + nomeProtocolo + ", tipoProtocolo=" + tipoProtocolo + ", descricaoProtocolo=" + descricaoProtocolo + '}';
    }
    
    
}
