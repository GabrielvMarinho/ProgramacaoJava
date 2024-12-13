package Classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BancoEvento {
    DB db = new DB();
    public void adicionarEvento(Evento evento){
        try(Connection con = db.getConnection()){
            PreparedStatement ps = con.prepareStatement("""
                    INSERT INTO eventos(nome, localidade, data_, descricao)
                    VALUES(?, ?, ?, ?);
                    """);
            ps.setString(1, evento.getNome());
            ps.setString(2, evento.getLocalidade());
            ps.setString(3, evento.getData());
            ps.setString(4, evento.getDescricao());

            if(ps.executeUpdate()>0){
                return;
            }
            throw new RuntimeException();

        }catch (SQLException e){
            System.err.println(e);
        }
        throw new RuntimeException();

    }
    public Evento buscarEventoPorNome(String nomeBusca){
        try(Connection con = db.getConnection()){
            PreparedStatement ps = con.prepareStatement("""
                    SELECT * FROM eventos where nome = ?;
                    """);
            ps.setString(1, nomeBusca);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String localidade = rs.getString("localidade");
                String data = rs.getString("data_");
                String descricao = rs.getString("descricao");
                return new Evento(id, nome, localidade, data, descricao);
            }
        }catch (SQLException e){
            System.err.println(e);
        }
        throw new RuntimeException();
    }
    public void removerEvento(int id){

    }
}
