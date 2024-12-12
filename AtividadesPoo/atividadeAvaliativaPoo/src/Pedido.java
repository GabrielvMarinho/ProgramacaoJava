import java.util.ArrayList;

public class Pedido {

    private Cliente cliente;
    private ArrayList<Produto> itens = new ArrayList<>();
    private String status="Em andamento";

    public String listarItens(){
        String lista="";
        for(Produto produto:itens){
            String add = produto.exibirDetalhes();
            lista = lista+add;
        }
        return lista;
    }
    public ArrayList<Produto> getItens() {
        return itens;
    }

    public String getStatus() {
        return status;
    }


    public void adicionarItem(Produto item){
        itens.add(item);
    }

    public void removerItem(int codigo){
        itens.remove(codigo);
    }
    public double calcularTotal(){
        double tot=0;
        for(Produto produto:itens){
            tot=+produto.getPreco();
        }
        return tot;
    }
    public void confirmarPedido(){
        this.status = "Confirmado";
    }

}
