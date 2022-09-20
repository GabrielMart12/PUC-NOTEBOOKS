import java.util.*;

class AlteracaoAleatoria {
	public static String alterarLetras(String str, char alet1, char alet2) {
		String resp = "";

		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == alet1) {
				resp += alet2;	
			} else {
				resp += str.charAt(i);
			}
		}

		return resp;
	}

	public static boolean isFim(String str) {
		return str.length() == 3 && str.charAt(0) == 'F' && str.charAt(1) == 'I' && str.charAt(2) == 'M'; 	
	}

	public static void main(String[] args) {
		MyIO.setCharset("UTF-8");

		String[] entrada = new String[1000];
		String[] saida = new String[1000];
		int numEntrada = 0;

		Random gerador = new Random();
		gerador.setSeed(4);

		//MyIO.println((char)Math.abs(gerador.nextInt()) % 26);
		//MyIO.println((char)('u' + (Math.abs(gerador.nextInt()) % 26)));
		
		
		do {
			entrada[numEntrada] = MyIO.readLine();
			
			char alet1 = (char)('a' + (Math.abs(gerador.nextInt()) % 26));
 			char alet2 = (char)('a' + (Math.abs(gerador.nextInt()) % 26));
			
			saida[numEntrada] = alterarLetras(entrada[numEntrada], alet1, alet2);

		} while(!isFim(entrada[numEntrada++]));
		numEntrada--;
		
		for(int i = 0; i < numEntrada; i++) {
			MyIO.println(saida[i]);	
		}
	}
}
