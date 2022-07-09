
package br.com.pizzaria.entidade;

import java.util.List;
import javax.persistence.*;


@Entity
@Table(name = "cliente")
@PrimaryKeyJoinColumn(name = "id_pessoa")
public class Cliente extends Pessoa{
    
    private boolean cupom;
    
    @OneToMany(mappedBy = "cliente",cascade = CascadeType.ALL)
    private List<Pedido> pedidos;

    public Cliente() {
    }
    
    public Cliente(String nome, String email, String telefone, 
                                                      boolean cupom) {
        super(nome, email, telefone);
        this.cupom = cupom;
    }

    public boolean isCupom() {
        return cupom;
    }

    public void setCupom(boolean cupom) {
        this.cupom = cupom;
    }   

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
    
}
