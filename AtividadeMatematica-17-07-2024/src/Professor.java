import java.text.Normalizer;
import java.util.ArrayList;

public class Professor {

    String senha="123";

    ArrayList<FormaGeometrica> listaFormas = new ArrayList<>();

    public boolean checarSenha(String tentativaSenha){
        if(tentativaSenha.equals(senha)){
            return true;
        }
        return false;
    }
    public void adicionarForma(FormaGeometrica forma){
        listaFormas.add(forma);
    }

    public void listarFormas(){
        System.out.println("Quadrados_____________________");
        for(FormaGeometrica forma : listaFormas){
            if(forma.getClass().getName().equals("Quadrado")){
                System.out.println(forma.toString());
                System.out.println("_____________________");
            }
        }
        System.out.println("Círculos_____________________");
        for(FormaGeometrica forma : listaFormas){
            if(forma.getClass().getName().equals("Circulo")){
                System.out.println(forma.toString());
                System.out.println("_____________________");

            }
        }
        System.out.println("Triângulos_____________________");
        System.out.println("Isosceles-------------------");
        for(FormaGeometrica forma : listaFormas){
            if(forma.getClass().getName().equals("Isosceles")){
                System.out.println(forma.toString());
                System.out.println("_____________________");
            }
        }
        System.out.println("Escaleno-------------------");
        for(FormaGeometrica forma : listaFormas){
            if(forma.getClass().getName().equals("Escaleno")){
                System.out.println(forma.toString());
                System.out.println("_____________________");
            }
        }
        System.out.println("Equilatero-------------------");
        for(FormaGeometrica forma : listaFormas){
            if(forma.getClass().getName().equals("Equilatero")){
                System.out.println(forma.toString());
                System.out.println("_____________________");
            }
        }
        System.out.println("Retângulos_____________________");
        for(FormaGeometrica forma : listaFormas){
            if(forma.getClass().getName().equals("Retangulo")){
                System.out.println(forma.toString());
                System.out.println("_____________________");

            }
        }
    }
    public void listarFormas(String classe){
        System.out.println(classe+"_____________________");
        for(FormaGeometrica forma : listaFormas){
            if(forma.getClass().getName().equals(classe)){
                System.out.println(forma.toString());
                System.out.println("_____________________");
            }
        }
    }
    public FormaGeometrica getLastForma(){
        return listaFormas.get(listaFormas.size()-1);
    }
}
