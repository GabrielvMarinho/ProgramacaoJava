package org.example.CRUDs;

import org.example.Classes.Alimento;
import org.example.DB;

import java.sql.*;
import java.util.ArrayList;

public class CrudAlimento {
    static DB db = new DB();
    public static Alimento create(Alimento alimento){
        try(Connection con = db.getConnection()){
            PreparedStatement ps = con.prepareStatement("""
                    INSERT INTO alimento(nome, nutricao)
                    VALUES(?, ?);""", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, alimento.getNome());
            ps.setInt(2, alimento.getNutricao());


            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                alimento.setCodigo(rs.getInt(1));
                return alimento;
            }
        }catch (SQLException e){
            System.err.println(e);
        }
        throw new RuntimeException();
    }
    public static ArrayList<Alimento> readAll(){
        ArrayList<Alimento> lista = new ArrayList<>();
        try(Connection con = db.getConnection()){
            PreparedStatement ps = con.prepareStatement("""
                    SELECT * FROM alimento;""");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int codigo = rs.getInt("id");
                String nome = rs.getString("nome");
                int nutricao = rs.getInt("nutricao");
                lista.add(new Alimento(codigo, nome, nutricao));
            }
            return lista;
        }catch (SQLException e){
            System.err.println(e);
        }
        throw new RuntimeException();
    }
    public static Alimento readOne(int id){
        try(Connection con = db.getConnection()){
            PreparedStatement ps = con.prepareStatement("""
                    SELECT * FROM alimento WHERE id = ?;""");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                int codigo = rs.getInt("id");
                String nome = rs.getString("nome");
                int nutricao = rs.getInt("nutricao");
                return new Alimento(codigo, nome, nutricao);
            }
        }catch (SQLException e){
            System.err.println(e);
        }
        throw new RuntimeException();
    }
    public static void update(Alimento alimento){
        try(Connection con = db.getConnection()){
            PreparedStatement ps = con.prepareStatement("""
                    UPDATE alimento SET nome = ?, nutricao = ? WHERE id = ?;""");
            ps.setString(1, alimento.getNome());
            ps.setInt(2, alimento.getNutricao());
            ps.setInt(3, alimento.getCodigo());
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
                    DELETE FROM alimento WHERE id = ?;""");
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
