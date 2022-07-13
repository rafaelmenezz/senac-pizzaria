package br.com.pizzaria.tela;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

import br.com.pizzaria.controller.UsuarioController;
import br.com.pizzaria.entidade.Usuario;

public class FrameNovoUsuario extends JFrame {

    private JPanel pnlFormulario;
    private Usuario usuario;

    private JLabel lbLogin, lbSenha, lbNome, lbEmail, lbTelefone;
    private JTextField tfLogin, tfNome, tfEmail;
    private JFormattedTextField tfTelefone;
    private JPasswordField tfSenha;
    private JButton btnSalvar, btnCancelar;

    private UsuarioController uController;

    public FrameNovoUsuario() {
        uController = new UsuarioController();
        initComponents();
        eventos();
    }

    public void initComponents() {

        setSize(600, 340); // define o tamanho do Frame
        setLayout(null); // Método que permite manipular as posições dos componentes em tela
        setLocationRelativeTo(null); // método que centraliza a aplicação no centro da tela
        setResizable(false);
        setTitle("Cadastro de Usuário");

        pnlFormulario = new JPanel();
        pnlFormulario.setLayout(null);
        pnlFormulario.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        pnlFormulario.setBounds(5, 5, 590, 290);

        lbNome = new JLabel("Nome: ", SwingConstants.RIGHT);
        lbEmail = new JLabel("Email: ", SwingConstants.RIGHT);
        lbTelefone = new JLabel("Telefone: ", SwingConstants.RIGHT);
        lbLogin = new JLabel("Login: ", SwingConstants.RIGHT);
        lbSenha = new JLabel("Senha: ", SwingConstants.RIGHT);

        tfLogin = new JTextField();
        tfNome = new JTextField();
        tfEmail = new JTextField();
        tfSenha = new JPasswordField();

        tfTelefone = new JFormattedTextField();
        try {
            tfTelefone.setFormatterFactory(
                    new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        btnSalvar = new JButton("Salvar");
        btnCancelar = new JButton("Cancelar");

        lbNome.setBounds(10, 10, 70, 30);
        tfNome.setBounds(80, 10, 480, 30);

        lbEmail.setBounds(10, 55, 70, 30);
        tfEmail.setBounds(80, 55, 480, 30);

        lbTelefone.setBounds(10, 100, 70, 30);
        tfTelefone.setBounds(80, 100, 480, 30);

        lbLogin.setBounds(10, 145, 70, 30);
        tfLogin.setBounds(80, 145, 480, 30);

        lbSenha.setBounds(10, 190, 70, 30);
        tfSenha.setBounds(80, 190, 480, 30);

        btnCancelar.setBounds(350, 235, 100, 30);
        btnSalvar.setBounds(460, 235, 100, 30);

        tfSenha.setToolTipText("   No mínimo 6 caracter   ");

        initPanelFormulario();

    }

    private void initPanelFormulario() {

        pnlFormulario.add(lbNome);
        pnlFormulario.add(tfNome);
        pnlFormulario.add(lbEmail);
        pnlFormulario.add(tfEmail);
        pnlFormulario.add(lbTelefone);
        pnlFormulario.add(tfTelefone);
        pnlFormulario.add(lbLogin);
        pnlFormulario.add(tfLogin);
        pnlFormulario.add(lbSenha);
        pnlFormulario.add(tfSenha);
        pnlFormulario.add(btnSalvar);
        pnlFormulario.add(btnCancelar);

        add(pnlFormulario);
    }

    private boolean validarFormulario() {
        String nome = tfNome.getText().trim();
        if (verificarCampoMaior2(nome)) {
            JOptionPane.showMessageDialog(null,   "O nome tem que ter pelo menos 3 letras", "", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        String email = tfEmail.getText().trim();
        if (verificarEmail(email)) {
            JOptionPane.showMessageDialog(null,   "Digite um e-mail correto!", "", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        String telefone = tfTelefone.getText().trim();
        if (verificarTelefone(telefone)) {
            JOptionPane.showMessageDialog(null,   "Digite um telefone válido!", "", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        String login = tfLogin.getText().trim();
        if (login.length() < 5) {
            JOptionPane.showMessageDialog(null,   "Login deve no mínimo 5 caracter!", "", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (uController.verificaLogin(login)) {
            JOptionPane.showMessageDialog(null,   "Login já está sendo utilizado!", "", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        String senha = tfSenha.getPassword().toString();
        if (senha.length() < 6) {
            JOptionPane.showMessageDialog(null,   "Senha deve ter no mínimo 6 caracter!", "", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // esse return tem que ser a ultima linha do metodo
        return true;
    }

    private boolean verificarCampoMaior2(String campo) {
        return campo.length() < 3;
    }

    private boolean verificarEmail(String email) {
        return !email.contains("@") && !email.contains(".");
    }

    private boolean verificarTelefone(String telefone) {

        return telefone.length() < 13;
    }

    private void carregarUsuario() {

        usuario = new Usuario();
        usuario.setNome(tfNome.getText().trim());
        usuario.setEmail(tfEmail.getText().trim());
        usuario.setTelefone(tfTelefone.getText().trim());
        usuario.setLogin(tfLogin.getText().trim());
        usuario.setSenha(new String (tfSenha.getPassword()).trim());

    }

    private void eventos() {
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                System.exit(0);
            }
        });

        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (validarFormulario()) {
                    carregarUsuario();
                    uController.salvarUsuario(usuario);
                    new FrameLogin().setVisible(true);
                    dispose();
                }
            }
        });

    }
}
