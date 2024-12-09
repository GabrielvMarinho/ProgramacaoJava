import java.util.ArrayList;

public class Cliente extends Pessoa{

    private ArrayList<Pedido> pedidos = new ArrayList<>();

    public Cliente(String nome, String endereco, String telefone){
        super(nome, endereco, telefone);
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    @Override
    public String toString() {
        return "Cliente-->" +
                "\nnome: " + nome +
                "\nendereco: " + endereco +
                "\ntelefone: " + telefone;
    }

    public void fazerPedido(Pedido pedido){
        pedidos.add(pedido);
    }
    public void cancelarPedido(Pedido pedido){
        pedidos.remove(pedido);
    }
    public String visualizarPedidos(){
        String lista="";
        for(Pedido pedido:pedidos){
            String add=pedido.getStatus()+pedido.listarItens();
            lista = lista+add;
        }
        return lista;

    }



}
