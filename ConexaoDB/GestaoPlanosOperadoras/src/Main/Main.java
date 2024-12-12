package Main;

import CRUDs.*;
import Classes.*;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        do{

            opcoesMain();

        }while(true);
    }

    public static void opcoesMain() {
        System.out.println("""
                [ 1 ] Cliente
                [ 2 ] Plano
                [ 3 ] Plano Serviço
                [ 4 ] Contrato
                [ 5 ] Serviço Adicional
                [ 6 ] Sair
                """);
        int escolha = sc.nextInt();
        sc.nextLine();
        switch (escolha){
            case 1:
                listarExecutarOpcoesUsuario();
                break;
            case 2:
                listarExecutarOpcoesPlano();
                break;
            case 3:
                listarExecutarOpcoesPlanoServico();
                break;
            case 4:
                listarExecutarOpcoesContrato();
                break;
            case 5:
                listarExecutarOpcoesServicoAdicional();
                break;
            case 6:
                System.err.println("Aplicação encerrada");
                System.exit(0);
            default:
                break;
        }
    }
    public static int opcoesCrudGenerico(){
        System.out.println("""
                { 1 } Cadastrar
                { 2 } Listar
                { 3 } Atualizar
                { 4 } Remover
                """);
        int escolha = sc.nextInt();
        sc.nextLine();
        return escolha;
    }
    //-----------------------------------------------------------------------------------------------------------
    public static void listarExecutarOpcoesUsuario(){
        executarOpcaoUsuario(opcoesCrudGenerico());
    }
    public static void executarOpcaoUsuario(int escolha){

        switch (escolha){
            case 1:
                cadastrarUsuario();
                break;
            case 2:
                listarUsuario();
                break;
            case 3:
                atualizarUsuario();
                break;
            case 4:
                remocaoUsuario();
                break;
            default:
                break;
        }
    }
    public static void listarUsuario(){

        for(Cliente c:CrudCliente.consulta()){
            System.out.println(c.toString());
        };
    }
    public static void cadastrarUsuario(){
        System.out.println("Digite o nome: ");
        String nome = sc.nextLine();

        System.out.println("Digite o email: ");
        String email = sc.nextLine();

        System.out.println("Digite o telefone: ");
        String telefone = sc.nextLine();

        System.out.println("Cadastro realizado: "+CrudCliente.cadastro(new Cliente(nome, email, telefone)).toString());

    }
    public static void atualizarUsuario(){
        Cliente cliente = listarValidarRetornarUsuarioExistente();

        System.out.println("Digite o nome: ");
        String nome = sc.nextLine();
        System.out.println("Digite o email: ");
        String email = sc.nextLine();
        System.out.println("Digite o telefone: ");
        String telefone = sc.nextLine();

        cliente.setNome(nome);
        cliente.setEmail(email);
        cliente.setTelefone(telefone);
        CrudCliente.atualizacao(cliente);
        System.out.println("Atualizado com sucesso");
    }
    public static Cliente listarValidarRetornarUsuarioExistente(){
        listarUsuario();
        System.out.println("Digite o id do usuário: ");
        int id = sc.nextInt();
        sc.nextLine();
        return CrudCliente.consultaId(id);
    }
    public static void remocaoUsuario(){
        CrudCliente.remocao(listarValidarRetornarUsuarioExistente().getId());
        System.out.println("Removido com sucesso");

    }
    //-----------------------------------------------------------------------------------------------------------
    public static void listarExecutarOpcoesServicoAdicional(){
        executarOpcaoServicoAdicional(opcoesCrudGenerico());
    }
    public static void executarOpcaoServicoAdicional(int escolha){
        switch (escolha){
            case 1:
                cadastrarServicoAdicional();
                break;
            case 2:
                listarServicoAdicional();
                break;
            case 3:
                atualizarServicoAdicional();
                break;
            case 4:
                remocaoServicoAdicional();
                break;
            default:
                break;
        }
    }
    public static void cadastrarServicoAdicional(){
        System.out.println("Digite a descrição: ");
        String descricao = sc.nextLine();
        System.out.println("Digite o custo mensal");
        double custo_mensal = sc.nextDouble();
        sc.nextLine();
        System.out.println("Cadastro realizado: "+CrudServicoAdicional.cadastro(new ServicoAdicional(descricao, custo_mensal)));

    }
    public static void listarServicoAdicional(){
        for(ServicoAdicional s:CrudServicoAdicional.consulta()){
            System.out.println(s.toString());
        };
    }
    public static ServicoAdicional listarValidarRetornarServicoAdicionalExistente(){
        listarServicoAdicional();
        System.out.println("Digite o id do serviço adicional: ");
        int id = sc.nextInt();
        sc.nextLine();
        return CrudServicoAdicional.consultaId(id);
    }
    public static void atualizarServicoAdicional(){
        ServicoAdicional servicoAdicional = listarValidarRetornarServicoAdicionalExistente();

        System.out.println("Digite a descrição: ");
        String descricao = sc.nextLine();
        System.out.println("Digite o custo mensal");
        double custo_mensal = sc.nextDouble();
        sc.nextLine();

        servicoAdicional.setDescricao(descricao);
        servicoAdicional.setCusto_mensal(custo_mensal);
        CrudServicoAdicional.atualizacao(servicoAdicional);

        System.out.println("Atualizado com sucesso");
    }
    public static void remocaoServicoAdicional(){
        CrudServicoAdicional.remocao(listarValidarRetornarServicoAdicionalExistente().getId());
        System.out.println("Removido com sucesso");

    }
    //-----------------------------------------------------------------------------------------------------------
    public static void listarExecutarOpcoesPlano(){
        executarOpcaoPlano(opcoesCrudPlano());
    }
    public static int opcoesCrudPlano(){
        System.out.println("""
                { 1 } Cadastrar
                { 2 } Listar
                { 3 } Atualizar
                { 4 } Remover
                { 5 } Serviços associados a um plano
                { 6 } Clientes associados a um plano
                { 7 } Contrato associado a um plano

                """);
        int escolha = sc.nextInt();
        sc.nextLine();
        return escolha;
    }

    public static void executarOpcaoPlano(int escolha){
        switch (escolha){
            case 1:
                cadastrarPlano();
                break;
            case 2:
                listarPlano();
                break;
            case 3:
                atualizarPlano();
                break;
            case 4:
                remocaoPlano();
                break;
            case 5:
                consultaServicosAdicionaisPlano();
                break;
            case 6:
                consultaClientePlano();
                break;
            case 7:
                consultaContratoPlano();
                break;
            default:
                break;
        }
    }
    public static Plano listarValidarRetornarPlanoExistente(){
        listarPlano();
        System.out.println("Digite o id do plano: ");

        int id = sc.nextInt();
        sc.nextLine();
        return CrudPlano.consultaIndividual(id);
    }
    public static void cadastrarPlano(){
        System.out.println("Digite o nome: ");
        String nome = sc.nextLine();

        System.out.println("Digite a operadora: ");
        String operadora = sc.nextLine();

        System.out.println("Digite a quantidade de dados: ");
        double dados = sc.nextDouble();
        sc.nextLine();

        System.out.println("Digite a quantidade de dados bonus (0 se não tiver bonus): ");
        double dados_bonus = sc.nextDouble();
        sc.nextLine();

        System.out.println("Digite os beneficios: ");
        String beneficios = sc.nextLine();

        System.out.println("Digite o valor: ");
        double valor = sc.nextDouble();
        sc.nextLine();

        System.out.println("Cadastro Realizado: "+CrudPlano.cadastro(new Plano(operadora, nome, dados, dados_bonus, beneficios, valor)).toString());

    }
    public static void listarPlano(){
        for(Plano p:CrudPlano.consulta()){
            System.out.println(p.toString());
        };
    }
    public static void atualizarPlano(){
        Plano plano = listarValidarRetornarPlanoExistente();

        System.out.println("Digite o nome: ");
        String nome = sc.nextLine();

        System.out.println("Digite a operadora: ");
        String operadora = sc.nextLine();

        System.out.println("Digite a quantidade de dados: ");
        double dados = sc.nextDouble();
        sc.nextLine();

        System.out.println("Digite a quantidade de dados bonus (0 se não tiver bonus): ");
        double dados_bonus = sc.nextDouble();
        sc.nextLine();

        System.out.println("Digite os beneficios: ");
        String beneficios = sc.nextLine();

        System.out.println("Digite o valor: ");
        double valor = sc.nextDouble();
        sc.nextLine();


        plano.setNome(nome);
        plano.setOperadora(operadora);
        plano.setQuantidade_dados(dados);
        plano.setQuantidade_dados_bonus(dados_bonus);
        plano.setBeneficios(beneficios);
        plano.setValor(valor);
        CrudPlano.atualizacao(plano);
        System.out.println("Atualizado com sucesso");
    }
    public static void remocaoPlano(){
        CrudPlano.remocao(listarValidarRetornarPlanoExistente().getId());
        System.out.println("Removido com sucesso");

    }
    public static void consultaServicosAdicionaisPlano(){
        for(ServicoAdicional s:CrudPlano.consultaServicosAdicionaisPlano(listarValidarRetornarPlanoExistente())){
            System.out.println(s.toString());
        }
    }
    public static void consultaContratoPlano(){
        System.out.println(CrudPlano.buscarContratoPlano(listarValidarRetornarPlanoExistente()));
    }

    public static void consultaClientePlano(){
        for(Cliente c:CrudPlano.clientesEmUmPlano(listarValidarRetornarPlanoExistente())){
            System.out.println(c.toString());
        }
    }
    //-----------------------------------------------------------------------------------------------------------
    public static int opcoesCrudPlanoServico(){
        System.out.println("""
                { 1 } Adicionar
                { 2 } Listar
                { 3 } Remover
                """);
        int escolha = sc.nextInt();
        sc.nextLine();
        return escolha;
    }

    public static void listarExecutarOpcoesPlanoServico(){
        executarOpcaoPlanoServico(opcoesCrudPlanoServico());
    }
    public static PlanoServico listarValidarRetornarPlanoServicoExistente(){
        listarPlanoServico();
        System.out.println("Digite o id do plano serviço");

        int id = sc.nextInt();
        sc.nextLine();
        return CrudPlanoServico.consultaPlanoServicoId(id);
    }
    public static void executarOpcaoPlanoServico(int escolha){
        switch (escolha){
            case 1:
                adicionarServicoPlano();
                break;
            case 2:
                listarPlanoServico();
                break;
            case 3:
                removerServicoPlano();
                break;
            default:
                break;
        }
    }
    public static void adicionarServicoPlano(){
        listarPlanoServico();
        Plano plano =listarValidarRetornarPlanoExistente();
        ServicoAdicional servicoAdicional = listarValidarRetornarServicoAdicionalExistente();
        CrudPlano.checarConexaoPlanoServico(plano, servicoAdicional);
        CrudPlano.adicionarServico(plano, servicoAdicional);
    }
    public static void removerServicoPlano(){
        CrudPlanoServico.removerPlanoServico(listarValidarRetornarPlanoServicoExistente().getId());
        System.out.println("Removido com sucesso");
    }
    public static void listarPlanoServico(){
        for(PlanoServico p:CrudPlanoServico.consultaPlanoServico()){
            System.out.println(p.toString());
        }
    }

    //-----------------------------------------------------------------------------------------------------------
    public static void listarExecutarOpcoesContrato(){
        executarOpcoesContrato(opcoesCrudContrato());
    }
    public static int opcoesCrudContrato(){
        System.out.println("""
                { 1 } Adicionar
                { 2 } Listar
                { 3 } Remover
                """);
        int escolha = sc.nextInt();
        sc.nextLine();
        return escolha;
    }
    public static void executarOpcoesContrato(int escolha){
        switch (escolha){
            case 1:
                cadastroContrato();
                break;
            case 2:
                listarContrato();
                break;
            case 3:
                removerContrato();
                break;
            default:
                break;
        }
    }
    public static Contrato listarValidarRetornarContratoExistente(){
        listarContrato();
        System.out.println("Digite o id do contrato: ");
        int id = sc.nextInt();
        sc.nextLine();
        return CrudContrato.consultaId(id);
    }
    public static void listarContrato(){
        for(Contrato c:CrudContrato.consulta()){
            System.out.println(c.toString());
        }
    }
    public static void cadastroContrato(){
        System.out.println("Digite o id do plano do contrato: ");
        Plano plano = listarValidarRetornarPlanoExistente();
        CrudContrato.validarIdPlanoUnique(plano.getId());
        System.out.println("Digite os termos: ");
        String termos = sc.nextLine();

        System.out.println("Digite a data de inicio: ");
        String data_inicio = sc.nextLine();

        System.out.println("Digite a data de termino: ");
        String data_fim = sc.nextLine();

        System.out.println("Cadastro realizado: "+CrudContrato.cadastro(new Contrato(plano, termos, data_inicio, data_fim)).toString());

    }

    public static void removerContrato(){
        CrudContrato.remocao(listarValidarRetornarContratoExistente().getId());
    }
}