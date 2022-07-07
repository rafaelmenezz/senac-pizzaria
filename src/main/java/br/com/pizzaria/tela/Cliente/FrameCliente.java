package br.com.pizzaria.tela.Cliente;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import br.com.pizzaria.entidade.Cliente;

public class FrameCliente extends JFrame{
    
    private Cliente cliente;

    private JLabel  lbNomeCliente, lbEmailCliente, lbTelefoneCliente;
    private JTextField  tfNomeCliente, tfEmailCliente, tfTelefoneCliente;
    private JButton btnEditarDadosCliente, btnSalvarDadosCliente, btnCancelarAlteracaoCliente;

    public FrameCliente(Cliente cliente){
        this.cliente = cliente;
        initComponents();
    }

    private void initComponents(){
        setSize(600, 800); // define o tamanho do Frame
        setLayout(null); // Método que permite manipular as posições dos componentes em tela
        setLocationRelativeTo(null); // método que centraliza a aplicação no centro da tela
        setResizable(false);
        setTitle("Cliente: " + cliente.getNome());

        lbNomeCliente = new JLabel("Nome: ");
        lbTelefoneCliente = new JLabel("Telefone: ");
        lbEmailCliente = new JLabel("Email: ");

        tfNomeCliente = new JTextField();
        tfTelefoneCliente = new JTextField();
        tfEmailCliente = new JTextField();

        btnEditarDadosCliente = new JButton("Editar");
        btnSalvarDadosCliente = new JButton("Salvar");
        btnCancelarAlteracaoCliente = new JButton("Cancelar");


        lbNomeCliente.setBounds(10, 55, 100, 30);
        tfNomeCliente.setBounds(110, 55, 290, 30);

        lbTelefoneCliente.setBounds(10, 90, 100, 30);
        tfTelefoneCliente.setBounds(110, 90, 290, 30);

        lbEmailCliente.setBounds(10, 125, 100, 30);
        tfEmailCliente.setBounds(110, 125, 290, 30);

        btnCancelarAlteracaoCliente.setBounds(200, 480, 100, 30);
        btnSalvarDadosCliente.setBounds(310, 480, 100, 30);
        btnEditarDadosCliente.setBounds(310, 480, 100, 30);

        add(lbNomeCliente);
        add(lbTelefoneCliente);
        add(lbEmailCliente);

        add(tfNomeCliente);
        add(tfEmailCliente);
        add(tfTelefoneCliente);

        add(btnEditarDadosCliente);
        add(btnSalvarDadosCliente);
        add(btnCancelarAlteracaoCliente);


    }
}
