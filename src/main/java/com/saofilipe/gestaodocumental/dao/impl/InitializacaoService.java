/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.saofilipe.gestaodocumental.dao.impl;

import com.saofilipe.gestaodocumental.domain.AcessoPermissao;
import com.saofilipe.gestaodocumental.domain.CategoriaDocumento;
import com.saofilipe.gestaodocumental.domain.Documento;
import com.saofilipe.gestaodocumental.domain.Gerenciamento;
import com.saofilipe.gestaodocumental.domain.PrazoRetencao;
import com.saofilipe.gestaodocumental.domain.Protocolo;
import com.saofilipe.gestaodocumental.domain.Utilizador;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 *
 * @author mfernando
 */
public class InitializacaoService {

    /*public InitializacaoService() {
        List<AcessoPermissao> acessos = createAcessoPermissaoData();
        List<CategoriaDocumento> categorias = createCategoriaDocumentoData();
        List<Documento> documentos = createDocumentoData();
        List<Gerenciamento> gerenciamentos = createGerenciamentoData();
        List<PrazoRetencao> prazos = createPrazoRetencaoData();
        List<Protocolo> protocolos = createProtocoloData();
        List<Utilizador> utilizadores = createUtilizadorData();
    }*/
    private static List<AcessoPermissao> createAcessoPermissaoData() {
        List<AcessoPermissao> acessos = new ArrayList<>();

        acessos.add(new AcessoPermissao(1L, new Date(), "Admin", "Leitura", "192.168.1.1", new Date()));
        acessos.add(new AcessoPermissao(2L, new Date(), "Usuário", "Escrita", "192.168.1.2", new Date()));
        acessos.add(new AcessoPermissao(3L, new Date(), "Gerente", "Execução", "192.168.1.3", new Date()));

        return acessos;
    }

    private static List<CategoriaDocumento> createCategoriaDocumentoData() {
        List<CategoriaDocumento> categorias = new ArrayList<>();

        categorias.add(new CategoriaDocumento(1L, "Financeiro", "Documento Fiscal", "Privado", "João", "Ativo", new Date(), new Date()));
        categorias.add(new CategoriaDocumento(2L, "Recursos Humanos", "Contrato de Trabalho", "Público", "Maria", "Inativo", new Date(), new Date()));
        categorias.add(new CategoriaDocumento(3L, "Projetos", "Plano de Projeto", "Restrito", "Carlos", "Ativo", new Date(), new Date()));

        return categorias;
    }

    private static List<Documento> createDocumentoData() {
        List<Documento> documentos = new ArrayList<>();

        documentos.add(new Documento(1L, "Invoice", "Fatura", new Date(), "Fatura de serviços prestados"));
        documentos.add(new Documento(2L, "Contract", "Contrato", new Date(), "Contrato de fornecimento"));
        documentos.add(new Documento(3L, "ProjectPlan", "Plano de Projeto", new Date(), "Plano detalhado do projeto"));

        return documentos;
    }

    private static List<Gerenciamento> createGerenciamentoData() {
        List<Gerenciamento> gerenciamentos = new ArrayList<>();

        gerenciamentos.add(new Gerenciamento(1L, new Date(), "Aprovação de Despesas", "Ana", "Aprovado", "192.168.2.1", 101L, 201L));
        gerenciamentos.add(new Gerenciamento(2L, new Date(), "Revisão de Relatório", "José", "Em análise", "192.168.2.2", 102L, 202L));
        gerenciamentos.add(new Gerenciamento(3L, new Date(), "Implementação de Sistema", "Roberto", "Concluído", "192.168.2.3", 103L, 203L));

        return gerenciamentos;
    }

    private static List<PrazoRetencao> createPrazoRetencaoData() {
        List<PrazoRetencao> prazos = new ArrayList<>();

        prazos.add(new PrazoRetencao(1L, new Date(), "Arquivamento permanente", "Manter indefinidamente", "Descartar após 10 anos", "Alice", "Ativo", new Date(), new Date()));
        prazos.add(new PrazoRetencao(2L, new Date(), "Backup semanal", "Manter por 1 ano", "Descartar após 1 ano", "Bob", "Inativo", new Date(), new Date()));
        prazos.add(new PrazoRetencao(3L, new Date(), "Documentação de Projeto", "Manter por 5 anos", "Descartar após 5 anos", "Eva", "Ativo", new Date(), new Date()));

        return prazos;
    }

    private static List<Protocolo> createProtocoloData() {
        List<Protocolo> protocolos = new ArrayList<>();

        protocolos.add(new Protocolo(1L, "SMTP", "Email", "Protocolo para envio de emails"));
        protocolos.add(new Protocolo(2L, "HTTP", "Web", "Protocolo para transferência de hipertexto"));
        protocolos.add(new Protocolo(3L, "FTP", "Rede", "Protocolo de transferência de arquivos"));

        return protocolos;
    }

    private static List<Utilizador> createUtilizadorData() {
        List<Utilizador> utilizadores = new ArrayList<>();

        utilizadores.add(new Utilizador(1L, "Alice", "Administrador", "pass123", "alice@example.com", new Date(), "123-456-7890"));
        utilizadores.add(new Utilizador(2L, "Bob", "Analista", "pass456", "bob@example.com", new Date(), "987-654-3210"));
        utilizadores.add(new Utilizador(3L, "Charlie", "Desenvolvedor", "pass789", "charlie@example.com", new Date(), "555-555-5555"));

        return utilizadores;
    }
}
