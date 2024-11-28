public abstract class Item {

    String titulo;
    double preco;
    int quantidade;

    public Item(String titulo, double preco, int quantidade) {
        this.titulo = titulo;
        this.preco = preco;
        this.quantidade = quantidade;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }
    public double getPreco() {
        return preco;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getTitulo() {
        return titulo;
    }

    @Override
    public String toString() {
        return "Título: " + titulo + '\n' +
                "- preco: " + preco + '\n' +
                "- quantidade: " + quantidade ;
    }

    public abstract double calcularValorTotalComDesconto(double percentual);

}