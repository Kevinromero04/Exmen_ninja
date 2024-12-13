///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package com.mycompany.ninjas;
//
///**
// *
// * @author camper
// */
//public class pninjas {
//
//    public boolean insertion()throws SQLException {
//    String añadir = "INSERT INTO Owners(full_name,email,document,phone,emergency_number) VALUES (?,?,?,?,?);";
//
//    Connection conector = Conexion.getConexion();
//
//    try ( PreparedStatement ownner = conector.prepareStatement(añadir)) {
//
//        ownner.setString(1, fullName);
//        ownner.setString(2, email);
//        ownner.setString(3, document);
//        ownner.setString(4, phone);
//        ownner.setString(5, emergencyNumber);
//
//        ownner.executeUpdate();
//
//        System.out.println("registro exitoso");
//    } catch (SQLException e) {
//        System.err.println("Error al insertar Owner: " + e.getMessage());
//        return false;
//    }
//    return true;
//}
//
//public static int getIdOwner(String cedula) throws SQLException {
//Connection conector = Conexion.getConexion();
//String consult = "SELECT id_owner FROM Owners WHERE document = ?";
//int idOwner = 0;
//try(PreparedStatement testamento = conector.prepareStatement(consult);) {
//testamento.setString(1, cedula);
//ResultSet resultado = testamento.executeQuery();
//
//
//if (resultado.next()) {
//    idOwner = resultado.getInt("id_owner");
//} else {
//    System.out.println("No se encontró ningún propietario con el documento: " + cedula);
//}
//} catch (Exception e) {
//}
//
//return idOwner;
//}
//
//    
//}
