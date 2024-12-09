package classes;

public class Lanche extends Produto{
    double peso;

    public Lanche(String descricao, double preco, double peso) {
        super(descricao, preco);
        this.peso = peso;
    }

    public double calcularPreco(double desconto){
        this.preco = this.preco*desconto;
        return this.preco;
    }
    public String exibirDetalhes(){
        return "Lanche{" +
                "codigo=" + codigo +
                ", descricao='" + descricao +
                ", preco=" + preco +
                ", peso=" + peso +
                '}';
    }


}
