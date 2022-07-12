package br.com.pizzaria.tela;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

public class PanelPrincipal extends JPanel{

    private JPanel clienteCard, pedidoCard, searchClienteCard, searchPedidoCard, searchForDatePedido;

    private JLabel lbImgCadCliente, lbImgCadPedido, lbImgPeqCliente, lbImgPeqPedido, lbImgSearchForDatePedido;


    public PanelPrincipal(){
        initComponents();
        initCard();
    }

    private void initComponents(){
        setLayout(null);
        setBounds(5, 40, 860, 590);


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
    

       add(clienteCard);
       add(searchClienteCard);
       add(pedidoCard);
       add(searchPedidoCard);
       add(searchForDatePedido);
    }
    
}
