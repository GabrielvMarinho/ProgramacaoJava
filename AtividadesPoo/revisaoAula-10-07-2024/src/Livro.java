public class Livro extends ItemBiblioteca{

    private String autor;
    private String isbn;

    public Livro(String titulo, double preco, int quantidade, String autor, String isbn){
        super(titulo, preco, quantidade);
        this.autor = autor;
        this.isbn = isbn;
    }


    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getAutor() {
        return autor;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }

    @Override
    public String toString() {
        return super.toString()+
                "\nautor='" + this.autor + '\'' +
                "\nisbn='" + this.isbn + '\'' +
                "\n}";
    }

    @Override
    public double calcularValorTotalComDesconto(double percentual) {
        return 0.0;
    }
}
