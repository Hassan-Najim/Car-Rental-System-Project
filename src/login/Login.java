/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package login;

import java.sql.*;

public class Login {
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
public static void main(String[] args) {

         java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginTable1().setVisible(true);
            }
        });
    
    
    
}

  
    
}
