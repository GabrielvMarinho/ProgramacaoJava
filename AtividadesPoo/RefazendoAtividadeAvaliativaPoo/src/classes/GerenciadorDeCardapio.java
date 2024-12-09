package classes;

import java.util.ArrayList;

public class GerenciadorDeCardapio {
    ArrayList<Produto> cardapio;

    public void adicionarProduto(Produto produto){
        this.cardapio.add(produto);
    }

    public void removerProduto(int codigo){
        this.cardapio.removeIf(p -> p.getCodigo()==codigo);
    }

    public void editarProduto(int codigo, Produto novoProduto){

    }

    public ArrayList<Produto> listarProdutos(){
        return null;
    }

}
