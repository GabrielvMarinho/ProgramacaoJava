package classes;

import java.util.ArrayList;

public class Combo extends Produto{
    ArrayList<Produto> produtos;
    double desconto;

    public Combo(String descricao, double preco, ArrayList<Produto> produtos){

        super(descricao, preco);
        this.produtos = produtos;

        if(this.produtos.size()>=4){
            this.desconto= 0.15;
        }else if(this.produtos.size()==3){
            this.desconto= 0.1;
        }else{
            this.desconto= 0.05;
        }
    }


    public double calcularPreco(){
        return this.preco-(this.preco*this.desconto);
    }

    public double calcularPreco(double desconto) {
        this.preco = this.preco*desconto;
        return this.preco;
    }


    public String exibirDetalhes() {
        return "Combo{" +
                "produtos=" + produtos +
                ", desconto=" + desconto +
                ", codigo=" + codigo +
                ", descricao='" + descricao + '\'' +
                ", preco=" + preco +
                '}';
    }
}
