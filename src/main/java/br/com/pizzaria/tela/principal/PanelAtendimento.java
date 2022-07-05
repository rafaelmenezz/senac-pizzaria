package br.com.pizzaria.tela.principal;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import br.com.pizzaria.model.TabelaPesquisa;

public class PanelAtendimento extends JPanel {

    private JPanel pai;
    private JPanel pnlSearch, pnlTabela;

    private JLabel lbPesquisar;
    private JTextField tfPesquisar;

    private JTable tbCliente;
    private TabelaPesquisa mdtPesquisa;


    public PanelAtendimento(JPanel pai) {
        this.pai = pai;    
        initComponents();
    }

    private void initComponents() {
        setLayout(null);
        setBounds(5,5,860,590);
        addPanelSearch();
        initPanelCliente();
    }

    private void addPanelSearch() {
        pnlSearch = new JPanel();
        pnlSearch.setLayout(null);
        pnlSearch.setBounds(5, 5, 900, 30);

        lbPesquisar = new JLabel();
        lbPesquisar.setText("Nome ou Telefone:");
        lbPesquisar.setHorizontalAlignment(SwingConstants.RIGHT);
        lbPesquisar.setBounds(0, 0, 130, 30);

        tfPesquisar = new JTextField();
        tfPesquisar.setBounds(135, 0, 715, 30);

        pnlSearch.add(lbPesquisar);
        pnlSearch.add(tfPesquisar);

        add(pnlSearch);
    }

    private void initPanelCliente(){
        pnlTabela = new JPanel();
        pnlTabela.setBounds(5, 50, 850, 500);
        pnlTabela.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        tbCliente = new JTable();
        mdtPesquisa = new TabelaPesquisa();

        tbCliente.setModel(mdtPesquisa);

        JScrollPane scrollTbProduto = new JScrollPane(tbCliente, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollTbProduto.setBounds(0, 0, 850, 500);

        pnlTabela.add(tbCliente);
    
        add(pnlTabela);
    }
   
}
