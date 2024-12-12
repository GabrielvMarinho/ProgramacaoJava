package Classes;

public class Evento {
    int id;
    String nome;
    String data;
    String localidade;
    String descricao;

    public Evento(int id, String nome, String data, String localidade, String descricao) {
        this.id = id;
        this.nome = nome;
        this.data = data;
        this.localidade = localidade;
        this.descricao = descricao;
    }

    public Evento(String nome, String data, String localidade, String descricao) {
        this.nome = nome;
        this.data = data;
        this.localidade = localidade;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", data='" + data + '\'' +
                ", localidade='" + localidade + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }

    public String getData() {
        return data;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getLocalidade() {
        return localidade;
    }
}
