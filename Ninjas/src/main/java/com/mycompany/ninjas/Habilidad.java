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
public class Habilidad {
    private String habilidad;

    public Habilidad(String habilidad) {
        this.habilidad = habilidad;
    }

    public String getHabilidad() {
        return habilidad;
    }

    public void setHabilidad(String habilidad) {
        this.habilidad = habilidad;
    }
        public boolean registrar() throws SQLException {
        String añadir = "INSERT INTO habilidades (nombre_habilidad) VALUES (?);";

        Connection conector = conexion.Conexion.getConexion();

        try (PreparedStatement ninja = conector.prepareStatement(añadir)) {

            ninja.setString(1, habilidad);

            ninja.executeUpdate();

            System.out.println("registro exitoso");
        } catch (SQLException e) {
            System.err.println("Error al insertar habilidades: " + e.getMessage());
            return false;
        }
        return true;
    }

    public static boolean vistaHabilidades() throws SQLException {
        String consulta = "Select * from habilidades";
        Connection conector = conexion.Conexion.getConexion();
        try (PreparedStatement testamento = conector.prepareStatement(consulta); ResultSet resultado = testamento.executeQuery();) {

            while (resultado.next()) {
                int id = resultado.getInt("id_habilidad");
                String nombre = resultado.getString("nombre_habilidad");

                System.out.println("**********habilidades***************");
                System.out.println("Id: " + id);
                System.out.println("Nombre: " + nombre);

            }
        } catch (SQLException e) {
            System.err.println("Error al consultar la tde habilidades: " + e.getMessage());
        }
        return true;
    }

    public boolean modificar(int id) throws SQLException {
        String modifica = "UPDATE habilidades SET nombre_habilidad = ? WHERE id_habilidad = ?";

        Connection con = conexion.Conexion.getConexion();

        try (PreparedStatement ninjas = con.prepareStatement(modifica)) {

            ninjas.setString(1, habilidad);
            ninjas.setInt(2, id);

            int rowsAffected = ninjas.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("habilidades actualizado exitosamente.");
            } else {
                System.out.println("No se encontró el habilidades con el id especificado.");
            }
        } catch (SQLException e) {
            System.err.println("Error al actualizar el habilidades: " + e.getMessage());
            return false;
        }

        return true;
    }

    public static boolean eliminarAldea(int id) throws SQLException {
        String elimina = "DELETE FROM habilidades WHERE id_habilidad = ?";
        Connection con = conexion.Conexion.getConexion();
        try (
                PreparedStatement Eliminador = con.prepareStatement(elimina)) {
            Eliminador.setInt(1, id);
            int rowsAffected = Eliminador.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Ninja eliminado exitosamente.");
            } else {
                System.out.println("No se encontró el habilidades con el id especificado.");
            }
        } catch (SQLException e) {
            System.err.println("Error al remover el habilidades: " + e.getMessage());
            return false;
        }
        return true;
    }
}
