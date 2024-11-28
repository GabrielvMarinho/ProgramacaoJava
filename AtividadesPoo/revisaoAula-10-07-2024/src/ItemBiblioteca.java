public abstract class ItemBiblioteca {

    private String titulo;
    private double preco;
    private int quantidade;

    public ItemBiblioteca(String titulo, double preco, int quantidade){
        this.titulo = titulo;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public void setPreco(double preco) { this.preco = preco; }
    public double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return "ItemBiblioteca{" +
                "\ntitulo='" + this.titulo + '\'' +
                "\npreco=" + this.preco +
                "\nquantidade=" + this.quantidade;
    }

    public abstract double calcularValorTotalComDesconto(double percentual);

}
