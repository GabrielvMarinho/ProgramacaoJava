import java.util.ArrayList;
import java.util.List;

public class Barco {
    Pessoa[] pessoas = new Pessoa[2];

    boolean lado = false; ///false esquerda - true direita

    public void mudarLado() throws ExceptionSemAdultoBarco {
        if(!(pessoas[0] instanceof Adulto)&&!(pessoas[1] instanceof Adulto))
            throw new ExceptionSemAdultoBarco();
        lado = !lado;
    };

    public ArrayList<Pessoa> getMargemProxima(){
        if(lado){
            return GerenT.getMargemDireita();
        }
        return GerenT.getMargemEsquerda();
    }
    public Pessoa[] listaPessoas(){
        return pessoas;

    }
    public void retirarPessoa(Pessoa pessoa){
        if(pessoa == pessoas[0]){
            pessoas[0] =null;
        }
        else{
            pessoas[1]=null;
        }
    }
    public void adicionarPessoa(Pessoa pessoa) throws ExceptionBarcoCheio{
        if(pessoas[0]==null){
            pessoas[0]=pessoa;
        }
        else if(pessoas[1]==null){
            pessoas[1]=pessoa;
        }
        else{
            throw new ExceptionBarcoCheio();
        }
    }
}
