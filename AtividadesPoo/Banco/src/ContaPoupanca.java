public class ContaPoupanca extends ContaBancaria{

    public ContaPoupanca(){
        this.numeroConta = Integer.toString((int) (random.nextDouble() * 10000000));
        this.saldo = 0;
    }

    @Override
    public void calcularRendimento(){
        setSaldo(getSaldo()*1.05);
    }
}