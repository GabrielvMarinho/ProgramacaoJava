import java.util.Random;

public abstract class ContaBancaria{
    public String numeroConta;
    public double saldo;
    public static Random random = new Random(); // Initialize Random

    public String getNumeroConta() {
        return numeroConta;
    }

    @Override
    public String toString() {
        return "ContaBancaria{" +
                "numeroConta='" + numeroConta + '\'' +
                ", saldo=" + saldo +
                '}';
    }

    public void depositar(double valor){
        this.saldo += valor;
    }
    public void sacar(double valor){
        if(this.saldo-valor>0){
            this.saldo -= valor;

        }else{
            System.out.println("Saldo insuficiente");
        }
    }
    public double getSaldo(){
        return this.saldo;
    }
    public void setSaldo(double soma){
        this.saldo =+ soma;
    }

    public void transferir(ContaBancaria origem, ContaBancaria destino, double valor){
        origem.sacar(valor);
        destino.depositar(valor);
    }
    public void exibirSaldo(){
        System.out.println("o saldo atual é "+this.saldo);
    }

    public abstract void calcularRendimento();

}