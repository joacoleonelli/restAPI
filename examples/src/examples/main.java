package examples;

public class main {

	public static void main(String[] args) {

		int[] a = { 2, 3, 1 };
		quicksort(a, 0, a.length - 1);

//		int[] b = insertAndOrderArray(a, 5);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}

	}

	private static void orderArray(int[] array, int izq, int der) {
		int pivote = array[izq]; // tomamos primer elemento como pivote
		int i = izq; // i realiza la búsqueda de izquierda a derecha
		int j = der; // j realiza la búsqueda de derecha a izquierda
		int aux;

		while (i < j) { // mientras no se crucen las búsquedas
			while (array[i] <= pivote && i < j)
				i++; // busca elemento mayor que pivote
			while (array[j] > pivote)
				j--; // busca elemento menor que pivote
			if (i < j) { // si no se han cruzado
				aux = array[i]; // los intercambia
				array[i] = array[j];
				array[j] = aux;
			}
		}
		array[izq] = array[j]; // se coloca el pivote en su lugar de forma que
								// tendremos
		array[j] = pivote; // los menores a su izquierda y los mayores a su
							// derecha
		if (izq < j - 1)
			orderArray(array, izq, j - 1); // ordenamos subarray izquierdo
		if (j + 1 < der)
			orderArray(array, j + 1, der); // ordenamos subarray derecho
	}

	private static int[] insertAndOrderArray(int[] array, int e) {
		int[] newArray = new int[array.length + 1];
		for (int i = 0; i < newArray.length; i++) {
			if (i == newArray.length - 1) {
				newArray[i] = e;
			} else {
				newArray[i] = array[i];
			}
		}
		orderArray(newArray, 0, newArray.length - 1);
		return newArray;
	}

	private static int fibonacci(int n) {
		if (n == 0)
			return 0;
		else if (n == 1)
			return 1;
		else
			return fibonacci(n - 1) + fibonacci(n - 2);
	}

	private static void printFibonacciUntilNumber(int number) {
		for (int i = 0; i <= number; i++) {
			System.out.println(fibonacci(i));
		}
	}

	private static void quicksort(int[] array, int izq, int der) { //parametros array, primer elemento y ultimo elemento
		int p;
		if (izq < der) {
			p = partition(array, izq, der);
			quicksort(array, izq, p - 1);
			quicksort(array, p + 1, der);
		}
	}

	private static int partition(int[] array, int izq, int der) {
		int pivot = array[der];
		int i = izq;
		int aux;
		for (int j = izq; j < der - 1; j++) {
			if(array[j] <= pivot){
				aux = array[i]; // los intercambia
				array[i] = array[j];
				array[j] = aux;
				i++;
			}
		}
		aux = array[i]; // los intercambia
		array[i] = array[der];
		array[der] = aux;
		return i;
	}
}
