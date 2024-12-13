/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ninjas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author camper
 */
public class DIficultad {
    
        public static void vistaDificultad() throws SQLException {
        String consulta = "Select * from dificultades";
        Connection conector = conexion.Conexion.getConexion();
        try (PreparedStatement testamento = conector.prepareStatement(consulta); ResultSet resultado = testamento.executeQuery();) {

            while (resultado.next()) {
                int id = resultado.getInt("id_dificultad");
                String nombre = resultado.getString("dificultad");


                System.out.println("**********dificultades***************");
                System.out.println("Id: " + id);
                System.out.println("dificulatd: " + nombre);

            }
        } catch (SQLException e) {
            System.err.println("Error al consultar la tde dificulatd: " + e.getMessage());
        }
    }
    
    
}
