public class CiframentoCesar {
    public static String criptografar(String str, int k) {
        String resp = "";
        for(int i = 0; i < str.length(); i++) {
            resp += (char)(str.charAt(i) + k);
        }
        return resp;
    }
    public static boolean isFim(String str) {
        return str.length() == 3 && str.charAt(0) == 'F' && str.charAt(1) == 'I' && str.charAt(2) == 'M';
    }
    public static void main(String[] args) {
        String[] entrada = new String[1000];
        String[] saida = new String[1000];
        int numEntrada = 0, k = 3;

        do {
            entrada[numEntrada] = MyIO.readLine();
            saida[numEntrada] = criptografar(entrada[numEntrada], k);
        } while(!isFim(entrada[numEntrada++]));
        numEntrada--;

        for(int i = 0; i < numEntrada; i++) {
            MyIO.println(saida[i]);
        }
    }
}
