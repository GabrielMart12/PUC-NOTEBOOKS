public class IsIterativo {
    public static boolean getVogal(String str) {
        boolean resp = true;
        for(int i = 0; i < str.length(); i++) {
            if(!(isVogal(toUpper(str.charAt(i))) || isEspaco(str.charAt(i)))) {
                resp = false;
            }
        }
        return resp;
    }

    public static boolean getConsoante(String str) {
        boolean resp = true;
        for(int i = 0; i < str.length(); i++) {
            if(!(isConsoante(str.charAt(i)) || isEspaco(str.charAt(i)))) {
                resp = false;
            }
        }
        return resp;
    }

    public static boolean getNumero(String str) {
        boolean resp = true;
        for(int i = 0; i < str.length(); i++) {
            if(!(isNumero(str.charAt(i)) || isEspaco(str.charAt(i)))) {
                resp = false;
            }
        }
        return resp;
    }

    public static boolean getDecimal(String str) {
        boolean resp = true;
        for(int i = 0; i < str.length(); i++) {
            if(!(isDecimal(str.charAt(i)) || isEspaco(str.charAt(i)))) {
                resp = false;
            }
        }
        return resp;
    }

    public static boolean isDecimal(char c) {
        return isNumero(c) || c == '.' || c == ',';
    }

    public static boolean isNumero(char c) {
        return c >= '0' && c <= '9';
    }

    public static boolean isVogal(char c) {
        return c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }

    public static boolean isConsoante(char c) {
        return isLetra(c) && !isVogal(c);
    }

    public static boolean isLetra(char c) {
        return toUpper(c) >= 'A' && toUpper(c) <= 'Z';
    }

    public static boolean isEspaco(char c) {
        return c == ' ';        
    }

    public static char toUpper(char c) {
        return c >= 'a' & c <= 'z' ? (char)(c - 32) : c;
    }

    public static String getResultado(String str) {
        String resp = "";
        String vogais = getVogal(str) ? "SIM" : "NAO";
        String consoantes = getConsoante(str) ? "SIM" : "NAO";
        String numeros = getNumero(str) ? "SIM" : "NAO";
        String decimais = getDecimal(str) ? "SIM" : "NAO";
        resp += vogais + " " + consoantes + " " + numeros + " " + decimais; 
        return resp;
    }

    public static boolean isFim(String str) {
        return str.length() == 1 && str.charAt(0) == '0';
    }

    public static void main(String[] args) {
        String[] entrada = new String[1000];
        String[] saida = new String[1000];
        int numEntrada = 0;

        do {
            entrada[numEntrada] = MyIO.readLine();
            saida[numEntrada] = getResultado(entrada[numEntrada]);
        } while(!isFim(entrada[numEntrada++]));
        numEntrada--;

        for(int i = 1; i < numEntrada; i++) {
            MyIO.println(saida[i]);
        }
    }
}
