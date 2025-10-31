public class BubbleSort {
    public void sort(int[] vetor) {
        int i, continua, aux, fim = vetor.length;
        do {
            continua = 0;
            for (i = 0; i < fim - 1; i++) {
                if (vetor[i] > vetor[i + 1]) {
                    aux = vetor[i];
                    vetor[i] = vetor[i + 1];
                    vetor[i + 1] = aux;
                    continua = i; 
                }
            }
            fim--;
        } while (continua != 0);
    }
}
