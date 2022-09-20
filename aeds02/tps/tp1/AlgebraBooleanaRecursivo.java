class AlgebraBooleanaRecursivo {
	public static String getUltimoChar(String str) {
		String ultimoChar = "";
		ultimoChar += str.charAt(str.length() - 1);
		return ultimoChar;
	}
	public static String getExpressaoResolvida(String expressao) {
		expressao = trim(expressao);
		String valores = getValores(expressao);
		expressao = getExpressao(expressao);
		expressao = substituirLetras(expressao, valores);
		String resultado = getExpressaoResolvida(expressao, "", 0); 

		return getUltimoChar(resultado);
	}
	public static String getExpressaoResolvida(String expressao, String resultado, int index) {
		//MyIO.println(index + " --- " + expressao);
		if(expressao.length() != 1) {
			if(AND(expressao, index)) {
				if(!conterExpressao(expressao, index)) {
					resultado += resultadoAND(expressao, index);
					index = andarParenteses(expressao, index);
				} else {
					resultado += expressao.charAt(index);
				}
			} else if(OR(expressao, index)) {
				if(!conterExpressao(expressao, index)) {
					resultado += resultadoOR(expressao, index);
					index = andarParenteses(expressao, index);
				} else {
					resultado += expressao.charAt(index);
				}
			} else if(NOT(expressao, index)) {
				if(!conterExpressao(expressao, index)) {
					resultado += resultadoNOT(expressao, index);
					index = andarParenteses(expressao, index);
				} else {
					resultado += expressao.charAt(index);
				}
			} else {
				resultado += expressao.charAt(index);
			}
			
			if(index == expressao.length() - 1) {
				//MyIO.println("FIM: " + resultado + resultado.length());
				expressao += getExpressaoResolvida(resultado, "", 0);
			} else {
				//MyIO.println(resultado);
				expressao += getExpressaoResolvida(expressao, resultado, index + 1);
			}
		}	
		//MyIO.println(expressao);

		return expressao;
	}

	public static int andarParenteses(String str, int index) {
		if(str.charAt(index) != ')') {
			index = andarParenteses(str, index + 1);
		}
		return index;
	}

	public static char resultadoNOT(String str, int index) {
		String num = getNumeros(str, index);
		return num.charAt(0) == '1' ? '0' : '1';
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

	public static char resultadoOR(String str, int index) {
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

	public static String getNumeros(String str, int index) {
		String resp = "";
		if(str.charAt(index) != ')') {
			if(str.charAt(index) == '1' || str.charAt(index) == '0') {
				resp += str.charAt(index) + getNumeros(str, index + 1);	
			} else {
				resp += getNumeros(str, index + 1);
			}
		}
		return resp;
	}
	
	public static boolean conterExpressao(String str, int index) {
		return conterExpressao(str, index, 0) > 1 ? true : false;
	}
	public static int conterExpressao(String str, int index, int contador) {
		if(index < str.length()) {
			if(str.charAt(index) != ')') {
				if(str.charAt(index) == '(') {
					contador = conterExpressao(str, index + 1, contador + 1);
				} else {
					contador = conterExpressao(str, index + 1, contador);
				}
			}
		}
		return contador;
	}

	public static boolean NOT(String str, int index) {
		return str.charAt(index) == 'n' && str.charAt(index + 1) == 'o' && str.charAt(index + 2) == 't';
	}

	public static boolean OR(String str, int index) {
		return str.charAt(index) == 'o' && str.charAt(index + 1) == 'r';
	}

	public static boolean AND(String str, int index) {
		//MyIO.println(str);
		return str.charAt(index) == 'a' && str.charAt(index + 1) == 'n' && str.charAt(index + 2) == 'd';
	}

	public static String substituirLetras(String str, String valores) {
		return substituirLetras(str, valores, 0);
	}
	public static String substituirLetras(String str, String valores, int index) {
		String resp = "";
		if(index < str.length()) {
			if(valores.charAt(0) == '3') {
				if(str.charAt(index) == 'A') {
					resp += valores.charAt(1) + substituirLetras(str, valores, index + 1);
				} else if(str.charAt(index) == 'B') {
					resp += valores.charAt(2) + substituirLetras(str, valores, index + 1);
				} else if(str.charAt(index) == 'C') {
					resp += valores.charAt(3) + substituirLetras(str, valores, index + 1);
				} else {
					resp += str.charAt(index) + substituirLetras(str, valores, index + 1);
				}
			} else if(valores.charAt(0) == '2') {
				if(str.charAt(index) == 'A') {
					resp += valores.charAt(1) + substituirLetras(str, valores, index + 1);
				} else if(str.charAt(index) == 'B') {
					resp += valores.charAt(2) + substituirLetras(str, valores, index + 1);
				} else {
					resp += str.charAt(index) + substituirLetras(str, valores, index + 1);
				}
			}
		}
		return resp;
	}

	public static String getExpressao(String str) {
		return getExpressao(str, 0); 
	}
	public static String getExpressao(String str, int index) {
		String resp = "";
		if(index < str.length()) {
			if(str.charAt(index) >= '0' && str.charAt(index) <= '9') {
				resp += getExpressao(str, index + 1);
			} else {
				resp += str.charAt(index) + getExpressao(str, index + 1);
			}
		}
		return resp;
	}

	public static String getValores(String str) {
		return getValores(str, 0);
	}
	public static String getValores(String str, int index) {
		String resp = "";
		if(index < str.length()) {
			if(str.charAt(index) >= '0' && str.charAt(index) <= '9') {
				resp += str.charAt(index) + getValores(str, index + 1);
			} else {
				resp += getValores(str, index + 1);
			}
			
		}
		return resp;
	}

	public static String trim(String str) {
		return trim(str, 0);
	}
	public static String trim(String str, int index) {
		String resp = "";
		if(index < str.length()) {
			if(str.charAt(index) != ' ') {
				resp += str.charAt(index) + trim(str, index + 1);
			} else {
				resp += trim(str, index + 1); 
			}
			//str = trim(str, index + 1);
		}
		return resp;
	}

	public static String[] getSaida(String[] entrada) {
		return getSaida(entrada, 0);
	}
	public static String[] getSaida(String[] entrada, int index) {
		if(!isFim(entrada[index])) {
			//MyIO.println("Cheguei");
			entrada[index] = getExpressaoResolvida(entrada[index]);
			entrada = getSaida(entrada, index + 1);
		}

		return entrada;
	}

	public static int getNumEntrada(String[] entrada) {
		return getNumEntrada(entrada, 0);
	}
	public static int getNumEntrada(String[] entrada, int index) {
		int resp = 0;
		if(!isFim(entrada[index])) {
			resp = 1 + getNumEntrada(entrada, index + 1);
		}
		return resp;
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

	public static void imprimir(String[] entrada, int numElementos) {
		imprimir(entrada, numElementos, 0);
	}
	public static void imprimir(String[] entrada, int numElementos, int index) {
		if(index < numElementos ) {
			MyIO.println(entrada[index]);
			imprimir(entrada, numElementos, index + 1);
		} 
	}

	public static boolean isFim(String str) {
		return str.length() == 1 && str.charAt(0) == '0';
	}

	public static void main(String[] args) {
		String[] entrada = new String[1000];
		int numEntrada = 0;
		
		entrada = getEntrada(entrada);
		numEntrada = getNumEntrada(entrada);
		entrada = getSaida(entrada);
		
		imprimir(entrada, numEntrada);
	}
}
