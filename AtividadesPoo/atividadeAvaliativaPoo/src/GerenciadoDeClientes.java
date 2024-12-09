import java.util.ArrayList;

public class GerenciadoDeClientes {
    ArrayList<Cliente> listaClientes = new ArrayList<>();

    public String getGerenciadorDeClientesString() {
        String lista="";
        for(Cliente cliente:listaClientes){
            String add = cliente.toString();
            lista = lista+add+"\n\n";
        }
        return lista;
    }
    public void adicionarCliente(Cliente cliente){
        listaClientes.add(cliente);
    }
    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }
}
