/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pizzaria.dao;

import br.com.pizzaria.entidade.Fornecedor;
import java.io.Serializable;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author rafael.menezes
 */
public class FornecedorDaoImpl extends BaseDaoImpl<Fornecedor, Long> implements FornecedorDao, Serializable{

    @Override
    public Fornecedor pesquisarPorId(Long id, Session sessao) throws HibernateException {
        return sessao.find(Fornecedor.class, id);
    }

    @Override
    public Fornecedor buscarFornecedorCnpj(String cnpj, Session sessao) throws HibernateException {
        Query<Fornecedor> consulta = sessao.createQuery("FROM Fornecedor f WHERE f.cnpj = :cnpj", Fornecedor.class);
        consulta.setParameter("cnpj", cnpj);
        return consulta.getSingleResult();
    }
    
}
