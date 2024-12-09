public class Bebida extends Produto{

    private double volume;

    Bebida(String descricao, double preco, double volume){
        super(descricao, preco);
        this.volume = volume;
    }
    @Override
    public double calcularPreco(double desconto){
        this.preco= this.preco -desconto*100;
        return this.preco;
    }

    @Override
    public String exibirDetalhes() {
        return "Bebida--->" +
                "\nvolume: " + volume +
                "\ncodigo: " + codigo +
                "\ndescricao: '" + descricao +
                "\npreco: " + preco;
    }
}
