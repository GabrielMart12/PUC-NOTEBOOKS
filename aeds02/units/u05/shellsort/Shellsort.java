class Shellsort {
	public static int[] sort(int[] arr) {
		int h = 1;
		do { h = (h * 3) + 1; } while(h < arr.length);
		do {
			h /= 3;
			for(int cor = 0; cor < h; cor++) {
				arr = insercaoPorCor(arr, cor, h);
			}
		} while(h != 1);
		return arr;
	}

	public static int[] insercaoPorCor(int[] arr, int cor, int h) {
		for(int i = (cor + h); i < arr.length; i++) {
			int tmp = arr[i];
			int j = i - h;
			while((j >= 0) && (arr[j] > tmp)) {
				arr[j + h] = arr[j];
				j -= h;
			}
			arr[j + h] = tmp;
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
		int[] arr = { 23, 4, 83, 21, 4, 67, 32, 9, 65, 382, 2356, 23, 683, 2361, 2, 34 };
		arr = sort(arr);
		mostrar(arr);
	}
}
