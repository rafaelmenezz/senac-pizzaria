package br.com.pizzaria.model;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import org.hibernate.Session;

import br.com.pizzaria.dao.HibernateUtil;
import br.com.pizzaria.dao.PedidoDao;
import br.com.pizzaria.dao.PedidoDaoImpl;
import br.com.pizzaria.entidade.Pedido;

public class ModeloTabelaPedido extends AbstractTableModel {

    private Session session;
    private List<Pedido> pedidos;
    private PedidoDao pedidoDao;
    private String[] colunas = {"Cliente", "Telefone", "Numero", "Valor Total", "Data"};

    public ModeloTabelaPedido(){
        pedidos = new ArrayList<>();
        pedidoDao = new PedidoDaoImpl();
    }

    @Override
    public String getColumnName(int column){
        return colunas[column];
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public int getRowCount() {
        return pedidos.size();
    }

    @Override
    public Object getValueAt(int linha, int coluna) {


            switch (coluna) {
                case 0:
                    return pedidos.get(linha).getCliente().getNome();
                    
                case 1:
                    return pedidos.get(linha).getCliente().getTelefone();
                    
                case 2:
                    return pedidos.get(linha).getNumero();

                case 3:
                    return NumberFormat.getCurrencyInstance().format(pedidos.get(linha).getValor_total());
                
                case 4:
                    return pedidos.get(linha).getDt_pedido();
                
                default:
                    break;
        }

        return null;
    }

    public void pesquisarPedido(int numero){

        session = HibernateUtil.abrirConexao();
        pedidos = pedidoDao.pesquisarPorNumero(numero, session);
        session.close();
        fireTableDataChanged();
    }

    public void limparListaPedido(){
        pedidos = new ArrayList<>();
        fireTableDataChanged();
    }

    public Pedido getPedido(int linha){
        return pedidos.get(linha);
    }

    public void listarPedidos(List<Pedido> pedidos){
        this.pedidos = pedidos;
        fireTableDataChanged();
    }
    
}
