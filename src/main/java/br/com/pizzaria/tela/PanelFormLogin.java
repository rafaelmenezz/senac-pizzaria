package br.com.pizzaria.tela;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class PanelFormLogin extends JPanel{

    private JFrame pai;

    private JLabel labelLogin;
    private JLabel labelSenha;
    private JLabel labelDetalhes;

    private JTextField jtfLogin;
    private JPasswordField jpSenha;

    private JButton btnCancelar, btnEntrar;


    public PanelFormLogin(JFrame pai){
        this.pai = pai;

        initComponents();
    }

    private void initComponents(){
        setLayout(null);
        setBounds(5, 5, 485, 350);
        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        adicionarLabelDetalhes();
        adicionarLabelsForm();
        adicionarBotoes();
    }

    private void adicionarLabelDetalhes(){
        labelDetalhes = new JLabel();
        labelDetalhes.setFont(new java.awt.Font("Myanmar Text", 1, 24));
        labelDetalhes.setText("Sistema Pizzaria");
        labelDetalhes.setBounds(10, 10, 485, 50);

        add(labelDetalhes);
    }

    private void adicionarLabelsForm(){
        labelLogin = new JLabel();
        labelLogin.setText("login:");
        labelSenha = new JLabel();
        labelSenha.setText("senha:");

        jtfLogin = new JTextField();
        jpSenha = new JPasswordField();


        labelLogin.setFont(new java.awt.Font("Tahoma", 1, 20));
        labelLogin.setHorizontalAlignment(SwingConstants.RIGHT);  
        labelLogin.setBounds(10, 80, 100, 50);

        labelSenha.setFont(new java.awt.Font("Tahoma", 1, 20));
        labelSenha.setHorizontalAlignment(SwingConstants.RIGHT);  
        labelSenha.setBounds(10, 140, 100, 50);


        jtfLogin.setBounds(120, 80, 350, 50);
        jpSenha.setBounds(120, 140, 350, 50);

        add(labelLogin);
        add(labelSenha);
        add(jtfLogin);
        add(jpSenha);
    }

    private void adicionarBotoes(){

        btnCancelar = new JButton();
        btnEntrar = new JButton();

        btnCancelar.setText("Cancelar");
        btnEntrar.setText("Entrar");

        btnCancelar.setBounds(120, 220, 160, 50);
        btnEntrar.setBounds(310, 220, 160, 50);

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
    
    

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarCepActionPerformed
        System.exit(0);
    }
    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarCepActionPerformed
        new FramePrincipal().setVisible(true);
        pai.dispose();
       
    }
}
