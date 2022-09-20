class MergesortEstudo03 {
	public static int[] mergesort(int[] arr, int esq, int dir) {
		if(esq < dir) {
			int meio = (esq + dir) / 2;
			arr = mergesort(arr, esq, meio);
			arr = mergesort(arr, meio + 1, dir);
			arr = intercalar(arr, esq, meio, dir);
		}
		return arr;
	}

	public static int[] intercalar(int[] arr, int esq, int meio, int dir) {
		// tamanho dos subarrays
		int nEsq = (meio + 1) - esq;
		int nDir = dir - meio;

		// declarar subarrays
		int[] arrEsq = new int[nEsq + 1];
		int[] arrDir = new int[nDir + 1];

		// definir ultimo elemento do array
		arrEsq[nEsq] = arrDir[nDir] = 0x7FFFFFFF;
		
		int iEsq, iDir, i;
		
		// inicializar array arrEsq
		for (iEsq = 0; iEsq < nEsq; iEsq++)
			arrEsq[iEsq] = arr[iEsq + esq];
		
		// inicializar array arrDir
		for (iDir = 0; iDir < nDir; iDir++)
			arrDir[iDir] = arr[iDir + (meio + 1)];
		
		// intercalar elementos
		for (iEsq = iDir = 0, i = esq; i <= dir; i++)
			arr[i] = (arrEsq[iEsq] <= arrDir[iDir]) ? arrEsq[iEsq++] : arrDir[iDir++];

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
		int[] arr = { 6, 23, 12, 92, 34, 67, 14, 89, 21, 10, 4, 123, 56, 92 };
		arr = mergesort(arr, 0, arr.length - 1);
		mostrar(arr);
	}
}
