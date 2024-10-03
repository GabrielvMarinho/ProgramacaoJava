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
    public void realizarTarefa(int id) {
        //lógica para poder concluir tarefas mas apenas se for dele
    }


    /**
     * toString
     */

}
