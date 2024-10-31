import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static CRUDConta crud = new CRUDConta();
    public static void main(String[] args) {



        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        do{
            mostrarOpcoesMenu();
            int opcaoMenu = sc.nextInt();

            try{
                executarOpcaoMenu(opcaoMenu);
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }while(true);


    }


    private static void cadastroConta(){
        System.out.println("Número da conta: ");
        int numero = sc.nextInt();
        //checks if the account exists, if so stops the process
        try{
            Conta conta = crud.read(numero);
        }catch(ContaInexistenteException e){
            System.out.println("Titular: ");
            String titular = sc.next();
            System.out.println("Limite: ");
            double limite = sc.nextDouble();
            crud.create(new Conta(numero, titular, limite));
            return;
        }
        throw new ContaJaCadastradaException();

    }
    private static void removerConta() throws ContasInexistentesException {
        Conta conta = buscarConta();
        crud.delete(conta.getNumero());
    }
    private static void editarConta() throws ContasInexistentesException {
        Conta conta = buscarConta();
        System.out.println("Titular: ");
        String titular = sc.next();
        System.out.println("Limite: ");
        double limite = sc.nextDouble();
        System.out.println("Saldo: ");
        double saldo = sc.nextDouble();
        conta.setTitular(titular);
        conta.setLimite(limite);
        conta.setSaldo(saldo);
        crud.update(conta);
    }
    private static Conta buscarConta() throws ContasInexistentesException {
        try{
            System.out.println(crud.readAll());

        }catch(ContasInexistentesException e){
            System.out.println(e.getMessage());
        }

        System.out.println("Número da Conta: ");
        int numero = sc.nextInt();

        return crud.read(numero);

    }
    private void loginConta(){

    }
    private void logoutConta(){

    }
    private void mostrarDadosConta(){

    }
    private void mostrarDados(){

    }

    private static void mostrarOpcoesMenu(){
        System.out.print("""
                MENU:
                
                1 - Cadastro
                2 - Editar
                3 - Deletar
                4 - Mostrar Todas
                5 - Selecionar
                6 - Sair
                
                >""");
    }

    private static void mostrarOpcoesConta(){
        System.out.println("""
                OPERAÇÕES 
                
                1 - Depósito
                2 - Saque
                3 - Tranferência
                4 - Saldo
                5 - Sair
                
                >
                """);
    }
    private static void executarOpcaoMenu(int opcao) throws Exception {
        switch(opcao){
            case 1: {
                cadastroConta();
                break;
            }
            case 2: {
                editarConta();
                break;
            }
            case 3: {
                removerConta();
                break;
            }
            case 4: {
                System.out.println(crud.readAll());
                break;
            }
            case 5:{
                int opcaoConta;
                Conta conta = buscarConta();

                do {
                    mostrarOpcoesConta();
                    opcaoConta = sc.nextInt();
                    do {


                        try {
                            executarOpcaoConta(conta, opcaoConta);
                            break;

                        } catch (ValorInvalidoException |
                                 ContaInexistenteException e) {

                            System.out.println(e.getMessage());

                        } catch (SaldoInsuficienteException |
                                 LimiteInsuficienteException |
                                 PropriaContaException e) {
                            System.out.println(e.getMessage());
                            break;
                        }
                    }while(true);

                }while(opcaoConta!=5);
                break;
            }
            case 6:{
                System.exit(0);
            }
        }
    }

    private static double solicitarValor(){
        System.out.println("Valor: R$");
        return sc.nextDouble();
    }

    private static void executarOpcaoConta(Conta conta, int opcao) throws ContasInexistentesException {

        switch(opcao){
            case 1:{
                conta.deposito(solicitarValor());
                break;
            }
            case 2:{
                conta.saque(solicitarValor());
                break;
            }
            case 3:{
                /*
                 * SaldoInsuficiente, LimiteInsuficiente, PropriaConta
                 * Retornam para o menu da conta
                 *
                 * ContaInexistente, ValorInvalido solicita novamente
                 * o valor e a conta para tranferência
                 * **/
                conta.transferencia(solicitarValor(), buscarConta());
                break;

            }
            case 4:{
                System.out.println("Saldo: R$ "+conta.getSaldo());
                break;
            }
            case 5:{
                System.out.println("Até mais!");
                break;
            }
            default:{
                System.out.println("Opção inválida!");
            }

        }
    }



}