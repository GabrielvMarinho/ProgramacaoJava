import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String [] args){
        PessoaCrud pessoaCrud = new PessoaCrud();
        EnderecoCrud enderecoCrud = new EnderecoCrud();

//        pessoaCrud.salvar(new Pessoa(12312354366L, "sad"));
//        pessoaCrud.salvar(new Pessoa(12312354306L, "sad"));
//        pessoaCrud.salvar(new Pessoa(12312354306L, "sdadasdasd"));
//        pessoaCrud.remover(12312354306L);

//        System.out.println(enderecoCrud.salvar(new Endereco(23123, 123123)));
        System.out.println(enderecoCrud.salvar(new Endereco(17, 999,new Pessoa(12312354309L, "asdasd"))));
        enderecoCrud.remover(2);

        //        System.out.println(pessoaCrud.buscarTodos());
    }
}
