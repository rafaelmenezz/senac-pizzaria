package br.com.pizzaria.controller;

import javax.swing.JOptionPane;

import org.hibernate.Session;

import br.com.pizzaria.dao.HibernateUtil;
import br.com.pizzaria.dao.PedidoDao;
import br.com.pizzaria.dao.PedidoDaoImpl;
import br.com.pizzaria.entidade.Pedido;
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
        try {
            session = HibernateUtil.abrirConexao();
            mtPedido.listarPedidos(pedidoDao.pesquisarPorNomeCliente(pesquisa, session));
            session.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível pesquisar cliente!", "", JOptionPane.ERROR_MESSAGE);
            System.out.println(e.getMessage());
        }
        
    }

    public void pesquisarPeriodo(String dtInicio, String dtFim){
        try {
            session = HibernateUtil.abrirConexao();
            mtPedido.listarPedidos(pedidoDao.pesquisarPorPeriodo(dtInicio, dtFim, session));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "", JOptionPane.ERROR_MESSAGE);
        }
       
    }
    public Integer ultimoNumeroGravado(){
        session = HibernateUtil.abrirConexao();
        Integer numero = pedidoDao.pesquisarUltimoNumero(session);
        return  numero;
    }
    public void salvarPedido(Pedido pedido){
        try {
            session = HibernateUtil.abrirConexao();
            pedidoDao.salvarOuAlterar(pedido, session);
            session.close();
            JOptionPane.showMessageDialog(null, "Pedido salvo com sucesso.", "", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível salvar o pedido!", "", JOptionPane.ERROR_MESSAGE);
        }  
    }

    public void limparTabelaPedidos(){
        mtPedido.limparListaPedido();
    }


}
