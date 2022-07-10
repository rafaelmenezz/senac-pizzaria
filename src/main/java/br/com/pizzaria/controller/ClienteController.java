package br.com.pizzaria.controller;

import org.hibernate.Session;

import br.com.pizzaria.dao.ClienteDao;
import br.com.pizzaria.dao.ClienteDaoImpl;
import br.com.pizzaria.dao.HibernateUtil;
import br.com.pizzaria.entidade.Cliente;
import br.com.pizzaria.model.ModeloTabelaCliente;

public class ClienteController {

    private ClienteDao cliDao;
    private Session session;
    private ModeloTabelaCliente mtc;

    public ClienteController(){
        cliDao = new ClienteDaoImpl();
        mtc = new ModeloTabelaCliente();
    }

    public ModeloTabelaCliente getModeloTabela(){
        return mtc;
    }

    public void salvarCliente(Cliente cliente){
        session = HibernateUtil.abrirConexao();
        cliDao.salvarOuAlterar(cliente, session);
        session.close();
    }
    public void excluirCliente(Cliente cliente){
        session = HibernateUtil.abrirConexao();
        cliDao.excluir(cliente, session);
        session.close();
    }
    public void pesquisarClientePorNome(String nome){

        session = HibernateUtil.abrirConexao();
        mtc.atualizarDadosTabela(cliDao.pesquisarPorNome(nome, session));
        session.close();

    }

    public Cliente buscarPorTelefone(String telefone){
        session = HibernateUtil.abrirConexao();
        Cliente cli = cliDao.pesquisarPorTelefone(telefone, session);
        session.close();
        return cli;

    }
    
}
