public class ClienteInexistenteException extends Exception{
    ClienteInexistenteException(){
        super("Cliente não encontrado no sistema");
    }
}
