/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pizzaria.dao;

import br.com.pizzaria.entidade.Usuario;
import java.io.Serializable;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author rafael.menezes
 */
public class UsuarioDaoImpl extends BaseDaoImpl<Usuario, Long> implements UsuarioDao, Serializable{

    @Override
    public Usuario pesquisarPorId(Long id, Session sessao) throws HibernateException {
        return sessao.find(Usuario.class, id);
    }

    @Override
    public Usuario login(String login, String senha, Session sessao) throws HibernateException {
        Query<Usuario> consulta = sessao.createQuery("From Usuario u WHERE u.login = :login and u.senha = :senha", Usuario.class);
        consulta.setParameter("login", login);
        consulta.setParameter("senha", senha);
        return consulta.getSingleResult();
    }

    @Override
    public Integer quantidadeUsuarios(Session session) throws HibernateException {
        return Integer.parseInt(session.createQuery("SELECT COUNT(*) FROM Usuario").getSingleResult().toString());
    }

    @Override
    public Boolean verificaLogin(String login,  Session session) throws HibernateException {
        Query<Long> consulta = session.createQuery("SELECT COUNT(*) FROM Usuario u WHERE u.login = :login", Long.class);
        consulta.setParameter("login", login);
        return Integer.parseInt(consulta.getSingleResult().toString()) > 0;
    }
    
}
