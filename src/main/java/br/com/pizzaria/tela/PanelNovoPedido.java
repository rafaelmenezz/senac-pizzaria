package br.com.pizzaria.tela;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import br.com.pizzaria.controller.ClienteController;
import br.com.pizzaria.controller.PedidoController;
import br.com.pizzaria.entidade.Cliente;
import br.com.pizzaria.entidade.Pedido;

public class PanelNovoPedido extends JPanel {

    private JPanel pnlSearch, pnlCliente, pnlEndereco, pnlPedido;

    private Cliente cliente;
    private ClienteController clienteCTRL;
    private PedidoController pedidoCTRL;

    private JLabel lbPesquisar, lbNomeCliente, lbEmailCliente, lbTelefoneCliente,
            lbLogradouro, lbNumero, lbBairro, lbCidade, lbEstado, lbCep,
            lbComplemento, lbObservacao, lbNumeroPedido, lbDataPedido, lbValorTotal;

    private JTextField tfNomeCliente, tfEmailCliente, tfTelefoneCliente,
            tfLogradouro, tfNumero, tfBairro, tfCidade, tfEstado,
            tfComplemento, tfNumeroPedido, tfDataPedido, tfValorTotal;
    
    private JButton btnSalvarPedido, btnCancelarPedido;

    private JTextArea taObservacao;
    private JFormattedTextField tfPesquisar, tfCep;
    private JButton btnPesquisarCliente;

    public PanelNovoPedido() {
        this.cliente = new Cliente();
        clienteCTRL = new ClienteController();
        pedidoCTRL = new PedidoController();

        initComponents();
    }

