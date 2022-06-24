package br.com.pizzaria.tela;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import br.com.pizzaria.tela.principal.PanelAtendimento;

public class FramePrincipal extends JFrame {

    private JMenuBar mbMenu;
    private JMenu JMenuArquivo, jMenuAtendimento;
    private JMenuItem mSair, mNovoAtendimento;
    private JPanel panelPrincipal;

    public FramePrincipal() {
        addMenuBar();
        confPanelPrincipal();
        initComponents();
    }

    private void initComponents() {
        setSize(1360, 750); // define o tamanho do Frame
        setLayout(null); // Método que permite manipular as posições dos componentes em tela
        setLocationRelativeTo(null); // método que centraliza a aplicação no centro da tela
        setResizable(false);
        setTitle("Sistema Pizzaria - SENAC");

        
    }

    private void addMenuBar() {

        mbMenu = new JMenuBar();
        mbMenu.setBounds(0, 0, 1360, 30);

        JMenuArquivo = new JMenu();
        JMenuArquivo.setText("Arquivo");

        jMenuAtendimento = new JMenu();
        jMenuAtendimento.setText("Atendimento");

        mNovoAtendimento = new JMenuItem();
        mNovoAtendimento.setText("Novo");

        mSair = new JMenuItem();
        mSair.setText("Sair");

        jMenuAtendimento.add(mNovoAtendimento);
        JMenuArquivo.add(mSair);
        mbMenu.add(JMenuArquivo);
        mbMenu.add(jMenuAtendimento);

        mSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mSairActionPerformed(evt);
            }
        });

        mNovoAtendimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mNovoAtendimentoActionPerformed(evt);
            }
        });

        add(mbMenu);

    }

    private void confPanelPrincipal() {
        panelPrincipal = new JPanel();
        panelPrincipal.setLayout(null);
        panelPrincipal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelPrincipal.setBounds(5, 35, 1350, 670);
        add(panelPrincipal);
    }

    private void mSairActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btBuscarCepActionPerformed
        System.exit(0);
    }

    private void mNovoAtendimentoActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btBuscarCepActionPerformed
        panelPrincipal.setVisible(false);
        JPanel atendimento = new PanelAtendimento(panelPrincipal);
        panelPrincipal.add(atendimento);
        panelPrincipal.setVisible(true);

        add(panelPrincipal);
    }
}
