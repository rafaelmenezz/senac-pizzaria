package br.com.pizzaria.tela;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import org.hibernate.HibernateException;

import br.com.pizzaria.controller.ClienteController;
import br.com.pizzaria.entidade.Cliente;

public class PanelPesquisarCliente extends JPanel {

    private JPanel pnlSearch;

    private JLabel lbPesquisar;
    private JTextField tfPesquisar;
    private JButton btnPesquisarCliente, btnEditarCliente, btnExcluirCliente, btnNovoCliente;
    private JTable tbCliente;

    private ClienteController clienteCTRL;
    private JScrollPane scrollTbCliente;

    private Cliente cliente;

    public PanelPesquisarCliente() {
     
        clienteCTRL = new ClienteController();
        initComponents();
    }

    private void initComponents() {
        setLayout(null);
        setBounds(5, 40, 860, 590);

        pnlSearch = new JPanel();
        pnlSearch.setLayout(null);
        pnlSearch.setBounds(5, 5, 900, 30);
        
        lbPesquisar = new JLabel();
        lbPesquisar.setText("Nome ou Telefone:");
        lbPesquisar.setBounds(0, 0, 130, 30);

        btnPesquisarCliente = new JButton("Pesquisar");
        btnEditarCliente = new JButton("Editar");
        btnExcluirCliente = new JButton("Excluir");
        btnNovoCliente = new JButton("Novo");
        

        tfPesquisar = new JTextField();
        tfPesquisar.setBounds(135, 0, 605, 30);
        btnPesquisarCliente.setBounds(750, 0, 100, 30);

        btnNovoCliente.setBounds(10, 550, 100, 30);
        btnExcluirCliente.setBounds(640, 550, 100, 30);
        btnEditarCliente.setBounds(750, 550, 100, 30);

        tbCliente = new JTable();
        scrollTbCliente = new JScrollPane();

        addPanelSearch();
        initTabelaCliente();
        initEventos();
    }

    private void addPanelSearch() {

        pnlSearch.add(lbPesquisar);
        pnlSearch.add(tfPesquisar);
        pnlSearch.add(btnPesquisarCliente);

        add(pnlSearch);
    }

    private void initTabelaCliente() {

        tbCliente.setModel(clienteCTRL.getModeloTabela());
        scrollTbCliente.setBounds(5, 50, 850, 490);
        scrollTbCliente.setViewportView(tbCliente);
        scrollTbCliente.setVisible(true);

        add(btnExcluirCliente);
        add(btnEditarCliente);
        add(btnNovoCliente);

        add(scrollTbCliente);

    }

    private void initEventos() {
        tfPesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (tfPesquisar.getText().length() >= 2) {
                    clienteCTRL.pesquisarClientePorNome(tfPesquisar.getText());
                } else {
                    clienteCTRL.getModeloTabela().limparListaClientes();
                }
            }
        });

        tbCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (evt.getClickCount() == 2) {
                    if (tbCliente.getSelectedRow() > -1) {
                       
                        cliente = clienteCTRL.getModeloTabela().getCliente(tbCliente.getSelectedRow());
                        FrameCliente frmCliente = new FrameCliente(cliente, clienteCTRL.getModeloTabela());
                        frmCliente.setVisible(true);
                    }

                }
            }
        });
        btnNovoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
              new FrameCliente(clienteCTRL.getModeloTabela()).setVisible(true);

            }
        });
        btnPesquisarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (tfPesquisar.getText().length() > 2) {
                    clienteCTRL.getModeloTabela().pesquisarClientePorNome(tfPesquisar.getText());
                }
            }
        });
        btnEditarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (tbCliente.getSelectedRow() > -1) {
                    cliente = clienteCTRL.getModeloTabela().getCliente(tbCliente.getSelectedRow());
                    FrameCliente frmCliente = new FrameCliente(cliente, clienteCTRL.getModeloTabela());
                    frmCliente.editarCliente(true);
                    frmCliente.setVisible(true);
                }
            }
        });

        btnExcluirCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (tbCliente.getSelectedRow() > -1) {
                    cliente = clienteCTRL.getModeloTabela().getCliente(tbCliente.getSelectedRow());
                    try {
                        if (JOptionPane.showConfirmDialog(null, "Deseja realmente excluir todos os dados do " + cliente.getNome() + " ?") == 0) {
                            clienteCTRL.excluirCliente(cliente);
                            JOptionPane.showMessageDialog(null, "Dados do " + cliente.getNome() + " excluído com sucesso!" );
                        }                      
                        
                    } catch (HibernateException e) {
                        JOptionPane.showMessageDialog(null, "Erro ao excluir!!");
                    }
                    clienteCTRL.getModeloTabela().limparListaClientes();
                    tfPesquisar.setText("");
                }
            }
        });

    }

}
