public class Outro extends Produto{

    private String tamanho;

    Outro(String descricao, double preco, double peso){
        super(descricao, preco);
        this.tamanho = tamanho;
    }

    @Override
    public double calcularPreco(double desconto){
        return 0;
    }

    @Override
    public String exibirDetalhes() {
        return "Outro{" +
                "tamanho='" + tamanho + '\'' +
                ", codigo=" + codigo +
                ", descricao='" + descricao + '\'' +
                ", preco=" + preco +
                '}';
    }

}
