public abstract class Produto {

    int codigo;
    String descricao;
    double preco;

    public String getDescricao() {
        return descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public Produto(String descricao, double preco){
        this.descricao=descricao;
        this.preco=preco;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getPreco() {
        return preco;
    }


    public abstract double calcularPreco(double desconto);

    public abstract String exibirDetalhes();

}
