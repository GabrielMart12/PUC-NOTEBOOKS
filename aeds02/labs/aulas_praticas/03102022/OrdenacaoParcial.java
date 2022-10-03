class OrdenacaoParcial {
	public static int[] insercao(int[] arr) {
		int k = 3;
		for(int i = 1; i < arr.length; i++) {
			int tmp = arr[i];
			int j = (i < k) ? i - 1 : k - 1;
			while((j >= 0) && (arr[j] > tmp)) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = tmp;
		}
		return arr;
	}

	public static int[] quicksort(int[] arr, int esq, int dir) {
		int i = esq, j = dir, pivo = arr[(esq + dir) / 2], k = 2; // o valor k limita a quantidade de elementos a serem ordenados
		while(i <= j) {
			while(pivo > arr[i])
				i++;
			while(pivo < arr[j])
				j--;
			if(i <= j) 
			{ arr = swap(arr, i, j); i++; j--; }	
		}
		if(esq < j)
			quicksort(arr, esq, j);
		if(i < k && i < dir) // nesse caso a recursividade será aplicada quando o valor i for menor que k e i menor que dir
			quicksort(arr, i, dir);	
		return arr;
	}

	public static int[] swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
		return arr;
	}

	public static void mostrar(int[] arr) {
		System.out.print("[ ");
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.print("]\n");
	}

	public static void main(String[] args) {
		int[] arr = { 9, 2, 5, 1, 6, 8, 32, 4, 3 };
		arr = quicksort(arr, 0, arr.length - 1);
		mostrar(arr);
	}
}
