package algoritmo_puro;

import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class verificador {
    public static void main(String[] args) {
        while(true) {
            System.out.println("Digite o token:");
            
            String token = new Scanner(System.in).nextLine();
            try {
                System.out.println(TOTP.equals(token));
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(verificador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
