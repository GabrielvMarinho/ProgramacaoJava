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

        while(true) {

            //pegando o usuário logando
            Pessoa usuario_logado = login();
            // testando se é um gerente ou funcionario comum
            if (usuario_logado instanceof Funcionario) {
                int escolha = 99;
                do {
                    System.out.println("[ 0 ] listar minhas tarefas\n");
                    escolha = sc.nextInt();

                    if(escolha==0){
                        System.out.println("SUAS TAREFAS ->");
                        for (Tarefa tarefa : usuario_logado.getTarefas(usuario_logado)) {
                            System.out.println(tarefa.toString());
                        }
                    }
                }while(escolha!=99);
            }

            else if (usuario_logado instanceof Gerente) {

                int escolha = 999;
                do {
                    System.out.println("[ 0 ] listar funcionarios\n");
                    System.out.println("[ 1 ] adicionar uma tarefa pessoal\n");
                    System.out.println("[ 2 ] listar minhas tarefas pessoais\n");
                    System.out.println("[ 3 ] adicionar uma tarefa para um funcionário\n");
                    System.out.println("[ 4 ] listar tarefas equipe inteira\n");

                    System.out.println("[ 99 ] sair\n");
                    escolha = sc.nextInt();


                    if (escolha == 0) {
                        //iterar sobre todas as pessoas da lista de funcionários
                        int cont = 1;
                        for (Pessoa i : ((Gerente) usuario_logado).getlistaFuncionarios()) {
                            System.out.println("\nFuncionário " + cont);
                            cont++;
                            System.out.println(i.toString());
                        }
                    }

                    else if (escolha == 1) {
                        addTarefa(usuario_logado);
                    }

                    else if (escolha == 2) {
                        //lógica para buscar as tarefas pessoais
                        System.out.println("SUAS TAREFAS ->");
                        for (Tarefa tarefa : usuario_logado.getTarefas(usuario_logado)) {
                            System.out.println(tarefa.toString());
                        }
                    }

                    else if (escolha == 3){
                        int cont = 1;
                        for (Pessoa i : ((Gerente) usuario_logado).getlistaFuncionarios()) {
                            System.out.println("\nFuncionário " + cont);
                            cont++;
                            System.out.println(i.toString());
                        }
                        boolean achou=false;
                        Pessoa funcionario=null;

                        do{

                            System.out.println("Digite o id da pessoa que terá uma tarefa ");
                            int id = sc.nextInt();
                            for(Pessoa i:((Gerente) usuario_logado).getlistaFuncionarios()){
                                if(i.getId()==id) {
                                    funcionario = i;
                                    achou = true;
                                }
                            }
                            if(achou==false){
                                System.err.println("usuário não existente");
                            }

                        }while(!achou);
                        addTarefaFunc(usuario_logado, funcionario);

                    }

                    else if (escolha == 4) {
                        System.out.println("TAREFAS EQUIPE "+usuario_logado.getNome()+" ->");
                        for(Tarefa tarefa:((Gerente) usuario_logado).getTarefasEquipe()){
                            System.out.println("---------------");
                            System.out.println(tarefa.toString());

                        }

                    }

                    } while (escolha != 99);
            }

            else {
                System.out.println("tipo de usuário não existente");
            }
        }

    }





    /**
     * funções para criar os gerentes e funcionario
     */
    public static void criarDados(){
        Pessoa func1 = new Funcionario("joão", "joao@gmail.com");
        Pessoa func2 = new Funcionario("pedro", "pedro@gmail.com");
        Pessoa func3 = new Funcionario("joana", "joana@gmail.com");

        Pessoa gerente = new Gerente("maria", "mari");
        Pessoa gerente1 = new Gerente("marcos", "marc");

        gerenciador.addPessoa(gerente);
        gerenciador.addPessoa(gerente1);

        gerenciador.addPessoa(func1);
        gerenciador.addPessoa(func2);
        gerenciador.addPessoa(func3);


        ((Gerente) gerente1).addFuncionario(func3);

        ((Gerente) gerente).addFuncionario(func1);
        ((Gerente) gerente).addFuncionario(func2);

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


    public static void addTarefa(Pessoa usuario_logado){
        //adicionar uma tarefa
        System.out.println("digite a descrição de sua tarefa\n");
        String desc = sc.next();
        System.out.println("escolha a prioridade: \n[ 0 ] pouco importante\n[ 1 ] importante\n[ 2 ] muito importante");
        int prio = sc.nextInt();
        String prioridade = "";

        if (prio == 0)
            prioridade = "Pouco Importante";
        else if (prio == 1)
            prioridade = "Importante";
        else if (prio == 2)
            prioridade = "Muito Importante";
        else
            System.out.println("Número inváldo");

        ((Gerente) usuario_logado).addTarefa(new Tarefa(desc, prioridade, usuario_logado));
        System.out.println("tarefa adicionada com sucesso");
    }

    public static void addTarefaFunc(Pessoa usuario_logado, Pessoa funcionario){
        //adicionar uma tarefa
        System.out.println("digite a descrição de sua tarefa\n");
        String desc = sc.next();
        System.out.println("escolha a prioridade: \n[ 0 ] pouco importante\n[ 1 ] importante\n[ 2 ] muito importante");
        int prio = sc.nextInt();
        String prioridade = "";

        if (prio == 0)
            prioridade = "Pouco Importante";
        else if (prio == 1)
            prioridade = "Importante";
        else if (prio == 2)
            prioridade = "Muito Importante";
        else
            System.out.println("Número inváldo");

        ((Gerente) usuario_logado).addTarefa(new Tarefa(desc, prioridade, funcionario));
        System.out.println("tarefa adicionada com sucesso");
    }

}