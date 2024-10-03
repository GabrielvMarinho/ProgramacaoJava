import java.util.ArrayList;

public class Gerente extends Pessoa {


    private ArrayList<Pessoa> listaFuncionario = new ArrayList<>();

    /**
     * o construtor do gerente não possui lista de tarefas no contrutor por que
     * a logica do sistema é que o próprio gerente crie as tarefas e atribua
     * a si mesmo se necessário
     */
    public Gerente(String nome, String email, ArrayList<Pessoa> listaFuncionarios){
        super(nome, email);
        this.listaFuncionario = listaFuncionarios;
    }
    public Gerente(String nome, String email){
        super(nome, email);
    }

    public void addTarefa(Tarefa tarefa){
        GerenciadorEmpresa.addTarefa(tarefa);
    }
    public ArrayList<Tarefa> getTarefasFuncionarioEspecifico(Pessoa usuario_logado, Pessoa funcionario) {
        //lógica para buscar as tarefas baseado em um funcionario específico
        return null;
    }
    public ArrayList<Tarefa> getTarefasEquipe(Pessoa usuario_logado) {
        //lógica para retornar lista com todas as tarefas(gerente e funcionarios
        return null;
    }


    /**
     * GETTERS E SETTERS
     */
    public ArrayList<Pessoa> getlistaFuncionarios() {
        return this.listaFuncionario;
    }
    public void setlistaFuncionarios(ArrayList<Pessoa> listaFuncionarios) {
        this.listaFuncionario = listaFuncionarios;
    }
    public void addFuncionario(Pessoa func){
        this.listaFuncionario.add(func);

    }


    /**
     * MÉTODOS ABSTRATOS
     */



    @Override
    public void realizarTarefa(int id) {
        //lógica para poder concluir tarefas se for dele ou de qualquer um de seus funcionarios

    }
}
