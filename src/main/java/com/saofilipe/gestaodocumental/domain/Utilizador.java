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
public class Utilizador {
    private Long id;
    private String nomeUtilizador;
    private String funcaoUtilizador;
    private String senhaUtilizador;
    private String emailUtilizador;
    private Date historicoActividadeUtilizador;
    private String contactoUtilizador;

    public Utilizador() {
    }

    public Utilizador(Long id, String nomeUtilizador, String funcaoUtilizador, String senhaUtilizador, String emailUtilizador, Date historicoActividadeUtilizador, String contactoUtilizador) {
        this.id = id;
        this.nomeUtilizador = nomeUtilizador;
        this.funcaoUtilizador = funcaoUtilizador;
        this.senhaUtilizador = senhaUtilizador;
        this.emailUtilizador = emailUtilizador;
        this.historicoActividadeUtilizador = historicoActividadeUtilizador;
        this.contactoUtilizador = contactoUtilizador;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeUtilizador() {
        return nomeUtilizador;
    }

    public void setNomeUtilizador(String nomeUtilizador) {
        this.nomeUtilizador = nomeUtilizador;
    }

    public String getFuncaoUtilizador() {
        return funcaoUtilizador;
    }

    public void setFuncaoUtilizador(String funcaoUtilizador) {
        this.funcaoUtilizador = funcaoUtilizador;
    }

    public String getSenhaUtilizador() {
        return senhaUtilizador;
    }

    public void setSenhaUtilizador(String senhaUtilizador) {
        this.senhaUtilizador = senhaUtilizador;
    }

    public String getEmailUtilizador() {
        return emailUtilizador;
    }

    public void setEmailUtilizador(String emailUtilizador) {
        this.emailUtilizador = emailUtilizador;
    }

    public Date getHistoricoActividadeUtilizador() {
        return historicoActividadeUtilizador;
    }

    public void setHistoricoActividadeUtilizador(Date historicoActividadeUtilizador) {
        this.historicoActividadeUtilizador = historicoActividadeUtilizador;
    }

    public String getContactoUtilizador() {
        return contactoUtilizador;
    }

    public void setContactoUtilizador(String contactoUtilizador) {
        this.contactoUtilizador = contactoUtilizador;
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
        final Utilizador other = (Utilizador) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Utilizador{" + "id=" + id + ", nomeUtilizador=" + nomeUtilizador + ", funcaoUtilizador=" + funcaoUtilizador + ", senhaUtilizador=" + senhaUtilizador + ", emailUtilizador=" + emailUtilizador + ", historicoActividadeUtilizador=" + historicoActividadeUtilizador + ", contactoUtilizador=" + contactoUtilizador + '}';
    }
    

}
