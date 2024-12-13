public class Cliente {
    private int id;
    private String nome;
    private String cpf;
    private Conta conta;

    public void setId(int id) {
        this.id = id;
    }

    public Cliente(int id, String nome, String cpf){
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;

    }
    public Cliente(String nome, String cpf){
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", conta=" + conta +
                '}';
    }

    public String getCpf() {
        return cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public int getId() {
        return id;
    }
}
