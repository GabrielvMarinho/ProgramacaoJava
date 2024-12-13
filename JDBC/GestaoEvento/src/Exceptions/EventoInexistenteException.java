package Exceptions;

public class EventoInexistenteException extends Exception{
    public EventoInexistenteException(){
        super("Nenhum Evento Encontrado!");
    }
}
