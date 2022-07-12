package br.com.pizzaria.tela;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

public class FramePrincipal extends JFrame {

    private JMenuBar mbMenu;
    private JMenu JMenuArquivo, jMenuCliente, JMenuPedido;
    private JMenuItem mSair, mClientePesquisar, mNovoPedido, mPedidoPesquisarCliente, mPedidoPesquisarData, mPrincipal;
    private JPanel panelPrincipal, clienteCard, pedidoCard, searchClienteCard, searchPedidoCard, searchForDatePedido;

    private JLabel lbImgCadCliente, lbImgCadPedido, lbImgPeqCliente, lbImgPeqPedido, lbImgSearchForDatePedido;

    public FramePrincipal() {
        
        initComponents();
        confPanelPrincipal();
        initCard();
    }

    private void initComponents() {
        setSize(880, 680); // define o tamanho do Frame
        setLayout(null); // Método que permite manipular as posições dos componentes em tela
        setLocationRelativeTo(null); // método que centraliza a aplicação no centro da tela
        setResizable(false);
        setTitle("Sistema Pizzaria - SENAC");

        mbMenu = new JMenuBar();
        mbMenu.setBounds(0, 0, 880, 30);

        clienteCard = new JPanel();
        clienteCard.setLayout(null);
        clienteCard.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        clienteCard.setBounds(30, 30, 120, 120);
        clienteCard.setToolTipText(" Adicionar Novo Cliente");

        searchClienteCard = new JPanel();
        searchClienteCard.setLayout(null);
        searchClienteCard.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        searchClienteCard.setBounds(160, 30, 120, 120);
        searchClienteCard.setToolTipText(" Pesquisar Cliente");
        
        pedidoCard = new JPanel();
        pedidoCard.setLayout(null);
        pedidoCard.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        pedidoCard.setBounds(30, 160, 120, 120);
        pedidoCard.setToolTipText(" Cadastrar Pedido ");

        searchPedidoCard = new JPanel();
        searchPedidoCard.setLayout(null);
        searchPedidoCard.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        searchPedidoCard.setBounds(160, 160, 120, 120);
        searchPedidoCard.setToolTipText(" Pesquisar pedido do cliente");

        searchForDatePedido = new JPanel();
        searchForDatePedido.setLayout(null);
        searchForDatePedido.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        searchForDatePedido.setBounds(290, 160, 120, 120);
        searchForDatePedido.setToolTipText(" Pesquisar pedido por período ");

        lbImgCadCliente = new JLabel();
        lbImgCadCliente.setBounds(15, 10, 100, 100);

        lbImgPeqCliente = new JLabel();
        lbImgPeqCliente.setBounds(15, 10, 100, 100);

        lbImgCadPedido = new JLabel();
        lbImgCadPedido.setBounds(15, 10, 100, 100);

        lbImgPeqPedido = new JLabel();
        lbImgPeqPedido.setBounds(15, 10, 100, 100);

        lbImgSearchForDatePedido = new JLabel();
        lbImgSearchForDatePedido.setBounds(15, 10, 100, 100);


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

        mPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mPrincipalActionPerformed(evt);
            }
        });

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
        mNovoPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mNovoPedidoActionPerformed(evt);
            }
        });
        mPedidoPesquisarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mPedidoPesquisarActionPerformed(evt);
            }
        });
        mPedidoPesquisarData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mPedidoPesquisarDataActionPerformed(evt);
            }
        });

        add(mbMenu);
        
       

    }

    private void initCard(){
     
        ImageIcon cadCliente = new ImageIcon(getClass().getResource("/META-INF.imagens/cad_cliente.png"));
        ImageIcon cadSearchCliente = new ImageIcon(getClass().getResource("/META-INF.imagens/search_cliente.png"));
        ImageIcon cadPedido = new ImageIcon(getClass().getResource("/META-INF.imagens/add_pedido.png"));
        ImageIcon searchPedido = new ImageIcon(getClass().getResource("/META-INF.imagens/search_pedido.png"));
        ImageIcon searchPedidoForDate = new ImageIcon(getClass().getResource("/META-INF.imagens/search_for_date.png"));

        lbImgCadCliente.setIcon(cadCliente);
        lbImgPeqCliente.setIcon(cadSearchCliente);
        lbImgCadPedido.setIcon(cadPedido);
        lbImgPeqPedido.setIcon(searchPedido);
        lbImgSearchForDatePedido.setIcon(searchPedidoForDate);


        searchClienteCard.add(lbImgPeqCliente);
        clienteCard.add(lbImgCadCliente);
        pedidoCard.add(lbImgCadPedido);
        searchPedidoCard.add(lbImgPeqPedido);
        searchForDatePedido.add(lbImgSearchForDatePedido);
    

       panelPrincipal.add(clienteCard);
       panelPrincipal.add(searchClienteCard);
       panelPrincipal.add(pedidoCard);
       panelPrincipal.add(searchPedidoCard);
       panelPrincipal.add(searchForDatePedido);
    }

    private void confPanelPrincipal() {
        panelPrincipal = new JPanel();
        panelPrincipal.setLayout(null);
        panelPrincipal.setBounds(5, 35, 870, 600);
       
        add(panelPrincipal);
    }

    private void mPrincipalActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btBuscarCepActionPerformed
        panelPrincipal.setVisible(false);
        remove(panelPrincipal);
        JPanel principal = new PanelPrincipal();
         panelPrincipal = principal;
        panelPrincipal.setVisible(true);

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

    private void mNovoPedidoActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btBuscarCepActionPerformed
        panelPrincipal.setVisible(false);
        remove(panelPrincipal);
        JPanel novoPedido = new PanelNovoPedido();
        panelPrincipal = novoPedido;
        panelPrincipal.setVisible(true);

        add(panelPrincipal);
    }

    private void mPedidoPesquisarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btBuscarCepActionPerformed
        panelPrincipal.setVisible(false);
        remove(panelPrincipal);
        JPanel pedido = new PanelPequisarPedido(false);
        panelPrincipal = pedido;
        panelPrincipal.setVisible(true);

        add(panelPrincipal);
    }
    private void mPedidoPesquisarDataActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btBuscarCepActionPerformed
        panelPrincipal.setVisible(false);
        remove(panelPrincipal);
        JPanel pedido = new PanelPequisarPedido(true);
        panelPrincipal = pedido;
        panelPrincipal.setVisible(true);

        add(panelPrincipal);
    }
}
