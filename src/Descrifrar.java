import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.*;
import java.util.Base64;

public class Descrifrar {

    public static void main(String[] args) throws Exception {
        byte[] input = Funciones.abrirArchivo();
        chacha20 cipher = new chacha20();

        //recogemos clave
        String clave = JOptionPane.showInputDialog("Introduzca la clave de descifrado");
        byte[] decodedKey = Base64.getDecoder().decode(clave);
        SecretKey key = new SecretKeySpec(decodedKey, 0, decodedKey.length, "ChaCha20");

        System.out.println("\n---Decryption---");
        byte[] pText = cipher.decrypt(input, key);
        Funciones.guardar(pText);     //guardamos desencriptado
    }
}
