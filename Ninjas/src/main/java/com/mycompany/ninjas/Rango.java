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
public class Rango {

    private String rango;

    public Rango(String rango) {
        this.rango = rango;
    }

    public String getRango() {
        return rango;
    }

    public void setRango(String rango) {
        this.rango = rango;
    }

    public static void vistaRango() throws SQLException {
        String consulta = "Select * from rangos";
        Connection conector = conexion.Conexion.getConexion();
        try (PreparedStatement testamento = conector.prepareStatement(consulta); ResultSet resultado = testamento.executeQuery();) {

            while (resultado.next()) {
                int id = resultado.getInt("id_rango");
                String nombre = resultado.getString("nombre_rango");


                System.out.println("**********Rangos***************");
                System.out.println("Id: " + id);
                System.out.println("Nombre: " + nombre);

            }
        } catch (SQLException e) {
            System.err.println("Error al consultar la tde rangos: " + e.getMessage());
        }
    }


    
    }
