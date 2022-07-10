package br.com.pizzaria.tela;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import br.com.pizzaria.controller.PedidoController;

public class PanelPequisarPedido extends JPanel {

    private JPanel pnlPesquisaNome, pnlPesquisaData;

    private JLabel lbPesquisarPedido, lbPesquisaPeriodo, lbPeriodoAte;
    private JTextField tfPesquisarPedido;
    private JButton btnPesquisarPedido, btnPesquisarData;

    private JFormattedTextField tfDataInicio, tfDataFim;

    private PedidoController ctrlPedido;
    private JTable jtTabelaPedido;
    private JScrollPane scrollTbPedido;

    public PanelPequisarPedido(Boolean pesquisaPorData) {
        ctrlPedido = new PedidoController();
        initComponents();
        addPanelSearch(pesquisaPorData);
    }

    private void initComponents() {
        setLayout(null);
        setBounds(5, 40, 860, 590);

        

        pnlPesquisaData = new JPanel();
        pnlPesquisaData.setLayout(null);
        pnlPesquisaData.setBounds(5, 5, 900, 30);

        jtTabelaPedido = new JTable();
        scrollTbPedido = new JScrollPane();

        lbPesquisarPedido = new JLabel();
        lbPesquisarPedido.setText("Cliente | N° Pedido:");
        lbPesquisarPedido.setBounds(0, 0, 130, 30);

        tfPesquisarPedido = new JTextField();
        tfPesquisarPedido.setBounds(135, 0, 605, 30);

        tfDataInicio = new JFormattedTextField();
        tfDataFim = new JFormattedTextField();

        try {
            tfDataInicio.setFormatterFactory(
                    new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
            tfDataFim.setFormatterFactory(
                    new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        lbPesquisaPeriodo = new JLabel("Pesquisa por período: ");
        lbPesquisaPeriodo.setBounds(100, 0, 200, 30);
        tfDataInicio.setBounds(240, 0, 150, 30);
        lbPeriodoAte = new JLabel(" - ");
        lbPeriodoAte.setBounds(400, 0, 50, 30);
        tfDataFim.setBounds(425, 0, 150, 30);



        btnPesquisarPedido = new JButton("Pesquisar");
        btnPesquisarPedido.setBounds(750, 0, 100, 30);

        btnPesquisarData = new JButton("Pesquisar");
        btnPesquisarData.setBounds(750, 0, 100, 30);

        
        initTabelaCliente();

        eventos();
    }

    private void addPanelSearch(Boolean pesquisarPorData) {

        if (pesquisarPorData) {
            pnlPesquisaData = new JPanel();
            pnlPesquisaData.setLayout(null);
            pnlPesquisaData.setBounds(5, 5, 900, 30);
    
            pnlPesquisaData.add(lbPesquisaPeriodo);
            pnlPesquisaData.add(tfDataInicio);
            pnlPesquisaData.add(lbPeriodoAte);
            pnlPesquisaData.add(tfDataFim);
            pnlPesquisaData.add(btnPesquisarData);
    
            add(pnlPesquisaData);
        } else {
            pnlPesquisaNome = new JPanel();
            pnlPesquisaNome.setLayout(null);
            pnlPesquisaNome.setBounds(5, 5, 900, 30);
    
            pnlPesquisaNome.add(lbPesquisarPedido);
            pnlPesquisaNome.add(tfPesquisarPedido);
            pnlPesquisaNome.add(btnPesquisarPedido);
    
            add(pnlPesquisaNome);
        }

    }

    private void initTabelaCliente() {

        jtTabelaPedido.setModel(ctrlPedido.getModeloTabela());
        scrollTbPedido.setBounds(5, 50, 850, 520);
        scrollTbPedido.setViewportView(jtTabelaPedido);
        scrollTbPedido.setVisible(true);

        add(scrollTbPedido);

    }

    private void eventos() {
        tfPesquisarPedido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (tfPesquisarPedido.getText().length() >= 2) {
                    ctrlPedido.pesquisarPedidoPorNomeCliente(tfPesquisarPedido.getText());
                } else {
                    ctrlPedido.limparTabelaPedidos();
                }
            }
        });
        btnPesquisarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (tfPesquisarPedido.getText().length() >= 2) {
                    ctrlPedido.pesquisarPedidoPorNomeCliente(tfPesquisarPedido.getText());
                } 
            }
        });
        btnPesquisarData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ctrlPedido.pesquisarPeriodo(tfDataInicio.getText(), tfDataFim.getText());
            }
        });
    }
}
