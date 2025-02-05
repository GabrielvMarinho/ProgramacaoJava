import java.util.Scanner;
import java.util.ArrayList;

public class Main{
    static ArrayList<ContaCorrente> lcontasCorrentes = new ArrayList<ContaCorrente>();
    static ArrayList<ContaPoupanca> lcontasPoupanca = new ArrayList<ContaPoupanca>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String args[]){
        System.out.println("BEM VINDO AO BANCO WEGfinance");
        do{
            mostrarOpcoes();
            switch(sc.nextInt()){
                case 0:
                    ContaCorrente cc = new ContaCorrente();
                    lcontasCorrentes.add(cc);
                    break;
                case 1:
                    ContaPoupanca cp = new ContaPoupanca();
                    lcontasPoupanca.add(cp);
                    break;
                case 2:
                    ContaBancaria conta = mostrarContasPegar1();
                    if(conta == null){
                        System.out.println("Conta não existe!");
                    }
                    else{
                        System.out.println("Digite a quantia para sacar: ");
                        double quantia = sc.nextInt();
                        conta.sacar(quantia);
                    }
                    break;
                case 3:
                    ContaBancaria conta1 = mostrarContasPegar1();
                    if(conta1 == null){
                        System.out.println("Conta não existe!");
                    }
                    else{
                        System.out.println("Digite a quantia para depositar: ");
                        double quantia = sc.nextInt();
                        conta1.depositar(quantia);
                    }
                    break;
                case 4:
                    ContaBancaria conta2 = mostrarContasPegar1();
                    if(conta2 == null){
                        System.out.println("Conta não existe!");
                    }
                    else{
                        ContaBancaria conta5 = mostrarContasPegar1();
                        if(conta5 == null){
                            System.out.println("Conta não existe!");
                        }else{
                            System.out.println("Digite o valor: ");
                            double valor = sc.nextDouble();
                            conta2.transferir(conta2, conta5, valor);

                        }
                    }
                case 5:
                    System.out.println("Conta correntes");
                    for(int i=0; i<lcontasCorrentes.size(); i++){
                        System.out.println(lcontasCorrentes.get(i).toString());
                    }
                    System.out.println("Conta poupancas");
                    for(int i=0; i<lcontasPoupanca.size(); i++){
                        System.out.println(lcontasPoupanca.get(i).toString());
                    }
            }
        }while(true);
    }
    public static ContaBancaria mostrarContasPegar1(){
        System.out.println("Conta correntes");
        for(int i=0; i<lcontasCorrentes.size(); i++){
            System.out.println(lcontasCorrentes.get(i).toString());
        }
        System.out.println("Conta poupancas");
        for(int i=0; i<lcontasPoupanca.size(); i++){
            System.out.println(lcontasPoupanca.get(i).toString());
        }
        System.out.println("Digite o id do conta: ");
        String id = sc.next();

        ContaBancaria conta = null;
        for(int i=0; i<lcontasCorrentes.size(); i++){
            if(lcontasCorrentes.get(i).getNumeroConta().equals(id)){
                conta = lcontasCorrentes.get(i);
            };
        }
        for(int i=0; i<lcontasPoupanca.size(); i++){
            if(lcontasPoupanca.get(i).getNumeroConta().equals(id)){
                conta = lcontasPoupanca.get(i);
            };
        }
        return conta;
    };

    public static void mostrarOpcoes(){
        System.out.println("DIGITE SUA OPÇÃO\n"+
                "[ 0 ] criar conta corrente\n"+
                "[ 1 ] criar conta poupança\n"+
                "[ 2 ] realizar saque\n"+
                "[ 3 ] realizar deposito\n"+
                "[ 4 ] realizar transferência\n"+
                "[ 5 ] mostrar todas as contas\n\n"+
                ">");
    }
}