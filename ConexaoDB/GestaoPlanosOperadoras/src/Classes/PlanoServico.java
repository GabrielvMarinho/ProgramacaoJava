package Classes;

public class PlanoServico {
    int id;
    Plano plano;
    ServicoAdicional servico;

    public PlanoServico(int id, Plano plano, ServicoAdicional servico) {
        this.id = id;
        this.plano = plano;
        this.servico = servico;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "PlanoServico{" +
                "id=" + id +
                ", plano=" + plano +
                ", servico=" + servico +
                '}';
    }
}
