package br.com.pizzaria.tela;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class FramePrincipal extends JFrame {

    private JMenuBar mbMenu;
    private JMenu JMenuArquivo, jMenuCliente, JMenuPedido;
    private JMenuItem mSair, mClientePesquisar, mPedidoPesquisar;
    private JPanel panelPrincipal;

    public FramePrincipal() {
        addMenuBar();
        confPanelPrincipal();
        initComponents();
    }

    private void initComponents() {
        setSize(880, 680); // define o tamanho do Frame
        setLayout(null); // Método que permite manipular as posições dos componentes em tela
        setLocationRelativeTo(null); // método que centraliza a aplicação no centro da tela
        setResizable(false);
        setTitle("Sistema Pizzaria - SENAC");
    }

    private void addMenuBar() {

        mbMenu = new JMenuBar();
        mbMenu.setBounds(0, 0, 880, 30);

        JMenuArquivo = new JMenu();
        JMenuArquivo.setText("Arquivo");

        jMenuCliente = new JMenu();
        jMenuCliente.setText("Cliente");

        JMenuPedido = new JMenu("Pedido");

        mClientePesquisar = new JMenuItem();
        mClientePesquisar.setText("Pesquisar");

        mSair = new JMenuItem();
        mSair.setText("Sair");

        mPedidoPesquisar = new JMenuItem("Pesquisar");

        jMenuCliente.add(mClientePesquisar);
        JMenuArquivo.add(mSair);
        JMenuPedido.add(mPedidoPesquisar);

        mbMenu.add(JMenuArquivo);
        mbMenu.add(jMenuCliente);
        mbMenu.add(JMenuPedido);

        mSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mSairActionPerformed(evt);
            }
        });

        mClientePesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mClientePesquisarActionPerformed(evt);
            }
        });
        mPedidoPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mPedidoPesquisarActionPerformed(evt);
            }
        });

        add(mbMenu);

    }

    private void confPanelPrincipal() {
        panelPrincipal = new JPanel();
        panelPrincipal.setLayout(null);
        panelPrincipal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelPrincipal.setBounds(5, 35, 870, 600);
        add(panelPrincipal);
    }

    private void mSairActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btBuscarCepActionPerformed
        System.exit(0);
    }

    private void mClientePesquisarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btBuscarCepActionPerformed
        panelPrincipal.setVisible(false);
        remove(panelPrincipal);
        JPanel atendimento = new PanelPesquisarCliente();
        panelPrincipal = atendimento;
        panelPrincipal.setVisible(true);

        add(panelPrincipal);
    }

    private void mPedidoPesquisarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btBuscarCepActionPerformed
        panelPrincipal.setVisible(false);
        remove(panelPrincipal);
        JPanel pedido = new PanelPequisarPedido();
        panelPrincipal = pedido;
        panelPrincipal.setVisible(true);

        add(panelPrincipal);
    }
}
