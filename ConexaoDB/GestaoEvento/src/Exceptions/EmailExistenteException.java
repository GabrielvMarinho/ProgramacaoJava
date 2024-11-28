package Exceptions;


public class EmailExistenteException extends Exception{
    public EmailExistenteException(){
        super("Email já existente!");
    }
}
