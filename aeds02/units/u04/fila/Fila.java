class Fila {
	private int[] arr;
	private int n;

	Fila() {
		this(6);
	}

	Fila(int tamanho) {
		this.arr = new int[tamanho];
		this.n = 0;
	}
	
	// II
	public void enfileirarInicio(int x) throws Exception {
		if(n >= arr.length) throw new Exception("Impossivel adicionar mais elementos na fila");
		for(int i = n; i > 0; i--) {
			this.arr[i] = this.arr[i - 1];
		}
		this.arr[0] = x;
		n++;
	}

	// RF
	public int desenfileirarFim() throws Exception {
		if(n == 0) throw new Exception("Impossivel remover elementos nessa fila");
		return this.arr[--n];
	}

	// IF
	public void enfileirarFim(int x) throws Exception {
		if(n >= arr.length) throw new Exception("Impossivel adicionar mais elementos na fila");
		this.arr[n++] = x;
	}

	// RI
	public int desenfileirarInicio() throws Exception {
		if(n == 0) throw new Exception("Impossivel remover elementos nessa fila");
		int resp = arr[0]; 
		n--;
		for(int i = 0; i < n; i++) {
			this.arr[i] = this.arr[i + 1]; 
		}
		return resp;
	}

	public void mostrar() {
		System.out.print("[ ");
		for(int i = 0; i < n; i++) {
			System.out.print(this.arr[i] + " ");
		}
		System.out.print("]\n");
	}	
}

class App {
	public static void main(String[] args) {
		Fila fila1 = new Fila(6);
		Fila fila2 = new Fila(6);
		int w1 = 0;

		try {
			fila1.enfileirarInicio(3);
			fila1.enfileirarInicio(5);
			fila1.enfileirarInicio(6);
			w1 = fila1.desenfileirarFim();
			fila1.mostrar();
			System.out.println("w1 = " + w1);

			fila2.enfileirarFim(9);
			fila2.enfileirarFim(5);
			fila2.enfileirarFim(3);
			w1 = fila2.desenfileirarInicio();
			fila2.mostrar();
			System.out.println("w1 = " + w1);

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
