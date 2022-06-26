/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pizzaria.dao;

import br.com.pizzaria.entidade.Usuario;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author rafael.menezes
 */
public interface UsuarioDao extends BaseDao<Usuario, Long>{
    
    Usuario login(String login, String senha, Session sessao) throws HibernateException;
    
}