    private void initComponents() {

        setLayout(null);
        setBounds(5, 40, 860, 590);

        pnlSearch = new JPanel();
        pnlSearch.setLayout(null);
        pnlSearch.setBounds(5, 5, 900, 30);

        pnlCliente = new JPanel();
        pnlEndereco = new JPanel();
        pnlPedido = new JPanel();

        lbPesquisar = new JLabel();
        lbPesquisar.setText("Telefone:");
        lbPesquisar.setBounds(0, 0, 130, 30);

        tfPesquisar = new JFormattedTextField();
        tfPesquisar.setBounds(135, 0, 605, 30);

        tfCep = new JFormattedTextField();

        try {
            tfPesquisar.setFormatterFactory(
                    new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));

            tfCep.setFormatterFactory(
                    new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        lbNomeCliente = new JLabel("Nome: ", SwingConstants.RIGHT);
        lbNomeCliente.setVerticalAlignment(SwingConstants.CENTER);
        lbNomeCliente.setBounds(10, 30, 100, 30);

        tfNomeCliente = new JTextField();
        tfNomeCliente.setBounds(110, 30, 300, 30);
        tfNomeCliente.setEditable(false);

        lbEmailCliente = new JLabel("Email: ", SwingConstants.RIGHT);
        lbEmailCliente.setVerticalAlignment(SwingConstants.CENTER);
        lbEmailCliente.setBounds(10, 80, 100, 30);

        tfEmailCliente = new JTextField();
        tfEmailCliente.setBounds(110, 80, 300, 30);
        tfEmailCliente.setEditable(false);

        lbTelefoneCliente = new JLabel("Telefone: ", SwingConstants.RIGHT);
        lbTelefoneCliente.setVerticalAlignment(SwingConstants.CENTER);
        lbTelefoneCliente.setBounds(10, 130, 100, 30);

        tfTelefoneCliente = new JTextField();
        tfTelefoneCliente.setBounds(110, 130, 300, 30);
        tfTelefoneCliente.setEditable(false);

        btnPesquisarCliente = new JButton("Pesquisar");
        btnPesquisarCliente.setBounds(750, 0, 100, 30);

        lbLogradouro = new JLabel("Logradouro: ", SwingConstants.RIGHT);
        lbLogradouro.setVerticalAlignment(SwingConstants.CENTER);
        lbLogradouro.setBounds(10, 30, 100, 30);

        tfLogradouro = new JTextField();
        tfLogradouro.setBounds(110, 30, 300, 30);
        tfLogradouro.setEditable(false);

        lbNumero = new JLabel("Número: ", SwingConstants.RIGHT);
        lbNumero.setVerticalAlignment(SwingConstants.CENTER);
        lbNumero.setBounds(10, 80, 100, 30);

        tfNumero = new JTextField();
        tfNumero.setBounds(110, 80, 75, 30);
        tfNumero.setEditable(false);

        lbBairro = new JLabel("Bairro: ", SwingConstants.RIGHT);
        lbBairro.setVerticalAlignment(SwingConstants.CENTER);
        lbBairro.setBounds(185, 80, 60, 30);

        tfBairro = new JTextField();
        tfBairro.setBounds(250, 80, 160, 30);
        tfBairro.setEditable(false);

        lbCidade = new JLabel("Cidade: ", SwingConstants.RIGHT);
        lbCidade.setVerticalAlignment(SwingConstants.CENTER);
        lbCidade.setBounds(10, 130, 100, 30);

        tfCidade = new JTextField();
        tfCidade.setBounds(110, 130, 140, 30);
        tfCidade.setEditable(false);

        lbEstado = new JLabel("UF: ", SwingConstants.RIGHT);
        lbEstado.setVerticalAlignment(SwingConstants.CENTER);
        lbEstado.setBounds(255, 130, 30, 30);

        tfEstado = new JTextField();
        tfEstado.setBounds(290, 130, 120, 30);
        tfEstado.setEditable(false);

        lbComplemento = new JLabel("Complemento: ", SwingConstants.RIGHT);
        lbComplemento.setVerticalAlignment(SwingConstants.CENTER);
        lbComplemento.setBounds(10, 180, 100, 30);

        tfComplemento = new JTextField();
        tfComplemento.setBounds(110, 180, 140, 30);
        tfComplemento.setEditable(false);

        lbCep = new JLabel("CEP: ", SwingConstants.RIGHT);
        lbCep.setVerticalAlignment(SwingConstants.CENTER);
        lbCep.setBounds(255, 180, 30, 30);

        tfCep.setBounds(290, 180, 120, 30);
        tfCep.setEditable(false);

        lbObservacao = new JLabel("Observação: ", SwingConstants.RIGHT);
        lbObservacao.setVerticalAlignment(SwingConstants.CENTER);
        lbObservacao.setBounds(10, 230, 100, 30);

        taObservacao = new JTextArea();
        taObservacao.setBorder(tfCep.getBorder());
        taObservacao.setBounds(110, 230, 300, 60);
        taObservacao.setEditable(false);

        lbNumeroPedido = new JLabel("Numero: ", SwingConstants.RIGHT);
        lbNumeroPedido.setVerticalAlignment(SwingConstants.CENTER);
        lbNumeroPedido.setBounds(10, 30, 100, 30);

        tfNumeroPedido = new JTextField();
        tfNumeroPedido.setBounds(110, 30, 300, 30);
        tfNumeroPedido.setEditable(false);

        lbDataPedido = new JLabel("Data: ", SwingConstants.RIGHT);
        lbDataPedido.setVerticalAlignment(SwingConstants.CENTER);
        lbDataPedido.setBounds(10, 80, 100, 30);

        tfDataPedido = new JTextField();
        tfDataPedido.setBounds(110, 80, 300, 30);
        tfDataPedido.setEditable(false);

        lbValorTotal = new JLabel("Valor Total R$: ", SwingConstants.RIGHT);
        lbValorTotal.setVerticalAlignment(SwingConstants.CENTER);
        lbValorTotal.setBounds(10, 130, 100, 30);

        tfValorTotal = new JTextField();
        tfValorTotal.setBounds(110, 130, 300, 30);
        tfValorTotal.setEditable(false);

        btnCancelarPedido = new JButton("Cancelar");
        btnSalvarPedido = new JButton("Salvar");

        btnSalvarPedido.setBounds(700, 260, 100, 30);


        addPanelSearch();
        initPanelCliente();
        initPanelPedido();
        addBotoes();
        eventos();
    }

    private void addPanelSearch() {

        pnlSearch.add(lbPesquisar);
        pnlSearch.add(tfPesquisar);
        pnlSearch.add(btnPesquisarCliente);

        add(pnlSearch);
    }

    private void initPanelCliente() {
        pnlCliente.setLayout(null);
        pnlCliente.setBounds(5, 50, 425, 200);
        Border bordaCliente = BorderFactory.createTitledBorder(null, "Cliente", javax.swing.border.TitledBorder.CENTER,
                javax.swing.border.TitledBorder.DEFAULT_POSITION);
        pnlCliente.setBorder(bordaCliente);

        pnlCliente.add(lbNomeCliente);
        pnlCliente.add(lbEmailCliente);
        pnlCliente.add(lbTelefoneCliente);
        pnlCliente.add(tfNomeCliente);
        pnlCliente.add(tfEmailCliente);
        pnlCliente.add(tfTelefoneCliente);

        pnlEndereco.setLayout(null);
        pnlEndereco.setBounds(5, 260, 425, 330);
        Border bordaEndenreco = BorderFactory.createTitledBorder(null, "Endereço",
                javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION);
        pnlEndereco.setBorder(bordaEndenreco);

        pnlEndereco.add(lbLogradouro);
        pnlEndereco.add(tfLogradouro);
        pnlEndereco.add(lbNumero);
        pnlEndereco.add(tfNumero);
        pnlEndereco.add(lbBairro);
        pnlEndereco.add(tfBairro);
        pnlEndereco.add(lbCidade);
        pnlEndereco.add(tfCidade);
        pnlEndereco.add(lbEstado);
        pnlEndereco.add(tfEstado);
        pnlEndereco.add(lbComplemento);
        pnlEndereco.add(tfComplemento);
        pnlEndereco.add(lbCep);
        pnlEndereco.add(tfCep);
        pnlEndereco.add(lbObservacao);
        pnlEndereco.add(taObservacao);


        add(pnlEndereco);
        add(pnlCliente);
    }

    private void initPanelPedido() {

        pnlPedido.setLayout(null);
        pnlPedido.setBounds(435, 50, 425, 200);
        Border bordaPedido = BorderFactory.createTitledBorder(null, "Pedido", javax.swing.border.TitledBorder.CENTER,
                javax.swing.border.TitledBorder.DEFAULT_POSITION);
        pnlPedido.setBorder(bordaPedido);

        pnlPedido.add(lbNumeroPedido);
        pnlPedido.add(tfNumeroPedido);
        pnlPedido.add(lbDataPedido);
        pnlPedido.add(tfDataPedido);
        pnlPedido.add(lbValorTotal);
        pnlPedido.add(tfValorTotal);


        add(pnlPedido);
    }
    private void addBotoes(){
        btnSalvarPedido.setBounds(760, 260, 100, 30);
        btnCancelarPedido.setBounds(650, 260, 100, 30);
        habilitarCadastro(false);
        add(btnSalvarPedido);
        add(btnCancelarPedido);
    }


    public void habilitarCadastro(Boolean habilitar){
        pnlPedido.setVisible(false);
        tfValorTotal.setEditable(habilitar);
        btnCancelarPedido.setEnabled(habilitar);
        btnSalvarPedido.setEnabled(habilitar);
        pnlPedido.setVisible(true);

        if (habilitar) {
            try {
                SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
                tfDataPedido.setText(dt.format(new Date()));
                tfNumeroPedido.setText((pedidoCTRL.ultimoNumeroGravado() + 1) + "");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
       
    }

    private Pedido criarPedido(){

        Pedido novoPedido = new Pedido();
        novoPedido.setCliente(cliente);
        novoPedido.setDt_pedido(new Date());
        novoPedido.setNumero(Integer.parseInt(tfNumeroPedido.getText()));
        novoPedido.setValor_total(new BigDecimal(tfValorTotal.getText()));

        return novoPedido;
    }

    public void carregarCliente(){

        tfNomeCliente.setText(cliente.getNome());
        tfEmailCliente.setText(cliente.getEmail());
        tfTelefoneCliente.setText(cliente.getTelefone());
        tfLogradouro.setText(cliente.getEnderecos().get(0).getLogradouro());
        tfNumero.setText(cliente.getEnderecos().get(0).getNumero());
        tfBairro.setText(cliente.getEnderecos().get(0).getBairro());
        tfCidade.setText(cliente.getEnderecos().get(0).getCidade());
        tfEstado.setText(cliente.getEnderecos().get(0).getEstado());
        tfCep.setText(cliente.getEnderecos().get(0).getCep());
        tfComplemento.setText(cliente.getEnderecos().get(0).getComplemento());
        taObservacao.setText(cliente.getEnderecos().get(0).getObservacao());
    }

    public void limparDados(){

        tfNomeCliente.setText("");
        tfEmailCliente.setText("");
        tfTelefoneCliente.setText("");
        tfLogradouro.setText("");
        tfNumero.setText("");
        tfBairro.setText("");
        tfCidade.setText("");
        tfEstado.setText("");
        tfCep.setText("");
        tfComplemento.setText("");
        taObservacao.setText("");
        tfNumeroPedido.setText("");
        tfDataPedido.setText("");
        tfValorTotal.setText("");
        tfPesquisar.setText("");
        habilitarCadastro(false);
    }

    private void novoCliente(){
     
        if (JOptionPane.showConfirmDialog(null, "Cliente não encontrado, deseja cadastrar novo cliente?") == 0) {
            cliente.setTelefone(tfPesquisar.getText());
            new FrameCliente(cliente, this).setVisible(true);
            carregarCliente();
            
        } else {
            tfPesquisar.setText("");
        }
    }

    private void eventos() {

        btnPesquisarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (tfPesquisar.getText().trim().length() >= 13 && tfPesquisar.getText().trim().length() <= 14) {
                    
                    try {
                        cliente = clienteCTRL.buscarPorTelefone(tfPesquisar.getText().trim());
                        carregarCliente(); 
                        habilitarCadastro(true);   
                    } catch (Exception e) {
                      novoCliente();
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Numero de Telefone inválido!");
                }
            }
        });
        btnSalvarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (tfValorTotal.getText().length() > 0 ) {
                    pedidoCTRL.salvarPedido(criarPedido());
                    limparDados();
                } else {
                    JOptionPane.showMessageDialog(null, "Campo valor total não preenchido!");
                }
                
            }
        });

        btnCancelarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparDados();
            }
        });
 
    }
}
