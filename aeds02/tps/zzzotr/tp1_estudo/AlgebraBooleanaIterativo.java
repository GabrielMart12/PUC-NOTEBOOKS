public class AlgebraBooleanaIterativo {
    public static String solucionar(String str) {
        String valores = getValores(str);
        String expressao = trim(subLetras(getExpressao(str), valores));
        String resultado = "";
        int index = 0;

        while(expressao.length() != 1) {
            //MyIO.println(expressao);
            if(AND(expressao, index)) {
                if(!conterExpressao(expressao, index)) {
                    resultado += resolverAND(expressao, index);
                    index = andarParenteses(expressao, index);
                } else {
                    resultado += expressao.charAt(index);
                }
            } else if(OR(expressao, index)) {
                if(!conterExpressao(expressao, index)) {
                    resultado += resolverOR(expressao, index);
                    index = andarParenteses(expressao, index);
                } else {
                    resultado += expressao.charAt(index);
                }
            } else if(NOT(expressao, index)) {
                if(!conterExpressao(expressao, index)) {
                    resultado += resolverNOT(expressao, index);
                    index = andarParenteses(expressao, index);
                } else {
                    resultado += expressao.charAt(index);
                }
            } else {
                resultado += expressao.charAt(index);
            }

            if(index == expressao.length() - 1) {
                expressao = resultado;
                resultado = "";
                index = 0;
            } else {
                index++;
            }
        }
        //MyIO.println(expressao);
        return expressao;
    }

    public static int andarParenteses(String str, int index) {
        int resp = 0;
        for(resp = index; str.charAt(resp) != ')'; resp++);
        return resp;
    }

    public static int resolverNOT(String str, int index) {
        String valor = getValoresRestritos(str);
        return valor.charAt(0) == '1' ? 0 : 1; 
    }

    public static int resolverAND(String str, int index) {
        String valores = getValoresRestritos(str);
        int resp = 0;
        boolean v01 = false, v02 = false, v03 = false, v04 = false;
        if(valores.length() == 2) {
            v01 = valores.charAt(0) == '1' ? true : false;
            v02 = valores.charAt(1) == '1' ? true : false;
            resp = v01 && v02 ? 1 : 0;
        } else if(valores.length() == 3) {
            v01 = valores.charAt(0) == '1' ? true : false;
            v02 = valores.charAt(1) == '1' ? true : false;
            v03 = valores.charAt(2) == '1' ? true : false;
            resp = v01 && v02 && v03 ? 1 : 0;
        } else {
            v01 = valores.charAt(0) == '1' ? true : false;
            v02 = valores.charAt(1) == '1' ? true : false;
            v03 = valores.charAt(2) == '1' ? true : false;
            v04 = valores.charAt(3) == '1' ? true : false;
            resp = v01 && v02 && v03 && v04 ? 1 : 0;
        }
        return resp;
    }

    public static int resolverOR(String str, int index) {
        String valores = getValoresRestritos(str);
        int resp = 0;
        boolean v01 = false, v02 = false, v03 = false, v04 = false;
        if(valores.length() == 2) {
            v01 = valores.charAt(0) == '1' ? true : false;
            v02 = valores.charAt(1) == '1' ? true : false;
            resp = v01 || v02 ? 1 : 0;
        } else if(valores.length() == 3) {
            v01 = valores.charAt(0) == '1' ? true : false;
            v02 = valores.charAt(1) == '1' ? true : false;
            v03 = valores.charAt(2) == '1' ? true : false;
            resp = v01 || v02 || v03 ? 1 : 0;
        } else {
            v01 = valores.charAt(0) == '1' ? true : false;
            v02 = valores.charAt(1) == '1' ? true : false;
            v03 = valores.charAt(2) == '1' ? true : false;
            v04 = valores.charAt(3) == '1' ? true : false;
            resp = v01 || v02 || v03 || v04 ? 1 : 0;
        }
        return resp;
    }

    public static boolean conterExpressao(String str, int index) {
        int cont = 0;
        for(int i = index; str.charAt(i) != ')'; i++) {
            if(str.charAt(i) == '(') {
                cont++;
            }
        }
        return cont > 1 ? true : false;
    }

    public static boolean AND(String str, int index) {
        return str.charAt(index) == 'a' && str.charAt(index + 1) == 'n' && str.charAt(index + 2) == 'd';
    }

    public static boolean OR(String str, int index) {
        return str.charAt(index) == 'o' && str.charAt(index + 1) == 'r';
    }

    public static boolean NOT(String str, int index) {
        return str.charAt(index) == 'n' && str.charAt(index + 1) == 'o' && str.charAt(index + 2) == 't';
    }

    public static String subLetras(String str, String valores) {
        String resp = "";
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == 'A') {
                resp += valores.charAt(1);
            } else if(str.charAt(i) == 'B') {
                resp += valores.charAt(2);
            } else if(str.charAt(i) == 'C') {
                resp += valores.charAt(3);
            } else {
                resp += str.charAt(i);
            }
        }
        return resp;
    }

    public static String getExpressao(String str) {
        String resp = "";
        for(int i = 0; i < str.length(); i++) {
            if(!(str.charAt(i) >= '0' && str.charAt(i) <= '9')) {
                resp += str.charAt(i);
            }
        }
        return resp;
    }

    public static String getValoresRestritos(String str) {
        String resp = "";
        for(int i = 0; str.charAt(i) != ')'; i++) {
            if(str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                resp += str.charAt(i);
            }
        }
        return resp;
    }

    public static String getValores(String str) {
        String resp = "";
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                resp += str.charAt(i);
            }
        }
        return resp;
    }

    public static String trim(String str) {
        String resp = "";
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) != ' ') {
                resp += str.charAt(i);
            }
        }
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
            saida[numEntrada] = !isFim(entrada[numEntrada]) ? solucionar(entrada[numEntrada]) : "FIM";
        } while(!isFim(entrada[numEntrada++]));
        numEntrada--;

        for(int i = 0; i < numEntrada; i++) {
            MyIO.println(saida[i]);
        }
    }
}
