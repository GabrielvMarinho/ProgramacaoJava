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
                    System.out.println("[ 0 ] Listar minhas tarefas\n" +
                            "[ 1 ] Concluir uma tarefa\n"+
                            "[ 99 ] Sair \n");

                    escolha = sc.nextInt();

                    if(escolha==0){
                        System.out.println("SUAS TAREFAS ->");
                        for (Tarefa tarefa : usuario_logado.getTarefas(usuario_logado)) {
                            System.out.println(tarefa.toString());
                        }
                    }

                    Tarefa tarefaCerta=null;
                    boolean achou=false;
                    if(escolha==1){
                        System.out.println("SUAS TAREFAS ->");
                        for (Tarefa tarefa : usuario_logado.getTarefas(usuario_logado)) {
                            if(tarefa.getStatus().equals("Não Concluída")) {
                                System.out.println(tarefa.toString());
                            }
                        }
                        do{
                            System.out.println("Digite o id da tarefa que deseja concluir (-1 para voltar)");
                            int id =sc.nextInt();
                            if(id==-1){
                                break;
                            }
                            for (Tarefa tarefa : usuario_logado.getTarefas(usuario_logado)) {
                                if(tarefa.getId()==id){
                                    if(tarefa.getStatus().equals("Não Concluída")) {

                                        tarefaCerta = tarefa;
                                        achou = true;
                                    }
                                }
                            }
                            if(achou){
                                System.out.println("Tarefa Concluída");
                                ((Funcionario)usuario_logado).concluirTarefa(tarefaCerta);
                                break;
                            }
                            else{
                                System.err.println("TAREFA NÃO EXISTE");
                            }
                        }while(true);

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
                    System.out.println("[ 5 ] listar tarefas equipe individual \n");
                    System.out.println("[ 6 ] concluir tarefas tarefa pessoal \n");
                    System.out.println("[ 7 ] concluir tarefas tarefa da equipe \n");
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
                        System.out.println("--------------------");
                        System.out.println("Tarefas não concluídas");
                        System.out.println("--------------------");

                        for (Tarefa tarefa : usuario_logado.getTarefas(usuario_logado)) {
                            if(tarefa.getStatus().equals("Não Concluída")) {
                                System.out.println(tarefa.toString());

                            }
                        }
                        System.out.println("------------------");
                        System.out.println("Tarefas concluídas");
                        System.out.println("------------------");
                        for (Tarefa tarefa : usuario_logado.getTarefas(usuario_logado)) {
                            if(!tarefa.getStatus().equals("Não Concluída")) {
                                System.out.println(tarefa.toString());

                            }
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

                        System.out.println("--------------------");
                        System.out.println("Tarefas não concluídas");
                        System.out.println("--------------------");
                        for(Tarefa tarefa:((Gerente) usuario_logado).getTarefasEquipe()){
                            if(tarefa.getStatus().equals("Não Concluída")) {
                                System.out.println(tarefa.toString());
                            }
                        }


                        System.out.println("------------------");
                        System.out.println("Tarefas concluídas");
                        System.out.println("------------------");

                        for(Tarefa tarefa:((Gerente) usuario_logado).getTarefasEquipe()){
                            if(!tarefa.getStatus().equals("Não Concluída")) {
                                System.out.println("---------------");
                                System.out.println(tarefa.toString());
                            }
                        }

                    }


                    else if (escolha == 5) {
                        boolean achou=false;
                        Pessoa funcionario=null;
                        int cont = 1;
                        for (Pessoa i : ((Gerente) usuario_logado).getlistaFuncionarios()) {
                            System.out.println("\nFuncionário " + cont);
                            cont++;
                            System.out.println(i.toString());
                        }
                        do{

                            System.out.println("Digite o id da pessoa que verá as tarefa ");
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

                        for(Tarefa tarefa:((Gerente) usuario_logado).getTarefasFuncionarioEspecifico(funcionario)){
                            System.out.println(tarefa.toString());
                        }
                        System.out.println("TAREFAS DE "+funcionario.getNome());
                        System.out.println("--------------------");
                        System.out.println("Tarefas não concluídas");
                        System.out.println("--------------------");

                        for (Tarefa tarefa:((Gerente) usuario_logado).getTarefasFuncionarioEspecifico(funcionario)) {
                            if(tarefa.getStatus().equals("Não Concluída")) {
                                System.out.println(tarefa.toString());

                            }
                        }
                        System.out.println("------------------");
                        System.out.println("Tarefas concluídas");
                        System.out.println("------------------");
                        for (Tarefa tarefa:((Gerente) usuario_logado).getTarefasFuncionarioEspecifico(funcionario)) {
                            if(!tarefa.getStatus().equals("Não Concluída")) {
                                System.out.println(tarefa.toString());

                            }
                        }
                    }


                    else if (escolha == 6) {
                        //pegar tarefas que não estão cocluídas
                        System.out.println("SUAS TAREFAS ->");

                        for (Tarefa tarefa : usuario_logado.getTarefas(usuario_logado)) {
                            if(tarefa.getStatus().equals("Não Concluída")){
                                System.out.println(tarefa.toString());
                            }
                        }
                        boolean achou = false;
                        Tarefa tarefaCerta=null;

                        do{
                            System.out.println("Digite o id da tarefa que deseja concluir (-1 para voltar)");
                            int id =sc.nextInt();
                            if(id==-1){
                                break;
                            }
                            for (Tarefa tarefa : usuario_logado.getTarefas(usuario_logado)) {
                                if(tarefa.getResponsavel().equals(usuario_logado)) {
                                    if (tarefa.getId() == id) {
                                        if (tarefa.getStatus().equals("Não Concluída")) {

                                            tarefaCerta = tarefa;
                                            achou = true;
                                        }
                                    }
                                }
                            }
                            if(achou){
                                System.out.println("Tarefa Concluída");
                                ((Gerente)usuario_logado).concluirTarefa(tarefaCerta, usuario_logado);
                                break;
                            }
                            else{
                                System.err.println("TAREFA NÃO EXISTE");
                            }
                        }while(true);

                    }

                    else if (escolha == 7) {

                        System.out.println("TAREFAS FUNCIONÁRIOS ->");

                        for (Tarefa tarefa : ((Gerente)usuario_logado).getTarefasEquipe()) {
                            if(tarefa.getStatus().equals("Não Concluída")){
                                System.out.println(tarefa.toString());
                            }
                        }

                        boolean achou = false;
                        Tarefa tarefaCerta=null;

                        do{
                            System.out.println("Digite o id da tarefa que deseja concluir (-1 para voltar)");
                            int id =sc.nextInt();
                            if(id==-1){
                                break;
                            }
                            for (Tarefa tarefa : ((Gerente)usuario_logado).getTarefasEquipe()) {
                                    if (tarefa.getId() == id) {
                                        if (tarefa.getStatus().equals("Não Concluída")) {
                                            tarefaCerta = tarefa;
                                            achou = true;
                                        }
                                }
                            }
                            if(achou){
                                if(((Gerente)usuario_logado).concluirTarefa(tarefaCerta) ){
                                    System.out.println("Tarefa Concluída");
                                    break;
                                }
                            }
                            System.err.println("TAREFA NÃO EXISTE");

                        }while(true);
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
        String prioridade = escolherPrioridade();

        ((Gerente) usuario_logado).addTarefa(new Tarefa(desc, prioridade, usuario_logado));
        System.out.println("tarefa adicionada com sucesso");
    }

    public static void addTarefaFunc(Pessoa usuario_logado, Pessoa funcionario){
        //adicionar uma tarefa
        System.out.println("digite a descrição de sua tarefa\n");
        String desc = sc.next();

        String prioridade = escolherPrioridade();


        ((Gerente) usuario_logado).addTarefa(new Tarefa(desc, prioridade, funcionario));
        System.out.println("tarefa adicionada com sucesso");
    }
    //função para testar e validar a prioridade
    public static String escolherPrioridade(){
        boolean finalizar=false;
        int prio=0;

        System.out.println("escolha a prioridade: \n[ 0 ] pouco importante\n[ 1 ] importante\n[ 2 ] muito importante");
        while(true) {
            try {
                prio = sc.nextInt();
                if (prio < 0 || prio > 2) {
                    System.out.println("Valor inválido. Tente novamente.");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.err.println("Não é número inteiro");
                sc.next();
                continue;

            }
        }
        String prioridade = "";

        if (prio == 0)
            prioridade = "Pouco Importante";
        else if (prio == 1)
            prioridade = "Importante";
        else if (prio == 2)
            prioridade = "Muito Importante";

        return prioridade;
    }
}