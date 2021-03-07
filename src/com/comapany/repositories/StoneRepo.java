package com.comapany.repositories;

import com.comapany.DATA.interfaces.IDB;
import com.comapany.entities.Stone;
import com.comapany.repositories.interfaces.IStone;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class StoneRepo implements IStone {
    private final IDB db;

    public StoneRepo(IDB db) {
        this.db = db;
    }
    @Override
    public boolean createStone(Stone stone) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO stone(stone_id,,name,cost,weight) VALUES (?,?,?,?)";//query for creating user
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1,stone.getId());
            st.setString(2, stone.getName());
            st.setInt(3,stone.getCost());
            st.setInt(4,stone.getWeight());
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }




    @Override
    public Stone getStoneById(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT stone_id,name,cost,weight FROM stone WHERE stone_id=?";//query for this method
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Stone stone = new Stone(rs.getInt("stone_id"),
                        rs.getString("name"),
                        rs.getInt("cost"),
                        rs.getInt("weight"));
                return stone;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<Stone> getAllStones() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT stone_id,name,cost,weight FROM stone";//query for this method
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Stone> stones = new LinkedList<>();
            while (rs.next()) {//getting all columns
                Stone stone = new Stone(rs.getInt("stone_id"),

                        rs.getString("name"),
                        rs.getInt("cost"),
                        rs.getInt("weight"));

                stones.add(stone);
            }

            return stones;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }
}
