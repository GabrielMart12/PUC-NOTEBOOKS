/**
 * Algoritmo de ordenacao por insercao
 * @author Max do Val Machado
 * @version 3 01/2020
 */

class Insercao extends Geracao {

	/**
	 * Construtor.
	 */
   public Insercao(){
      super();
   }


	/**
	 * Construtor.
	 * @param int tamanho do array de numeros inteiros.
	 */
   public Insercao(int tamanho){
      super(tamanho);
   }


	/**
	 * Algoritmo de ordenacao por insercao.
	 */
	@Override
	public void sort() {
		int contMov = 0, contComp = 0;
		for (int i = 1; i < n; i++) {
			int tmp = array[i]; contMov++;
			int j = i - 1;

        		while ((j >= 0) && (array[j] > tmp)) {
        			array[j + 1] = array[j]; 
				contMov++; contComp++;
            			j--;
        		}
        		array[j + 1] = tmp; contMov++;
		}
		System.out.println("Comparacoes: " + contComp);
		System.out.println("Movimentacoes: " + contMov);
	}
}
