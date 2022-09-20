class IsRecursivo {
	public static boolean isSomenteVogal(String str) {
		return isSomenteVogal(str, 0) == str.length() ? true : false;
	}
	public static int isSomenteVogal(String str, int index) {
		int resp = 0;
		if(index < str.length()) {
			if(isVogal(str.charAt(index)) || isEspaco(str.charAt(index))) {
				resp += 1 + isSomenteVogal(str, index + 1);
			}
		}
		return resp;
	}

	public static boolean isSomenteConsoante(String str) {
		return isSomenteConsoante(str, 0) == str.length() ? true : false;
	}
	public static int isSomenteConsoante(String str, int index) {
		int resp = 0;
		if(index < str.length()) {
			if((isLetra(str.charAt(index)) && !isVogal(str.charAt(index))) || isEspaco(str.charAt(index))) {
				resp += 1 + isSomenteConsoante(str, index + 1);
			}
		}
		return resp;
	}

	public static boolean isSomenteInteiro(String str) {
		return isSomenteInteiro(str, 0) == str.length() ? true : false;
	}
	public static int isSomenteInteiro(String str, int index) {
		int resp = 0;
		if(index < str.length()) {
			if(isNumeroInteiro(str.charAt(index)) || isEspaco(str.charAt(index))) {
				resp += 1 + isSomenteInteiro(str, index + 1);
			}
		}
		return resp;
	}

	public static boolean isNumeroReal(String str) {
		//MyIO.println(isNumeroReal(str, 0));
		return isNumeroReal(str, 0) == str.length() && isMaisPontos(str)? true : false;
	}
	public static int isNumeroReal(String str, int index) {
		int resp = 0;
		if(index < str.length()) {
			if(isNumeroInteiro(str.charAt(index)) || isEspaco(str.charAt(index)) || isPonto(str.charAt(index))) {
				resp += 1 + isNumeroReal(str, index + 1);
			}
		}
		return resp;
	}

	public static boolean isLetra(char c) {
		return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
	}

	public static boolean isVogal(char c) {
		c = toUpper(c);
		return c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
	}

	public static boolean isNumeroInteiro(char c) {
		return c >= '0' && c <= '9'; 
	}

	public static boolean isEspaco(char c) {
		return c == ' ';
	}

	public static boolean isPonto(char c) {
		return c == '.' || c == ',';
	}

	public static char toUpper(char c) {
		if(c >= 'a' && c <= 'z') {
			c = (char)(c - 32);	
		}
		return c;
	}

	public static boolean isMaisPontos(String str) {
		//MyIO.println(isMaisPontos(str, 0) <= 1 ? true : false);
		return isMaisPontos(str, 0) <= 1 ? true : false;
	} 
	public static int isMaisPontos(String str, int index) {
		int resp = 0;
		if(index < str.length()) {
			if(isPonto(str.charAt(index))) {
				resp += 1 + isMaisPontos(str, index + 1);
			} else {
				resp += isMaisPontos(str, index + 1);
			}
		}
		//MyIO.println(resp);
		return resp;
	}
	
	public static String verificarString(String str) {
		String resp = "";

		resp += isSomenteVogal(str) ? "SIM " : "NAO ";
		resp += isSomenteConsoante(str) ? "SIM " : "NAO ";
		resp += isSomenteInteiro(str) ? "SIM " : "NAO ";
		resp += isNumeroReal(str) ? "SIM" : "NAO";

		return resp;
	}

	public static String[] getSaida(String[] entrada) {
		return getSaida(entrada, 0);
	}
	public static String[] getSaida(String[] entrada, int index) {
		if(!isFim(entrada[index])) {
			entrada[index] = verificarString(entrada[index]);
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

	public static void imprimir(String[] entrada) {
		imprimir(entrada, 0);
	}
	public static void imprimir(String[] entrada, int index) {
		if(!isFim(entrada[index])) {
			MyIO.println(entrada[index]);
			imprimir(entrada, index + 1);
		}
	}

	public static boolean isFim(String str) {
		return str.length() == 3 && str.charAt(0) == 'F' && str.charAt(1) == 'I' && str.charAt(2) == 'M';
	}

	public static void main(String[] args) {
		String[] entrada = new String[1000];

		entrada = getEntrada(entrada);
		entrada = getSaida(entrada);
		imprimir(entrada);
	}
}
