package br.com.pizzaria.controller;

import javax.swing.JOptionPane;

import org.hibernate.Session;

import br.com.pizzaria.dao.HibernateUtil;
import br.com.pizzaria.dao.UsuarioDao;
import br.com.pizzaria.dao.UsuarioDaoImpl;
import br.com.pizzaria.entidade.Usuario;

public class UsuarioController {

    private Session session;
    private UsuarioDao usuarioDao;

    public UsuarioController() {
        usuarioDao = new UsuarioDaoImpl();
    }

    public Boolean existiUsuario() {
        session = HibernateUtil.abrirConexao();
        Integer qtd = usuarioDao.quantidadeUsuarios(session);
        session.close();
        return qtd > 0 ? true : false;
    }

    public Boolean verificaLogin(String login) {
        session = HibernateUtil.abrirConexao();
        Boolean existe = usuarioDao.verificaLogin(login, session);
        session.close();

        return existe;
    }

    public void salvarUsuario(Usuario usuario) {
        try {
            session = HibernateUtil.abrirConexao();
            usuarioDao.salvarOuAlterar(usuario, session);
            session.close();
            JOptionPane.showMessageDialog(null, "Dados do usuário " + usuario.getNome() + " salvo com sucesso!", "", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Não foi possivel salvar usuário!", "", JOptionPane.ERROR_MESSAGE);
        }

    }

    public Usuario singIn(String login, String senha) {

        try {
            session = HibernateUtil.abrirConexao();
            Usuario user = usuarioDao.login(login, senha, session);
            session.close();
            return user;
        } catch (Exception e) {
          System.out.println(e.getMessage());
            return null;
        }

    }

}
