class Ex01 {
	public static int getMaior(int[] arr) {
		int resp = arr[0];
		// custo -> f(n) = n - 1
		for(int i = 1; i < arr.length; i++) {
			if(resp < arr[i]) {
				resp = arr[i];
			}
		}
		return resp;
	}
	
	public static int getMenor(int[] arr) {
		int resp = arr[0];
		// custo -> f(n) = n - 1
		for(int i = 1; i < arr.length; i++) {
			if(resp > arr[i]) {
				resp = arr[i];
			}
		}
		return resp;
	}

	public static void main(String[] args) {
		int[] arr = {5, 2, 4, 5, 6, 2, 64, 23, 93, 45, 10, 23, 4};

		int maior = getMaior(arr);
		int menor = getMenor(arr);
		// custo total -> f(n) = 2n - 2 -> O(n)

		System.out.println(maior + " - " + menor);
	}
}
