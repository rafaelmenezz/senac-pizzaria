
package br.com.pizzaria.dao;

import br.com.pizzaria.entidade.Usuario;
import br.com.pizzaria.util.GeradorUtil;
import java.util.List;
import org.hibernate.Session;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rafael.menezes
 */
public class UsuarioDaoImplTest {

    private Usuario usuario;
    private UsuarioDao usuarioDao;
    private Session sessao;

    public UsuarioDaoImplTest() {
        usuarioDao = new UsuarioDaoImpl();
    }

    // @Test
    public void testSalvar() {
        System.out.println("Teste Salvar");

        usuario = new Usuario(GeradorUtil.gerarNome(),
                GeradorUtil.gerarEmail(), GeradorUtil.gerarCelular(), GeradorUtil.gerarLogin(), GeradorUtil.gerarSenha(8));

        sessao = HibernateUtil.abrirConexao();
        usuarioDao.salvarOuAlterar(usuario, sessao);
        sessao.close();

        assertNotNull(usuario.getId());
    }

    //@Test
    public void testAlterar() {
        System.out.println("Teste Alterar");
        buscarUsuarioBD();
        
        usuario.setNome("Alterado" + GeradorUtil.gerarNome());
        
        sessao = HibernateUtil.abrirConexao();
        usuarioDao.salvarOuAlterar(usuario, sessao);
        sessao.close();
        
        sessao = HibernateUtil.abrirConexao();
        Usuario alterado = usuarioDao.pesquisarPorId(usuario.getId(), sessao);
        sessao.close();
        
        assertEquals(usuario.getNome(), alterado.getNome());
    }
    
   // @Test
    public void testExcluir(){
        System.out.println("Teste Excluir");
        
        buscarUsuarioBD();
        
        sessao = HibernateUtil.abrirConexao();
        usuarioDao.excluir(usuario, sessao);
        
        sessao = HibernateUtil.abrirConexao();
        
        Usuario excluido = usuarioDao.pesquisarPorId(usuario.getId(), sessao);
        sessao.close();
        
        assertNull(excluido);
        
    }
    
    @Test
    public void testLogin(){
        System.out.println("Teste login");
        
        buscarUsuarioBD();
        
        sessao = HibernateUtil.abrirConexao();
        Usuario logado = usuarioDao.login(usuario.getLogin(), usuario.getSenha(), sessao);
        sessao.close();
        
        assertNotNull(logado);
    }

    public Usuario buscarUsuarioBD() {
        sessao = HibernateUtil.abrirConexao();
        List<Usuario> usuarios = sessao.createQuery("FROM Usuario u", Usuario.class).getResultList();
        sessao.close();

        if (usuarios.isEmpty()) {
            testSalvar();
        } else {
            int indice = (int) (Math.random() * usuarios.size());
            usuario = usuarios.get(indice);
        }
        return usuario;
    }
}
