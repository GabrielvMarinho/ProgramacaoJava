

public class Main extends Thread{
    public static void main(String[] args) {

        Thread thread1 = new Moeda("--BITCOIN--", "BTCUSDT", 1000);
        Thread thread2 = new Moeda("--ETHEREUM--", "ETHUSDT", 1000);

        thread1.start();
        thread2.start();


    }


}