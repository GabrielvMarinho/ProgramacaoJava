public class PropriaContaException extends ContaException{

    public PropriaContaException(){
        super("não é possivel realizar a operação para a própria conta");
    }
}
