import java.util.ArrayList;

public class Funcionario extends Pessoa {

    /**
     * apesar de poder ter tarefas atribuidas o analista ja pode ser
     * instanciado com uma lista
     */
    public Funcionario(String nome, String email, ArrayList<Tarefa>listaTarefas){
        super(nome, email);
        this.listaTarefas = listaTarefas;
    }
    public Funcionario(String nome, String email){
        super(nome, email);
    }
    /**
     * MÉTODOS ABSTRATOS
     */
    @Override
    public ArrayList<Tarefa> retornarListaTarefas() {
        return this.listaTarefas;
    }

    @Override
    public void realizarTarefa(int id) {
        this.listaTarefas.remove(id);
    }
}
