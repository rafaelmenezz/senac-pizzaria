/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pizzaria.dao;

import br.com.pizzaria.entidade.Fornecedor;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author rafael.menezes
 */
public interface FornecedorDao extends BaseDao<Fornecedor, Long>{
    
    Fornecedor buscarFornecedorCnpj(String cnpj, Session sessao) throws HibernateException;
}
