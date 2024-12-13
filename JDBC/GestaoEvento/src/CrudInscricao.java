import Exceptions.EventoInexistenteException;
import Exceptions.IdInvalidoException;
import Exceptions.ParticipanteInexistenteException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CrudInscricao {
    static DB banco = new DB();

    static CrudParticipante crudParticipante = new CrudParticipante();
    static CrudEvento crudEvento = new CrudEvento();

    public void inscreverParticipante(int eventoId, int participanteId) throws IdInvalidoException {
        try(Connection con = banco.getConnection()){
            PreparedStatement ps = con.prepareStatement("""
                    INSERT INTO inscricoes(eventoId, participanteId)
                    VALUES(?, ?); 
                    """);
            ps.setInt(1, eventoId);
            ps.setInt(2, participanteId);

            if(ps.executeUpdate()>0)
                return;
        }catch (SQLException e){
            System.out.println("Erro ao atualizar, id provavelmente não existe!");
        }
        throw new IdInvalidoException();
    }
    public void removerInscricao(int id) throws IdInvalidoException {
        try(Connection con = banco.getConnection()){
            PreparedStatement ps = con.prepareStatement("""
                    DELETE FROM inscricoes
                    WHERE id = ?; 
                    """);
            ps.setInt(1, id);
            if(ps.executeUpdate()>0)
                return;
        }catch (SQLException e){
            e.printStackTrace();
        }
        throw new IdInvalidoException();
    }

    public static ArrayList<Inscricao> buscarTodasInscrições(){
        ArrayList<Inscricao> lista = new ArrayList<>();

        try (Connection con = banco.getConnection()) {
            PreparedStatement ps = con.prepareStatement("""
                    SELECT * FROM inscricoes
                    

                    """);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");

                int eventoId = rs.getInt("eventoId");
                int participanteId = rs.getInt("participanteId");

                lista.add(new Inscricao(id, crudEvento.buscarEventoPorId(eventoId), crudParticipante.buscarParticipantePorId(participanteId)));
            }
            return lista;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParticipanteInexistenteException e) {
            throw new RuntimeException(e);
        } catch (EventoInexistenteException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }
}
