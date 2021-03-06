package com.comapany.DATA;
import com.comapany.DATA.interfaces.IDB;
import java.sql.*;
public class Postgre implements IDB{

    @Override
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        String connectionUrl = "jdbc:postgresql://localhost:5432/Sultan";// link for connecion
        try {
            // Here we load the driver’s class file into memory at the runtime
            Class.forName("org.postgresql.Driver");

            // Establish the connection
            Connection con = DriverManager.getConnection(connectionUrl, "postgres", "sultan");// driver manager for working

            return con;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
