class Mergesort {
	public static int[] sort(int[] arr) {
		return sort(arr, 0, arr.length - 1);
	}
	public static int[] sort(int[] arr, int esq, int dir) {
		if(esq < dir) {
			int meio = (esq + dir) / 2;
			arr = sort(arr, esq, meio);
			arr = sort(arr, meio + 1, dir);
			arr = intercalar(arr, esq, meio, dir);
		}
		return arr;
	}

	public static int[] intercalar(int[] arr, int esq, int meio, int dir) {
		int nEsq = (meio + 1) - esq;
		int nDir = dir - meio;

		int[] arrEsq = new int[nEsq + 1];
		int[] arrDir = new int[nDir + 1];

		arrEsq[nEsq] = arrDir[nDir] = 0x7FFFFFFF;

		int iEsq, iDir, i;

		for(iEsq = 0; iEsq < nEsq; iEsq++)
			arrEsq[iEsq] = arr[esq + iEsq];

		for(iDir = 0; iDir < nDir; iDir++)
			arrDir[iDir] = arr[(meio + 1) + iDir];

		for(iEsq = iDir = 0, i = esq; i <= dir; i++)
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
		int[] arr = {0, 32, 21, 10, 34, 8, 2, 90, 2};
		arr = sort(arr);
		mostrar(arr);
	}
}
