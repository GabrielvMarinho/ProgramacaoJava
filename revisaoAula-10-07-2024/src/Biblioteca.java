import java.util.ArrayList;

public class Biblioteca {

    static ArrayList<ItemBiblioteca> lista = new ArrayList<>();

    public static void adicionarItem(ItemBiblioteca item){
        lista.add(item);
    }
    public static void atualizarItem(int index, ItemBiblioteca item){
        lista.set(index, item);
    }
    public static void removerItem(int index){
        lista.remove(index);
    }
    public static void listarItens(){
        for(ItemBiblioteca item:lista){
            System.out.println(item.toString());
        }
    }
    public static ItemBiblioteca buscarItemPorTitulo(String titulo){
        for(ItemBiblioteca item:lista){
            if(item.getTitulo().equals(titulo)){
                return item;
            }

        }
        return null;


    }
    public static double calcularTotalEstoque(){
        return 0.0;
    }


}
