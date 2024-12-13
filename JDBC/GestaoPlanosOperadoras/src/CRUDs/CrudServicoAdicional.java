package CRUDs;

import Classes.Cliente;
import Classes.Plano;
import Classes.ServicoAdicional;
import DB.DB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CrudServicoAdicional {
    //classe responsável pelo crud do servico adicional

    public static ServicoAdicional cadastro(ServicoAdicional servicoAdicional){
        try(Connection con = DB.getConnection()){
            PreparedStatement ps =con.prepareStatement("""
                    INSERT INTO servico_adicional(descricao, custo_mensal)
                    VALUES(?, ?);
                    """, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, servicoAdicional.getDescricao());
            ps.setDouble(2, servicoAdicional.getCusto_mensal());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();

            if(rs.next()){
                servicoAdicional.setId(rs.getInt(1));
                return servicoAdicional;
            }
        }catch (SQLException e){
            System.err.println(e);
        }
        throw new RuntimeException();
    }
    public static List<ServicoAdicional> consulta(){
        List<ServicoAdicional> lista = new ArrayList<>();
        try(Connection con = DB.getConnection()){
            PreparedStatement ps = con.prepareStatement("""
                    SELECT * FROM servico_adicional
                    """);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                String descricao = rs.getString("descricao");
                double custo_mensal = rs.getDouble("custo_mensal");
                lista.add(new ServicoAdicional(id, descricao, custo_mensal));
            }
            return lista;
        }catch (SQLException e){
            System.err.println(e);
        }
        throw new RuntimeException();
    }
    public static ServicoAdicional consultaId(int idbusca){
        try(Connection con = DB.getConnection()){
            PreparedStatement ps = con.prepareStatement("""
                    SELECT * FROM servico_adicional WHERE id = ?
                    """);
            ps.setInt(1, idbusca);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                int id = rs.getInt("id");
                String descricao = rs.getString("descricao");
                double custo_mensal = rs.getDouble("custo_mensal");
                return new ServicoAdicional(id, descricao, custo_mensal);
            }
        }catch (SQLException e){
            System.err.println(e);
        }
        throw new RuntimeException();
    }
    public static void atualizacao(ServicoAdicional servicoAdicional){
        try(Connection con = DB.getConnection()){
            PreparedStatement ps = con.prepareStatement("""
                    UPDATE servico_adicional
                    SET descricao = ?,
                    custo_mensal = ?
                    WHERE id = ?;
                    """);
            ps.setString(1, servicoAdicional.getDescricao());
            ps.setDouble(2, servicoAdicional.getCusto_mensal());
            ps.setInt(3, servicoAdicional.getId());
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
                    DELETE FROM servico_adicional WHERE ID = ?
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
