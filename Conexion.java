/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PAZ ZUÑIGA
 */
public class Conexion {
    String bd="tecmex";
    String url="jdbc:mysql://127.0.0.1:3306/";
    String user="root";
    String password="";
    String driver="com.mysql.cj.jdbc.Driver";
    Connection con;

   public Conexion(String bd){
        this.bd=bd;
        
        
    }

    public Conexion() {
        //To change body of generated methods, choose Tools | Templates.
    }
    public Connection conectar(){
        try {
            Class.forName(driver);
            con=DriverManager.getConnection(url+bd, user, password);
            System.out.println("SE CONECTO A BD"+bd);
        } catch (ClassNotFoundException |SQLException ex) {
            System.out.println("NO SE CONECTO A BD"+bd);
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
    public void desconectar(){
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }
       public static void main(String[] args) {
        Conexion conexion=new Conexion("tecmex");
        
        conexion.conectar();
       }
    
    }
    

