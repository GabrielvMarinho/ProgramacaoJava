import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Scanner sc = new Scanner(System.in);
    static GerenciadorEmpresa gerenciador;

    public static void main(String[] args) {

        //criando dados pré setados para facilitar compreensão e teste
        criarDados();
        //pegando o usuário logando
        Pessoa usuario_logado = login();
        // testando se é um gerente ou funcionario comum
        if(usuario_logado instanceof Funcionario){

        }else if(usuario_logado instanceof Gerente){

        }else{
            System.out.println("tipo de usuário não existente");
        }
    }



    /**
     * funções para criar os gerentes e funcionario
     */
    public static void criarDados(){
        ArrayList<Funcionario> listaFunc = new ArrayList();
        Pessoa func1 = new Funcionario("joão", "joao@gmail.com");
        Pessoa gerente = new Gerente("maria", "maria@gmail.com", listaFunc);
        gerenciador.addPessoa(gerente);
        gerenciador.addPessoa(func1);
    }
    /**
     * lógica para o login
     */
    public static Pessoa login(){
        System.out.println("Digite seu email: ");
        String email = sc.next();
        System.out.println("Digite sua senha (email por padrão): ");
        String senha = sc.next();
        for( Pessoa pessoa:gerenciador.getListaPessoas()){
            if(pessoa.getEmail().equals(email) && pessoa.getEmail().equals(senha)){
                return pessoa;
            }
        }
        return null;
    }
}