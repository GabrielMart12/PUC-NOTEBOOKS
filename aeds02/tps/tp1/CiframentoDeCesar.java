class CiframentoDeCesar {
	public static boolean isFim(String str) {
		return str.length() == 3 && str.charAt(0) == 'F' && str.charAt(1) == 'I' && str.charAt(2) == 'M';
	}

	public static String cifrarFrase(String str, int chave) {
		String resp = "";
		for(int i = 0; i < str.length(); i++) {
			resp += (char)(str.charAt(i) + chave);
		}
		return resp;
	}

	public static void main(String[] args) {
		String[] entrada = new String[1000];
		String[] saida = new String[1000];
		int numEntrada = 0;
		int chave = 3;
		
		do {
			entrada[numEntrada] = MyIO.readLine();
			saida[numEntrada] = cifrarFrase(entrada[numEntrada], chave);
		} while(!isFim(entrada[numEntrada++]));
		numEntrada--;

		for(int i = 0; i < numEntrada; i++) {
			MyIO.println(saida[i]);
		}
	}
}
