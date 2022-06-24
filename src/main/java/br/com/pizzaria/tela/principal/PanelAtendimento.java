package br.com.pizzaria.tela.principal;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PanelAtendimento extends JPanel {

    private JPanel pai;
    private JPanel pnlSearch;

    private JLabel lbPesquisar;

    public PanelAtendimento(JPanel pai) {
        this.pai = pai;
        addPanelSearch();
        initComponents();
    }

    private void initComponents() {
        setLayout(null);
        setBounds(5,5,1330,600);
    }

    private void addPanelSearch() {
        pnlSearch = new JPanel();
        pnlSearch.setLayout(null);
        pnlSearch.setBounds(5, 5, 1300, 75);

        lbPesquisar = new JLabel();
        lbPesquisar.setText("Pesquisar:");
        lbPesquisar.setHorizontalAlignment(SwingConstants.RIGHT);
        lbPesquisar.setBounds(0, 0, 100, 30);

        pnlSearch.add(lbPesquisar);

        add(pnlSearch);
    }
}
