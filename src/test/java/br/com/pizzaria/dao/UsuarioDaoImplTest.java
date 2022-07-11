
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
    private Session session;

    public UsuarioDaoImplTest() {
        usuarioDao = new UsuarioDaoImpl();
    }

     @Test
    public void testSalvar() {
        System.out.println("Teste Salvar");

        usuario = new Usuario(GeradorUtil.gerarNome(),
                GeradorUtil.gerarEmail(), GeradorUtil.gerarCelular(), GeradorUtil.gerarLogin(), GeradorUtil.gerarSenha(8));

        session = HibernateUtil.abrirConexao();
        usuarioDao.salvarOuAlterar(usuario, session);
        session.close();

        assertNotNull(usuario.getId());
    }

    @Test
    public void testAlterar() {
        System.out.println("Teste Alterar");
        buscarUsuarioBD();
        
        usuario.setNome("Alterado" + GeradorUtil.gerarNome());
        
        session = HibernateUtil.abrirConexao();
        usuarioDao.salvarOuAlterar(usuario, session);
        session.close();
        
        session = HibernateUtil.abrirConexao();
        Usuario alterado = usuarioDao.pesquisarPorId(usuario.getId(), session);
        session.close();
        
        assertEquals(usuario.getNome(), alterado.getNome());
    }
    
    @Test
    public void testExcluir(){
        System.out.println("Teste Excluir");
        
        buscarUsuarioBD();
        
        session = HibernateUtil.abrirConexao();
        usuarioDao.excluir(usuario, session);
        
        session = HibernateUtil.abrirConexao();
        
        Usuario excluido = usuarioDao.pesquisarPorId(usuario.getId(), session);
        session.close();
        
        assertNull(excluido);
        
    }
    
    @Test
    public void testLogin(){
        System.out.println("Teste login");
        
        buscarUsuarioBD();
        
        session = HibernateUtil.abrirConexao();
        Usuario logado = usuarioDao.login(usuario.getLogin(), usuario.getSenha(), session);
        session.close();
        
        assertNotNull(logado);
    }

    @Test
    public void testQuantidadeUsuario(){
        buscarUsuarioBD();

        session = HibernateUtil.abrirConexao();
        Integer qtd = usuarioDao.quantidadeUsuarios(session);
        session.close();

        assertTrue(qtd > 0);
    }

    @Test
    public void testVerificaLogin(){
        System.out.println("Teste Verificar login");
        buscarUsuarioBD();

        session = HibernateUtil.abrirConexao();
        Boolean existeLogin = usuarioDao.verificaLogin(usuario.getLogin(), session);
        session.close();

        assertTrue(existeLogin);
    }

    public Usuario buscarUsuarioBD() {
        session = HibernateUtil.abrirConexao();
        List<Usuario> usuarios = session.createQuery("FROM Usuario u", Usuario.class).getResultList();
        session.close();

        if (usuarios.isEmpty()) {
            testSalvar();
        } else {
            int indice = (int) (Math.random() * usuarios.size());
            usuario = usuarios.get(indice);
        }
        return usuario;
    }
}
