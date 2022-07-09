package br.com.pizzaria.controller;

import org.hibernate.Session;

import br.com.pizzaria.dao.HibernateUtil;
import br.com.pizzaria.dao.PedidoDao;
import br.com.pizzaria.dao.PedidoDaoImpl;
import br.com.pizzaria.model.ModeloTabelaPedido;

public class PedidoController {
    
    private PedidoDao pedidoDao;
    private Session session;
    private ModeloTabelaPedido mtPedido;

    public PedidoController(){
        pedidoDao = new PedidoDaoImpl();
        mtPedido = new ModeloTabelaPedido();
    }

    public ModeloTabelaPedido getModeloTabela(){
        return mtPedido;
    }

    public void pesquisarPedidoPorNomeCliente(String pesquisa){

        session = HibernateUtil.abrirConexao();
        mtPedido.listarPedidos(pedidoDao.pesquisarPorNomeCliente(pesquisa, session));
        session.close();
    }

    public void limparTabelaPedidos(){
        mtPedido.limparListaPedido();
    }


}
