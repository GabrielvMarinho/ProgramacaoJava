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
        for(FormaGeometrica forma : listaFormas){
            System.out.println("Quadrados");
            if(forma.getClass().getName().equals("Quadrado")){
                System.out.println(forma.toString());
            }
        }
        for(FormaGeometrica forma : listaFormas){
            System.out.println("Círculos");
            if(forma.getClass().getName().equals("Circulo")){
                System.out.println(forma.toString());
            }
        }
        for(FormaGeometrica forma : listaFormas){
            System.out.println("Triângulos");
            if(forma.getClass().getName().equals("Triangulo")){
                System.out.println(forma.toString());
            }
        }
        for(FormaGeometrica forma : listaFormas){
            System.out.println("Retângulos");
            if(forma.getClass().getName().equals("Retângulo")){
                System.out.println(forma.toString());
            }
        }
    }
    public void listarFormas(String classe){
        for(FormaGeometrica forma : listaFormas){
            if(forma.getClass().getName().equals(classe)){
                System.out.println(forma.toString());
            }
        }
    }
    public FormaGeometrica getLastForma(){
        return listaFormas.get(listaFormas.size()-1);
    }
}
