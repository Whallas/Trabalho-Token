package com_javaMAC;

import java.math.BigInteger;

public class gerador {
    
    

    public static void main(String[] args) {
        //Base32 codec = new Base32(); 
        //byte[] key = codec.decode(keyString);
        
        System.out.println("GERADOR DE TOKENS");
 
        new Thread() {
            @Override
            public void run() {
            while(true) {
                try {
                    System.out.println(TOTP.generateTOTP());
                    sleep(30000);
                } catch (InterruptedException ex) {
                }
            }
        }
        }.start();
    }
}
