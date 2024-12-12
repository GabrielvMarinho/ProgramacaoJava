import java.sql.*;
import java.util.ArrayList;

public class CRUD {
    DB db = new DB();

    public ArrayList<Funcionario> select(){
        ArrayList<Funcionario> lista = new ArrayList<>();
        try(Connection con = db.getConnection()){
            PreparedStatement ps = con.prepareStatement("""
                       SELECT * FROM funcionario;
                    """);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                lista.add(new Funcionario(id, nome));
            }
            return lista;
        }catch (SQLException e){
            System.err.println(e);
        }
        throw new RuntimeException();
    }

    public Funcionario create(Funcionario funcionario){
        try(Connection con = db.getConnection()){
            PreparedStatement ps = con.prepareStatement("""
                    INSERT INTO funcionario(nome) VALUES(?);
                    """, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, funcionario.getNome());

            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();

            if(rs.next()){
                funcionario.setId(rs.getInt(1));
                return funcionario;
            }


        }catch (SQLException e){
            System.err.println(e);
        }
        throw new RuntimeException();
    }

    public Funcionario update(int id, Funcionario funcionario){
        try(Connection con = db.getConnection()){
            PreparedStatement ps = con.prepareStatement("""
                    UPDATE funcionario SET nome = ? WHERE id = ?;
                    """);
            ps.setString(1, funcionario.getNome());
            ps.setInt(2, id);

            if(ps.executeUpdate()>0) {
                funcionario.setId(id);
                return funcionario;
            }


        }catch (SQLException e){
            System.err.println(e);
        }
        throw new RuntimeException();
    }

    public void delete(int id){
        try(Connection con = db.getConnection()){
            PreparedStatement ps = con.prepareStatement("""
                    DELETE FROM funcionario WHERE id = ?;
                    """);
            ps.setInt(1, id);
            if(ps.executeUpdate()>0){
                return;
            }
        }catch (SQLException e){
            System.err.println(e);
        }
        throw new RuntimeException();
    }
}
