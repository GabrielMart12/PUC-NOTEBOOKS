import java.util.Random;
import java.lang.Math;

public class AlteracaoAleatoria {
    public static String alterar(String str, char a, char b) {
        String resp = "";
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == a) {
                resp += b;
            } else {
                resp += str.charAt(i);
            }
        }
        return resp;
    }
    public static boolean isFim(String str) {
        return str.length() == 3 && str.charAt(0) == 'F' && str.charAt(1) == 'I' && str.charAt(2) == 'M';
    }
    public static void main(String[] args) {
        String[] entrada = new String[1000];
        String[] saida = new String[1000];
        int numEntrada = 0;

        Random gerador = new Random();
        gerador.setSeed(4);

        do {
            entrada[numEntrada] = MyIO.readLine();
            char c01 = (char)('a' + (Math.abs(gerador.nextInt()) % 26));
            char c02 = (char)('a' + (Math.abs(gerador.nextInt()) % 26));
            saida[numEntrada] = alterar(entrada[numEntrada], c01, c02);
        } while(!isFim(entrada[numEntrada++]));
        numEntrada--;

        for(int i = 0; i < numEntrada; i++) {
            MyIO.println(saida[i]);
        }   
    }
}
