import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        //criando dados pré setados para facilitar compreensão e teste
        criarDados();

        while(true) {
            System.out.println("---------------------------------------");
            System.out.println("| SISTEMA DE GERENCIAMENTO DE TAREFAS |");
            System.out.println("---------------------------------------");

            System.out.println("Digite sua opção");
            System.out.println("[ 0 ] Admin");
            System.out.println("[ 1 ] Logar");

            int inicio = sc.nextInt();

            if (inicio == 0) {
                System.out.println("Digite a senha de administrador ('admin')");

                String senha = sc.next();
                int escolhaAdmin;
                if (senha.equals("admin")) {
                    do {
                        System.out.println("[ 0 ] Listar todos colaboradores");
                        System.out.println("[ 1 ] Cadastrar");
                        System.out.println("[ 99 ] Sair");

                        escolhaAdmin = sc.nextInt();

                        if (escolhaAdmin == 0) {
                            System.out.println("todos os Funcionários ->");
                            System.out.println("---------");
                            System.out.println("Gerentes");
                            System.out.println("---------");
                            for (Pessoa gerente : GerenciadorEmpresa.getListaPessoas()) {
                                if (gerente instanceof Gerente) {
                                    System.out.println(gerente.toString());
                                }
                            }
                            System.out.println("---------");
                            System.out.println("Funcionarios");
                            System.out.println("---------");

                            for (Pessoa funcionario : GerenciadorEmpresa.getListaPessoas()) {
                                if (funcionario instanceof Funcionario) {
                                    System.out.println(funcionario.toString());
                                }
                            }
                        }

                        else if (escolhaAdmin == 1) {

                            System.out.println("[ 0 ] Gerente");
                            System.out.println("[ 1 ] Funcionario");
                            int tipoCadastro = sc.nextInt();

                            if (tipoCadastro == 0) {
                                System.out.println("Digite o primeiro nome do gerente: ");
                                String nome = sc.next();
                                do {
                                    System.out.println("Digite o email do gerente: ");
                                    String email = sc.next();
                                    boolean achou = false;
                                    for (Pessoa i : GerenciadorEmpresa.getListaPessoas()) {
                                        if (i.getEmail().equals(email)) {
                                            System.err.println("Email já cadastrado");
                                            achou = true;
                                        }

                                    }
                                    if (!achou) {
                                        Admin.cadastrarGerente(new Gerente(nome, email));
                                        break;
                                    }

                                } while (true);
                            }

                            else if (tipoCadastro == 1) {

                                System.out.println("Digite o primeiro nome do funcionario: ");
                                String nome = sc.next();

                                    System.out.println("Digite o email do funcionario: ");

                                    boolean achou = false;
                                do {
                                    String email = sc.next();


                                    for (Pessoa i : GerenciadorEmpresa.getListaPessoas()) {
                                        if (i.getEmail().equals(email)) {
                                            System.err.println("Email já cadastrado");
                                            achou = true;
                                        }
                                    }
                                    if (!achou) {
                                        for (Pessoa i : GerenciadorEmpresa.getListaPessoas()) {
                                            if (i instanceof Gerente) {
                                                System.out.println(i.toString());
                                            }
                                        }


                                        Pessoa gerente = null;
                                        do {
                                            System.out.println("Digite o id do gerente responsável");
                                            int id = sc.nextInt();
                                            for (Pessoa i : GerenciadorEmpresa.getListaPessoas()) {
                                                if (i instanceof Gerente) {
                                                    if (id == i.getId()) {
                                                        gerente = i;
                                                    }
                                                }
                                            }
                                            if (gerente == null) {
                                                System.err.println("Gerente Não Existente");
                                            } else {
                                                Admin.cadastrarfuncionario((Gerente) gerente, new Funcionario(nome, email));
                                                break;
                                            }
                                        } while (true);
                                        break;
                                    }
                                    achou=false;
                                }while(true);
                            }
                        }

                    }while(escolhaAdmin!=99);
                }
            }

            else if (inicio == 1) {
                //pegando o usuário logando
                Pessoa usuario_logado = login();
                // testando se é um gerente ou funcionario comum
                if (usuario_logado instanceof Funcionario) {
                    int escolha = 99;
                    do {
                        System.out.println("[ 0 ] Listar minhas tarefas\n" +
                                "[ 1 ] Concluir uma tarefa\n" +
                                "[ 99 ] Sair \n");

                        escolha = sc.nextInt();

                        if (escolha == 0) {
                            System.out.println("SUAS TAREFAS ->");
                            for (Tarefa tarefa : usuario_logado.getTarefas(usuario_logado)) {
                                System.out.println(tarefa.toString());
                            }
                        }

                        Tarefa tarefaCerta = null;
                        boolean achou = false;
                        if (escolha == 1) {
                            System.out.println("SUAS TAREFAS ->");
                            for (Tarefa tarefa : usuario_logado.getTarefas(usuario_logado)) {
                                if (tarefa.getStatus().equals("Não Concluída")) {
                                    System.out.println(tarefa.toString());
                                }
                            }
                            do {
                                System.out.println("Digite o id da tarefa que deseja concluir (-1 para voltar)");
                                int id = sc.nextInt();
                                if (id == -1) {
                                    break;
                                }
                                for (Tarefa tarefa : usuario_logado.getTarefas(usuario_logado)) {
                                    if (tarefa.getId() == id) {
                                        if (tarefa.getStatus().equals("Não Concluída")) {

                                            tarefaCerta = tarefa;
                                            achou = true;
                                        }
                                    }
                                }
                                if (achou) {
                                    System.out.println("Tarefa Concluída");
                                    ((Funcionario) usuario_logado).concluirTarefa(tarefaCerta);
                                    break;
                                } else {
                                    System.err.println("TAREFA NÃO EXISTE");
                                }
                            } while (true);

                        }
                    } while (escolha != 99);
                }

                else if (usuario_logado instanceof Gerente) {

                    int escolha = 99;
                    do {
                        System.out.println("[ 0 ] listar funcionarios");
                        System.out.println("[ 1 ] adicionar uma tarefa pessoal");
                        System.out.println("[ 2 ] listar minhas tarefas pessoais");
                        System.out.println("[ 3 ] adicionar uma tarefa para um funcionário");
                        System.out.println("[ 4 ] listar tarefas equipe inteira");
                        System.out.println("[ 5 ] listar tarefas equipe individual");
                        System.out.println("[ 6 ] concluir tarefa pessoal");
                        System.out.println("[ 7 ] concluir tarefas da equipe");
                        System.out.println("[ 8 ] cadastrar funcionário");
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
                                if (tarefa.getStatus().equals("Não Concluída")) {
                                    System.out.println(tarefa.toString());

                                }
                            }
                            System.out.println("------------------");
                            System.out.println("Tarefas concluídas");
                            System.out.println("------------------");
                            for (Tarefa tarefa : usuario_logado.getTarefas(usuario_logado)) {
                                if (!tarefa.getStatus().equals("Não Concluída")) {
                                    System.out.println(tarefa.toString());

                                }
                            }

                        }
                        else if (escolha == 3) {
                            int cont = 1;
                            for (Pessoa i : ((Gerente) usuario_logado).getlistaFuncionarios()) {
                                System.out.println("\nFuncionário " + cont);
                                cont++;
                                System.out.println(i.toString());
                            }
                            boolean achou = false;
                            Pessoa funcionario = null;

                            do {

                                System.out.println("Digite o id da pessoa que terá uma tarefa ");
                                int id = sc.nextInt();
                                for (Pessoa i : ((Gerente) usuario_logado).getlistaFuncionarios()) {
                                    if (i.getId() == id) {
                                        funcionario = i;
                                        achou = true;
                                    }
                                }
                                if (achou == false) {
                                    System.err.println("usuário não existente");
                                }

                            } while (!achou);
                            addTarefaFunc(usuario_logado, funcionario);

                        }
                        else if (escolha == 4) {

                            System.out.println("TAREFAS EQUIPE " + usuario_logado.getNome() + " ->");

                            System.out.println("--------------------");
                            System.out.println("Tarefas não concluídas");
                            System.out.println("--------------------");
                            for (Tarefa tarefa : ((Gerente) usuario_logado).getTarefasEquipe()) {
                                if (tarefa.getStatus().equals("Não Concluída")) {
                                    System.out.println(tarefa.toString());
                                }
                            }


                            System.out.println("------------------");
                            System.out.println("Tarefas concluídas");
                            System.out.println("------------------");

                            for (Tarefa tarefa : ((Gerente) usuario_logado).getTarefasEquipe()) {
                                if (!tarefa.getStatus().equals("Não Concluída")) {
                                    System.out.println(tarefa.toString());
                                }
                            }

                        }
                        else if (escolha == 5) {
                            boolean achou = false;
                            Pessoa funcionario = null;
                            int cont = 1;
                            for (Pessoa i : ((Gerente) usuario_logado).getlistaFuncionarios()) {
                                System.out.println("\nFuncionário " + cont);
                                cont++;
                                System.out.println(i.toString());
                            }
                            do {

                                System.out.println("Digite o id da pessoa que verá as tarefa ");
                                int id = sc.nextInt();
                                for (Pessoa i : ((Gerente) usuario_logado).getlistaFuncionarios()) {
                                    if (i.getId() == id) {
                                        funcionario = i;
                                        achou = true;
                                    }
                                }
                                if (achou == false) {
                                    System.err.println("usuário não existente");
                                }

                            } while (!achou);

                            for (Tarefa tarefa : ((Gerente) usuario_logado).getTarefasFuncionarioEspecifico(funcionario)) {
                                System.out.println(tarefa.toString());
                            }
                            System.out.println("TAREFAS DE " + funcionario.getNome());
                            System.out.println("--------------------");
                            System.out.println("Tarefas não concluídas");
                            System.out.println("--------------------");

                            for (Tarefa tarefa : ((Gerente) usuario_logado).getTarefasFuncionarioEspecifico(funcionario)) {
                                if (tarefa.getStatus().equals("Não Concluída")) {
                                    System.out.println(tarefa.toString());

                                }
                            }
                            System.out.println("------------------");
                            System.out.println("Tarefas concluídas");
                            System.out.println("------------------");
                            for (Tarefa tarefa : ((Gerente) usuario_logado).getTarefasFuncionarioEspecifico(funcionario)) {
                                if (!tarefa.getStatus().equals("Não Concluída")) {
                                    System.out.println(tarefa.toString());

                                }
                            }
                        }
                        else if (escolha == 6) {
                            //pegar tarefas que não estão cocluídas
                            System.out.println("SUAS TAREFAS ->");

                            for (Tarefa tarefa : usuario_logado.getTarefas(usuario_logado)) {
                                if (tarefa.getStatus().equals("Não Concluída")) {
                                    System.out.println(tarefa.toString());
                                }
                            }
                            boolean achou = false;
                            Tarefa tarefaCerta = null;

                            do {
                                System.out.println("Digite o id da tarefa que deseja concluir (-1 para voltar)");
                                int id = sc.nextInt();
                                if (id == -1) {
                                    break;
                                }
                                for (Tarefa tarefa : usuario_logado.getTarefas(usuario_logado)) {
                                    if (tarefa.getResponsavel().equals(usuario_logado)) {
                                        if (tarefa.getId() == id) {
                                            if (tarefa.getStatus().equals("Não Concluída")) {

                                                tarefaCerta = tarefa;
                                                achou = true;
                                            }
                                        }
                                    }
                                }
                                if (achou) {
                                    System.out.println("Tarefa Concluída");
                                    ((Gerente) usuario_logado).concluirTarefa(tarefaCerta, usuario_logado);
                                    break;
                                } else {
                                    System.err.println("TAREFA NÃO EXISTE");
                                }
                            } while (true);

                        }
                        else if (escolha == 7) {

                            System.out.println("TAREFAS FUNCIONÁRIOS ->");

                            for (Tarefa tarefa : ((Gerente) usuario_logado).getTarefasEquipe()) {
                                if (tarefa.getStatus().equals("Não Concluída")) {
                                    System.out.println(tarefa.toString());
                                }
                            }

                            boolean achou = false;
                            Tarefa tarefaCerta = null;

                            do {
                                System.out.println("Digite o id da tarefa que deseja concluir (-1 para voltar)");
                                int id = sc.nextInt();
                                if (id == -1) {
                                    break;
                                }
                                for (Tarefa tarefa : ((Gerente) usuario_logado).getTarefasEquipe()) {
                                    if (tarefa.getId() == id) {
                                        if (tarefa.getStatus().equals("Não Concluída")) {
                                            tarefaCerta = tarefa;
                                            achou = true;
                                        }
                                    }
                                }
                                if (achou) {
                                    if (((Gerente) usuario_logado).concluirTarefa(tarefaCerta)) {
                                        System.out.println("Tarefa Concluída");
                                        break;
                                    }
                                }
                                System.err.println("TAREFA NÃO EXISTE");

                            } while (true);
                        }
                        else if (escolha == 8){
                            System.out.println("Digite o primeiro nome do funcionario: ");
                            String nome = sc.next();

                            System.out.println("Digite o email do funcionario: ");

                            boolean achou = false;
                            do {
                                String email = sc.next();


                                for (Pessoa i : GerenciadorEmpresa.getListaPessoas()) {
                                    if (i.getEmail().equals(email)) {
                                        System.err.println("Email já cadastrado");
                                        achou = true;
                                    }
                                }
                                if (!achou) {
                                    ((Gerente) usuario_logado).cadastrarFuncionario(new Funcionario(nome, email));
                                    System.out.println("Usuário adicionado");
                                    break;
                                }



                                achou=false;
                            }while(true);

                        }

                    } while (escolha != 99);
                }

                else {
                    System.out.println("tipo de usuário não existente");
                }
            }
        }

    }

    /**
     * funções para criar os gerentes e funcionario
     */
    public static void criarDados(){
        Pessoa func1 = new Funcionario("joão", "joao@gmail.com");
        Pessoa func3 = new Funcionario("joana", "joana@gmail.com");
        Pessoa gerente = new Gerente("maria", "maria@gmail.com");
        Pessoa gerente1 = new Gerente("marcos", "marcos@gmail.com");
        GerenciadorEmpresa.addPessoa(gerente);
        GerenciadorEmpresa.addPessoa(gerente1);
        GerenciadorEmpresa.addPessoa(func1);
        GerenciadorEmpresa.addPessoa(func3);
        ((Gerente) gerente1).addFuncionario(func3);
        ((Gerente) gerente).addFuncionario(func1);
    }
    /**
     * lógica para o login
     */
    public static Pessoa login(){
        System.out.println("Digite seu email: ");
        String email = sc.next();
        System.out.println("Digite sua senha (email por padrão): ");
        String senha = sc.next();
        for( Pessoa pessoa:GerenciadorEmpresa.getListaPessoas()){
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