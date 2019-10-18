import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Random;


public class Main {

	public static int SIZE = Integer.MAX_VALUE / 10000;
	public static int[] tableau = new int[SIZE];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		initialiserTableau();

		int[] tableauSelection = new int[SIZE];
		// arraycopy(src, startIndex, dest, startIndex, size)
		System.arraycopy(tableau, 0, tableauSelection, 0, SIZE);
		int[] tableauInsertion = new int[SIZE];
		System.arraycopy(tableau, 0, tableauInsertion, 0, SIZE);
		int[] tableauBulles = new int[SIZE];
		System.arraycopy(tableau, 0, tableauBulles, 0, SIZE);
		int[] tableauQuickSort = new int[SIZE];
		System.arraycopy(tableau, 0, tableauQuickSort, 0, SIZE);
		int[] tableauSort = new int[SIZE];
		System.arraycopy(tableau, 0, tableauSort, 0, SIZE);
		
		triSelection(tableauSelection);
		triInsertion(tableauInsertion);
		triBulles(tableauBulles);
		triQuickSort(tableauQuickSort);
		triJava(tableauSort);
	}

	public static void initialiserTableau() {
		Instant start = Instant.now();
		System.out.println("Debut d’initialisation...");
		Random random = new Random();
		for (int i = 0; i < tableau.length; i++) {
			tableau[i] = random.nextInt(SIZE);
		}
		Instant end = Instant.now();
		long duration = Duration.between(start, end).toMillis();
		System.out.println("L’initialisation a pris " + duration + " ms");
	}

	public static void triSelection(int[] tableau) {
		Instant start = Instant.now();
		for (int i = 0; i < tableau.length - 1; i++) {
			int indiceMin = i;
			for (int j = i; j < tableau.length; j++) {
				if (tableau[j] < tableau[indiceMin]) {
					indiceMin = j;
				}
			}
			int swap = tableau[i];
			tableau[i] = tableau[indiceMin];
			tableau[indiceMin] = swap;
		}
		Instant end = Instant.now();
		long duration = Duration.between(start, end).toMillis();
		System.out.println("Le tri par selection a pris " + duration + " ms");
	}

	public static void triInsertion(int[] tableau) {
		Instant start = Instant.now();
		for (int i = 1; i < tableau.length; i++) {
			int elementATrier = tableau[i];
			int j = i;
			while (j > 0 && tableau[j - 1] > elementATrier) {
				tableau[j] = tableau[j - 1];
				j--;
			}
			tableau[j] = elementATrier;
		}
		Instant end = Instant.now();
		long duration = Duration.between(start, end).toMillis();
		System.out.println("Le tri par insertion a pris " + duration + " ms");
	}

	public static void triBulles(int[] tableau) {
		Instant start = Instant.now();
		boolean estTrie = false;
		while (!estTrie) {
			estTrie = true;
			for (int i = 1; i < tableau.length; i++) {
				if (tableau[i - 1] > tableau[i]) {
					int stock = tableau[i - 1];
					tableau[i - 1] = tableau[i];
					tableau[i] = stock;
					estTrie = false;
				}
			}
		}
		Instant end = Instant.now();
		long duration = Duration.between(start, end).toMillis();
		System.out.println("Le tri à bulles a pris " + duration + " ms");
	}
	
	public static void triQuickSort(int[] tableau) {
		Instant start = Instant.now();
		quicksort(tableau,0,SIZE-1);
		Instant end = Instant.now();
		long duration = Duration.between(start, end).toMillis();
		System.out.println("Le QuickSort a pris " + duration + " ms");
	}

	public static void quicksort(int[] tableau, int indiceGauche, int indiceDroit) {
		if (indiceGauche < indiceDroit) {
			int indicePartition = partition(tableau, indiceGauche, indiceDroit);
			quicksort(tableau, indiceGauche, indicePartition);
			quicksort(tableau, indicePartition + 1, indiceDroit);
		}
	}

	public static int partition(int[] tableau, int indiceGauche, int indiceDroit) {
		int elementPivot = tableau[indiceGauche + (indiceDroit - indiceGauche) / 2];
		int left = indiceGauche - 1;
		int right = indiceDroit + 1;
		while (true) {
			do {
				left++;
			} while (tableau[left] < elementPivot);
			do {
				right--;
			} while (tableau[right] > elementPivot);
			if (left >= right) {
				return right;
			}
			int tmp = tableau[left];
			tableau[left] = tableau[right];
			tableau[right] = tmp;
		}
	}
	
	public static void triJava(int[] tableau) {
		Instant start = Instant.now();
		Arrays.sort(tableau);
		Instant end = Instant.now();
		long duration = Duration.between(start, end).toMillis();
		System.out.println("Le tri java a pris " + duration + " ms");
	}
}
