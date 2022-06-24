package br.com.pizzaria.tela.login;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelLogo extends JPanel {

    private JFrame pai;

    private JLabel imagem;
    private ImageIcon logo;

    public PanelLogo(JFrame pai) {
        this.pai = pai;
        initComponents();
    }

    private void initComponents() {
        setLayout(null);
        setBounds(5, 5, 350, 350);
        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        logo = new ImageIcon(getClass().getResource("/img/senacLogo.png"));
        logo.setImage(logo.getImage().getScaledInstance(340, 280, 100));
        imagem = new JLabel(logo);
        imagem.setBounds(5, 5, 335, 350);
        add(imagem);
    }
}
