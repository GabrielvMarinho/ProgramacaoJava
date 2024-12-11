package classes;

public class Garcom extends Pessoa{

    double pagamento;

    public void cadastrarPedido(Cliente cliente, Pedido pedido){

    }

    public String exibirMenu(){
        return "";
    }
    public void adicionarItemAoPedido(Pedido pedido, Produto item){}

    public void removerItemDoPedido(Pedido pedido, int codigo){
        pedido.removerItem(codigo);
    }

    public void confirmarPedido(Pedido pedido){
        this.pagamento = this.pagamento*1.05;
    }

    public double calcularPagamento(Pedido pedido){
        return pedido.calcularTotal();
    }





}
