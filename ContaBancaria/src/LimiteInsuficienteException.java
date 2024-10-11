public class LimiteInsuficienteException  extends ContaException{

    public LimiteInsuficienteException(){
        super("Não é possível realizar a operação para a própria conta.");
    }
}
