public class PalindromoIterativo {
	public static boolean isFim(String str) {
		return str.length() == 3 && str.charAt(0) == 'F' && str.charAt(1) == 'I' && str.charAt(2) == 'M'; 
	}

	public static String getPalindromo(String str) {
		return isPalindromo(str) ? "SIM" : "NAO";
	}

	public static boolean isPalindromo(String str) {
		boolean resp = true;
		int j = str.length() - 1;

		for(int i = 0; i < str.length() / 2; i++) {
			if(str.charAt(i) != str.charAt(j)) {
				resp = false;
				i = str.length();
			}
			j--;
		}

		return resp;
	}

	public static void main(String[] args) {
		String[] entrada = new String[1000];
		String[] saida = new String[1000];
		int numEntrada = 0;

		do {
			entrada[numEntrada] = MyIO.readLine();
			saida[numEntrada] = getPalindromo(entrada[numEntrada]);
		} while(!isFim(entrada[numEntrada++]));
		numEntrada--;

		for(int i = 0; i < numEntrada; i++) {
			MyIO.println(saida[i]);
		}
	}
}
