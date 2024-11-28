package Exceptions;


public class NomeExistenteException extends Exception{
    public NomeExistenteException(){
        super("Nome já existente!");
    }
}
