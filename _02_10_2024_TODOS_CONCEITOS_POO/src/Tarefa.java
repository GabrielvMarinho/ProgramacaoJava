public class Tarefa {

    private static int geradorIdTarefa=0;
    int id;
    String descricao;
    String prioridade;
    String status;
    Pessoa responsavel;

    public Tarefa(String descricao, String prioridade, Pessoa responsavel){
        this.id = geradorIdTarefa;
        geradorIdTarefa++;
        this.descricao = descricao;
        this.prioridade = prioridade;
        this.responsavel = responsavel;
        this.status = "Não Concluída";
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Tarefa{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", prioridade='" + prioridade + '\'' +
                ", status='" + status + '\'' +
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
