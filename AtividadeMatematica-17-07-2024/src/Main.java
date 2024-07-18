import java.awt.event.ItemEvent;
import java.util.Scanner;
// -> comentario
/// -> tarefa
public class Main {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int contTentativasSenhas=0;
        Professor professor = new Professor();
        boolean login=false;



        //checando a senha -----------------------------------------------------------------------
        while(true) {
            System.out.println("Digite a senha: (123)");
            if (professor.checarSenha(sc.next()) == true) {
                login = true;
                break;
            } else {
                contTentativasSenhas++;
                if (contTentativasSenhas == 3) {
                    System.exit(0);
                }

            }
            System.err.println("Tentativa Inválida ("+(3-contTentativasSenhas)+" tentativas restantes)");

        }

        //login realizado -----------------------------------------------------------------------

        do{
            System.out.println("\n\n\n\nDigite sua escolha -> \n[ 0 ] Cadastrar Forma Geométrica \n[ 1 ] Listar Formas\n");
            switch(sc.nextInt()){
                case 0:

                    System.out.println("Digite qual forma cadastrar -> \n[ 0 ] Quadrado\n[ 1 ] Círculo\n[ 2 ] Triângulo\n" +
                            "[ 3 ] Retângulo\n");
                    switch(sc.nextInt()){
                        case 0:
                            do {
                                try {
                                    System.out.println("Digite o lado do quadrado: \n");
                                    double lado = sc.nextDouble();
                                    FormaGeometrica quadrado = new Quadrado(lado);
                                    professor.adicionarForma(quadrado);
                                    System.out.println("VOCE CADASTROU UM QUADRADO: ");
                                    System.out.println(professor.getLastForma().toString());
                                    break;
                                } catch (IllegalArgumentException e) {
                                    System.err.println("ERRO: " + e.getMessage());
                                }
                            }while(true);
                            break;

                        case 1:
                            do{
                                try{
                                    System.out.println("Digite o raio do círculo: \n");
                                    double raio = sc.nextDouble();
                                    FormaGeometrica circulo = new Circulo(raio);
                                    professor.adicionarForma(circulo);
                                    System.out.println("VOCE CADASTROU UM CIRCULO: ");
                                    System.out.println(professor.getLastForma().toString());
                                    break;
                                }catch(IllegalArgumentException e){
                                    System.err.println("ERRO: "+e.getMessage());
                                }
                            }while(true);

                            break;

                        case 2:
                            do {
                                try {
                                    System.out.println("Digite o valor da hipotenusa: ");
                                    double hipotenusa = sc.nextDouble();
                                    System.out.println("Digite o valor do primeiro cateto: ");
                                    double cateto1 = sc.nextDouble();
                                    System.out.println("Digite o valor do segundo cateto: ");
                                    double cateto2 = sc.nextDouble();
                                    professor.adicionarForma(Triangulo.retornarTipoEspecifico(hipotenusa, cateto1, cateto2));
                                    System.out.println("VOCE CADASTROU UM TRIANGULO: ");
                                    System.out.println(professor.getLastForma().toString());
                                    break;
                                } catch (IllegalArgumentException e) {
                                    System.err.println("ERRO: " + e.getMessage());
                                }
                            }while(true);
                            break;
                        case 3:
                            do{
                                try{
                                    System.out.println("Digite a largura do retângulo: \n");
                                    double largura = sc.nextDouble();
                                    System.out.println("Digite a altura do retângulo: \n");
                                    double altura = sc.nextDouble();
                                    FormaGeometrica retangulo = new Retangulo(largura, altura);
                                    professor.adicionarForma(retangulo);
                                    System.out.println("VOCE CADASTROU UM RETANGULO: ");
                                    System.out.println(professor.getLastForma().toString());
                                    break;
                                }catch(IllegalArgumentException e){
                                    System.err.println("ERRO: "+e.getMessage());
                                }
                            }while(true);
                            break;

                    }
                    break;

                case 1:
                    System.out.println("Digite qual forma listar -> [ 0 ] TODOS \n[ 1 ] Quadrado\n[ 2 ] Círculo\n[ 3 ] Triângulo \n" +
                            "[ 4 ] Retângulo\n");
                    switch (sc.nextInt()){
                        case 0:
                            professor.listarFormas();
                            break;
                        case 1:
                            professor.listarFormas("Quadrado");
                            break;
                        case 2:
                            professor.listarFormas("Circulo");
                            break;
                        case 3:
                            System.out.println("Isosceles--------------");
                            professor.listarFormas("Isosceles");
                            System.out.println("Escalenos--------------");
                            professor.listarFormas("Escaleno");
                            System.out.println("Equilateros--------------");
                            professor.listarFormas("Equilatero");
                            break;
                        case 4:
                            professor.listarFormas("Retangulo");
                            break;
                    }
                    break;

            }


        }while(login==true);

    }


}
