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
        
//        while (true) {            
//            System.out.println("Bienvenido");
//            System.out.println("1. registrar ninja");
//            System.out.println("2. registar aldea");
//            System.out.println("3. registar habilidad");
//            System.out.println("4. registrar misiion");
//            System.out.println("5. editar ninja");
//            int op = Integer.parseInt(scanner.nextLine());
//            switch (op) {
//                case 1:
//                    MenusRegistro.registroNinja();
//                    break;
//                                    case 2:
//                    MenusRegistro.registroAldea();
//                    break;
//                                    case 3:
//                    MenusRegistro.registroHabilidad();
//                    break;
//                                    case 4:
//                    MenusRegistro.registroMision();
//                    break;
//                                    case 5:
//                    MenusEditar.modificarNinja();
//                    break;
//                default:
//                    throw new AssertionError();
//            }
//        }
//        
        
        
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
