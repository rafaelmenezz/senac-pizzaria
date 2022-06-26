/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pizzaria.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author rafael.menezes
 */
@Entity
@Table(name = "fornecedor")
@PrimaryKeyJoinColumn(name = "id_pessoa")
public class Fornecedor extends Pessoa {

    @Column(nullable = false)
    private String inscricao_estadual;

    @Column(nullable = false, unique = true)
    private String cnpj;

    public Fornecedor() {
    }

    public Fornecedor(String nome, String email, String telefone, String inscricao_estadual, String cnpj) {
        super(nome, email, telefone);
        this.inscricao_estadual = inscricao_estadual;
        this.cnpj = cnpj;
    }

    public String getInscricao_estadual() {
        return inscricao_estadual;
    }

    public void setInscricao_estadual(String inscricao_estadual) {
        this.inscricao_estadual = inscricao_estadual;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

}
