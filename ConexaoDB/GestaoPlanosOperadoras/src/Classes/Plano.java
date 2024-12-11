package Classes;

public class Plano {
    int id;
    String operadora;
    String nome;
    double quantidade_dados;
    double quantidade_dados_bonus;
    String beneficios;
    double valor;

    public Plano(int id, String operadora, String nome, double quantidade_dados, double quantidade_dados_bonus, String beneficios, double valor){
        this.id = id;
        this.operadora = operadora;
        this.nome = nome;
        this.quantidade_dados = quantidade_dados;
        this.quantidade_dados_bonus = quantidade_dados_bonus;
        this.beneficios = beneficios;
        this.valor = valor;
    }
    public Plano(String operadora, String nome, double quantidade_dados, double quantidade_dados_bonus, String beneficios, double valor){
        this.id = id;
        this.operadora = operadora;
        this.nome = nome;
        this.quantidade_dados = quantidade_dados;
        this.quantidade_dados_bonus = quantidade_dados_bonus;
        this.beneficios = beneficios;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Plano{" +
                "id=" + id +
                ", operadora='" + operadora + '\'' +
                ", nome='" + nome + '\'' +
                ", quantidade_dados=" + quantidade_dados +
                ", quantidade_dados_bonus=" + quantidade_dados_bonus +
                ", beneficios='" + beneficios + '\'' +
                ", valor=" + valor +
                '}';
    }

    public void setOperadora(String operadora) {
        this.operadora = operadora;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setQuantidade_dados(double quantidade_dados) {
        this.quantidade_dados = quantidade_dados;
    }

    public void setQuantidade_dados_bonus(double quantidade_dados_bonus) {
        this.quantidade_dados_bonus = quantidade_dados_bonus;
    }

    public void setBeneficios(String beneficios) {
        this.beneficios = beneficios;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getOperadora() {
        return operadora;
    }
    public String getNome() {
        return nome;
    }
    public double getQuantidade_dados() {
        return quantidade_dados;
    }
    public double getQuantidade_dados_bonus() {
        return quantidade_dados_bonus;
    }
    public String getBeneficios() {
        return beneficios;
    }
    public double getValor() {
        return valor;
    }
}
