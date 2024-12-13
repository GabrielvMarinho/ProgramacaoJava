package org.example.CRUDs;

import org.example.Classes.Brincadeira;
import org.example.Classes.Pet;
import org.example.DB;

import java.sql.*;
import java.util.ArrayList;

public class CrudBrincadeira {
    static DB db = new DB();
    public static Brincadeira create(Brincadeira brincadeira){
        try(Connection con = db.getConnection()){
            PreparedStatement ps = con.prepareStatement("""
                    INSERT INTO brincadeira(nome, cansaco, fome, sede, sujeira, divertimento)
                    VALUES(?, ?, ?, ?, ?, ?);""", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, brincadeira.getNome());
            ps.setInt(2, brincadeira.getCansaco());
            ps.setInt(3, brincadeira.getFome());
            ps.setInt(4, brincadeira.getSede());
            ps.setInt(5, brincadeira.getSujeira());
            ps.setInt(6, brincadeira.getDivertimento());

            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();

            if(rs.next()){
                brincadeira.setCodigo(rs.getInt(1));
                return brincadeira;
            }
        }catch (SQLException e){
            System.err.println(e);
        }
        throw new RuntimeException();
    }
    public static ArrayList<Brincadeira> readAll(){
        ArrayList<Brincadeira> lista = new ArrayList<>();
        try(Connection con = db.getConnection()){
            PreparedStatement ps = con.prepareStatement("""
                    SELECT * FROM brincadeira;""");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){

                int codigo = rs.getInt("id");
                String nome = rs.getString("nome");
                int cansaco = rs.getInt("cansaco");
                int fome = rs.getInt("fome");
                int sede = rs.getInt("sede");
                int sujeira = rs.getInt("sujeira");
                int divertimento = rs.getInt("divertimento");

                lista.add(new Brincadeira(codigo, nome, cansaco, fome, sede, sujeira, divertimento));
            }
            return lista;
        }catch (SQLException e){
            System.err.println(e);
        }
        throw new RuntimeException();
    }
    public static Brincadeira readOne(int id){
        try(Connection con = db.getConnection()){
            PreparedStatement ps = con.prepareStatement("""
                    SELECT * FROM brincadeira WHERE id = ?;""");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                int codigo = rs.getInt("id");
                String nome = rs.getString("nome");
                int cansaco = rs.getInt("cansaco");
                int fome = rs.getInt("fome");
                int sede = rs.getInt("sede");
                int sujeira = rs.getInt("sujeira");
                int divertimento = rs.getInt("divertimento");

                return new Brincadeira(codigo, nome, cansaco, fome, sede, sujeira, divertimento);
            }
        }catch (SQLException e){
            System.err.println(e);
        }
        throw new RuntimeException();
    }
    public static void update(Brincadeira brincadeira){
        try(Connection con = db.getConnection()){

            PreparedStatement ps = con.prepareStatement("""
                    UPDATE brincadeira SET nome = ?, cansaco = ?, fome = ?, sede = ?, sujeira = ?, divertimento = ? 
                    WHERE id = ?;""");
            ps.setString(1, brincadeira.getNome());
            ps.setInt(2, brincadeira.getCansaco());
            ps.setInt(3, brincadeira.getFome());
            ps.setInt(4, brincadeira.getSede());
            ps.setInt(5, brincadeira.getSujeira());
            ps.setInt(6, brincadeira.getDivertimento());
            ps.setInt(7, brincadeira.getCodigo());
            ps.execute();

            return;

        }catch (SQLException e){
            System.err.println(e);
        }
        throw new RuntimeException();
    }
    public static void delete(int id){
        try(Connection con = db.getConnection()){
            PreparedStatement ps = con.prepareStatement("""
                    DELETE FROM brincadeira WHERE id = ?;""");
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
