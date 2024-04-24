/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package login;
import java.sql.*;

public class DBConnection {
    Connection con = null;
     public static Connection ConnectionDB(){
        
        try{
            Class.forName("org.sqlite.JDBC");//loading the sqlite driver 
            Connection con = DriverManager.getConnection("jdbc:sqlite:LoginDataBase.sqlite");
            System.out.println("Connection Successful");
            return con;
        }
        
        catch(Exception e){
                        System.out.println("Connection Failed");
                         return null;
        }
    } 
}
