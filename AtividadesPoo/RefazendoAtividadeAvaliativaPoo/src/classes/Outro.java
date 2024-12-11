package classes;

public class Outro extends Produto{
    String tamanho;

    public Outro(String descricao, double preco, String tamanho) {
        super(descricao, preco);
        this.tamanho = tamanho;
    }

    public double calcularPreco(double descontro){
        //logica de desconto do outro
        return 0;
    }
    public String exibirDetalhes(){
        //logica de exibir detalhes do outro
        return "";
    }
}
