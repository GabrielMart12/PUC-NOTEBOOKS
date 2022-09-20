class AlgebraBooleana {
	public static boolean isFim(String str) {
		return str.length() == 1 && str.charAt(0) == '0';
	}

	public static String resolverString(String str) {
		String valores = getValores(str);
		String expressao = trim(getExpressao(str, valores));
		String resultado = "";
		int index = 0;
		
		//MyIO.println(expressao + " --- " + valores);

		// percorre a string diversas vezes ate resolver toda expressao booleana
		while(expressao.length() != 1) {
			//MyIO.println(resultado + "---" + index);
			if(AND(expressao, index)) {
				if(!conterExpressao(expressao, index)) {
					resultado += resultadoAND(expressao, index);
					index = andarParenteses(expressao, index);
					//MyIO.println("AND: " + resultado);
				} else {
					resultado += expressao.charAt(index);
				}
			} else if(OR(expressao, index)) {
				if(!conterExpressao(expressao, index)) {
					resultado += resultadoOr(expressao, index);
					index = andarParenteses(expressao, index);
					//MyIO.println("OR: " + resultado + "---" + resultado.length());
				} else {
					resultado += expressao.charAt(index);
				}
			} else if(NOT(expressao, index)) {
				if(!conterExpressao(expressao, index)) {
					resultado += resultadoNOT(expressao, index);
					index = andarParenteses(expressao, index);
					//MyIO.println("NOT: " + resultado);
				} else {
					resultado += expressao.charAt(index);
				}
					
			} else {
				resultado += expressao.charAt(index);
			}
			
			if(index == expressao.length() - 1) {
				index = 0;
				expressao = resultado;
				//MyIO.println("FIM: " + expressao + expressao.length());
				resultado = "";
			} else {
				index++;
			}
		}

		return expressao;
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

	public static int andarParenteses(String str, int index) {
		int i;
		for(i = index; str.charAt(i) != ')'; i++);
		return i;	
	}

	public static String getNumeros(String str, int index) {
		String nums = "";
		for(int i = index; str.charAt(i) != ')'; i++) {
			if(str.charAt(i) == '1' || str.charAt(i) == '0') {
				nums += str.charAt(i);
			}
		}
		return nums;
	}

	public static char resultadoAND(String str, int index) {
		boolean resp = false;
		String nums = getNumeros(str, index);
		
		if((int)nums.length() == 2) {
			resp = (nums.charAt(0) == '1' ? true : false)  && 
			       (nums.charAt(1) == '1' ? true : false);
		} else if((int)nums.length() == 3) {
			resp = (nums.charAt(0) == '1' ? true : false)  && 
			       (nums.charAt(1) == '1' ? true : false) && 
			       (nums.charAt(2) == '1' ? true : false);
		} else if((int)nums.length() == 4) {
			resp = (nums.charAt(0) == '1' ? true : false)  && 
			       (nums.charAt(1) == '1' ? true : false) && 
			       (nums.charAt(2) == '1' ? true : false) &&
			       (nums.charAt(3) == '1' ? true : false);
		} 

		return resp ? '1' : '0';
	}

	public static char resultadoOr(String str, int index) {
		boolean resp = false;
		String nums = getNumeros(str, index);
		if((int)nums.length() == 2) {
			resp = (nums.charAt(0) == '1' ? true : false)  ||
			       (nums.charAt(1) == '1' ? true : false);
		} else if((int)nums.length() == 3) {
			resp = (nums.charAt(0) == '1' ? true : false)  || 
			       (nums.charAt(1) == '1' ? true : false) ||
			       (nums.charAt(2) == '1' ? true : false);
		} else if((int)nums.length() == 4) {
			resp = (nums.charAt(0) == '1' ? true : false)  || 
			       (nums.charAt(1) == '1' ? true : false) ||
			       (nums.charAt(2) == '1' ? true : false) ||
			       (nums.charAt(3) == '1' ? true : false);
		}

		return resp ? '1' : '0';  
	} 

	public static char resultadoNOT(String str, int index) {
		String num = getNumeros(str, index);
		return num.charAt(0) == '1' ? '0' : '1';
	}

	// Se há (, tem expressao interna
	public static boolean conterExpressao(String str, int index) {
		int cont = 0;
		for(int i = index; str.charAt(i) != ')'; i++) if (str.charAt(i) == '(') cont++;
		return cont > 1 ? true : false;
	}

	public static boolean AND(String str, int index) {
		return str.charAt(index) == 'a';
	}

	public static boolean OR(String str, int index) {
		return str.charAt(index) == 'o';
	}

	public static boolean NOT(String str, int index) {
		return str.charAt(index) == 'n';
	}

	// Armazena valores X Y Y em uma string
	public static String getValores(String str) {
		String resp = "";
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) >= '0' && str.charAt(i) <= '3') {
				resp += str.charAt(i);
			}
		}
		return resp;
	}
	
	// retorna a expressao booleana com letras substituidas
	public static String getExpressao(String str, String valores) {
		String resp = "";

		for(int i = str.charAt(0) == '2' ? 6 : 8; i < str.length(); i++){
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

	public static void main(String[] args) {
		String[] entrada = new String[1000];
		String[] saida = new String[1000];
		int numEntrada = 0;

		do {
			entrada[numEntrada] = MyIO.readLine();
			//MyIO.println(entrada[numEntrada] + " --- " + entrada[numEntrada].length());
			saida[numEntrada] = !isFim(entrada[numEntrada]) ? resolverString(entrada[numEntrada]) : "FIM";
		} while(!isFim(entrada[numEntrada++]));
		numEntrada--;
		
		
		for(int i = 0; i < numEntrada; i++) {
			MyIO.println(saida[i]);
		}
	}
}
