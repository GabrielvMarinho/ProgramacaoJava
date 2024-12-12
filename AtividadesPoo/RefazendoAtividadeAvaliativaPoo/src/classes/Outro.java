package classes;

public class Outro extends Produto{
    String tamanho;

    public Outro(String descricao, double preco, String tamanho) {
        super(descricao, preco);
        this.tamanho = tamanho;
    }

    public double calcularPreco(double desconto){
        this.preco = this.preco*desconto;
        return this.preco;
    }


    public String exibirDetalhes() {
        return "Outro{" +
                "tamanho='" + tamanho + '\'' +
                ", codigo=" + codigo +
                ", descricao='" + descricao + '\'' +
                ", preco=" + preco +
                '}';
    }


}
