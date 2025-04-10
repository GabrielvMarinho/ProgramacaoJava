import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class EnderecoCrud {

    private final Conexao conexao = new Conexao();

    private String comando;

    public Endereco buscarUm(int id){
        comando = "select * from endereco where id = ?";

        try
            (Connection con = conexao.getConnection();
            PreparedStatement ps = con.prepareStatement(comando)){


            ps.setInt(1, id);

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

    private Endereco criarObjetoSemPessoa(ResultSet rs) throws SQLException {
        Endereco endereco = new Endereco();
        endereco.setId(rs.getInt("id"));
        endereco.setCep(rs.getInt("cep"));
        endereco.setNumero(rs.getInt("numero"));
        Long cpf = rs.getLong("cpf");
        return endereco;
    }
    private Endereco criarObjeto(ResultSet rs) throws SQLException {
        Endereco endereco = new Endereco();
        endereco.setId(rs.getInt("id"));
        endereco.setCep(rs.getInt("cep"));
        endereco.setNumero(rs.getInt("numero"));
        Long cpf = rs.getLong("cpf");
        try{
            PessoaCrud pessoaCrud = new PessoaCrud();
            endereco.setPessoa(pessoaCrud.buscarUm(cpf));
        }catch (Exception ignore){

        }finally {
            return endereco;
        }
    }


    public List<Endereco> buscarTodos(){
        comando = "select * from endereco";

        try (
            Connection con = conexao.getConnection();
            PreparedStatement ps = con.prepareStatement(comando);
            ResultSet rs = ps.executeQuery()
            ){

            List<Endereco> enderecos = new ArrayList<>();

            while(rs.next()) {
                enderecos.add(criarObjeto(rs));
            }

            return enderecos;


        }catch (SQLException e){
            throw new RuntimeException();
        }
    }



    public void remover(int id){
        comando = "delete from endereco where id = ?";
        try(
                Connection con = conexao.getConnection();
                PreparedStatement ps = con.prepareStatement(comando)
        ){
            ps.setInt(1, id);
            ps.execute();

        }catch (SQLException e){
            throw new RuntimeException();
        }
    }

    public Endereco salvar(Endereco endereco) throws NoSuchElementException{

        try {
            buscarUm(endereco.getId());
            return editar(endereco);

        }catch (NoSuchElementException e){
            return cadastrar(endereco);
        }

    }

    private Endereco cadastrar(Endereco endereco){
        if(endereco.getPessoa() ==null){
            comando = "insert into endereco(cep, numero) values(?, ?)";
        }else{
            comando = "insert into endereco(cep, numero, cpf) values(?, ?, ?)";
        }
        try(Connection con = conexao.getConnection();
            PreparedStatement ps = con.prepareStatement(comando, Statement.RETURN_GENERATED_KEYS)){
            ps.setInt(1, endereco.getCep());
            ps.setInt(2, endereco.getNumero());
            if(endereco.getPessoa() != null){

                ps.setLong(3, endereco.getPessoa().getCpf());
            }
            System.out.println(ps);
            ps.execute();
            try(ResultSet rs = ps.getGeneratedKeys()){
                if(rs.next()){
                    endereco.setId(rs.getInt(1));
                }
            }
            return endereco;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Endereco editar(Endereco endereco){
        if(endereco.getPessoa()==null){
            comando = "update endereco set cep = ?, numero = ? where id = ?";
        }else{
            comando = "update endereco set cep = ?, numero = ?, cpf = ? where id = ?";

        }
        try(Connection con = conexao.getConnection();
            PreparedStatement ps = con.prepareStatement(comando)
        ) {
            ps.setInt(1, endereco.getCep());
            ps.setInt(2, endereco.getNumero());
            if(endereco.getPessoa() ==null){
                ps.setInt(3, endereco.getId());
            }else{
                ps.setLong(3, endereco.getPessoa().getCpf());
                ps.setInt(4, endereco.getId());
            }
            ps.execute();
            return endereco;
        }catch (SQLException e){
            throw new RuntimeException();
        }
    }

    public List<Endereco> buscarPorCpf(Long cpf) {
//        return buscarTodos().stream().filter(e -> e.getPessoa().getCpf() == cpf).toList();
        comando = "select * from endereco where cpf = ?";

        try (
                Connection con = conexao.getConnection();
                PreparedStatement ps = con.prepareStatement(comando);

        ){
            ps.setLong(1, cpf);
            try(ResultSet rs = ps.executeQuery()) {

                List<Endereco> enderecos = new ArrayList<>();

                while (rs.next()) {
                    enderecos.add(criarObjetoSemPessoa(rs));
                }

                return enderecos;
            }

        }catch (SQLException e){
            throw new RuntimeException();
        }
    }
}
