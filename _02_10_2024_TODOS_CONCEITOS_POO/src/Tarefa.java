public class Tarefa {
    String descricao;
    String prioridade;
    String status;

    Pessoa responsavel;

    public Tarefa(String descricao, String prioridade, Pessoa responsavel){
        this.descricao = descricao;
        this.prioridade = prioridade;
        this.responsavel = responsavel;
        this.status = "Não Concluída";
    }


    @Override
    public String toString() {
        return "Tarefa{" +
                "descricao='" + descricao + '\'' +
                ", prioridade='" + prioridade + '\'' +
                ", responsavel=" + responsavel +
                '}';
    }

    public Pessoa getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Pessoa responsavel) {
        this.responsavel = responsavel;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPrioridade() {
        return this.prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }
}
