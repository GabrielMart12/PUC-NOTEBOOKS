public class CiframentoRecursivo {
    public static String cifrar(String str) {
        return cifrar(str, 0, 3);
    }
    public static String cifrar(String str, int index, int k) {
        String resp = "";
        if(index < str.length()) {
            resp += (char)(str.charAt(index) + k) + cifrar(str, index + 1, k);
        }
        return resp;
    }

    public static String[] getEntrada(String[] entrada) {
        return getEntrada(entrada, 0);
    }
    public static String[] getEntrada(String[] entrada, int index) {
        entrada[index] = MyIO.readLine();
        if(!isFim(entrada[index])) {
            entrada = getEntrada(entrada, index + 1);
        }
        return entrada;
    }

    public static String[] getSaida(String[] entrada) {
        return getSaida(entrada, 0);
    }
    public static String[] getSaida(String[] entrada, int index) {
        if(!isFim(entrada[index])) {
            entrada[index] = cifrar(entrada[index]);
            entrada = getSaida(entrada, index + 1);
        }
        return entrada;
    }

    public static void mostrar(String[] entrada) {
        mostrar(entrada, 0);
    }
    public static void mostrar(String[] entrada, int index) {
        if(!isFim(entrada[index])) {
            MyIO.println(entrada[index]);
            mostrar(entrada, index + 1);
        }
    }

    public static boolean isFim(String str) {
        return str.length() == 3 && str.charAt(0) == 'F' && str.charAt(1) == 'I' && str.charAt(2) == 'M';
    }
    public static void main(String[] args) {
        String[] entrada = new String[1000];
        String[] saida = new String[1000];

        entrada = getEntrada(entrada);
        saida = getSaida(entrada);
        mostrar(saida);

    }
}
