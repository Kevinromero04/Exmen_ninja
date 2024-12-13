/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ninjas;

import com.mycompany.ninjas.conexion.Conexion;
import java.sql.Connection;

/**
 *
 * @author camper
 */
public class Ninjas {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Connection con = Conexion.getConexion();
        
        System.out.println(con);
        
    }
}
