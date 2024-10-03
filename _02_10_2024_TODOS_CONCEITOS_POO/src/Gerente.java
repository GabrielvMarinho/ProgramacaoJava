import java.util.ArrayList;

public class Gerente extends Pessoa {


    private ArrayList<Funcionario> listaAnalistas = new ArrayList<>();

    /**
     * o construtor do gerente não possui lista de tarefas no contrutor por que
     * a logica do sistema é que o próprio gerente crie as tarefas e atribua
     * a si mesmo se necessário
     */
    public Gerente(String nome, String email, ArrayList<Funcionario> listaFuncionarios){
        super(nome, email);
        this.listaAnalistas = listaFuncionarios;
    }
    public String addTarefa(int idAnalista, Tarefa tarefa){
        for(Funcionario funcionario :this.getListaAnalistas() ){
        }
        return "cadastrado com sucesso";
    }

    /**
     * GETTERS E SETTERS
     */
    public ArrayList<Funcionario> getListaAnalistas() {
        return listaAnalistas;
    }
    public void setListaAnalistas(ArrayList<Funcionario> listaFuncionarios) {
        this.listaAnalistas = listaFuncionarios;
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
