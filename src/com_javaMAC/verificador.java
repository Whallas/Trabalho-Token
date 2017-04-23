package com_javaMAC;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class verificador {
    
    private static final String secret = "3132333435363738393031323334353637383930";
    
    public static void main(String[] args) {
        while(true) {
            System.out.println("Digite o token:");
            
            String token = new Scanner(System.in).nextLine();
            long code = Long.parseLong(token);
            
            try {
                System.out.println( TOTPUtils.checkCode(secret, code) );
            } 
            catch (NoSuchAlgorithmException | InvalidKeyException ex) {
                Logger.getLogger(verificador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
