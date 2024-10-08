import java.util.ArrayList;

public abstract class Pessoa {

    private static int geradorId=0;

    private int id;
    private String nome;
    private String email;

    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                '}';
    }


    public Pessoa(String nome, String email){
        this.id = geradorId;
        geradorId++;
        this.nome = nome;
        this.email = email;
    }





    /**
     * GETTERS E SETTERS
     */


    public ArrayList<Tarefa> getTarefas(Pessoa usuario_logado) {
        //instanciando uma lista de tarefas
        ArrayList<Tarefa> listaTarefas = new ArrayList<Tarefa>();
        //passando por todas as tarefas salvas e adicionando na lista criada
        for(Tarefa tarefa:GerenciadorEmpresa.getListaTarefas()){
            if(tarefa.getResponsavel()==usuario_logado)
                listaTarefas.add(tarefa);
        }
        return listaTarefas;
    }
    public int getId() {
        return id;
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

    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * MÉTODOS ABSTRATOS
     *
     */

    public abstract void realizarTarefa(int id);

    public abstract boolean concluirTarefa(Tarefa tarefa);

}
