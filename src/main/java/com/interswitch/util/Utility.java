/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.interswitch.util;

import java.security.MessageDigest;

/**
 *
 * @author therapy
 */
public class Utility {
    public static String hashPassword(String password){
        String generatedPassword;
        try {
            //Create MessageDigest instance for MD5
            MessageDigest md=MessageDigest.getInstance("MD5");
            //Add password bytes to digest
            md.update(password.getBytes());
            //Get the hash's bytes
            byte[] bytes=md.digest();
            //this bytes[] has bytes in decimal format;
            //convert it to hexadecimal format
            StringBuilder sb=new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100,16).substring(1));
                
            }
            //get complete hashed password in hex format
            generatedPassword=sb.toString();
        } catch (Exception e) {
            generatedPassword="";
            e.printStackTrace();
        }
        return generatedPassword;
    }
    
    public static void main(String[] args) {
        System.out.println(Utility.hashPassword("temitope"));
    }
}
