import java.util.ArrayList;


public class Biblioteca {

    private static ArrayList<Item> acervo = new ArrayList<>();

    public static void adicionarItem(Item item){
        acervo.add(item);
    }

    public static void atualizaritem(int index, Item item){
        acervo.set(index, item);
    }

    public static void removerItem(int index){
        acervo.remove(index);
    }

    public static void listarItens(){
        for(Item item:acervo){
            System.out.println(item);
        }
    }

    public static Item buscarItemPorTitulo(String titulo){
        for(Item item:acervo){
            if(item.getTitulo().equals(titulo)){
                return item;
            }
        }
        return null;
    }

    public static double calcularValorTotalEstoque(){
        double valorTotal=0;
        for(Item item:acervo){
            valorTotal += item.getPreco()*item.getQuantidade();
        };
        return valorTotal;

    }

}
