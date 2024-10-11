public class Main{
    public static void main(String[] args) {
        //instanciando os objetos
        Moeda btc = new Moeda("--BITCOIN--", "BTCUSDT", 1000);
        Moeda eth = new Moeda("--ETHEREUM--", "ETHUSDT", 1000);
        //instanciando os threads
        Thread thread1 = new Thread(btc);
        Thread thread2 = new Thread(eth);
        //iniciando o threads
        thread1.start();
        thread2.start();


    }


}