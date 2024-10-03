import java.util.ArrayList;

public abstract class Pessoa {

    private static int geradorId=0;

    private int id;
    private String nome;
    private String email;
    public ArrayList<Tarefa> listaTarefas = new ArrayList<>();

    public Pessoa(String nome, String email){
        this.id = geradorId;
        geradorId++;
        this.nome = nome;
        this.email = email;
    }





    /**
     * GETTERS E SETTERS
     */

    public int getId() {
        return id;
    }
    public ArrayList<Tarefa> getListaTarefas() {
        return listaTarefas;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setListaTarefas(ArrayList<Tarefa> listaTarefas) {
        this.listaTarefas = listaTarefas;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * MÉTODOS ABSTRATOS
     *
     */
    public abstract ArrayList<Tarefa> retornarListaTarefas();
    public abstract void realizarTarefa(int id);



}
