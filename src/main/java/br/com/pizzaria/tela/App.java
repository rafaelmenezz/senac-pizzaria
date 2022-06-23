package br.com.pizzaria.tela;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import com.formdev.flatlaf.FlatLightLaf;

import br.com.pizzaria.tela.login.FrameLogin;


public class App {

	public static void main(String[] args) {

		// Após executar o programa será aberto a primeira tela de login
        try {
            UIManager.setLookAndFeel( new FlatLightLaf() );
        } catch( Exception ex ) {
            System.err.println( "Failed to initialize LaF" );
        }
		try {
			FrameLogin app = new FrameLogin(); 
			app.setVisible(true); 
		} catch (Exception e) {
			
			JOptionPane.showMessageDialog(null, "Erro: " + e.toString(), "Erro App", JOptionPane.ERROR_MESSAGE);
		}
	}

}
