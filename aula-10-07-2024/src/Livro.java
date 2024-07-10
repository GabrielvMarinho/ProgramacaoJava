public class Livro extends Item {

    private long isbn;
    private String autor;

    public Livro(String titulo, double preco, int quantidade, long isbn, String autor) {
        super(titulo, preco, quantidade);
        this.isbn = isbn;
        this.autor = autor;
    }

    @Override
    public double calcularValorTotalComDesconto(double percentual) {

        if(autor.equals("Machado de Assis")){
            percentual = 1;
        }
        if(this.getPreco() > 82.5){
            System.out.println(this);
            percentual+=0.05;
        }

        return (this.getPreco()-(this.getPreco() * percentual)) * this.getQuantidade();
    }


    @Override
    public String toString() {
        return super.toString() + "\n"+
                "- isbn: " + isbn + "\n" +
                "- Autor: " + autor;
    }
}
