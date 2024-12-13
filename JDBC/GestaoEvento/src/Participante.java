public class Participante {
    private int id;
    private String nome;
    private String email;

    Participante(String nome, String email){
        this.nome = nome;
        this.email = email;
    }
    Participante(int id, String nome, String email){
        this.id = id;
        this.nome = nome;
        this.email = email;
    }
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Participante{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
    public String toStringId() {
        return "Participante{" +
                "id='" + id + '\'' +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
