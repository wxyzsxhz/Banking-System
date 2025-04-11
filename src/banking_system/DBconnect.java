/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banking_system;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author Kyaw Min Wai
 */
public class DBconnect {
       public static Connection connect(){
           Connection con=null;
           try{
               Class.forName("com.mysql.cj.jdbc.Driver");
//con=DriverManager.getConnection ("jdbc:mysql://sql6.freesqldatabase.com:3306/sql6686292","sql6686292","r3Fgm91scT");
con=DriverManager.getConnection("jdbc:mysql://localhost:3306/banking_system_sign_form","root","");
               
           }catch(ClassNotFoundException | SQLException e){
               JOptionPane.showMessageDialog(null, e);
           }  
           return con;
       }
    
}
