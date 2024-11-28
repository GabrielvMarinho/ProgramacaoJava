package Exceptions;


public class ParticipanteInexistenteException extends Exception{
    public ParticipanteInexistenteException(){
        super("Nenhum Participante Encontrado!");
    }
}
