package br.com.pizzaria.tela;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.hibernate.HibernateException;

import br.com.pizzaria.controller.ClienteController;
import br.com.pizzaria.entidade.Cliente;
import br.com.pizzaria.entidade.Endereco;
import br.com.pizzaria.entidade.EnderecoDTO;
import br.com.pizzaria.model.ModeloTabelaCliente;
import br.com.pizzaria.webservice.CepRest;

public class FrameCliente extends JFrame {

    private Cliente cliente;
    private ModeloTabelaCliente tbPesquisa;

    private JLabel lbNomeCliente, lbEmailCliente, lbTelefoneCliente, lbLogradouro, lbBairro,
            lbNumero, lbCidade, lbEstado, lbComplemento, lbCep, lbObservacao;

    private JTextField tfNomeCliente, tfEmailCliente, tfLogradouro, tfBairro,
            tfNumero, tfCidade, tfEstado, tfComplemento;

    private JButton btnEditarDadosCliente, btnSalvarDadosCliente, btnCancelarAlteracaoCliente,
            btnBuscarCep;

    private JFormattedTextField tfTelefone, tfCep;

    private JTextArea taObservao;

    private ClienteController clienteCTRL;
    private Endereco endereco;

    public FrameCliente(Cliente cliente, ModeloTabelaCliente tbPesquisa) {
        this.cliente = cliente;
        initComponents();
        visualizarDadosClientes(cliente);
        this.tbPesquisa = tbPesquisa;
        editarCliente(false);
    }

    public FrameCliente(ModeloTabelaCliente tbPesquisa) {
        cliente = new Cliente();
        this.tbPesquisa = tbPesquisa;
        initComponents();
        editarCliente(true);
    }

