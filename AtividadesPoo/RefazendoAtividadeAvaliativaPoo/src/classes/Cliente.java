package classes;

import java.util.ArrayList;

public class Cliente extends Pessoa{
    ArrayList<Pedido> pedidos;

    public void fazerPedido(Pedido pedido){
        pedidos.add(pedido);
    }
    public void cancelarPedido(Pedido pedido){
        pedidos.remove(pedido);

    }
    public String visualizarPedidos(){
        String dados = "";
        for(Pedido p:this.pedidos){
            dados += p.toString();
        }
        return dados;
    }
}
