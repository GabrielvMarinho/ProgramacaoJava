package Exceptions;

public class ErroInsercaoException extends Exception{
    public ErroInsercaoException(){
        super("Erro na inserção, verifique a consistência dos dados");
    }
}
