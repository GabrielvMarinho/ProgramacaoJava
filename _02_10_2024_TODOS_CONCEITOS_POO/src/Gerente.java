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
    public ArrayList<Tarefa> getTarefasFuncionarioEspecifico(Pessoa funcionario) {
        ArrayList<Tarefa> lista = new ArrayList<>();
        for(Tarefa tarefa:GerenciadorEmpresa.getListaTarefas()){
            if(tarefa.getResponsavel()==funcionario) {

                lista.add(tarefa);
            }
        }
        return lista;
    }

    public void concluirTarefa(Tarefa tarefa, Pessoa usuario_logado){
        if(tarefa.getResponsavel().getId()==usuario_logado.getId()){
            if(tarefa.getStatus().equals("Não Concluída")){
                tarefa.setStatus("Concluída");
            }else{
                tarefa.setStatus("Não Concluída");
            }
        }
    }
    public boolean concluirTarefa(Tarefa tarefa){
            //lógica para concluir só da sua equipe
        boolean achou = false;
        for(Pessoa funcionario:this.getlistaFuncionarios()){
            if(tarefa.getResponsavel()==funcionario){
                achou = true;
            }

        }
        if(achou){
            if(tarefa.getStatus().equals("Não Concluída")){
                tarefa.setStatus("Concluída");
            }else{
                tarefa.setStatus("Não Concluída");
            }
            return true;
        }

        return false;


    }

    public ArrayList<Tarefa> getTarefasEquipe() {
        //lógica para retornar lista com todas as tarefas(gerente e funcionarios

        ArrayList<Tarefa> lista = new ArrayList<>();
        for(Tarefa tarefa:GerenciadorEmpresa.getListaTarefas()){
            for(Pessoa pessoa:this.getlistaFuncionarios()){
                if(pessoa.getId()==tarefa.getResponsavel().getId())
                    lista.add(tarefa);
            }

        }
        return lista;
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
