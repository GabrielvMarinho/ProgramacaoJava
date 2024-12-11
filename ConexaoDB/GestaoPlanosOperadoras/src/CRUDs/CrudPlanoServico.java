package CRUDs;

import Classes.Plano;
import Classes.PlanoServico;
import Classes.ServicoAdicional;
import DB.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CrudPlanoServico {
    //classe responsável pelo crud do servico


    public static List<PlanoServico> consultaPlanoServico(){
        List<PlanoServico> lista = new ArrayList<>();
        try(Connection con = DB.getConnection()){
            PreparedStatement ps = con.prepareStatement("""
                    SELECT * FROM plano_servico""");


            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                ServicoAdicional servicoAdicional = CrudServicoAdicional.consultaId(rs.getInt("id_servico"));
                Plano plano = CrudPlano.consultaIndividual(rs.getInt("id_plano"));
                lista.add(new PlanoServico(id, plano, servicoAdicional));
            }
            return lista;

        }catch (SQLException e){
            System.err.println(e);
        }
        throw new RuntimeException();
    }
    public static PlanoServico consultaPlanoServicoId(int idBusca){

        try(Connection con = DB.getConnection()){
            PreparedStatement ps = con.prepareStatement("""
                    SELECT * FROM plano_servico WHERE id = ?""");

            ps.setInt(1, idBusca);

            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                ServicoAdicional servicoAdicional = CrudServicoAdicional.consultaId(rs.getInt("id_servico"));
                Plano plano = CrudPlano.consultaIndividual(rs.getInt("id_plano"));
                return new PlanoServico(id, plano, servicoAdicional);
            }

        }catch (SQLException e){
            System.err.println(e);
        }
        throw new RuntimeException();
    }

    public static void removerPlanoServico(int id){
        try(Connection con = DB.getConnection()){
            PreparedStatement ps = con.prepareStatement("""
                    DELETE FROM plano_servico WHERE id = ?; 
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
