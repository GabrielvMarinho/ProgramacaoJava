import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        Pessoa pessoa = new Pessoa(1);
        Pessoa pessoa1 = new Pessoa(2);
        Pessoa pessoa2 = new Pessoa(3);
        Pessoa pessoa3 = new Pessoa(4);
        Pessoa pessoa4 = new Pessoa(5);
        Pessoa pessoa5 = new Pessoa(6);
        Barco barco = new Barco();
        do {
            try {
                System.out.println(GerenT.retornarStatus(barco));
                System.out.println("[ 1 ] mudar local" +
                        "\n[ 2 ] mudar lado\n");
                int escolha = sc.nextInt();


                if(escolha==1){
                    System.out.println("digite o id");
                    int id = sc.nextInt();
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

                else if(escolha==2){
                    barco.mudarLado();
                }


            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }while(true);


    }
}