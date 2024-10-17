import java.io.OutputStream;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        Pessoa pessoa1 = new Policial(1);
        Pessoa pessoa2 = new Ladrao(2);
        Pessoa pessoa3 = new Homem(3);
        Pessoa pessoa4 = new Menino(4);
        Pessoa pessoa5 = new Menino(5);
        Pessoa pessoa6 = new Mulher(6);
        Pessoa pessoa7 = new Menina(7);
        Pessoa pessoa8 = new Menina(8);

        Barco barco = new Barco();
        do {
            try {

                System.out.println(GerenT.retornarStatus(barco));

                System.out.println("digite o id");
                int id = sc.nextInt();
                System.out.println("\n\n\n\n\n\n\n\n\n\n");

                if(id==0){
                    barco.mudarLado();
                }else{

                    Pessoa escolhido = GerenT.returnById(id);
                    //valida para ver se ele esta em um barco ou borda para mudar a logica

                    if(GerenT.emQualMargemEsta(escolhido)==null){
                        //pega a borda mais proxima do barco baseado em um atributo
                        GerenT.moverDePara(escolhido, barco, barco.getMargemProxima());
                    }
                    else{
                        GerenT.moverDePara(escolhido, GerenT.emQualMargemEsta(escolhido), barco);
                    }
                }




            } catch (Exception e) {
                System.out.println("▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇");

                System.out.println("  "+e.getMessage());
                System.out.println("▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇");

            }

        }while(true);


    }
}