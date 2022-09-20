class Insercao {
	public static int[] sort(int[] arr) {
		for(int i = 1; i < arr.length; i++) {
			int tmp = arr[i];
			int j = i - 1;
			while ((j >= 0) && (arr[j] > tmp)) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = tmp;
		}
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
		int[] arr = {34, 12, 45, 12, 576, 234, 12};
		arr = sort(arr);
		mostrar(arr);
	}
}
