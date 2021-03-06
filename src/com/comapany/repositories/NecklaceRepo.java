package com.comapany.repositories;

import com.comapany.DATA.interfaces.IDB;
import com.comapany.entities.Necklace;
import com.comapany.interfaces.Methods;


import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NecklaceRepo implements Methods {

    private final IDB db;

    public NecklaceRepo(IDB db) {
        this.db = db;
    }

    @Override
    public int CalculateCost(int id , int id1) {
        Connection con = null;
        try{
            con = db.getConnection();
            String sql="SELECT cost FROM stone where stone_id=?";
           PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, id);

            ResultSet rs = st.executeQuery();

            int response=0;
            if(rs.next()){
                        response=rs.getInt("cost");
            }
            String sql1="SELECT cost1,stones FROM necklace where necklace_id=?";
            PreparedStatement st1 = con.prepareStatement(sql1);
            st1.setInt(1, id1);
            ResultSet rs1 = st1.executeQuery();

            int response1=0;
            int response2=0;
            if(rs1.next()){
                response1=rs1.getInt("cost1");
                response2 = rs1.getInt("stones");
            }
            int a=0;
            int b=0;
            Method multiply = (((x, y) -> x*y));
            Method add = ((x1, y1) -> x1+y1);
            a= multiply.CalculateCost(response,response2);
            b= add.CalculateCost(a,response1);
         return b;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public int CalculateWeight(int weight, int weight1) {
        Connection con = null;
        try{
            con = db.getConnection();
            String sql="SELECT weight FROM stone where stone_id=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, weight);

            ResultSet rs = st.executeQuery();

            int response=0;
            if(rs.next()){
                response=rs.getInt("weight");
            }
            String sql1="SELECT weight,number FROM necklace where necklace_id=?";
            PreparedStatement st1 = con.prepareStatement(sql1);
            st1.setInt(1, weight1);
            ResultSet rs1 = st1.executeQuery();

            int response1=0;
            int response2=0;
            if(rs1.next()){
                response1=rs1.getInt("weight");
                response2=rs1.getInt("stones");
            }
            Method main = ((x1, y1) -> (x1+y1)*5);
            Method multiply = (((x, y) -> x*y));

            int a=0;
            int b=0;
            a= multiply.CalculateCost(response,response2);
            b= main.CalculateCost(a,response1);
            return b;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public boolean createNecklace(Necklace necklace) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO necklace(necklace_id,,weight,name,cost1,stones) VALUES (?,?,?,?,?)";//query for creating user
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1,necklace.getNecklace_id());
            st.setString(2, necklace.getName());
            st.setInt(4,necklace.getWeight());
            st.setInt(3,necklace.getCost1());
            st.setInt(5,necklace.getStones());
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
        return false;    }

    @Override
    public Necklace getNecklaceById(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT necklace_id,,weight,name,cost1,stones FROM necklace WHERE necklace_id=?";//query for this method
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Necklace necklace = new Necklace(rs.getInt("necklace_id"),
                        rs.getString("name"),
                        rs.getInt("weight"),
                        rs.getInt("cost1"),
                        rs.getInt("stones"));
                return necklace;
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
    public List<Necklace> getAllNecklace() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT necklace_id,,weight,name,cost1,stones FROM necklace";//query for this method
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Necklace> necklaces = new LinkedList<>();
            while (rs.next()) {//getting all columns
                Necklace necklace = new Necklace(rs.getInt("necklace_id"),
                        rs.getString("name"),
                        rs.getInt("weight"),
                        rs.getInt("cost1"),
                        rs.getInt("stones"));


                necklaces.add(necklace);
            }

            return necklaces;
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

 interface Method{
    int CalculateCost(int x, int y);
}
