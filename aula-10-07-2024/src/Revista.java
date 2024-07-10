public class Revista extends Item{

    private int edicao;

    public Revista(String titulo, double preco, int quantidade, int edicao){
        super(titulo, preco, quantidade);
        this.edicao = edicao;
    }

    @Override
    public double calcularValorTotalComDesconto(double percentual) {
        int quantidade = this.getQuantidade();

        if(quantidade > 10){
            quantidade--;
        }
        if (edicao <=3){
            percentual -=0.1;
        }
        return (this.getPreco()-(this.getPreco() * percentual)) * quantidade;
    }

    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }

    public int getEdicao() {
        return edicao;
    }

    @Override
    public String toString() {
        return super.toString() +"\n"+
                "- Edição: " + edicao;
    }
}