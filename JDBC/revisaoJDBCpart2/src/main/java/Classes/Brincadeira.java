package Classes;

public class Brincadeira {
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

    @Override
    public String toString() {
        return "Brincadeira{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
