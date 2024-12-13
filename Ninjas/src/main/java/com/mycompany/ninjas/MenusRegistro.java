package com.mycompany.ninjas;

import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author camper
 */
public class MenusRegistro {

    public static void registroNinja() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido futuro ninja\n Ingresa tu nombre");
        String nombre = scanner.nextLine();
        System.out.println("Ingresa tu numero de documento");
        String documento = scanner.nextLine();
        Rango.vistaRango();
        System.out.println("Ingresa el id del rango");
        int rango = Integer.parseInt(scanner.nextLine());
        System.out.println("Ingresa el id de la aldea que vienes");
        Aldea.vistaAldea();

        int aldea = Integer.parseInt(scanner.nextLine());

        Ninja n1 = new Ninja(nombre, documento, rango, aldea);
        n1.registrar();
    }

    public static void registroAldea() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Registrar aldeas");
        System.out.println("Ingresa el nombre de la aldea");
        String nombreAldea = scanner.nextLine();
        Aldea a1 = new Aldea(nombreAldea);
        a1.registrar();
    }
        public static void registroHabilidad() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Registrar habilidades");
        System.out.println("Ingresa el nombre de la habilidad");
        String nombreHabilidad = scanner.nextLine();
        Habilidad h1 = new Habilidad(nombreHabilidad);
        h1.registrar();
        
    }

        
        public static void registroMision() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Registrar misiones");
        System.out.println("Ingresa el nombre de la msion");
        String nombremsion = scanner.nextLine();
        System.out.println("Ingresa la descripcion de la msion");
        String descripcion = scanner.nextLine();
        DIficultad.vistaDificultad();
        System.out.println("INgresa el id de la dificultad");
        int idDificultad= Integer.parseInt(scanner.nextLine());
        System.out.println("Ingresa la recomepnsa de la miison");
        String recomepensa = scanner.nextLine();

        Mision m1 = new Mision(nombremsion, descripcion, idDificultad, recomepensa);
        m1.registrar();
        
    }
        
        
}
