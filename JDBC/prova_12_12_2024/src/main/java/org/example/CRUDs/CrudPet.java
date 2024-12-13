package org.example.CRUDs;

import org.example.Classes.Pet;
import org.example.DB;

import java.sql.*;
import java.util.ArrayList;

public class CrudPet {
    static DB db = new DB();

    public static Pet create(Pet pet){
        try(Connection con = db.getConnection()){
            PreparedStatement ps = con.prepareStatement("""
                    INSERT INTO pet(nome, acordado, vivo, diversao, energia, higiene, vontadeBanheiro, fome, sede)
                     VALUES(?, true, true, 100, 100, 100, 100, 100, 100);""", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, pet.getNome());

            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                pet.setCodigo(rs.getInt(1));
                return pet;
            }
        }catch (SQLException e){
            System.err.println(e);
        }
        throw new RuntimeException();
    }
    public static ArrayList<Pet> readAll(){
        ArrayList<Pet> lista = new ArrayList<>();
        try(Connection con = db.getConnection()){
            PreparedStatement ps = con.prepareStatement("""
                    SELECT * FROM pet;""");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int codigo = rs.getInt("id");
                int sede = rs.getInt("sede");
                int fome = rs.getInt("fome");
                String nome = rs.getString("nome");
                int vontadeDeBanheiro = rs.getInt("vontadeBanheiro");
                int higiene = rs.getInt("higiene");
                int energia = rs.getInt("energia");
                int diversao = rs.getInt("diversao");
                boolean vivo = rs.getBoolean("vivo");
                boolean acordado = rs.getBoolean("acordado");
                lista.add(new Pet(sede, fome, codigo, nome, vontadeDeBanheiro, higiene, acordado, energia, vivo, diversao));
            }
            return lista;
        }catch (SQLException e){
            System.err.println(e);
        }
        throw new RuntimeException();
    }
    public static Pet readOne(int id){
        try(Connection con = db.getConnection()){
            PreparedStatement ps = con.prepareStatement("""
                    SELECT * FROM pet WHERE id = ?;""");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                int codigo = rs.getInt("id");
                int sede = rs.getInt("sede");
                int fome = rs.getInt("fome");
                String nome = rs.getString("nome");
                int vontadeDeBanheiro = rs.getInt("vontadeBanheiro");
                int higiene = rs.getInt("higiene");
                int energia = rs.getInt("energia");
                int diversao = rs.getInt("diversao");
                boolean vivo = rs.getBoolean("vivo");
                boolean acordado = rs.getBoolean("acordado");
                return new Pet(sede, fome, codigo, nome, vontadeDeBanheiro, higiene, acordado, energia, vivo, diversao);
            }
        }catch (SQLException e){
            System.err.println(e);
        }
        throw new RuntimeException();
    }

    public static void updateDados(Pet pet){
        try(Connection con = db.getConnection()){
            PreparedStatement ps = con.prepareStatement("""
                    UPDATE pet SET sede= ?,fome= ?,vontadeBanheiro=?,higiene=?,energia=?,diversao=?, acordado=?, vivo=?  WHERE id = ?;""");
            ps.setInt(1, pet.getSede());
            ps.setInt(2, pet.getFome());
            ps.setInt(3, pet.getVontadeBanheiro());
            ps.setInt(4, pet.getHigiene());
            ps.setInt(5, pet.getEnergia());
            ps.setInt(6, pet.getDiversao());
            ps.setBoolean(7, pet.isAcordado());
            ps.setBoolean(8, pet.isVivo());
            ps.setInt(9, pet.getCodigo());



            ps.execute();

            return;

        }catch (SQLException e){
            System.err.println(e);
        }
        throw new RuntimeException();
    }
    public static void update(Pet pet){
        try(Connection con = db.getConnection()){
            PreparedStatement ps = con.prepareStatement("""
                    UPDATE pet SET nome = ? WHERE id = ?;""");
            ps.setString(1, pet.getNome());
            ps.setInt(2, pet.getCodigo());
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
                    DELETE FROM pet WHERE id = ?;""");
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
