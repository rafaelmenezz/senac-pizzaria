/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pizzaria.dao;

import br.com.pizzaria.entidade.Fornecedor;
import br.com.pizzaria.util.GeradorUtil;
import java.util.List;
import org.hibernate.Session;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rafael.menezes
 */
public class FornecedorDaoImplTest {
    
    private Fornecedor fornecedor;
    private FornecedorDao fornecedorDao;
    private Session sessao;
    
    public FornecedorDaoImplTest() {
        fornecedorDao = new FornecedorDaoImpl();
    }

    @Test
    public void testSalvar() {
        System.out.println("Teste salvar");
        
        fornecedor = new Fornecedor(GeradorUtil.gerarNome(), 
                                    GeradorUtil.gerarEmail(), 
                                    GeradorUtil.gerarCelular(), 
                                    GeradorUtil.gerarNumero(8), 
                                    GeradorUtil.gerarCnpj());
       
        sessao = HibernateUtil.abrirConexao();
        fornecedorDao.salvarOuAlterar(fornecedor, sessao);
        sessao.close();
        
        assertNotNull(fornecedor.getId());
    }
    
   @Test
    public void testAlterar(){
        System.out.println("Teste salvar");
        
        buscarFornecedorBD();
        
        fornecedor.setInscricao_estadual("Alterado");
        
        sessao = HibernateUtil.abrirConexao();
        fornecedorDao.salvarOuAlterar(fornecedor, sessao);
        sessao.close();
        
        sessao = HibernateUtil.abrirConexao();
        Fornecedor alterado = fornecedorDao.pesquisarPorId(fornecedor.getId(), sessao);
        sessao.close();
        
        assertEquals(fornecedor.getInscricao_estadual(), alterado.getInscricao_estadual());
        
        
    }
    
    @Test
    public void testExcluir(){
        System.out.println("Teste Excluir");
        buscarFornecedorBD();
        
        sessao = HibernateUtil.abrirConexao();
        fornecedorDao.excluir(fornecedor, sessao);
        
        sessao = HibernateUtil.abrirConexao();
        Fornecedor excluido = fornecedorDao.pesquisarPorId(fornecedor.getId(), sessao);
        sessao.close();
        
        assertNull(excluido);
    }
    
    public Fornecedor buscarFornecedorBD(){
        sessao = HibernateUtil.abrirConexao();
        List<Fornecedor> fornecedores = sessao.createQuery("FROM Fornecedor f", Fornecedor.class).getResultList();
        sessao.close();
        
        if (fornecedores.isEmpty()) {
            testSalvar();
        } else {
            int indice = (int) (Math.random() * fornecedores.size());
            fornecedor = fornecedores.get(indice);
        }
        return fornecedor;
    }
    
}
