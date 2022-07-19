/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.example.demo.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author Victor Rosales
 */
public class EncriptarPassword {

    
    public static void main(String[] args) {
        // TODO code application logic here
        String password = "12345";
        System.out.println("password: " + password);
        System.out.println("password encriptado:" + encriptarPassword(password));
    }
    
    public static String encriptarPassword(String password){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }
    
}
