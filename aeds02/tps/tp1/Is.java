class Is {
	public static boolean isFim(String str) {
		return str.length() == 3 && str.charAt(0) == 'F' && str.charAt(1) == 'I' && str.charAt(2) == 'M';
	}

	public static String verificarString(String str) {
		String resp = "";

		resp += isSomenteVogal(str) ? "SIM " : "NAO ";
		resp += isSomenteConsoante(str) ? "SIM " : "NAO ";
		resp += isSomenteInteiro(str) ? "SIM " : "NAO ";
		resp += isNumeroReal(str) ? "SIM" : "NAO";

		return resp;
	}

	public static boolean isNumeroReal(String str) {
		String reais = "-0123456789,. ";
		int cont = 0;
		int qtdPonto = getQtdPonto(str);

		for(int i = 0; i < str.length(); i++) {
			for(int j = 0; j < reais.length(); j++) {
				if(str.charAt(i) == reais.charAt(j)) {
					cont++;	
				}
			}	
		}
		
		
		//MyIO.println(qtdPonto + "---" + cont + "---" + str.length());
		return qtdPonto <= 1 && cont == str.length() ? true : false;
	}
	
	public static int getQtdPonto(String str) {
		int cont = 0;
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == '.' || str.charAt(i) == ',') {
				cont++;
			}
		}
		return cont;
	}

	public static boolean isSomenteInteiro(String str) {
		String inteiros = "-0123456789 ";
		int cont = 0;

		for(int i = 0; i < str.length(); i++) {
			for(int j = 0; j < inteiros.length(); j++) {
				if(str.charAt(i) == inteiros.charAt(j)) cont++;
			}
		}

		return cont == str.length() ? true : false;
	} 

	public static boolean isSomenteConsoante(String str) {
		//String vogais = "0123456789aeiouAEIOUáéíóúâêôãõÁÉÍÓÚÂÊÔÃÕŨ";
		String vogais = "0123456789aeiouAEIOU";
		int cont = 0;

		for(int i = 0; i < str.length(); i++) {
			for(int j = 0; j < vogais.length(); j++) {
				if(str.charAt(i) == vogais.charAt(j)) cont++;
			}
		}

		return cont == 0 ? true : false;
	}

	public static boolean isSomenteVogal(String str) {
		//String vogais = "aeiouAEIOUáéíóúâêôãõÁÉÍÓÚÂÊÔÃÕŨ";
		String vogais = "aeiouAEIOU";
		//char[] vogais = {'a','e','i','o','u','A','E','I','O','U',225,233,237,243,250,226,234,238,244,251,227,245,' '};
		int cont = 0;
		
		for(int i = 0; i < str.length(); i++) {
			for(int j = 0; j < vogais.length(); j++) {
				if(str.charAt(i) == vogais.charAt(j)) cont++;		
			}
		}

		return cont == str.length() ? true : false;
	}

	public static void main(String[] args) {
		//MyIO.setCharset("UTF-8");
		String[] entrada = new String[1000];
		String[] saida = new String[1000];
		int numEntrada = 0;

		do {
			entrada[numEntrada] = MyIO.readLine();
			saida[numEntrada] = verificarString(entrada[numEntrada]);
		} while(!isFim(entrada[numEntrada++]));
		numEntrada--;

		for(int i = 0; i < numEntrada; i++) {
			MyIO.println(saida[i]);
		}
	}
}
