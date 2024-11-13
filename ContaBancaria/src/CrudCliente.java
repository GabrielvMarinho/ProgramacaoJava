import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CrudCliente {

    BancoDeDados banco = new BancoDeDados();

    public List<Cliente> readAll() {
        List<Cliente> clientes = new ArrayList<>();

        try (Connection con = banco.getConnection()) {
            PreparedStatement ps = con.prepareStatement("""
                    SELECT * FROM tb_cliente
                                
                    """);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(1);
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                clientes.add(new Cliente(id, nome, cpf));

            }
            return clientes;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientes;

    }

    public Cliente readOne(int idCliente) throws ClienteInexistenteException {
        try (Connection con = banco.getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM tb_cliente WHERE id = ?");
            ps.setInt(1, idCliente);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                return new Cliente(id, nome, cpf);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new RuntimeException();
    }

    public Cliente create(Cliente cliente) {
        try (Connection con = banco.getConnection()) {
            PreparedStatement ps = con.prepareStatement("""
                            INSERT INTO tb_cliente(nome, cpf) VALUES(?, ?)
                            """,
                    //especifies that sql has to return the generated primary keys
                    /**you could just put a "1", because the value of
                     * "Statement.RETURN_GENERATED_KEYS" id "1", it's just
                     * an attempt to make it look better
                     **/
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getCpf());
            ps.execute();
            //get the resultSet of the columns of primary keys
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                cliente.setId(rs.getInt("id"));
                return cliente;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new RuntimeException();
    }

    public void delete(Cliente cliente){
        try (Connection con = banco.getConnection()) {
            PreparedStatement ps = con.prepareStatement("""
                    DELETE FROM tb_cliente WHERE id = ?
                        
                    """);
            ps.setInt(1, cliente.getId());
            ps.execute();
            return;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new RuntimeException();
    }

    public void update(Cliente cliente) throws ClienteInexistenteException {
        try (Connection con = banco.getConnection()) {
            PreparedStatement ps = con.prepareStatement("""
                    UPDATE TABLE tb_cliente WHERE id = ?
                    SET nome = ?, cpf = ?
                    """);
            ps.setString(1, cliente.getNome());
            ps.setInt(2, cliente.getId());
            ps.execute();
            return;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new RuntimeException();

    }
}
