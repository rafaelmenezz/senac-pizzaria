package br.com.pizzaria.tela;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import br.com.pizzaria.controller.PedidoController;

public class PanelPesquisarPedidoData extends JPanel{
    
    private JPanel pnlSearch;

    private JLabel lbPesquisarPedido;
    private JFormattedTextField tfDataInicio, tfDataFinal;
    private JButton btnPesquisarPedido;

    private PedidoController ctrlPedido;
    private JTable jtTabelaPedido;
    private JScrollPane scrollTbPedido;

    public PanelPesquisarPedidoData(){
        ctrlPedido = new PedidoController();
    }
}
