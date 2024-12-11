package CRUDs;

import Classes.Cliente;
import Classes.Plano;
import Classes.ServicoAdicional;
import DB.DB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CrudCliente {
    //classe responsável pelo crud do cliente

    public static Cliente cadastro(Cliente cliente){
        try(Connection con = DB.getConnection()){
            PreparedStatement ps =con.prepareStatement("""
                    INSERT INTO cliente(nome, email, telefone, id_plano)
                    VALUES(?, ?, ?, ?);
                    """, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getEmail());
            ps.setString(3, cliente.getTelefone());
            Object id_plano = cliente.getPlanoId();
            ps.setObject(4, id_plano);

            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();

            if(rs.next()){
                cliente.setId(rs.getInt(1));
                return cliente;
            }
        }catch (SQLException e){
            System.err.println(e);
        }
        throw new RuntimeException();
    }

    public static List<Cliente> consulta(){
        List<Cliente> lista = new ArrayList<>();
        try(Connection con = DB.getConnection()){
            PreparedStatement ps = con.prepareStatement("""
                    SELECT * FROM cliente;
                    """);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                String telefone = rs.getString("telefone");
                Plano plano=null;
                if(!(rs.getInt("id_plano")==0)){
                    plano = CrudPlano.consultaIndividual(rs.getInt("id_plano"));

                }
                lista.add(new Cliente(id, nome, email, telefone, plano));
            }
            return lista;
        }catch (SQLException e){
            System.err.println(e);
        }
        throw new RuntimeException();
    }
    public static Cliente consultaId(int idbusca){
        try(Connection con = DB.getConnection()){
            PreparedStatement ps = con.prepareStatement("""
                    SELECT * FROM cliente WHERE id = ?
                    """);
            ps.setInt(1, idbusca);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                String telefone = rs.getString("telefone");
                Plano plano = CrudPlano.consultaIndividual(rs.getInt("id"));
                return new Cliente(id, nome, email, telefone, plano);
            }
        }catch (SQLException e){
            System.err.println(e);
        }
        throw new RuntimeException();
    }

    public static void atualizacao(Cliente cliente){
        try(Connection con = DB.getConnection()){
            PreparedStatement ps = con.prepareStatement("""
                    UPDATE cliente
                    SET nome = ?,
                    email = ?,
                    telefone = ?,
                    id_plano = ?
                    WHERE id = ?;
                    """);
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getEmail());
            ps.setString(3, cliente.getTelefone());
            ps.setObject(4, cliente.getPlanoId());
            ps.setInt(5, cliente.getId());
            if(ps.executeUpdate()>0){
                return;
            }
        }catch (SQLException e){
            System.err.println(e);
        }
        throw new RuntimeException();
    }

    public static void remocao(int id){
        try(Connection con = DB.getConnection()){
            PreparedStatement ps = con.prepareStatement("""
                    DELETE FROM cliente WHERE ID = ?
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
