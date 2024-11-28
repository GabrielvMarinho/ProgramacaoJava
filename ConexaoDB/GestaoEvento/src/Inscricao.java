public class Inscricao {
    int id;
    Evento evento;
    Participante participante;

    Inscricao(int id, Evento evento, Participante participante){
        this.id = id;
        this.evento = evento;
        this.participante = participante;
    }

    @Override
    public String toString() {
        return "Inscricao{" +
                "id=" + id +
                ", evento=" + evento.getNome() +
                ", participante=" + participante.getNome() +
                '}';
    }
}
