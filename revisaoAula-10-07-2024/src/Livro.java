public class Livro extends ItemBiblioteca{

    private String autor;
    private String isbn;

    public Livro(String titulo, double preco, int quantidade, String autor, String isbn){
        super(titulo, preco, quantidade);
        this.autor = autor;
        this.isbn = isbn;
    }

    @Override
    public void setPreco(double preco) {
        super.setPreco(preco);
    }
    @Override
    public double getPreco() {
        return super.getPreco();
    }

    @Override
    public void setQuantidade(int quantidade) {
        super.setQuantidade(quantidade);
    }
    @Override
    public int getQuantidade() {
        return super.getQuantidade();
    }

    @Override

    public String toString() {
        return super.toString()+
                "\nautor='" + autor + '\'' +
                "\nisbn='" + isbn + '\'' +
                "\n}";
    }

    public double calcularValorTotalComDesconto(double percentual){
        return 0.0;
    };
}
