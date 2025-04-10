package Classes;

public class Alimento {
    Integer id;
    String nome;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Alimento(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Alimento(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Alimento{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
