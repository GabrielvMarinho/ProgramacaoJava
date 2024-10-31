import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static BancoDeDados db = new BancoDeDados();
    public static void main(String[] args) {



        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        do{
            mostrarOpcoesMenu();
            int opcaoMenu = sc.nextInt();

            try{
                executarOpcaoMenu(opcaoMenu);
            }catch(ContaInexistenteException |
                ContaJaCadastradaException e){
                System.out.println(e.getMessage());
            }
        }while(true);


    }


    private static void cadastroConta(){
        System.out.println("Número da conta: ");
        int numero = sc.nextInt();

        try{
            Conta conta = db.buscarConta(numero);
        }catch(ContaInexistenteException e){
            System.out.println("Titular: ");
            String titular = sc.next();
            System.out.println("Limite: ");
            double limite = sc.nextDouble();
            db.inserirConta(new Conta(numero, titular, limite));
            return;
        }
        throw new ContaJaCadastradaException();



    }
    private static void removerConta(){
        Conta conta = buscarConta();
        db.deletarConta(conta);
    }
    private static void editarConta(){
        Conta conta = buscarConta();
        System.out.println("Titular: ");
        String titular = sc.next();
        System.out.println("Limite: ");
        double limite = sc.nextDouble();
        conta.setTitular(titular);
        conta.setLimite(limite);
//        db.atualizarConta(conta);//só importa quando tiver db de fato, pois alterar o objeto em java não necessariamente altera algo no db
    }
    private static Conta buscarConta(){
        System.out.println(db.buscarContas());
        System.out.println("Número da Conta: ");
        int numero = sc.nextInt();
        return db.buscarConta(numero);

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
    private static void executarOpcaoMenu(int opcao){
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
                System.out.println(db.buscarContas());
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

    private static void executarOpcaoConta(Conta conta, int opcao){

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