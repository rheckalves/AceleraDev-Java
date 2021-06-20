package challenge;
import java.util.ArrayList;

public class CriptografiaCesariana implements Criptografia {

    private Object IllegalArgumentException;

    @Override
    public String criptografar(String texto) {
        ArrayList<Integer> listAscii = new ArrayList<>();
        ArrayList<Integer> lastThreeAsciiList = new ArrayList<>();
        texto = texto.toLowerCase();
        String codedMessage = "";
    if(texto == "") {
        throw new IllegalArgumentException();
    }

    if(texto == null) {
        throw new NullPointerException();
    }
    
        for(int asciiCode = 97; asciiCode < 123; asciiCode++) {
            if (asciiCode < 120) {
                listAscii.add(asciiCode);
            } else {
                lastThreeAsciiList.add(asciiCode);
            }
        }

        for(char originalChar : texto.toCharArray())
            if (listAscii.contains((int) originalChar)) {
                int cryptoCharAscii = (int) originalChar + 3;
                char cryptoChar = (char) cryptoCharAscii;
                codedMessage = codedMessage + cryptoChar;
            } else if (lastThreeAsciiList.contains((int) originalChar)) {
                int cryptoCharAscii = (int) originalChar - 23;
                char cryptoChar = (char) cryptoCharAscii;
                codedMessage = codedMessage + cryptoChar;

            } else {
                codedMessage = codedMessage + originalChar;
            }
        return codedMessage;
    }

    @Override
    public String descriptografar(String texto) {
        ArrayList<Integer> listAscii = new ArrayList<>();
        ArrayList<Integer> firstThreeAsciiList = new ArrayList<>();
        texto = texto.toLowerCase();
        String decodedMessage = "";

        if(texto == "") {
            throw new IllegalArgumentException();
        }

        if(texto == null) {
            throw new NullPointerException();
        }

        for(int asciiCode = 97; asciiCode < 123; asciiCode++) {
            if(asciiCode > 99) {
                listAscii.add(asciiCode);
            } else {
                firstThreeAsciiList.add(asciiCode);
            }

        }

        for(char originalChar : texto.toCharArray())
            if (listAscii.contains((int) originalChar)) {
                int cryptoCharAscii = (int) originalChar - 3;
                char cryptoChar = (char) cryptoCharAscii;
                decodedMessage = decodedMessage + cryptoChar;
            } else if (firstThreeAsciiList.contains((int) originalChar)) {
                int cryptoCharAscii = (int) originalChar + 23;
                char cryptoChar = (char) cryptoCharAscii;
                decodedMessage = decodedMessage + cryptoChar;

            } else {
                decodedMessage = decodedMessage + originalChar;
            }

        return decodedMessage;
    }
}
