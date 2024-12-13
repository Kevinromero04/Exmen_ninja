package com.mycompany.ninjas;

import com.mycompany.ninjas.conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ninja {

    private String nombre;
    private String documento;
    private int idRango;
    private int idAldea;

    public Ninja(String nombre, String documento, int idRanfo, int idAldea) {
        this.nombre = nombre;
        this.documento = documento;
        this.idRango = idRanfo;
        this.idAldea = idAldea;
    }

    public Ninja(String nombre, int idRango, int idAldea) {
        this.nombre = nombre;
        this.idRango = idRango;
        this.idAldea = idAldea;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public int getIdRango() {
        return idRango;
    }

    public void setIdRanfo(int idRanfo) {
        this.idRango = idRanfo;
    }

    public int getIdAldea() {
        return idAldea;
    }

    public void setIdAldea(int idAldea) {
        this.idAldea = idAldea;
    }

    public boolean registrar() throws SQLException {
        String añadir = "INSERT INTO ninjas(nombre,documento,id_rango,id_aldea) VALUES (?,?,?,?);";

        Connection conector = Conexion.getConexion();

        try (PreparedStatement ninja = conector.prepareStatement(añadir)) {

            ninja.setString(1, nombre);
            ninja.setString(2, documento);
            ninja.setInt(3, idRango);
            ninja.setInt(4, idAldea);

            ninja.executeUpdate();

            System.out.println("registro exitoso");
        } catch (SQLException e) {
            System.err.println("Error al insertar ninja: " + e.getMessage());
            return false;
        }
        return true;
    }

    public static int getIdNInja(String documento) throws SQLException {
        Connection conector = Conexion.getConexion();
        String consult = "SELECT id_ninja FROM ninjas WHERE document = ?";
        int idOwner = 0;
        try (PreparedStatement testamento = conector.prepareStatement(consult);) {
            testamento.setString(1, documento);
            ResultSet resultado = testamento.executeQuery();

            if (resultado.next()) {
                idOwner = resultado.getInt("id_ninja");
            } else {
                System.out.println("No se encontró ningún ninja con el documento: " + documento);
            }
        } catch (Exception e) {
        }

        return idOwner;
    }

    public static void vistaNInja() throws SQLException {
        String consulta = "Select * from ninjas";
        Connection conector = Conexion.getConexion();
        try (PreparedStatement testamento = conector.prepareStatement(consulta); ResultSet resultado = testamento.executeQuery();) {

            while (resultado.next()) {
                int id = resultado.getInt("id_ninja");
                String nombre = resultado.getString("nombre");
                int rango = resultado.getInt("id_rango");
                int aldea = resultado.getInt("id_aldea");

                System.out.println("**********Ninjas***************");
                System.out.println("Id: " + id);
                System.out.println("Nombre: " + nombre);
                System.out.println("Rango: " + rango);
                System.out.println("Aldea: " + aldea);

            }
        } catch (SQLException e) {
            System.err.println("Error al consultar la tde ninjas: " + e.getMessage());
        }

    }

    public boolean modificar(String documentoo) throws SQLException {
        String modifica = "UPDATE ninjas SET nombre = ?, documento = ?, id_rango = ?, id_aldea = ? WHERE documento = ?";

        Connection con = Conexion.getConexion();

        try (PreparedStatement ninjas = con.prepareStatement(modifica)) {

            ninjas.setString(1, nombre);
            ninjas.setString(2, documento);
            ninjas.setInt(3, idRango);
            ninjas.setInt(4, idAldea);
            ninjas.setString(5, documentoo);

            int rowsAffected = ninjas.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("ninja actualizado exitosamente.");
            } else {
                System.out.println("No se encontró el ninja con el documento especificado.");
            }
        } catch (SQLException e) {
            System.err.println("Error al actualizar el ninja: " + e.getMessage());
            return false;
        }

        return true;
    }

    public static boolean eliminarNinja(String documento) throws SQLException {
        String elimina = "DELETE FROM ninjas WHERE document = ?";
        Connection con = Conexion.getConexion();
        try (
                PreparedStatement Eliminador = con.prepareStatement(elimina)) {
            Eliminador.setString(1, documento);
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
