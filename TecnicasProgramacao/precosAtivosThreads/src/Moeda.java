import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
public class Moeda extends Thread {

    String nome;
    String par;
    double response;

    int intervaloEmMill;
    Moeda(String nome, String par, int intervaloEmMill){
        this.nome = nome;
        this.par = par;
        this.intervaloEmMill = intervaloEmMill;
    }
    @Override
    public void run() {
        while(true) {

            URL url;
            try {
                url = new URL("https://api.binance.com/api/v3/ticker/price?symbol="+this.getPar());
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
            BufferedReader in;
            try {
                in = new BufferedReader(new InputStreamReader(url.openStream()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            String response;
            try {
                response = in.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println("____________________________");
            System.out.println("dados recebidos da "+this.getNome()+" ="+response);

            try {
                Thread.sleep(this.getIntervaloEmMill());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }

    private String getPar() {
        return this.par;
    }

    public int getIntervaloEmMill() {
        return intervaloEmMill;
    }

    public void setIntervaloEmMill(int intervaloEmMill) {
        this.intervaloEmMill = intervaloEmMill;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }




}
