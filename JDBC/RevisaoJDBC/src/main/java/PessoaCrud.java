import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class PessoaCrud {

    private final Conexao conexao = new Conexao();


    private String comando;

    public Pessoa buscarUm(Long cpf) {



        comando = "select * from pessoa where cpf = ?";

        try{

            Connection con = conexao.getConnection();
            PreparedStatement ps = con.prepareStatement(comando);
            ps.setLong(1, cpf);
            System.out.println(ps);


            try(ResultSet rs = ps.executeQuery()){
                if(rs.next()) {
                    return criarObjeto(rs);
                }else{
                    throw new NoSuchElementException();
                }
            }



        }catch (SQLException e){
            throw new RuntimeException();
        }
    }
    private Pessoa criarObjeto(ResultSet rs) throws SQLException {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(rs.getString("nome"));
        pessoa.setCpf(rs.getLong("cpf"));
        EnderecoCrud enderecoCrud = new EnderecoCrud();

        pessoa.setEnderecos(enderecoCrud.buscarPorCpf(pessoa.getCpf()));

        for(Endereco e : pessoa.getEnderecos()){
            e.setPessoa(pessoa);
        }
        return pessoa;
    }

    public List<Pessoa> buscarTodos(){
        comando = "select * from pessoa";

        try (
                Connection con = conexao.getConnection();
                PreparedStatement ps = con.prepareStatement(comando);
                ResultSet rs = ps.executeQuery()
        ){

            List<Pessoa> pessoas = new ArrayList<>();

            while(rs.next()) {
                pessoas.add(criarObjeto(rs));
            }

            return pessoas;


        }catch (SQLException e){
            throw new RuntimeException();
        }
    }
    public void remover(Long cpf){
        comando = "delete from pessoa where cpf = ?";
        try(
                Connection con = conexao.getConnection();
            PreparedStatement ps = con.prepareStatement(comando)
        ){
            ps.setLong(1, cpf);
            System.out.println(ps);

            ps.execute();

        }catch (SQLException e){
            throw new RuntimeException();
        }
    }

    public Pessoa salvar(Pessoa pessoa){
        try {
            buscarUm(pessoa.getCpf());
            return editar(pessoa);
        }catch (NoSuchElementException e){
            return cadastrar(pessoa);
        }
    }

    private Pessoa cadastrar(Pessoa pessoa){

        comando = "insert into pessoa(cpf, nome) values(?, ?)";
        try(Connection con = conexao.getConnection();
        PreparedStatement ps = con.prepareStatement(comando)){
            ps.setLong(1, pessoa.getCpf());
            ps.setString(2, pessoa.getNome());

            ps.execute();

            return pessoa;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private Pessoa editar(Pessoa pessoa){
        comando = "update pessoa set nome = ? where cpf = ?";
        try(Connection con = conexao.getConnection();
            PreparedStatement ps = con.prepareStatement(comando)
        ) {
            ps.setString(1, pessoa.getNome());
            ps.setLong(2, pessoa.getCpf());
            ps.execute();
            return pessoa;
        }catch (SQLException e){
            throw new RuntimeException();
        }
    }
}
