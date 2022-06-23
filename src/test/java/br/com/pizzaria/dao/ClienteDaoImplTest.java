/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pizzaria.dao;

import br.com.pizzaria.entidade.Cliente;
import br.com.pizzaria.entidade.Endereco;
import br.com.pizzaria.entidade.Pessoa;
import static br.com.pizzaria.util.GeradorUtil.*;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author silvio.junior
 */
public class ClienteDaoImplTest {

    private Cliente cliente;
    private ClienteDao clienteDao;
    private Session sessao;

    public ClienteDaoImplTest() {
        clienteDao = new ClienteDaoImpl();
    }

    @Test
    public void testSalvar() {
        System.out.println("salvar");
        cliente = new Cliente(gerarNome(), gerarLogin() + "gmail.com",
                gerarTelefoneFixo(), true);

        List<Endereco> enderecos = new ArrayList<>();
        enderecos.add(gerarEndereco());
        enderecos.add(gerarEndereco());
        cliente.setEnderecos(enderecos);
        
        for (Endereco endereco : enderecos) {
            endereco.setPessoa(cliente);
        }

        sessao = HibernateUtil.abrirConexao();
        clienteDao.salvarOuAlterar(cliente, sessao);
        sessao.close();
        assertNotNull(cliente.getId());
    }

//    @Test
    public void testPesquisarPorId() {
        System.out.println("pesquisarPorId");
    }

//    @Test
    public void testPesquisarPorNome() {
        System.out.println("pesquisarPorNome");
    }

}
