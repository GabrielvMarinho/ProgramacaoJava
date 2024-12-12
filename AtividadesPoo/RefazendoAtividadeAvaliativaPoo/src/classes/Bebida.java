package classes;

public class Bebida extends Produto{
    double volume;

    public Bebida(String descricao, double preco,double volume) {
        super(descricao, preco);
        this.volume = volume;
    }


    public double calcularPreco(double desconto){
        this.preco = this.preco*desconto;
        return this.preco;
    }


    public String exibirDetalhes() {
        return "Bebida{" +
                "volume=" + volume +
                ", codigo=" + codigo +
                ", descricao='" + descricao + '\'' +
                ", preco=" + preco +
                '}';
    }

}
