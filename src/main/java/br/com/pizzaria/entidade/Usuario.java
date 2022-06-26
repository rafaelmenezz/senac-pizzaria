/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pizzaria.entidade;

import javax.persistence.*;
/**
 *
 * @author rafael.menezes
 */
@Entity
@Table(name = "usuario")
@PrimaryKeyJoinColumn(name = "id_pessoa")
public class Usuario extends Pessoa{
    
    @Column(nullable = false)
    private String login;
     @Column(nullable = false)
    private String senha;

    public Usuario() {
    }

    public Usuario(String nome, String email, String telefone, String login, String senha) {
        super(nome, email, telefone);
        this.login = login;
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
     
     
}
