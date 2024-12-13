/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ninjas;

import com.mycompany.ninjas.conexion.Conexion;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author camper
 */
public class main {

    public static void main(String[] args) throws SQLException {

        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Ingresa tu documento actual");
        String documentoCambio = scanner.nextLine();
        System.out.println("Ingresa tu nuevo nombre");
        String nombre = scanner.nextLine();
        Rango.vistaRango();
        System.out.println("Ingresa el id del rango");
        int rango = Integer.parseInt(scanner.nextLine());
        System.out.println("Ingresa el id de la aldea que vienes");
        Aldea.vistaAldea();

        int aldea = Integer.parseInt(scanner.nextLine());

        Ninja n1 = new Ninja(nombre, documentoCambio, rango, aldea);
        n1.modificar(documentoCambio);
        
    }
}
