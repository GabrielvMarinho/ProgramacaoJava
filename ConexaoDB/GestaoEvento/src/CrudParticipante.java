import Exceptions.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CrudParticipante {
    DB banco = new DB();

    public void adicionarParticipante(Participante participante) throws ErroInsercaoException {
        try(Connection con = banco.getConnection()){
            PreparedStatement ps = con.prepareStatement("""
                    INSERT INTO participantes(nome, email)
                    VALUES (?, ?);
                    """);
            ps.setString(1, participante.getNome());
            ps.setString(2, participante.getEmail());

            if(ps.executeUpdate()>0)
                return;

        }catch (SQLException e){
            e.printStackTrace();
        }
        throw new ErroInsercaoException();
    }
    public Participante buscarParticipantePorEmail(String email) throws ParticipanteInexistenteException {
        try(Connection con = banco.getConnection()){
            PreparedStatement ps = con.prepareStatement("""
                    SELECT * FROM participantes WHERE email = ?
                    """);
            ps.setString(1, email);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                String nome = rs.getString("nome");
                return new Participante(nome, email);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        throw new ParticipanteInexistenteException();
    }

    public void removerParticipante(int id) throws ParticipanteInexistenteException{
        try(Connection con = banco.getConnection()){
            PreparedStatement ps = con.prepareStatement("""
                    DELETE FROM participantes WHERE id = ?
                    """);
            ps.setInt(1, id);
            if(ps.executeUpdate()>0)
                return;
        }catch (SQLException e){
            System.out.println("Erro ao deletar, participante pode estar inscrito em um evento!");
            return;
        }
        throw new ParticipanteInexistenteException();
    }

    public ArrayList<Participante> buscarTodosParticipantes(){
        ArrayList<Participante> lista = new ArrayList<>();

        try (Connection con = banco.getConnection()) {
            PreparedStatement ps = con.prepareStatement("""
                    SELECT * FROM participantes;
                    """);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");

                String nome = rs.getString("nome");
                String email = rs.getString("email");

                lista.add(new Participante(id, nome, email));
            }
            return lista;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public Participante buscarParticipantePorId(int id) throws ParticipanteInexistenteException {
        try(Connection con = banco.getConnection()){
            PreparedStatement ps = con.prepareStatement("""
                    SELECT * FROM participantes WHERE id = ?
                    """);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                return new Participante(id, nome, email);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        throw new ParticipanteInexistenteException();
    }

    public void checarNomeExistente(String nome) throws NomeExistenteException {

        try (Connection con = banco.getConnection()) {
            PreparedStatement ps = con.prepareStatement("""
                    SELECT * FROM participantes WHERE nome = ?;
                    """);
            ps.setString(1, nome);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                throw new NomeExistenteException();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void checarEmailExistente(String email) throws EmailExistenteException {

        try(Connection con = banco.getConnection()){
            PreparedStatement ps = con.prepareStatement("""
                    SELECT * FROM participantes WHERE email = ?;
                    """);
            ps.setString(1, email);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                throw new EmailExistenteException();
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

    }

}
