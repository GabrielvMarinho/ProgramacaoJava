public class Revista extends ItemBiblioteca{

    private int edicao;

    public Revista(String titulo, double preco, int quantidade, int edicao ){
        super(titulo, preco, quantidade);
        this.edicao = edicao;
    }

    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }

    public int getEdicao() {
        return edicao;
    }

    public double calcularValorTotalComDesconto(double percentual){
        return 0.0;
    }

    @Override
    public String toString() {
        return super.toString()+
                "\nedicao=" + edicao+
                "\n}";
    }
}
