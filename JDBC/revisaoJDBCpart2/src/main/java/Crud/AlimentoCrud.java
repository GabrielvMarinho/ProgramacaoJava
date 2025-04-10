package Crud;

import Classes.Alimento;
import DB.DB;

import java.sql.*;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class AlimentoCrud {
    private DB db = new DB();

    public Alimento salvarAlimento(Alimento alimento){
            try{
                procurarAlimento(alimento.getId());
                String comando = "update alimento set nome = ? where id = ?";
                try(Connection con = db.getConnection();
                PreparedStatement ps = con.prepareStatement(comando)){

                    ps.setString(1, alimento.getNome());
                    ps.setInt(2, alimento.getId());
                    ps.executeUpdate();

                    return alimento;
                }
            }catch (Exception e){
                try{
                    String comando = "insert into alimento(nome) values(?)";
                    try(Connection con = db.getConnection();
                        PreparedStatement ps = con.prepareStatement(comando, Statement.RETURN_GENERATED_KEYS)){

                        ps.setString(1, alimento.getNome());
                        ps.execute();
                        ResultSet rs = ps.getGeneratedKeys();

                        alimento.setId(rs.getInt(1));
                        return alimento;
                    }
                }catch (Exception er){
                    System.err.println(er);
                }
            }

        throw new RuntimeException();
    }
    public void removerAlimento(Alimento alimento){
        String comando = "delete from alimento where id = ?";
        try(Connection con = db.getConnection();
            PreparedStatement ps = con.prepareStatement(comando)){

            ps.setInt(1, alimento.getId());

            ps.execute();

            return;

        }catch (SQLException e){
            System.err.println(e);
        }
        throw new RuntimeException();
    }
    public Alimento procurarAlimento(int codigo) throws SQLException {
        String comando = "select * from alimento where id = ?";
        try(Connection con = db.getConnection();
            PreparedStatement ps = con.prepareStatement(comando)){

            ps.setInt(1, codigo);

            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return new Alimento(rs.getInt("id"), rs.getString("nome"));
            }
            throw new NoSuchElementException();
        }catch (SQLException e){
            System.err.println(e);
        }
        throw new RuntimeException();
    }
//    public ArrayList<Alimento> procurarAlimentos(){
//
//    }



}
