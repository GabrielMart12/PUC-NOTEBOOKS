class Quicksort {
	public static int[] sort(int[] arr) {
		return sort(arr, 0, arr.length - 1);
	}
	public static int[] sort(int[] arr, int esq, int dir) {
		int i = esq, j = dir, pivo = arr[(esq + dir) / 2];
		while(i <= j) {
			while(arr[i] < pivo)
				i++;
			while(arr[j] > pivo)
				j--;
			if(i <= j)
			{ arr = swap(arr, i, j); i++; j--; }
		}
		if(esq < j)
			arr = sort(arr, esq, j);
		if(i < dir)
			arr = sort(arr, i, dir);
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

	public static void main(String args[]) {
		int[] arr = { 12, 4, 8, 2, 14, 17, 6, 18, 10, 16, 15, 5, 13, 9, 1, 11, 7, 3 };
		int[] resp = sort(arr);
		mostrar(arr);
	}
}
