import java.util.ArrayList;

public class GerenciadorEmpresa {
    static private ArrayList<Pessoa> listaPessoas = new ArrayList<>();


    public static ArrayList<Pessoa> getListaPessoas() {
        return listaPessoas;
    }

    public static void addPessoa(Pessoa pessoa){
        listaPessoas.add(pessoa);
    }
    public static void setListaPessoas(ArrayList<Pessoa> lista) {
        listaPessoas = lista;
    }
}
