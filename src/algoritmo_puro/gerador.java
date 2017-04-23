/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmo_puro;

import static java.lang.Thread.sleep;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author whallas
 */
public class gerador {
    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
            while(true) {
                try {
                    System.out.println(TOTP.getToken());
                    sleep(30000);
                } catch (InterruptedException | NoSuchAlgorithmException ex) {
                }
            }
        }
        }.start();
    }
}
