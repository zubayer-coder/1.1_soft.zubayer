/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package management.system;

import java.sql.*;

/**
 *
 * @Md.Dedarul Hasan
 */
public class Database {
    public static Connection getConnection(){
        try{
           Class.forName("com.mysql.jdbc.Driver");
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/inventorysystem","root","root");
           return con;
        }catch(Exception ex){
            System.out.println("Database.getConnection Error--->"+ex.getMessage());
            return null;
        }
        
    }
    public static void close(Connection con){
        try{
            con.close();
        }catch(Exception ex){
            
        }
    }
    
}