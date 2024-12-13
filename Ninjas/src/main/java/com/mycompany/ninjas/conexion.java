/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ninjas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author camper
 */
public class conexion {
    
        public class Conexion {
            private static String user = "campus2023";
            private static String password = "campus2023";
            private static String url = "jdbc:mysql://localhost:3306/ninjas";
            private static Connection conexion = null;

            public static Connection getConexion() {

            //        password = "Kevin2006.";
            if (conexion == null) {
            try {
            conexion = DriverManager.getConnection(url, user, password);
            if (conexion != null) {
            System.out.println("Conexion exitosa");
            } else {
            System.out.println("no se pudo hacer la conexion");
            }
            }catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
            return conexion;
            }

        }
}
