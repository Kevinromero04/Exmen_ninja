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
public class Mision {
    private String nombreMision;
    private String descripcion;
    private int idDificultad;
    private String recompensa;
    

    public Mision(String nombreMision, String descripcion, int idDificultad, String recompensa) {
        this.nombreMision = nombreMision;
        this.descripcion = descripcion;
        this.idDificultad = idDificultad;
        this.recompensa = recompensa;
    }

    public String getNombreMision() {
        return nombreMision;
    }

    public void setNombreMision(String nombreMision) {
        this.nombreMision = nombreMision;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdDificultad() {
        return idDificultad;
    }

    public void setIdDificultad(int idDificultad) {
        this.idDificultad = idDificultad;
    }

    public String getRecompensa() {
        return recompensa;
    }

    public void setRecompensa(String recompensa) {
        this.recompensa = recompensa;
    }
    
        public boolean registrar() throws SQLException {
        String añadir = "INSERT INTO misiones(nombre_mision,descripcion,id_dificultad,recompensa) VALUES (?,?,?,?);";

        Connection conector = conexion.Conexion.getConexion();

        try (PreparedStatement ninja = conector.prepareStatement(añadir)) {

            ninja.setString(1, nombreMision);
            ninja.setString(2, descripcion);
            ninja.setInt(3, idDificultad);
            ninja.setString(4, recompensa);

            ninja.executeUpdate();

            System.out.println("registro exitoso");
        } catch (SQLException e) {
            System.err.println("Error al insertar misiones: " + e.getMessage());
            return false;
        }
        return true;
    }



    public static void vistaMison() throws SQLException {
        String consulta = "Select * from misiones";
        Connection conector = conexion.Conexion.getConexion();
        try (PreparedStatement testamento = conector.prepareStatement(consulta); ResultSet resultado = testamento.executeQuery();) {

            while (resultado.next()) {
                int id = resultado.getInt("id_mision");
                String nombre = resultado.getString("nombre_mision");
                int rango = resultado.getInt("id_dificultad");
                String aldea = resultado.getString("recompensa");

                System.out.println("**********misiones***************");
                System.out.println("Id: " + id);
                System.out.println("Nombre: " + nombre);
                System.out.println("Rango: " + rango);
                System.out.println("Aldea: " + aldea);

            }
        } catch (SQLException e) {
            System.err.println("Error al consultar la tde misiones: " + e.getMessage());
        }

    }



    public static boolean eliminarMison(int id) throws SQLException {
        String elimina = "DELETE FROM misiones WHERE id_mision = ?";
        Connection con = conexion.Conexion.getConexion();
        try (
                PreparedStatement Eliminador = con.prepareStatement(elimina)) {
            Eliminador.setInt(1, id);
            int rowsAffected = Eliminador.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("misiones eliminado exitosamente.");
            } else {
                System.out.println("No se encontró el misiones con el id especificado.");
            }
        } catch (SQLException e) {
            System.err.println("Error al remover el misiones: " + e.getMessage());
            return false;
        }
        return true;
    }
    
}
