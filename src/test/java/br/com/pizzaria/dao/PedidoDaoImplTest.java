/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pizzaria.dao;

import br.com.pizzaria.entidade.Pedido;
import static br.com.pizzaria.util.GeradorUtil.*;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.junit.Test;
import static org.junit.Assert.*;

public class PedidoDaoImplTest {

    private Pedido pedido;
    private PedidoDao pedidoDao;
    private Session session;

    public PedidoDaoImplTest() {
        pedidoDao = new PedidoDaoImpl();
    }

    @Test
    public void testSalvar() {
        System.out.println("salvar");
        ClienteDaoImplTest cdit = new ClienteDaoImplTest();

        session = HibernateUtil.abrirConexao();
        pedido = new Pedido(pedidoDao.pesquisarUltimoNumero(session) + 1, new BigDecimal(gerarNumero(3)), new Date());
        session.close();
        pedido.setCliente(cdit.buscarClienteBd());
        session = HibernateUtil.abrirConexao();
        pedidoDao.salvarOuAlterar(pedido, session);
        session.close();
        assertNotNull(pedido.getId());
    }

    @Test
    public void testPesquisarPorId() {
        System.out.println("pesquisarPorId");
        buscarPedidoBD();

        session = HibernateUtil.abrirConexao();
        Pedido pesquisado = pedidoDao.pesquisarPorId(pedido.getId(), session);
        session.close();

        assertNotNull(pesquisado);

    }

    @Test
    public void testUpdate() {
        System.out.println("Alterar");

        buscarPedidoBD();

        session = HibernateUtil.abrirConexao();
        pedido.setNumero(pedidoDao.pesquisarUltimoNumero(session) + 1);
        session.close();


        session = HibernateUtil.abrirConexao();
        pedidoDao.salvarOuAlterar(pedido, session);
        session.close();

        session = HibernateUtil.abrirConexao();
        Pedido alterado = pedidoDao.pesquisarPorId(pedido.getId(), session);
        session.close();

        assertEquals(pedido.getNumero(), alterado.getNumero());
    }

    @Test
    public void testPesquisarPorNumero() {
        System.out.println("pesquisarPorNumero");
        buscarPedidoBD();

        session = HibernateUtil.abrirConexao();
        List<Pedido> pesquisados = pedidoDao.pesquisarPorNumero(pedido.getNumero(), session);
        session.close();

        assertTrue(!pesquisados.isEmpty());
    }

    @Test
    public void testPesquisarPorValorMaiorIgual() {
        System.out.println("pesquisarPorValorMaiorIgual");
        buscarPedidoBD();

        session = HibernateUtil.abrirConexao();
        List<Pedido> pedidos = pedidoDao.pesquisarPorValorMaiorIgual(pedido.getValor_total(), session);
        session.close();

        assertTrue(!pedidos.isEmpty());

    }

    @Test
    public void testPesquisaPorNomeOuTelefone() {
        System.out.println("Pesquisa por nome ou telefone cliente");

        buscarPedidoBD();

        session = HibernateUtil.abrirConexao();
        List<Pedido> pedidos = pedidoDao.pesquisarPorNomeCliente(pedido.getCliente().getNome(), session);
        session.close();

        assertTrue(!pedidos.isEmpty());
    }

    @Test
    public void testPesquisarPorPeriodo() throws ParseException {

        buscarPedidoBD();
        Date date = new Date();
        SimpleDateFormat dtFormatado = new SimpleDateFormat("dd/MM/yyyy");

        session = HibernateUtil.abrirConexao();
        List<Pedido> pedidos = pedidoDao.pesquisarPorPeriodo("01/07/2022", dtFormatado.format(date), session);
        session.close();

        assertTrue(!pedidos.isEmpty());
    }

    @Test
    public void testPesquisarUltimoNumero(){
        
        testSalvar();
        session = HibernateUtil.abrirConexao();
        Integer ultimo = pedidoDao.pesquisarUltimoNumero(session);
        session.close();

        assertTrue(pedido.getNumero() == ultimo);
    }

    public Pedido buscarPedidoBD() {

        session = HibernateUtil.abrirConexao();
        List<Pedido> pedidos = session.createQuery("FROM Pedido", Pedido.class).getResultList();
        session.close();

        if (pedidos.isEmpty()) {
            testSalvar();
        } else {
            int indice = (int) (Math.random() * pedidos.size());
            pedido = pedidos.get(indice);
        }

        return pedido;
    }

}
