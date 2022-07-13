package br.com.pizzaria.tela;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import com.formdev.flatlaf.FlatLightLaf;

import br.com.pizzaria.controller.UsuarioController;


public class App {

	public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel( new FlatLightLaf() );
        } catch( Exception ex ) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage(), "Erro App", JOptionPane.ERROR_MESSAGE);
        }

	
		try {
			if (new UsuarioController().existiUsuario()) {
				FrameLogin app = new FrameLogin(); 
				app.setVisible(true); 
			} else {
				FrameNovoUsuario novoUsuario = new FrameNovoUsuario();
				novoUsuario.setVisible(true);
			}
			
		} catch (Exception e) {
			
			JOptionPane.showMessageDialog(null, "Erro: " + e.toString(), "Erro App", JOptionPane.ERROR_MESSAGE);
		}
	}

}
