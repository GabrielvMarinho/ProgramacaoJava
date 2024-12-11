package classes;

public abstract class Produto {
    int codigo;
    String descricao;
    double preco;

    public Produto(String descricao, double preco){
        this.codigo = (int) System.currentTimeMillis();
        this.descricao = descricao;
        this.preco = preco;
    }
    public abstract double calcularPreco(double desconto);

    public abstract String exibirDetalhes();

    public double getPreco() {
        return preco;
    }

    public int getCodigo() {
        return codigo;
    }
}
