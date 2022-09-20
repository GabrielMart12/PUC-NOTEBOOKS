import java.util.Scanner;
class Espelho {
	public static String tratarEntrada(String entrada) {
		String[] valores = entrada.split(" ");
		String resp = "";
		
		int num1 = Integer.parseInt(valores[0]);
		int num2 = Integer.parseInt(valores[1]);

		for(int i = num1; i <= num2; i++) {
			resp += i;
		}

		for(int j = resp.length() - 1; j >= 0; j--) {
			resp += resp.charAt(j);
		}

		return resp;

	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String resp = "";

		while(sc.hasNext()) {
			resp = tratarEntrada(sc.nextLine());
			System.out.println(resp);
		}
		sc.close();
	}
}
