package CRUDs;

import Classes.Cliente;
import Classes.Contrato;
import Classes.Plano;
import DB.DB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CrudContrato {
    //classe responsável pelo crud do contrato

    public static Contrato cadastro(Contrato contrato){
        try(Connection con = DB.getConnection()){
            PreparedStatement ps =con.prepareStatement("""
                    INSERT INTO contrato(id_plano, termos, data_inicio, data_fim)
                    VALUES(?, ?, ?, ?);
                    """, Statement.RETURN_GENERATED_KEYS);
            ps.setObject(1, contrato.getPlanoId());
            ps.setString(2, contrato.getTermos());
            ps.setString(3, contrato.getData_inicio());
            ps.setString(4, contrato.getData_fim());

            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();

            if(rs.next()){
                contrato.setId(rs.getInt(1));
                return contrato;
            }
        }catch (SQLException e){
            System.err.println(e);
        }
        throw new RuntimeException();
    }
    public static void validarIdPlanoUnique(int id){
        try(Connection con = DB.getConnection()){
            PreparedStatement ps =con.prepareStatement("""
                    SELECT * FROM contrato WHERE id_plano = ?;
                    """, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);


            ResultSet rs = ps.executeQuery();

            if(!rs.next()){
                return;
            }
        }catch (SQLException e){
            System.err.println(e);
        }
        throw new RuntimeException();
    }
    public static List<Contrato> consulta(){
        List<Contrato> lista = new ArrayList<>();
        try(Connection con = DB.getConnection()){
            PreparedStatement ps = con.prepareStatement("""
                    SELECT * FROM contrato;
                    """);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                String termos = rs.getString("termos");
                String data_inicio = rs.getString("data_inicio");
                String data_fim = rs.getString("data_fim");
                Plano plano = CrudPlano.consultaIndividual(rs.getInt("id_plano"));
                lista.add(new Contrato(id, plano, termos, data_inicio, data_fim));
            }
            return lista;
        }catch (SQLException e){
            System.err.println(e);
        }
        throw new RuntimeException();
    }

    public static Contrato consultaId(int idbusca){
        try(Connection con = DB.getConnection()){
            PreparedStatement ps = con.prepareStatement("""
                    SELECT * FROM contrato WHERE id = ?
                    """);
            ps.setInt(1, idbusca);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                int id = rs.getInt("id");
                String termos = rs.getString("termos");
                String data_inicio = rs.getString("data_inicio");
                String data_fim = rs.getString("data_fim");
                Plano plano = CrudPlano.consultaIndividual(rs.getInt("id_plano"));
                return new Contrato(id, plano, termos, data_inicio, data_fim);
            }
        }catch (SQLException e){
            System.err.println(e);
        }
        throw new RuntimeException();
    }

//    public static void atualizacao(Cliente cliente){
//        try(Connection con = DB.getConnection()){
//            PreparedStatement ps = con.prepareStatement("""
//                    UPDATE cliente
//                    SET nome = ?,
//                    email = ?,
//                    telefone = ?,
//                    id_plano = ?
//                    WHERE id = ?;
//                    """);
//            ps.setString(1, cliente.getNome());
//            ps.setString(2, cliente.getEmail());
//            ps.setString(3, cliente.getTelefone());
//            ps.setObject(4, cliente.getPlanoId());
//            ps.setInt(5, cliente.getId());
//            if(ps.executeUpdate()>0){
//                return;
//            }
//        }catch (SQLException e){
//            System.err.println(e);
//        }
//        throw new RuntimeException();
//    }
//
    public static void remocao(int id){
        try(Connection con = DB.getConnection()){
            PreparedStatement ps = con.prepareStatement("""
                    DELETE FROM contrato WHERE ID = ?
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