    private void initComponents() {
        setSize(600, 480); // define o tamanho do Frame
        setLayout(null); // Método que permite manipular as posições dos componentes em tela
        setLocationRelativeTo(null); // método que centraliza a aplicação no centro da tela
        setResizable(false);
        setTitle("Dados do Cliente");

        clienteCTRL = new ClienteController();
        endereco = new Endereco();

        lbNomeCliente = new JLabel("Nome: ");
        lbTelefoneCliente = new JLabel("Telefone: ");
        lbEmailCliente = new JLabel("Email: ");
        lbLogradouro = new JLabel("Logradouro: ");
        lbCep = new JLabel("CEP: ");
        lbBairro = new JLabel("Bairro: ");
        lbNumero = new JLabel("Numero: ");
        lbCidade = new JLabel("Cidade: ");
        lbEstado = new JLabel("UF: ");
        lbComplemento = new JLabel("Complemento: ");
        lbObservacao = new JLabel("Observação: ");

        tfNomeCliente = new JTextField();
        tfEmailCliente = new JTextField();
        tfLogradouro = new JTextField();
        tfBairro = new JTextField();
        tfNumero = new JTextField();
        tfCidade = new JTextField();
        tfEstado = new JTextField();
        tfComplemento = new JTextField();

        taObservao = new JTextArea();

        tfTelefone = new JFormattedTextField();
        tfCep = new JFormattedTextField();

        btnEditarDadosCliente = new JButton("Editar");
        btnSalvarDadosCliente = new JButton("Salvar");
        btnCancelarAlteracaoCliente = new JButton("Cancelar");
        btnBuscarCep = new JButton("Buscar");

        try {
            tfTelefone.setFormatterFactory(
                    new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
            tfCep.setFormatterFactory(
                    new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        lbNomeCliente.setBounds(10, 25, 100, 30);
        tfNomeCliente.setBounds(110, 25, 480, 30);

        lbTelefoneCliente.setBounds(10, 60, 100, 30);
        tfTelefone.setBounds(110, 60, 480, 30);

        lbEmailCliente.setBounds(10, 95, 100, 30);
        tfEmailCliente.setBounds(110, 95, 480, 30);

        lbLogradouro.setBounds(10, 165, 100, 30);
        tfLogradouro.setBounds(110, 165, 280, 30);
        lbNumero.setBounds(400, 165, 100, 30);
        tfNumero.setBounds(465, 165, 125, 30);

        lbBairro.setBounds(10, 200, 100, 30);
        tfBairro.setBounds(110, 200, 150, 30);
        lbCidade.setBounds(270, 200, 80, 30);
        tfCidade.setBounds(330, 200, 130, 30);
        lbEstado.setBounds(480, 200, 50, 30);
        tfEstado.setBounds(530, 200, 60, 30);

        lbComplemento.setBounds(10, 235, 100, 30);
        tfComplemento.setBounds(110, 235, 480, 30);

        lbObservacao.setBounds(10, 275, 100, 30);
        taObservao.setBounds(110, 275, 480, 90);

        btnEditarDadosCliente.setBounds(490, 400, 100, 30);

        btnCancelarAlteracaoCliente.setBounds(380, 400, 100, 30);
        btnSalvarDadosCliente.setBounds(490, 400, 100, 30);

        add(lbNomeCliente);
        add(lbTelefoneCliente);
        add(lbEmailCliente);
        add(tfNomeCliente);
        add(tfEmailCliente);
        add(tfTelefone);
        add(btnEditarDadosCliente);
        add(btnSalvarDadosCliente);
        add(btnCancelarAlteracaoCliente);
        add(lbCep);
        add(tfCep);
        add(btnBuscarCep);
        add(lbLogradouro);
        add(tfLogradouro);
        add(lbNumero);
        add(tfNumero);
        add(lbBairro);
        add(tfBairro);
        add(lbCidade);
        add(tfCidade);
        add(lbEstado);
        add(tfEstado);
        add(lbComplemento);
        add(tfComplemento);
        add(lbObservacao);
        add(taObservao);

        eventos();
    }

    private boolean validarFormulario() {
        String nome = tfNomeCliente.getText().trim();
        if (verificarCampoMaior2(nome)) {
            JOptionPane.showMessageDialog(null, "O nome tem que ter "
                    + "pelo menos 3 letras");
            return false;
        }
        String email = tfEmailCliente.getText().trim();
        if (verificarEmail(email)) {
            JOptionPane.showMessageDialog(null, "Digite um e-mail correto!");
            return false;
        }

        String telefone = tfTelefone.getText().trim();
        if (verificarTelefone(telefone)) {
            JOptionPane.showMessageDialog(null, "Digite um telefone correto!");
            return false;
        }

        // esse return tem que ser a ultima linha do metodo
        return true;
    }

    private boolean verificarCampoMaior2(String campo) {
        return campo.length() < 3;
    }

    private boolean verificarEmail(String email) {
        return !email.contains("@") && !email.contains(".");
    }

    private boolean verificarTelefone(String telefone) {
        return telefone.length() == 10;
    }

    public void editarCliente(Boolean editar) {
        btnCancelarAlteracaoCliente.setVisible(editar);
        btnSalvarDadosCliente.setVisible(editar);
        btnEditarDadosCliente.setVisible(!editar);
        habilitarEdicao(editar);

        if (editar) {
            lbCep.setBounds(10, 130, 100, 30);
            tfCep.setBounds(110, 130, 350, 30);
            btnBuscarCep.setBounds(465, 130, 125, 30);
        } else {
            lbCep.setBounds(10, 130, 100, 30);
            tfCep.setBounds(110, 130, 480, 30);
        }

    }

    private void visualizarDadosClientes(Cliente cliente) {

        tfNomeCliente.setText(cliente.getNome());
        tfEmailCliente.setText(cliente.getEmail());
        tfTelefone.setText(cliente.getTelefone());
        tfCep.setText(cliente.getEnderecos().get(0).getCep());
        tfLogradouro.setText(cliente.getEnderecos().get(0).getLogradouro());
        tfBairro.setText(cliente.getEnderecos().get(0).getBairro());
        tfNumero.setText(cliente.getEnderecos().get(0).getNumero());
        tfCidade.setText(cliente.getEnderecos().get(0).getCidade());
        tfEstado.setText(cliente.getEnderecos().get(0).getEstado());
        tfComplemento.setText(cliente.getEnderecos().get(0).getComplemento());
        taObservao.setText(cliente.getEnderecos().get(0).getObservacao());

        habilitarEdicao(false);

    }

    private void habilitarEdicao(Boolean editar) {

        tfNomeCliente.setEditable(editar);
        tfEmailCliente.setEditable(editar);
        tfTelefone.setEditable(editar);
        tfCep.setEditable(editar);
        tfLogradouro.setEditable(editar);
        tfBairro.setEditable(editar);
        tfNumero.setEditable(editar);
        tfCidade.setEditable(editar);
        tfEstado.setEditable(editar);
        tfComplemento.setEditable(editar);
        taObservao.setEditable(editar);
    }

    private Cliente carregarCliente() {
        cliente.setNome(tfNomeCliente.getText().trim());
        cliente.setEmail(tfEmailCliente.getText().trim());
        cliente.setTelefone(tfTelefone.getText().trim());

        List<Endereco> enderecos = new ArrayList<>();

        endereco.setLogradouro(tfLogradouro.getText().trim());
        endereco.setBairro(tfBairro.getText().trim());
        endereco.setCep(tfCep.getText().trim());
        endereco.setCidade(tfCidade.getText().trim());
        endereco.setEstado(tfEstado.getText().trim());
        endereco.setNumero(tfNumero.getText().trim());
        endereco.setComplemento(tfComplemento.getText().trim());
        endereco.setObservacao(taObservao.getText().trim());

        enderecos.add(endereco);
        endereco.setPessoa(cliente);
        cliente.setEnderecos(enderecos);

        return cliente;
    }

    private void eventos() {
        btnEditarDadosCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarCliente(true);
            }
        });
        btnCancelarAlteracaoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarCliente(false);
                dispose();
            }
        });
        btnCancelarAlteracaoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarCliente(false);
            }
        });
        btnBuscarCep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CepRest cepRest = new CepRest();
                EnderecoDTO enderecoDTO = cepRest.pesquisarCep(tfCep.getText());
                if (enderecoDTO == null) {
                    JOptionPane.showMessageDialog(null, "CEP não encontrado!");
                } else {
                    tfLogradouro.setText(enderecoDTO.getLogradouro());
                    tfBairro.setText(enderecoDTO.getBairro());
                    tfCidade.setText(enderecoDTO.getLocalidade());
                    tfEstado.setToolTipText(enderecoDTO.getUf());

                }
            }
        });
        btnSalvarDadosCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (validarFormulario()) {
                    Cliente cliente = carregarCliente();
                    try {
                        clienteCTRL.salvarCliente(cliente);
                    } catch (HibernateException e) {
                        JOptionPane.showMessageDialog(null, "Erro ao salvar!!");
                    }
                    JOptionPane.showMessageDialog(null, "Salvo com sucesso!!");
                    tbPesquisa.limparListaClientes();
                    dispose();
                }
            }
        });

    }
}
