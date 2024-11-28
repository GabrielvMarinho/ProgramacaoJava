public class Evento {
    int id;
    String nome;
    String localidade;
    String data;
    String descricao;

    Evento(String nome, String localidade, String data, String descricao){
        this.nome = nome;
        this.localidade = localidade;
        this.data = data;
        this.descricao = descricao;
    }
    Evento(int id, String nome, String localidade, String data, String descricao){
        this.id = id;
        this.nome = nome;
        this.localidade = localidade;
        this.data = data;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getLocalidade() {
        return localidade;
    }

    public String getData() {
        return data;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "nome='" + nome + '\'' +
                ", localidade='" + localidade + '\'' +
                ", data='" + data + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }
    public String toStringId() {
        return "Evento{" +
                "id='" + id + '\'' +
                "nome='" + nome + '\'' +
                ", localidade='" + localidade + '\'' +
                ", data='" + data + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
