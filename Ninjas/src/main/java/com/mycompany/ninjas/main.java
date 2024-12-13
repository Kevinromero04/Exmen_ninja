/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.ninjas;

import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author camper
 */
public class main {

    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Bienvenido");
            System.out.println("1. registrar ninja");
            System.out.println("2. registar aldea");
            System.out.println("3. registar habilidad");
            System.out.println("4. registrar misiion");
            System.out.println("5. editar ninja");
            System.out.println("6. Ver a todos los ninjas");
            System.out.println("7. Ver a todas las aldeas");
            System.out.println("8. ver todas las misiones");
            System.out.println("9. ver todas las habilidades");
            int op = Integer.parseInt(scanner.nextLine());
            switch (op) {
                case 1:
                    MenusRegistro.registroNinja();
                    break;
                case 2:
                    MenusRegistro.registroAldea();
                    break;
                case 3:
                    MenusRegistro.registroHabilidad();
                    break;
                case 4:
                    MenusRegistro.registroMision();
                    break;
                case 5:
                    MenusEditar.modificarNinja();
                    break;
                case 6:
                    Ninja.vistaNInja();
                    break;
                case 7:
                    Aldea.vistaAldea();
                    break;
                case 8:
                    Mision.vistaMison();
                    break;
                case 9:
                    Habilidad.vistaHabilidades();
                    break;
                case 10:
                    System.out.println("saliendo...");
                    break;
                default:
                    throw new AssertionError();
            }
        }

    }
}
