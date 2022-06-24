
package br.com.pizzaria.tela.login;

import javax.swing.JPanel;

public class FrameLogin extends javax.swing.JFrame {

    private JPanel pLogo;
    private JPanel pForm;
    
    public FrameLogin() {
        initComponents();
    }

    public void initComponents(){

        setSize(850, 360); // define o tamanho do Frame
		setLayout(null); // Método que permite manipular as posições dos componentes em tela
		setLocationRelativeTo(null); // método que centraliza a aplicação no centro da tela
		setResizable(false); // Redimensionamento da tela desativada
		setUndecorated(true); // tira as bordas e a barra de titulos do JFrame
        pLogo = new PanelLogo();
        pForm = new PanelFormLogin();            

        add(pLogo);
        add(pForm);

    }

    private static final long serialVersionUID = 1L;
}
