import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CRUDConta {
    private final BancoDeDados banco = new BancoDeDados();


    //create an account
    public void create(Conta conta){
        try (Connection con = banco.getConnection()){
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO tb_conta " +
                            "(numero, id_cliente, saldo, limite)" +
                            "VALUES(?, ?, ?, ?)");
            //setting the values of the query looking forward to a sql injection free system
            ps.setInt(1, conta.getNumero());
            ps.setInt(2, conta.getTitular().getId());
            ps.setDouble(3, conta.getSaldo());
            ps.setDouble(4, conta.getLimite());
            ps.execute();
        } catch(SQLException e){
            System.err.println(e.getMessage());
        }

    }

    //reads a single account only
    public Conta read(int numero) throws ContaInexistenteException{
        try( Connection con = banco.getConnection()){
            PreparedStatement ps = con.prepareStatement(
                    "SELECT * FROM tb_conta WHERE numero = ?") ;
            ps.setInt(1, numero);
            /*
            is used to format an Object to print it correctly
             (It comes all messed up from te database)
             */
            ResultSet rs = ps.executeQuery();

            /*
            next returns a boolean and goes to the next line
            the first position before de next is like a -1 in an array [ doesn't exist ]
            only one next because its one query ( no repetition structure )
            if it doesn't exist it will just skip the if
             */
            if (rs.next()){
                //get the column "numero" specifically
                int num = rs.getInt("numero");
                //get the column "titular" specifically
                int idCliente = rs.getInt("id_cliente");
                //get the column "saldo" specifically
                double saldo = rs.getDouble("saldo");
                //get the column "limite" specifically
                double limite = rs.getDouble("limite");
                CrudCliente crudCliente = new CrudCliente();
                Cliente titular = crudCliente.readOne(idCliente);

                return new Conta(num, titular, saldo, limite);
            };
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
        throw new ContaInexistenteException();
    }

    //reads a list of accounts
    public List<Conta> readAll() throws ContasInexistentesException{
        List<Conta> lista = new ArrayList<>();
        try(Connection con = banco.getConnection()){
            PreparedStatement p = con.prepareStatement(
                    "SELECT * FROM tb_conta");

            ResultSet rs = p.executeQuery();

            while(rs.next()){
                int numero = rs.getInt("numero");
                int idCliente = rs.getInt("id_cliente");
                double saldo = rs.getDouble("saldo");
                double limite = rs.getDouble("limite");
                CrudCliente crudCliente = new CrudCliente();
                Cliente titular = crudCliente.readOne(idCliente);

                Conta conta = new Conta(numero, titular, saldo, limite);
                lista.add(conta);

            }

            return lista;
        }catch(SQLException e){
            System.err.println("erro ao pegar a lista "+e.getMessage());
        }
        throw new ContasInexistentesException();
    }
    //will update the saldo of an account
    public void update(Conta conta) throws ContaInexistenteException {
        try(Connection con = banco.getConnection()){
            PreparedStatement ps = con.prepareStatement(
                    "UPDATE tb_conta " +
                            "SET id_cliente = ?" +
                            ", saldo = ?" +
                            ", limite = ?" +
                            " WHERE numero = ?;");
            ps.setInt(1, conta.getTitular().getId());
            ps.setDouble(2, conta.getSaldo());
            ps.setDouble(3, conta.getLimite());
            ps.setDouble(4, conta.getNumero());
            ps.execute();
            return;
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
        throw new ContaInexistenteException();
    }
    public void delete(int numero){
        try( Connection con = banco.getConnection()){
            PreparedStatement ps = con.prepareStatement(
                    "DELETE FROM tb_conta WHERE numero = ?");
            ps.setDouble(1, numero);
            ps.execute();
            return;
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
        throw new ContaInexistenteException();

    }


}
