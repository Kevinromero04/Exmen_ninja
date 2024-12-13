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
public class Aldea {

    private String aldea;

    public Aldea(String aldea) {
        this.aldea = aldea;
    }

    public String getAldea() {
        return aldea;
    }

    public void setAldea(String aldea) {
        this.aldea = aldea;
    }

    public boolean registrar() throws SQLException {
        String añadir = "INSERT INTO aldeas (nombre_aldea) VALUES (?);";

        Connection conector = conexion.Conexion.getConexion();

        try (PreparedStatement ninja = conector.prepareStatement(añadir)) {

            ninja.setString(1, aldea);

            ninja.executeUpdate();

            System.out.println("registro exitoso");
        } catch (SQLException e) {
            System.err.println("Error al insertar ninja: " + e.getMessage());
            return false;
        }
        return true;
    }

    public static boolean vistaAldea() throws SQLException {
        String consulta = "Select * from aldeas";
        Connection conector = conexion.Conexion.getConexion();
        try (PreparedStatement testamento = conector.prepareStatement(consulta); ResultSet resultado = testamento.executeQuery();) {

            while (resultado.next()) {
                int id = resultado.getInt("id_aldea");
                String nombre = resultado.getString("nombre_aldea");

                System.out.println("**********Aldeas***************");
                System.out.println("Id: " + id);
                System.out.println("Nombre: " + nombre);

            }
        } catch (SQLException e) {
            System.err.println("Error al consultar la tde aldeas: " + e.getMessage());
        }
        return true;
    }

    public boolean modificar(int id) throws SQLException {
        String modifica = "UPDATE aldeas SET nombre_aldea = ? WHERE id_aldea = ?";

        Connection con = conexion.Conexion.getConexion();

        try (PreparedStatement ninjas = con.prepareStatement(modifica)) {

            ninjas.setString(1, aldea);
            ninjas.setInt(2, id);

            int rowsAffected = ninjas.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("aldea actualizado exitosamente.");
            } else {
                System.out.println("No se encontró el aldea con el id especificado.");
            }
        } catch (SQLException e) {
            System.err.println("Error al actualizar el aledea: " + e.getMessage());
            return false;
        }

        return true;
    }

    public static boolean eliminarAldea(int id) throws SQLException {
        String elimina = "DELETE FROM aldeas WHERE id_aldea = ?";
        Connection con = conexion.Conexion.getConexion();
        try (
                PreparedStatement Eliminador = con.prepareStatement(elimina)) {
            Eliminador.setInt(1, id);
            int rowsAffected = Eliminador.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Ninja eliminado exitosamente.");
            } else {
                System.out.println("No se encontró el ninja con el documento especificado.");
            }
        } catch (SQLException e) {
            System.err.println("Error al remover el ninja: " + e.getMessage());
            return false;
        }
        return true;
    }

}
