import java.util.ArrayList;

public class Funcionario extends Pessoa {

    /**
     * apesar de poder ter tarefas atribuidas o analista ja pode ser
     * instanciado com uma lista
     */
    public Funcionario(String nome, String email){
        super(nome, email);
    }
    /**
     * MÉTODOS ABSTRATOS
     */

    @Override
    public boolean concluirTarefa(Tarefa tarefa){
        //lógica para concluir apenas as suas tarefas
        if(tarefa.getResponsavel().getId() == this.getId()){
            if(tarefa.getStatus().equals("Não Concluída")){
                tarefa.setStatus("Concluída");
            }else{
                tarefa.setStatus("Não Concluída");
            }
        }
        return true;
    }
    @Override
    public void realizarTarefa(int id) {
        //lógica para poder concluir tarefas mas apenas se for dele
    }


    /**
     * toString
     */

}
