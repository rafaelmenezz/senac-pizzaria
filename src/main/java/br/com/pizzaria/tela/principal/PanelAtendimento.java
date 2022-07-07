package br.com.pizzaria.tela.principal;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import br.com.pizzaria.ClienteController;
import br.com.pizzaria.entidade.Cliente;
import br.com.pizzaria.model.TabelaPesquisa;
import br.com.pizzaria.tela.Cliente.FrameCliente;

public class PanelAtendimento extends JPanel {

    private JPanel pai;
    private JPanel pnlSearch, pnlCliente;

    private JLabel lbPesquisar, lbNomeCliente, lbEmailCliente, lbTelefoneCliente;
    private JTextField tfPesquisar, tfNomeCliente, tfEmailCliente, tfTelefoneCliente;
    private JButton btnEditarDadosCliente, btnSalvarDadosCliente, btnCancelarAlteracaoCliente;

    private JTable tbCliente;
    private TabelaPesquisa mdtPesquisa;

    private ClienteController clienteCTRL;
    private JScrollPane scrollTbProduto;

    private Cliente cliente;

    public PanelAtendimento(JPanel pai) {
        this.pai = pai;
        clienteCTRL = new ClienteController();
        initComponents();
    }

    private void initComponents() {
        setLayout(null);
        setBounds(5, 5, 860, 590);

        pnlSearch = new JPanel();
        pnlSearch.setLayout(null);
        pnlSearch.setBounds(5, 5, 900, 30);

        lbNomeCliente = new JLabel("Nome: ");
        lbTelefoneCliente = new JLabel("Telefone: ");
        lbEmailCliente = new JLabel("Email: ");

        tfNomeCliente = new JTextField();
        tfTelefoneCliente = new JTextField();
        tfEmailCliente = new JTextField();

        lbPesquisar = new JLabel();
        lbPesquisar.setText("Nome ou Telefone:");
        lbPesquisar.setHorizontalAlignment(SwingConstants.RIGHT);
        lbPesquisar.setBounds(0, 0, 130, 30);

        tfPesquisar = new JTextField();
        tfPesquisar.setBounds(135, 0, 715, 30);

        pnlCliente = new JPanel();
        tbCliente = new JTable();
        scrollTbProduto = new JScrollPane();

        btnEditarDadosCliente = new JButton("Editar");
        btnSalvarDadosCliente = new JButton("Salvar");
        btnCancelarAlteracaoCliente = new JButton("Cancelar");

        pnlCliente.setVisible(false);
        pnlCliente.setBounds(5, 50, 420, 522);
        pnlCliente.setBorder(javax.swing.BorderFactory.createTitledBorder(" Dados do Cliente "));

        lbNomeCliente.setBounds(10, 55, 100, 30);
        tfNomeCliente.setBounds(110, 55, 290, 30);

        lbTelefoneCliente.setBounds(10, 90, 100, 30);
        tfTelefoneCliente.setBounds(110, 90, 290, 30);

        lbEmailCliente.setBounds(10, 125, 100, 30);
        tfEmailCliente.setBounds(110, 125, 290, 30);

        btnCancelarAlteracaoCliente.setBounds(200, 480, 100, 30);
        btnSalvarDadosCliente.setBounds(310, 480, 100, 30);
        btnEditarDadosCliente.setBounds(310, 480, 100, 30);

        pnlCliente.add(lbNomeCliente);
        pnlCliente.add(lbTelefoneCliente);
        pnlCliente.add(lbEmailCliente);

        pnlCliente.add(tfNomeCliente);
        pnlCliente.add(tfEmailCliente);
        pnlCliente.add(tfTelefoneCliente);

        pnlCliente.add(btnEditarDadosCliente);
        pnlCliente.add(btnSalvarDadosCliente);
        pnlCliente.add(btnCancelarAlteracaoCliente);

        addPanelSearch();
        initTabelaCliente();
        initEventos();
    }

    private void addPanelSearch() {

        pnlSearch.add(lbPesquisar);
        pnlSearch.add(tfPesquisar);

        add(pnlSearch);
    }

    private void showPanelCliente(Cliente cliente) {
        pnlCliente.setVisible(false);
        scrollTbProduto.setVisible(false);

        tfNomeCliente.setText(cliente.getNome());
        tfTelefoneCliente.setText(cliente.getTelefone());
        tfEmailCliente.setText(cliente.getEmail());

        btnCancelarAlteracaoCliente.setVisible(false);
        btnSalvarDadosCliente.setVisible(false);
        btnEditarDadosCliente.setVisible(true);

        tfNomeCliente.setEditable(false);
        tfTelefoneCliente.setEditable(false);
        tfEmailCliente.setEditable(false);

        pnlCliente.setVisible(true);

        add(pnlCliente);

    }

    private void showEditarCliente() {

        pnlCliente.setVisible(false);
        scrollTbProduto.setVisible(false);

        tfNomeCliente.setEditable(true);
        tfTelefoneCliente.setEditable(true);
        tfEmailCliente.setEditable(true);
        btnEditarDadosCliente.setVisible(false);
        btnCancelarAlteracaoCliente.setVisible(true);
        btnSalvarDadosCliente.setVisible(true);

        pnlCliente.setVisible(true);

        add(pnlCliente);
    }

    private void initTabelaCliente() {

        pnlCliente.setVisible(false);

        mdtPesquisa = new TabelaPesquisa();
        tbCliente.setModel(mdtPesquisa);
        scrollTbProduto.setBounds(5, 50, 850, 525);
        scrollTbProduto.setViewportView(tbCliente);
        scrollTbProduto.setVisible(true);
        add(scrollTbProduto);

    }

    private void initEventos() {
        tfPesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (tfPesquisar.getText().length() >= 2) {
                    mdtPesquisa.pesquisarClientePorNome(tfPesquisar.getText());
                } else {
                    mdtPesquisa.limparListaClientes();
                }
            }
        });

        tbCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (evt.getClickCount() == 2) {
                    if (tbCliente.getSelectedRow() > -1) {
                        System.out.println("aqui");
                        cliente = mdtPesquisa.getCliente(tbCliente.getSelectedRow());
                        FrameCliente frmCliente = new FrameCliente(cliente);
                        frmCliente.setVisible(true);
                    }

                }
            }
        });

        btnEditarDadosCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showEditarCliente();
            }
        });

        btnCancelarAlteracaoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPesquisar.setText("");
                showPanelCliente(cliente);
            }
        });
    }

}
