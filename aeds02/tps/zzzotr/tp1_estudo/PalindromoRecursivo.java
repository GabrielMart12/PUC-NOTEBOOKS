public class PalindromoRecursivo {
    public static String getPalindromo(String str) {
        return getPalindromo(str, 0, str.length() - 1);
    }
    public static String getPalindromo(String str, int inicio, int fim) {
        String resp = "SIM"; 
        if(inicio < str.length() / 2) {
            if(str.charAt(inicio) != str.charAt(fim)) {
                resp = "NAO";
                inicio = str.length();
            } else {
                resp = getPalindromo(str, inicio + 1, fim - 1);
            }
        }
        return resp;
    }

    public static String[] getSaida(String[] entrada) {
        return getSaida(entrada, 0);
    }
    public static String[] getSaida(String[] entrada, int index) {
        if(!isFim(entrada[index])) {
            entrada[index] = getPalindromo(entrada[index]);
            entrada = getSaida(entrada, index + 1);    
        }
        return entrada;
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
