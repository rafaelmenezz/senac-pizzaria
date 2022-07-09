package br.com.pizzaria.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import org.hibernate.Session;

import br.com.pizzaria.dao.ClienteDao;
import br.com.pizzaria.dao.ClienteDaoImpl;
import br.com.pizzaria.dao.HibernateUtil;
import br.com.pizzaria.entidade.Cliente;

public class TabelaPesquisa extends AbstractTableModel {

    private Session session;
    private List<Cliente> clientes;
    private ClienteDao clienteDao;
    private String[] colunas = { "Nome", "Telefone", "Email" };

    public TabelaPesquisa() {
        clientes = new ArrayList<>();
        clienteDao = new ClienteDaoImpl();
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public int getRowCount() {
        return clientes.size();
    }

    @Override
    public Object getValueAt(int linha, int coluna) {

        switch (coluna) {
            case 0:
                return clientes.get(linha).getNome();
                
            case 1:
                return clientes.get(linha).getTelefone();
                
            case 2:
                return clientes.get(linha).getEmail();

            default:
                break;
        }

        return null;
    }

    public void pesquisarClientePorNome(String nome){
        session = HibernateUtil.abrirConexao();
        clientes = clienteDao.pesquisarPorNome(nome, session);
        session.close();

        this.fireTableDataChanged();
    }

    public void limparListaClientes(){
 
        clientes = new ArrayList<>();
        this.fireTableDataChanged();
    }
    public Cliente getCliente(int linha){
        return clientes.get(linha);
    }
}
