package classes;

import java.util.ArrayList;

public class Pedido {
    Cliente cliente;
    ArrayList<Produto> itens;
    String status="Em andamento";

    public void adicionarItem(Produto item){
        this.itens.add(item);
    }
    public void removerItem(int codigo){
        this.itens.removeIf(p -> p.getCodigo()==codigo);
    }
    public double calcularTotal(){
        double total=0;
        for(Produto p:this.itens){
            total +=p.getPreco();
        }
        return total;
    }
    public void confirmarPedido(){
        this.status ="Concluído";
    }

    public ArrayList<Produto> getItens() {
        return itens;
    }
}
