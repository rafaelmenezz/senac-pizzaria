package br.com.pizzaria.tela.cards;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CardCliente extends JPanel {
    
    private JLabel jlNome, jlTelefone, jlEmail;
    private JTextField jtfNome, jtfTelefone, jtfEmail;


    public CardCliente(){
        iniComponents();
    }

    public void iniComponents(){
     
        setBorder(javax.swing.BorderFactory.createTitledBorder("Cliente"));
    }
}
