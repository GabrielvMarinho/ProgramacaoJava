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
            System.out.println("Digite sua escolha -> \n[ 0 ] Cadastrar Forma Geométrica \n[ 1 ] Listar Formas\n");
            switch(sc.nextInt()){
                case 0:
                    System.out.println("Digite qual forma cadastrar -> \n[ 0 ] Quadrado\n[ 1 ] Círculo\n[ 2 ] Triângulo { EM MANUTENÇÃO }\n" +
                            "[ 3 ] Retângulo\n");
                    switch(sc.nextInt()){
                        case 0:
                            do {
                                try {
                                    System.out.println("Digite o lado do quadrado: \n");
                                    double lado = sc.nextDouble();
                                    FormaGeometrica quadrado = new Quadrado(lado);
                                    professor.adicionarForma(quadrado);
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
                                    break;
                                }catch(IllegalArgumentException e){
                                    System.err.println("ERRO: "+e.getMessage());
                                }
                            }while(true);

                            break;

                        case 2:

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
                                    break;
                                }catch(IllegalArgumentException e){
                                    System.err.println("ERRO: "+e.getMessage());
                                }
                            }while(true);

                            break;

                    }
                    break;

                case 1:
                    System.out.println("Digite qual forma listar -> [ 0 ] TODOS \n[ 1 ] Quadrado\n[ 2 ] Círculo\n[ 3 ] Triângulo { EM MANUTENÇÃO }\n" +
                            "[ 4 ] Retângulo\n");
                    switch (sc.nextInt()){
                        case 0:
                            professor.listarFormas();
                            break;
                        case 1:///descobrir como listar uma classe específica
                            professor.listarFormas();
                            break;
                    }
                    break;

            }


        }while(login==true);

    }
}
