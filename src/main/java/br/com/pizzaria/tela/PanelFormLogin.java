package br.com.pizzaria.tela;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

import br.com.pizzaria.controller.UsuarioController;

public class PanelFormLogin extends JPanel {

    private JFrame pai;
    private UsuarioController uController;

    private JLabel lbLogin;
    private JLabel lbSenha;
    private JLabel labelDetalhes;

    private JTextField tfLogin;
    private JPasswordField tfSenha;

    private JButton btnCancelar, btnEntrar;

    public PanelFormLogin(JFrame pai) {
        this.pai = pai;
        uController = new UsuarioController();
        initComponents();
    }

    private void initComponents() {
        setLayout(null);
        setBounds(5, 5, 485, 300);
        setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));

        adicionarLabelDetalhes();
        adicionarLabelsForm();
        adicionarBotoes();
    }

    private void adicionarLabelDetalhes() {
        labelDetalhes = new JLabel();
        labelDetalhes.setFont(new java.awt.Font("Myanmar Text", 1, 24));
        labelDetalhes.setText("Sistema Pizzaria");
        labelDetalhes.setBounds(10, 10, 485, 50);

        add(labelDetalhes);
    }

    private void adicionarLabelsForm() {
        lbLogin = new JLabel();
        lbLogin.setText("login:");
        lbSenha = new JLabel();
        lbSenha.setText("senha:");

        tfLogin = new JTextField();
        tfSenha = new JPasswordField();

        lbLogin.setHorizontalAlignment(SwingConstants.RIGHT);
        lbLogin.setBounds(10, 80, 100, 30);

        lbSenha.setHorizontalAlignment(SwingConstants.RIGHT);
        lbSenha.setBounds(10, 140, 100, 30);

        tfLogin.setBounds(120, 80, 350, 30);
        tfSenha.setBounds(120, 140, 350, 30);

        add(lbLogin);
        add(lbSenha);
        add(tfLogin);
        add(tfSenha);
    }

    private void adicionarBotoes() {

        btnCancelar = new JButton();
        btnEntrar = new JButton();

        btnCancelar.setText("Cancelar");
        btnEntrar.setText("Entrar");

        btnCancelar.setBounds(120, 190, 160, 30);
        btnEntrar.setBounds(310, 190, 160, 30);

        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });

        add(btnCancelar);
        add(btnEntrar);
    }

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {
        if (uController.singIn(tfLogin.getText().trim(), new String(tfSenha.getPassword()).trim()) != null) {
            new FramePrincipal().setVisible(true);
            pai.dispose();
        }else{
            JOptionPane.showMessageDialog(null,   "Login e/ou senha incorretos!", "", JOptionPane.ERROR_MESSAGE);
        }

    }
}
