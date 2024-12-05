package Classes;

public class ServicoAdicional {
    int id;
    String descricao;
    double custo_mensal;

    @Override
    public String toString() {
        return "ServicoAdicional{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", custo_mensal=" + custo_mensal +
                '}';
    }

    public ServicoAdicional(int id, String descricao, double custo_mensal){
        this.id = id;
        this.descricao = descricao;
        this.custo_mensal = custo_mensal;
    }
    public ServicoAdicional(String descricao, double custo_mensal){
        this.descricao = descricao;
        this.custo_mensal = custo_mensal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getCusto_mensal() {
        return custo_mensal;
    }
}
