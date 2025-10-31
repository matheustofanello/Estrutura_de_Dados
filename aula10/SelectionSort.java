public class SelectionSort {
    public void selecao(int[] vetor) {
        int n = vetor.length;
        for (int i = 0; i < n - 1; i++) {
            int indiceMenor = i;
            for (int j = i + 1; j < n; j++) {
                if (vetor[j] < vetor[indiceMenor]) {
                    indiceMenor = j;
                }
            }
            if (indiceMenor != i) {
                int aux = vetor[i];
                vetor[i] = vetor[indiceMenor];
                vetor[indiceMenor] = aux;
            }
        }
    }
}
