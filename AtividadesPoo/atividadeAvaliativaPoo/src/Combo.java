import java.util.ArrayList;

public class Combo extends Produto{
    private ArrayList<Produto> produtos = new ArrayList<>();
    private double desconto;

    public Combo(String descricao, double preco) {
        super(descricao, preco);
    }

    public void adicionarProdutos(Produto item){
        produtos.add(item);
    }

    public double calcularDesconto(){
        if(produtos.size()==2){
            return 0.05;
        }
        else if(produtos.size()==3){
            return 0.10;
        }
        else if(produtos.size()==4){
            return 0.15;
        }
        else{
            return 0;
        }
    }
    public double calcularPreco(double desconto){
        this.preco= this.preco -desconto*100;
        return this.preco;
    }

    @Override
    public String exibirDetalhes() {
        return "Combo-->" +
                "\ndesconto: " + desconto +
                "\ncodigo: " + codigo +
                "\ndescricao: " + descricao +
                "\npreco: " + preco ;
    }
}
