package br.com.pizzaria.tela;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class FramePrincipal extends JFrame {

    private JMenuBar mbMenu;
    private JMenu JMenuArquivo, jMenuCliente, JMenuPedido;
    private JMenuItem mSair, mClientePesquisar, mNovoPedido, mPedidoPesquisarCliente, mPedidoPesquisarData, mPrincipal;
    private JPanel panelPrincipal;

    public FramePrincipal() {

        initComponents();
        confPanelPrincipal();

        initHome();
    }

    private void initComponents() {
        setSize(880, 680); // define o tamanho do Frame
        setLayout(null); // Método que permite manipular as posições dos componentes em tela
        setLocationRelativeTo(null); // método que centraliza a aplicação no centro da tela
        setResizable(false);
        setTitle("Sistema Pizzaria - SENAC");

        mbMenu = new JMenuBar();
        mbMenu.setBounds(0, 0, 880, 30);

        JMenuArquivo = new JMenu();
        JMenuArquivo.setText("Arquivo");

        mPrincipal = new JMenuItem("Principal");
        JMenuArquivo.add(mPrincipal);

        jMenuCliente = new JMenu();
        jMenuCliente.setText("Cliente");

        JMenuPedido = new JMenu("Pedido");

        mClientePesquisar = new JMenuItem();
        mClientePesquisar.setText("Pesquisar");

        mSair = new JMenuItem();
        mSair.setText("Sair");

        mNovoPedido = new JMenuItem("Novo");
        mPedidoPesquisarCliente = new JMenuItem("Pesquisar Cliente");
        mPedidoPesquisarData = new JMenuItem("Pesquisar Data");

        jMenuCliente.add(mClientePesquisar);
        JMenuArquivo.add(mSair);
        JMenuPedido.add(mNovoPedido);
        JMenuPedido.add(mPedidoPesquisarCliente);
        JMenuPedido.add(mPedidoPesquisarData);

        mbMenu.add(JMenuArquivo);
        mbMenu.add(jMenuCliente);
        mbMenu.add(JMenuPedido);

        add(mbMenu);

        eventos();
    }

    public JPanel getPanelPrincipal() {
        return this.panelPrincipal;
    }

    public void setPanelPrincipal(JPanel panelPrincipal) {
        this.panelPrincipal = panelPrincipal;
    }

    public FramePrincipal getFrame() {
        return this;
    }

    private void confPanelPrincipal() {
        panelPrincipal = new JPanel();
        panelPrincipal.setLayout(null);
        panelPrincipal.setBounds(5, 35, 870, 600);

        add(panelPrincipal);
    }

    private void eventos() {
        mPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                initHome();
            }
        });

        mSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                System.exit(0);
            }
        });

        mClientePesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                panelPrincipal.setVisible(false);
                remove(panelPrincipal);
                JPanel atendimento = new PanelPesquisarCliente();
                panelPrincipal = atendimento;
                panelPrincipal.setVisible(true);

                add(panelPrincipal);
            }
        });
        mNovoPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                panelPrincipal.setVisible(false);
                remove(panelPrincipal);
                JPanel novoPedido = new PanelNovoPedido();
                panelPrincipal = novoPedido;
                panelPrincipal.setVisible(true);

                add(panelPrincipal);
            }
        });
        mPedidoPesquisarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                panelPrincipal.setVisible(false);
                remove(panelPrincipal);
                JPanel pedido = new PanelPequisarPedido(false);
                panelPrincipal = pedido;
                panelPrincipal.setVisible(true);

                add(panelPrincipal);
            }
        });
        mPedidoPesquisarData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                panelPrincipal.setVisible(false);
                remove(panelPrincipal);
                JPanel pedido = new PanelPequisarPedido(true);
                panelPrincipal = pedido;
                panelPrincipal.setVisible(true);

                add(panelPrincipal);
            }
        });

    }

    private void initHome() {
        panelPrincipal.setVisible(false);
        remove(panelPrincipal);
        JPanel principal = new PanelPrincipal(getFrame());
        panelPrincipal = principal;
        panelPrincipal.setVisible(true);

        add(panelPrincipal);
    }

}
