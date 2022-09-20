class Lista {
	private int[] array;
	private int n;

	Lista() {
		this(6);
	}

	Lista(int tamanho) {
		this.array = new int[tamanho];
		this.n = 0;
	}

	public void inserirInicio(int el) throws Exception {
		if(n >= this.array.length) 
			throw new Exception("Elementos adicionais no array sao invalidos");
		for(int i = n; i > 0; i--) {
			this.array[i] = this.array[i - 1];
		}
		this.array[0] = el;
		n++;
	}

	public void inserirFim(int el) throws Exception {
		if(n >= this.array.length)
			throw new Exception("Elementos adicionais no array sao invalidos");
		this.array[n] = el;
		n++;
	}

	public void inserir(int el, int pos) throws Exception {
		if(n >= this.array.length || pos < 0 || pos >= this.array.length)
			throw new Exception("Posicao invalida ou elementos adicionais no array");
		for(int i = n; i > pos; i--) {
			this.array[n] = this.array[n - 1];
		}
		this.array[pos] = el;
		n++;	
	}

	public int removerInicio() throws Exception {
		if(n == 0) throw new Exception("Sem elementos presentes no array");
		int resp = this.array[0];
		for(int i = 0; i < n; i++) {
			this.array[i] = this.array[i + 1];
		}
		n--;
		return resp;
	}

	public int removerFim() throws Exception {	
		if(n == 0) throw new Exception("Sem elementos presentes no array");
		return this.array[--n];
	}

	public int remover(int pos) throws Exception {
		if(n == 0 || pos < 0 || pos > n)
			throw new Exception("Sem elementos ou posicao excedente");
		int resp = this.array[pos];
		n--;
		for(int i = pos; i < n; i++) {
			this.array[i] = this.array[i + 1];
		}
		return resp;
	}

	public void mostrar() {
		System.out.print("[ ");
		for(int i = 0; i < n; i++) {
			System.out.print(this.array[i]  + " ");
		}
		System.out.print("]");
	}
}	

class App {
	public static void main(String[] args) {
		Lista lista = new Lista(6);
		int w1 = 0, w2 = 0, w3 = 0;

		try {
			lista.inserirInicio(4);
			lista.inserirFim(5);
			lista.inserir(2, 1);
			w1 = lista.removerInicio();
			w2 = lista.removerFim();
			lista.inserirFim(7);
			lista.inserirInicio(9);
			lista.inserir(12, 2);
			w3 = lista.remover(2);
		} catch(Exception e) { System.out.println(e); }

		lista.mostrar();

		System.out.println("\nw1 = " + w1);
		System.out.println("w2 = " + w2);
		System.out.println("w3 = " + w3);

	}
}
