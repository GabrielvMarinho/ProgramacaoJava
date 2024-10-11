import java.util.ArrayList;

public class GerenciadorEmpresa {
    static private ArrayList<Pessoa> listaPessoas = new ArrayList<>();
    static private ArrayList<Tarefa> listaTarefas = new ArrayList<>();


    public static ArrayList<Tarefa> getListaTarefas() {
        return listaTarefas;
    }

    public static ArrayList<Pessoa> getListaPessoas() {
        return listaPessoas;
    }
    public static void addTarefa(Tarefa tarefa){
        listaTarefas.add(tarefa);
    }
    public static void addPessoa(Pessoa pessoa){
        listaPessoas.add(pessoa);
    }

}
