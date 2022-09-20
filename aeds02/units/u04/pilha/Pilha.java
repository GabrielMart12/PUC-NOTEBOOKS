class Pilha {
	private int n;
	private int[] arr;

	Pilha() {
		this(6);
	}
	Pilha(int tamanho) {
		this.arr = new int[tamanho];
		n = 0;
	}
	
	// solucao eficiente
	public void empilhar(int x) throws Exception {
		if(n >= arr.length) throw new Exception("Erro");
		arr[n++] = x;
	} 
	public int desempilhar() throws Exception {
		if(n == 0) throw new Exception("Erro");
		return arr[--n];
	}

	public void mostrar() {
		System.out.print("[ ");
		for(int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.print("]");
	}
}

class App {
	public static void main(String[] args) {
		Pilha pilha = new Pilha(6);
		int w1 = 0, w2 = 0, w3 = 0;
		try {
			pilha.empilhar(3);
			pilha.empilhar(5);
			pilha.empilhar(8);
			w1 = pilha.desempilhar();
		} catch(Exception e) { 
			System.out.println(e);  
		}
		pilha.mostrar();
		System.out.println("\nw1 = " + w1);
	}
}
