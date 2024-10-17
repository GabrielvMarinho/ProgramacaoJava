import java.io.OutputStream;
import java.sql.SQLOutput;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws Exception {

        System.out.println("\nHOMEM -> \uD83D\uDE4D\u200D♂\uFE0F"+
                "\nMENINO -> \uD83D\uDC66"+
                "\nMULHER -> \uD83D\uDE4D\u200D♀\uFE0F"+
                "\nMENINA -> \uD83D\uDC67"+
                "\nPOLICIAL -> \uD83D\uDC6E\uD83C\uDFFB"+
                "\nLADRÃO -> \uD83D\uDE08");

        System.out.println("Digite qualquer caracter para iniciar\n");
        sc.next();
        Pessoa pessoa1 = new Policial(1, "\uD83D\uDC6E\uD83C\uDFFB");
        Pessoa pessoa2 = new Ladrao(2, "\uD83D\uDE08");
        Pessoa pessoa3 = new Homem(3, "\uD83D\uDE4D\u200D♂\uFE0F");
        Pessoa pessoa4 = new Menino(4, "\uD83D\uDC66");
        Pessoa pessoa5 = new Menino(5, "\uD83D\uDC66");
        Pessoa pessoa6 = new Mulher(6, "\uD83D\uDE4D\u200D♀\uFE0F");
        Pessoa pessoa7 = new Menina(7, "\uD83D\uDC67");
        Pessoa pessoa8 = new Menina(8, "\uD83D\uDC67");

        Barco barco = new Barco();
        do {
            try {

                System.out.println(GerenT.retornarStatus(barco));

                System.out.println("digite o id");
                int id = sc.nextInt();
                System.out.println("\n\n\n\n\n\n\n\n\n\n");

                if(id==0){
                    //validação para a troca de margem
                    GerenT.validacaoDeTrocaDeMargem(barco.getMargemProxima(), barco);

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
                if(GerenT.checarVitoria()){
                    System.out.println("\uD83C\uDF89\uD83C\uDF89\uD83C\uDF89\uD83C\uDF89\uD83C\uDF89\uD83C\uDF89\uD83C\uDF89\uD83C\uDF89\uD83C\uDF89");
                    System.out.println("\uD83C\uDF89\uD83C\uDF89 PARABÉNS \uD83C\uDF89\uD83C\uDF89\uD83C\uDF89");
                    System.out.println("\uD83C\uDF89\uD83C\uDF89\uD83C\uDF89\uD83C\uDF89\uD83C\uDF89\uD83C\uDF89\uD83C\uDF89\uD83C\uDF89\uD83C\uDF89");
                    System.out.println("Você concluiu o jogo com SUCESSO!");
                    break;
                }




            } catch (Exception e) {
                System.out.println("▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇");
                System.out.println("  "+e.getMessage());
                System.out.println("▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇▇");

            }

        }while(true);


    }
}