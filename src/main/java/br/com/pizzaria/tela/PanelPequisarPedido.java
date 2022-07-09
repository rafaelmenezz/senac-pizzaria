package br.com.pizzaria.tela;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import br.com.pizzaria.controller.PedidoController;

public class PanelPequisarPedido extends JPanel {

    private JPanel pnlSearch;

    private JLabel lbPesquisarPedido;
    private JTextField tfPesquisarPedido;
    private JButton btnPesquisarPedido;

    private PedidoController ctrlPedido;
    private JTable jtTabelaPedido;
    private JScrollPane scrollTbPedido;

    public PanelPequisarPedido() {
        ctrlPedido = new PedidoController();
        initComponents();
    }

    private void initComponents() {
        setLayout(null);
        setBounds(5, 40, 860, 590);

        pnlSearch = new JPanel();
        pnlSearch.setLayout(null);
        pnlSearch.setBounds(5, 5, 900, 30);

        jtTabelaPedido = new JTable();
        scrollTbPedido = new JScrollPane();

        lbPesquisarPedido = new JLabel();
        lbPesquisarPedido.setText("Cliente | N° Pedido:");
        lbPesquisarPedido.setBounds(0, 0, 130, 30);

        tfPesquisarPedido = new JTextField();
        tfPesquisarPedido.setBounds(135, 0, 605, 30);

        btnPesquisarPedido = new JButton("Pesquisar");
        btnPesquisarPedido.setBounds(750, 0, 100, 30);

        addPanelSearch();
        initTabelaCliente();

        eventos();
    }

    private void addPanelSearch() {

        pnlSearch.add(lbPesquisarPedido);
        pnlSearch.add(tfPesquisarPedido);
        pnlSearch.add(btnPesquisarPedido);

        add(pnlSearch);
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
    }
}
