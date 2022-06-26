package br.com.pizzaria.tela.principal;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import br.com.pizzaria.tela.cards.CardCliente;

public class PanelAtendimento extends JPanel {

    private JPanel pai;
    private JPanel pnlSearch, pnlCliente, pnlEndereco, pnlDetalhes;

    private JLabel lbPesquisar;
    private JTextField tfPesquisar;

    public PanelAtendimento(JPanel pai) {
        this.pai = pai;    
        initComponents();
    }

    private void initComponents() {
        setLayout(null);
        setBounds(5,5,1260,590);
        addPanelSearch();
        initPanelCliente();
        initPanelEndereco();
        initPanelDetalhes();
    }

    private void addPanelSearch() {
        pnlSearch = new JPanel();
        pnlSearch.setLayout(null);
        pnlSearch.setBounds(5, 5, 1300, 30);

        lbPesquisar = new JLabel();
        lbPesquisar.setText("Nome ou Telefone:");
        lbPesquisar.setHorizontalAlignment(SwingConstants.RIGHT);
        lbPesquisar.setBounds(0, 0, 130, 30);

        tfPesquisar = new JTextField();
        tfPesquisar.setBounds(135, 0, 1115, 30);

        pnlSearch.add(lbPesquisar);
        pnlSearch.add(tfPesquisar);

        add(pnlSearch);
    }

    private void initPanelCliente(){
        pnlCliente = new JPanel();
        pnlCliente.setBounds(5, 50, 625, 260);
        pnlCliente.setBorder(javax.swing.BorderFactory.createTitledBorder("Cliente"));
    

        add(pnlCliente);
    }
    private void initPanelEndereco(){
        pnlEndereco = new JPanel();
        pnlEndereco.setBounds(5, 310, 625, 270);
        pnlEndereco.setBorder(javax.swing.BorderFactory.createTitledBorder("Endereço"));


        add(pnlEndereco);
    }

    private void initPanelDetalhes(){
        pnlDetalhes = new JPanel();
        pnlDetalhes.setBounds(630, 50, 625, 530);
        pnlDetalhes.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalhes"));


        add(pnlDetalhes);
    }
}
