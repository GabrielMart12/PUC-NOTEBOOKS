class CiframentoRecursivo {
	public static String cifrarFrase(String str) {
		return cifrarFrase(str, 3, 0);
	}
	public static String cifrarFrase(String str, int chave, int index) {
		String resp = "";
		if(index < str.length()) {
			resp += (char)(str.charAt(index) + chave) + cifrarFrase(str, chave, index + 1);
		}
		return resp;
	}

	public static String[] getSaida(String[] entrada) {
		return getSaida(entrada, 0);
	}
	public static String[] getSaida(String[] entrada, int index) {
		if(!isFim(entrada[index])) {
			entrada[index] = cifrarFrase(entrada[index]);
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
