package br.com.pizzaria.controller;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;

import br.com.pizzaria.dao.ClienteDao;
import br.com.pizzaria.dao.ClienteDaoImpl;
import br.com.pizzaria.dao.HibernateUtil;
import br.com.pizzaria.entidade.Cliente;

public class ClienteController {

    private Cliente cliente;
    private ClienteDao cliDao;
    private Session session;

    public ClienteController(){
        cliDao = new ClienteDaoImpl();
    }

    public List<Cliente> pesquisarClientesPorNome(String nome){
        session = HibernateUtil.abrirConexao();
        List<Cliente> clientes = cliDao.pesquisarPorNome(nome, session);
        session.close();

        return clientes;
    }

    public void salvarCliente(Cliente cliente){
        session = HibernateUtil.abrirConexao();
        cliDao.salvarOuAlterar(cliente, session);
        session.close();
    }
    
}
