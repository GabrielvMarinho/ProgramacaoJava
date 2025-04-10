import java.util.List;

public class Pessoa {
    private Long cpf;
    private String nome;
    private List<Endereco> enderecos;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public Long getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public Pessoa(Long cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }
    public Pessoa(Long cpf, String nome, List<Endereco> endereco) {
        this.cpf = cpf;
        this.nome = nome;
        this.enderecos= endereco;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "cpf=" + cpf +
                ", nome='" + nome + '\'' +
                ", enderecos=" + enderecos +
                '}'+"\n";
    }


    public Pessoa(){}
}
