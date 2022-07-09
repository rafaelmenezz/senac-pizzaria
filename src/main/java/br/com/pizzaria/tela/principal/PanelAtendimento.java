package br.com.pizzaria.tela.principal;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.hibernate.HibernateException;

import br.com.pizzaria.controller.ClienteController;
import br.com.pizzaria.entidade.Cliente;
import br.com.pizzaria.model.TabelaPesquisa;
import br.com.pizzaria.tela.Cliente.FrameCliente;

public class PanelAtendimento extends JPanel {

    private JPanel pnlSearch;

    private JLabel lbPesquisar;
    private JTextField tfPesquisar;
    private JButton btnPesquisarCliente, btnEditarCliente, btnExcluirCliente, btnNovoCliente;
    private JTable tbCliente;
    private TabelaPesquisa mdtPesquisa;

    private ClienteController clienteCTRL;
    private JScrollPane scrollTbProduto;

    private Cliente cliente;

    public PanelAtendimento() {
     
        clienteCTRL = new ClienteController();
        initComponents();
    }

    private void initComponents() {
        setLayout(null);
        setBounds(5, 5, 860, 590);

        pnlSearch = new JPanel();
        pnlSearch.setLayout(null);
        pnlSearch.setBounds(5, 5, 900, 30);
        
        lbPesquisar = new JLabel();
        lbPesquisar.setText("Nome ou Telefone:");
        lbPesquisar.setHorizontalAlignment(SwingConstants.RIGHT);
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
        scrollTbProduto = new JScrollPane();

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

        mdtPesquisa = new TabelaPesquisa();
        tbCliente.setModel(mdtPesquisa);
        scrollTbProduto.setBounds(5, 50, 850, 490);
        scrollTbProduto.setViewportView(tbCliente);
        scrollTbProduto.setVisible(true);

        add(btnExcluirCliente);
        add(btnEditarCliente);
        add(btnNovoCliente);

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
                       
                        cliente = mdtPesquisa.getCliente(tbCliente.getSelectedRow());
                        FrameCliente frmCliente = new FrameCliente(cliente, mdtPesquisa);
                        frmCliente.setVisible(true);
                    }

                }
            }
        });
        btnNovoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
              new FrameCliente(mdtPesquisa).setVisible(true);

            }
        });
        btnPesquisarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (tfPesquisar.getText().length() > 2) {
                    mdtPesquisa.pesquisarClientePorNome(tfPesquisar.getText());
                }
            }
        });
        btnEditarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (tbCliente.getSelectedRow() > -1) {
                    cliente = mdtPesquisa.getCliente(tbCliente.getSelectedRow());
                    FrameCliente frmCliente = new FrameCliente(cliente, mdtPesquisa);
                    frmCliente.setVisible(true);
                }
            }
        });

        btnExcluirCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (tbCliente.getSelectedRow() > -1) {
                    cliente = mdtPesquisa.getCliente(tbCliente.getSelectedRow());
                    try {
                        if (JOptionPane.showConfirmDialog(null, "Deseja realmente excluir todos os dados do " + cliente.getNome() + " ?") == 0) {
                            clienteCTRL.excluirCliente(cliente);
                            JOptionPane.showMessageDialog(null, "Dados do " + cliente.getNome() + " excluído com sucesso!" );
                        }                      
                        
                    } catch (HibernateException e) {
                        JOptionPane.showMessageDialog(null, "Erro ao excluir!!");
                    }
                    mdtPesquisa.limparListaClientes();
                    tfPesquisar.setText("");
                }
            }
        });

    }

}
