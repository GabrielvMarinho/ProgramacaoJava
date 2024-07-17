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
            System.out.println(forma.toString());
        }
    }
}
