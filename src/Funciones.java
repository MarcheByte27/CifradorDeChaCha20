
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class Funciones extends Component {


    // A 256-bit secret key (32 bytes)
    public static SecretKey getKey() throws NoSuchAlgorithmException {
        KeyGenerator keyGen = KeyGenerator.getInstance("ChaCha20");
        keyGen.init(256, SecureRandom.getInstanceStrong());
        return keyGen.generateKey();
    }

    public static String convertBytesToHex(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        for (byte temp : bytes) {
            result.append(String.format("%02x", temp));
        }
        return result.toString();
    }


    // 96-bit nonce (12 bytes)
    public static byte[] getNonce() {
        byte[] newNonce = new byte[12];
        new SecureRandom().nextBytes(newNonce);
        return newNonce;
    }

    public static byte[] abrirArchivo() throws IOException {
        /** llamamos el metodo que permite cargar la ventana*/
        JFileChooser file = new JFileChooser();
        file.showOpenDialog(file);
        File archivo = file.getSelectedFile();
        FileInputStream input = new FileInputStream(archivo);
        byte[] b = new byte[(int) archivo.length()];
        input.read(b);
        input.close();
        return b;
    }


    public static void guardar(byte[] texto) throws IOException {

        JFileChooser guardar = new JFileChooser();
        guardar.showSaveDialog(guardar);
        File archivo = guardar.getSelectedFile();

        InputStream in = new ByteArrayInputStream(texto);
        BufferedImage image = ImageIO.read(in);

        FileOutputStream output = new FileOutputStream(archivo);
        output.write(texto);
        output.close();

    }


}
