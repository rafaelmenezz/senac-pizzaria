/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pizzaria.dao;

import br.com.pizzaria.entidade.Pedido;
import static br.com.pizzaria.util.GeradorUtil.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.junit.Test;
import static org.junit.Assert.*;


public class PedidoDaoImplTest {

    private Pedido pedido;
    private PedidoDao pedidoDao;
    private Session sessao;

    public PedidoDaoImplTest() {
        pedidoDao = new PedidoDaoImpl();
    }

    @Test
    public void testSalvar() {
        System.out.println("salvar");
        ClienteDaoImplTest cdit = new ClienteDaoImplTest();
        
        pedido = new Pedido(5, new BigDecimal(gerarNumero(3)), new Date());
        pedido.setCliente(cdit.buscarClienteBd());
        sessao = HibernateUtil.abrirConexao();
        pedidoDao.salvarOuAlterar(pedido, sessao);
        sessao.close();
        assertNotNull(pedido.getId());
    }

    @Test
    public void testPesquisarPorId() {
        System.out.println("pesquisarPorId");
        buscarPedidoBD();

        sessao = HibernateUtil.abrirConexao();
        Pedido pesquisado = pedidoDao.pesquisarPorId(pedido.getId(), sessao);
        sessao.close();

        assertNotNull(pesquisado);

    }

    @Test
    public void testUpdate(){
        System.out.println("Alterar");

        buscarPedidoBD();

        pedido.setNumero(6);

        sessao = HibernateUtil.abrirConexao();
        pedidoDao.salvarOuAlterar(pedido, sessao);
        sessao.close();

        sessao = HibernateUtil.abrirConexao();
        Pedido alterado = pedidoDao.pesquisarPorId(pedido.getId(), sessao);
        sessao.close();

        assertEquals(pedido.getNumero(), alterado.getNumero());
    }

    @Test
    public void testPesquisarPorNumero() {
        System.out.println("pesquisarPorNumero");
        buscarPedidoBD();

        sessao = HibernateUtil.abrirConexao();
        List<Pedido> pesquisados = pedidoDao.pesquisarPorNumero(pedido.getNumero(), sessao);
        sessao.close();

        assertTrue(!pesquisados.isEmpty());
    }

    @Test
    public void testPesquisarPorValorMaiorIgual() {
        System.out.println("pesquisarPorValorMaiorIgual");
        buscarPedidoBD();

        sessao = HibernateUtil.abrirConexao();
        List<Pedido> pedidos = pedidoDao.pesquisarPorValorMaiorIgual(pedido.getValor_total(), sessao);
        sessao.close();

        assertTrue(!pedidos.isEmpty());

    }

    @Test
    public void textPesquisaPorNomeOuTelefone(){
        System.out.println("Pesquisa por nome ou telefone cliente");

        buscarPedidoBD();

        sessao = HibernateUtil.abrirConexao();
        List<Pedido> pedidos = pedidoDao.pesquisarPorNomeCliente(pedido.getCliente().getNome(), sessao);
        sessao.close();

        assertTrue(!pedidos.isEmpty());
    }

    public Pedido buscarPedidoBD(){

        sessao = HibernateUtil.abrirConexao();
        List<Pedido> pedidos = sessao.createQuery("FROM Pedido", Pedido.class).getResultList();
        sessao.close();

        if (pedidos.isEmpty()) {
            testSalvar();
        } else {
            int indice = (int) (Math.random() * pedidos.size());
            pedido = pedidos.get(indice);
        }

        return pedido;
    }

}
