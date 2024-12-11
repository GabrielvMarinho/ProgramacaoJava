import java.util.ArrayList;

public class GerenciadorDeCardapio {
    private ArrayList<Produto> cardapio = new ArrayList<>();

    public void adicionarProduto(Produto produto){
        produto.setCodigo(cardapio.size());
        cardapio.add(produto);

    }

    public ArrayList<Produto> getCardapio() {
        return cardapio;
    }

    public String getCardapioString() {
        String lista="";
        for(Produto produto:cardapio){
            String add = produto.exibirDetalhes();
            lista = lista+add+"\n\n";
        }
        return lista;
    }

    public void removerProduto(int codigo){
        cardapio.remove(codigo);
    }
    public void editarProduto(int codigo, Produto novoProduto){
        cardapio.set(codigo, novoProduto);
    }
    public ArrayList<Produto> listarProdutos(){
        return cardapio;
    }

}
