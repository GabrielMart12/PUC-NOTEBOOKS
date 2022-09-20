import java.io.*;
import java.net.*;

class PaginaHTML {
	public static String lerPaginaHTML(String str) {
		String endereco = str;
		String html = getHtml(endereco);
		String resp = "";
		int contA = 0, contE = 0, contI = 0, contO = 0, contU = 0,
		    contAgudoA = 0, contAgudoE = 0, contAgudoI = 0, contAgudoO = 0, contAgudoU = 0,
		    contCraseA = 0, contCraseE = 0, contCraseI = 0, contCraseO = 0, contCraseU = 0,
		    contTilA = 0, contTilO = 0,
		    contCircA = 0, contCircE = 0, contCircI = 0, contCircO = 0, contCircU = 0,
		    contConsoante = 0, contBr = 0, contTable = 0;


      		for(int i = 0; i < html.length(); i++) {
			if(html.charAt(i) == 97) { contA++; }
			if(html.charAt(i) == 'e') { contE++; }
			if(html.charAt(i) == 'i') { contI++; }
			if(html.charAt(i) == 'o') { contO++; }
			if(html.charAt(i) == 'u') { contU++; }
			if(html.charAt(i) == 225) { contAgudoA++; }
			if(html.charAt(i) == 233) { contAgudoE++; }
			if(html.charAt(i) == 237) { contAgudoI++; }
			if(html.charAt(i) == 243) { contAgudoO++; }
			if(html.charAt(i) == 250) { contAgudoU++; }
			if(html.charAt(i) == 224) { contCraseA++; }
			if(html.charAt(i) == 232) { contCraseE++; }
			if(html.charAt(i) == 236) { contCraseI++; }
			if(html.charAt(i) == 242) { contCraseO++; }
			if(html.charAt(i) == 249) { contCraseU++; }
			if(html.charAt(i) == 227) { contTilA++; }
			if(html.charAt(i) == 245) { contTilO++; }
			if(html.charAt(i) == 226) { contCircA++; }
			if(html.charAt(i) == 234) { contCircE++; }
			if(html.charAt(i) == 238) { contCircI++; }
			if(html.charAt(i) == 244) { contCircO++; }
			if(html.charAt(i) == 251) { contCircU++; }
			if(isConsoante(html.charAt(i))) contConsoante++;
			if(html.charAt(i) == '<' &&
			   html.charAt(i + 1) == 'b' &&
			   html.charAt(i + 2) == 'r' &&
			   html.charAt(i + 3) == '>') { contBr++; contConsoante -= 2; }
			if(html.charAt(i) == '<' &&
			   html.charAt(i + 1) == 't' &&
			   html.charAt(i + 2) == 'a' &&
			   html.charAt(i + 3) == 'b' &&
			   html.charAt(i + 4) == 'l' &&
			   html.charAt(i + 5) == 'e' &&
			   html.charAt(i + 6) == '>') { contTable++; contConsoante -= 3; contA--; contE--; }
		}

		resp = "a(" + contA + ") " +
		       "e(" + contE + ") " +
		       "i(" + contI + ") " +
		       "o(" + contO + ") " +
		       "u(" + contU + ") " +
		       "á(" + contAgudoA + ") " +
		       "é(" + contAgudoE + ") " +
		       "í(" + contAgudoI + ") " +
		       "ó(" + contAgudoO + ") " +
		       "ú(" + contAgudoU + ") " +
		       "à(" + contCraseA + ") " +
		       "è(" + contCraseE + ") " +
		       "ì(" + contCraseI + ") " +
		       "ò(" + contCraseO + ") " +
		       "ù(" + contCraseU + ") " +
		       "ã(" + contTilA + ") " +
		       "õ(" + contTilO + ") " +
		       "â(" + contCircA + ") " +
		       "ê(" + contCircE + ") " +
		       "î(" + contCircI + ") " +
		       "ô(" + contCircO + ") " +
		       "û(" + contCircU + ") " +
		       "consoante(" + contConsoante + ") " +
		       "<br>(" + contBr + ") " +
		       "<table>(" + contTable + ") ";

		return resp;
	}

	public static boolean isConsoante(char c) {
		return (c >= 'a' && c <= 'z') && (c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u');
	}

	public static String getHtml(String endereco){
		URL url;
        	InputStream is = null;
        	BufferedReader br;
      		String resp = "", line;

      		try {
         		url = new URL(endereco);
         		is = url.openStream();  // throws an IOException
         		br = new BufferedReader(new InputStreamReader(is));

         		while ((line = br.readLine()) != null) {
            			resp += line + "\n";
         	}
      		} catch (MalformedURLException mue) {
         		mue.printStackTrace();
      		} catch (IOException ioe) {
         		ioe.printStackTrace();
      		} 

      		try {
         		is.close();
      		} catch (IOException ioe) {
         		// nothing to see here

      		}

      		return resp;
   	}

	public static boolean isFim(String str) {
		return str.length() == 3 && str.charAt(0) == 'F' && str.charAt(1) == 'I' && str.charAt(2) == 'M'; 
	}

	public static boolean isUrl(String str) {
		return str.charAt(0) == 'h';
	}

   	public static void main(String[] args) {
      		//MyIO.setCharset("UTF-8");
		String endereco, html;
		String[] entrada = new String[1000];
		String[] saida = new String[1000];
		int numEntrada = 0;
		int numSaida = 0;
		String tmp = "";

		do {
			entrada[numEntrada] = MyIO.readLine();	
			if(isUrl(entrada[numEntrada])) {
				saida[numSaida++] = lerPaginaHTML(entrada[numEntrada]) + tmp; 
			} else {
				tmp = entrada[numEntrada];
			}
		} while(!isFim(entrada[numEntrada++]));
		numEntrada--;

		for(int i = 0 ; i < numEntrada / 2; i++) {
			MyIO.println(saida[i]);
		}
   	}
}
