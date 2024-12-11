public class Lanche extends Produto{

    private double peso;

    Lanche(String descricao, double preco, double peso){
        super(descricao, preco);
        this.peso = peso;

    }
    @Override
    public double calcularPreco(double desconto) {
        this.preco= this.preco -desconto*100;
        return this.preco;
    }

    @Override
    public String exibirDetalhes() {
        return "Lanche-->" +
                "\npeso: " + peso +
                "\ncodigo: " + codigo +
                "\ndescricao: " + descricao +
                "\npreco: " + preco;
    }

}
