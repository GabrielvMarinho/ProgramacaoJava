public class ContasInexistentesException extends Exception {

    public ContasInexistentesException() {
        super("Nenhuma conta encontrada no sistema");
    }
}
