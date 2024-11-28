import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BancoDeDados {

    private final String URL = "jdbc:mysql://localhost:3306/db_sistema_bancario?"+"createDatabaseIfNotExist=true";
    private final String USER = "root";
    private final String PASSWORD = "";

    public Connection getConnection() throws SQLException {
        //class - gerencia drivers de banco de dados
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

//    private List<Conta> contas = new ArrayList<>();
//
//    public void inserirConta(Conta conta){
//        this.contas.add(conta);
//
//    }
////    public void deletarConta(int numero){
////        Conta conta = buscarConta(numero);
////        this.contas.remove(conta);
////    }
//    public void deletarConta(Conta conta){
//        this.contas.remove(conta);
//    }
//
//    public Conta buscarConta(int numero){
//        for(Conta conta : this.contas){
//            if(conta.getNumero()==numero){
//                return conta;
//            }
//        }
//        throw new ContaInexistenteException();
//    }
//    public List<Conta> buscarContas(){
//        return this.contas;
//    }
//
//    public void atualizarConta(Conta conta){
//        int indice = this.contas.indexOf(conta);
//        if(indice==-1){
//            throw new ContaInexistenteException();
//        }
//        this.contas.set(indice, conta);
//    }
}
