class PalindromoRecursivo {
	public static String[] getPalindromo(String[] entrada) {
		return getPalindromo(entrada, 0);
	}
	public static String[] getPalindromo(String[] entrada, int index) {
		//String[] resp = new String[1000];

		if(!isFim(entrada[index])) {
			if(isPalindromo(entrada[index])) {
				entrada[index] = "SIM";
			} else {
				entrada[index] = "NAO";
			}

			entrada = getPalindromo(entrada, index + 1);
		}
		
		return entrada;
	}

	public static boolean isPalindromo(String str) {
		return isPalindromo(str, 0);
	}
	public static boolean isPalindromo(String str, int index) {
		boolean resp = true;
		int primeiro = index;
		int ultimo = (str.length() - 1) - index;

		if(index < str.length()) {
			if(str.charAt(primeiro) == str.charAt(ultimo)) {
				resp = isPalindromo(str, index + 1);
			} else {
				resp = false;
				index = str.length();
			}
		}

		return resp;
	}

	public static String[] getEntrada(String[] entrada) {
		return getEntrada(entrada, 0);
	}
	public static String[] getEntrada(String[] entrada, int numEntrada) {
		entrada[numEntrada] = MyIO.readLine();
		if(!isFim(entrada[numEntrada])) entrada = getEntrada(entrada, numEntrada + 1);
		return entrada;
	}

	public static void imprimir(String[] saida) {
		imprimir(saida, 0);
	}
	public static void imprimir(String[] saida, int numSaida) {
		if(!isFim(saida[numSaida])) {
			MyIO.println(saida[numSaida]);
			imprimir(saida, numSaida + 1);
		}
	}

	public static boolean isFim(String str) {
		return str.length() == 3 && str.charAt(0) == 'F' && str.charAt(1) == 'I' && str.charAt(2) == 'M';
	} 

	public static void main(String[] args) {
		String[] entrada = new String[1000];
		String[] saida = new String[1000];

		entrada = getEntrada(entrada);
		saida = getPalindromo(entrada);
		//MyIO.println(saida[0] + " " + saida[1]);
		imprimir(saida);
	}
}
