import javax.crypto.SecretKey;
import javax.swing.*;
import java.util.Base64;

public class Cifrar {


    public static void main(String[] args) throws Exception {
        byte[] input = Funciones.abrirArchivo();
        chacha20 cipher = new chacha20();

        SecretKey key = Funciones.getKey();           // 256-bit secret key (32 bytes)
        byte[] nonce = Funciones.getNonce();          // 96-bit nonce (12 bytes)

        System.out.println("\n---Encryption---");
        byte[] cText = cipher.encrypt(input, key, nonce, 1);
        Funciones.guardar(cText);     //guardamos encriptado

        String clave = Base64.getEncoder().encodeToString(key.getEncoded());
        JOptionPane.showMessageDialog(null, "Clave: " + clave );
        System.out.println(clave);
    }
}
