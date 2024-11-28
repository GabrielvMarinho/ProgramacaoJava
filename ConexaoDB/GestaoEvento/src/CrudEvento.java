import Exceptions.ErroInsercaoException;
import Exceptions.EventoInexistenteException;
import Exceptions.ParticipanteInexistenteException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CrudEvento {
    DB banco = new DB();

    public void adicionarEvento(Evento evento) throws ErroInsercaoException {
        try (Connection con = banco.getConnection()) {
            PreparedStatement ps = con.prepareStatement("""
                    INSERT INTO eventos(nome, localidade, data_, descricao)
                    VALUES(?, ?, ?, ?);
                    """);
            ps.setString(1, evento.getNome());
            ps.setString(2, evento.getLocalidade());
            ps.setString(3, evento.getData());
            ps.setString(4, evento.getDescricao());

            if (ps.executeUpdate() > 0)
                return;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new ErroInsercaoException();

    }

    public Evento buscarEventoPorNome(String nome) throws EventoInexistenteException {
        try (Connection con = banco.getConnection()) {
            PreparedStatement ps = con.prepareStatement("""
                    SELECT * FROM eventos WHERE nome = ?;
                    """);
            ps.setString(1, nome);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String localidade = rs.getString("localidade");
                String data = rs.getString("data_");
                String descricao = rs.getString("descricao");
                return new Evento(nome, localidade, data, descricao);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new EventoInexistenteException();
    }

    public void removerEvento(int id) throws EventoInexistenteException {
        try (Connection con = banco.getConnection()) {
            PreparedStatement ps = con.prepareStatement("""
                    DELETE FROM eventos WHERE id = ?;
                    """);
            ps.setInt(1, id);

            if (ps.executeUpdate() > 0)
                return;

        } catch (SQLException e) {
            System.out.println("Erro ao deletar, Evento pode estar com algum participante inscrito!");
            return;

        }
        throw new EventoInexistenteException();
    }

    public ArrayList<Evento> buscarTodosEventos() {
        ArrayList<Evento> lista = new ArrayList<>();

        try (Connection con = banco.getConnection()) {
            PreparedStatement ps = con.prepareStatement("""
                    SELECT * FROM eventos;
                    """);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");

                String nome = rs.getString("nome");
                String localidade = rs.getString("localidade");
                String data = rs.getString("data_");
                String descricao = rs.getString("descricao");
                lista.add(new Evento(id, nome, localidade, data, descricao));
            }
            return lista;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public Evento buscarEventoPorId(int id) throws EventoInexistenteException {
        try(Connection con = banco.getConnection()){
            PreparedStatement ps = con.prepareStatement("""
                    SELECT * FROM eventos WHERE id = ?
                    """);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                String nome = rs.getString("nome");
                String localidade = rs.getString("localidade");
                String data = rs.getString("data_");
                String descricao = rs.getString("descricao");

                return new Evento(id, nome, localidade,data, descricao );
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        throw new EventoInexistenteException();
    }

}
