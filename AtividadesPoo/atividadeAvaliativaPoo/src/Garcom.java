import java.util.ArrayList;

public class Garcom extends Pessoa{
    private double pagamento;

    Garcom(String nome, String endereco, String telefone, double pagamento){
        super(nome, endereco, telefone);
        this.pagamento = pagamento;
    }
    public void cadastrarPedido(Cliente cliente, Pedido pedido){
        cliente.fazerPedido(pedido);
    }
    public String exibirMenu(GerenciadorDeCardapio cardapio){
        return cardapio.getCardapioString();
    }

    public void adicionarItemAoPedido(Pedido pedido, Produto item){
        pedido.adicionarItem(item);
    }
    public void removerItemAoPedido(Pedido pedido, int codigo){
        pedido.removerItem(codigo);
    }
    public void confirmarPedido(Pedido pedido){
        pedido.confirmarPedido();
    }
    public double calcularPagamento(Pedido pedido){
        return pedido.calcularTotal();
    }





}
