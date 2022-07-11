
package br.com.pizzaria.tela;

import javax.swing.JPanel;



public class FrameLogin extends javax.swing.JFrame {

    private JPanel pForm;

    public FrameLogin() {
        initComponents();
    }

    public void initComponents() {
        setSize(495, 350); // define o tamanho do Frame
        setLayout(null); // Método que permite manipular as posições dos componentes em tela
        setLocationRelativeTo(null); // método que centraliza a aplicação no centro da tela
        setResizable(false); // Redimensionamento da tela desativada
        //setUndecorated(true); // tira as bordas e a barra de titulos do JFrame
        pForm = new PanelFormLogin(this);
        add(pForm);

    }


}
