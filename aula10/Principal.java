import java.io.*;
import java.util.*;

public class Principal {
    public static void main(String[] args) {
        // Nome do arquivo com números aleatórios
        String inputFileName = "numeros_tamanho100.txt"; // Altere conforme necessário
        List<Integer> numbers = readNumbersFromFile(inputFileName);

        if (numbers == null) {
            System.out.println("Erro ao ler o arquivo.");
            return;
        }

        // ===== Testando BubbleSort =====
        int[] bubbleArray = listToArray(numbers);
        long startTime = System.nanoTime();
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(bubbleArray);
        long endTime = System.nanoTime();
        System.out.println("BubbleSort time: " + (endTime - startTime) + " nanoseconds");
        writeNumbersToFile(arrayToList(bubbleArray), inputFileName, "bubble");

        // ===== Testando InsertionSort =====
        int[] insertionArray = listToArray(numbers);
        startTime = System.nanoTime();
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.insercao(insertionArray);
        endTime = System.nanoTime();
        System.out.println("InsertionSort time: " + (endTime - startTime) + " nanoseconds");
        writeNumbersToFile(arrayToList(insertionArray), inputFileName, "insertion");

        // ===== Testando SelectionSort =====
        int[] selectionArray = listToArray(numbers);
        startTime = System.nanoTime();
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.selecao(selectionArray);
        endTime = System.nanoTime();
        System.out.println("SelectionSort time: " + (endTime - startTime) + " nanoseconds");
        writeNumbersToFile(arrayToList(selectionArray), inputFileName, "selection");

    }

    // Lê os números de um arquivo de texto
    private static List<Integer> readNumbersFromFile(String fileName) {
        List<Integer> numbers = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] numberStrings = line.split("[,\\s]+");
                for (String numStr : numberStrings) {
                    try {
                        numbers.add(Integer.parseInt(numStr.trim()));
                    } catch (NumberFormatException e) {
                        System.out.println("Erro ao converter número: " + numStr);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return numbers;
    }

    // Converte lista → array
    private static int[] listToArray(List<Integer> list) {
        int[] array = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }

    // Converte array → lista
    private static List<Integer> arrayToList(int[] array) {
        List<Integer> list = new ArrayList<>(array.length);
        for (int num : array) {
            list.add(num);
        }
        return list;
    }

    // Escreve os números ordenados em um arquivo
    private static void writeNumbersToFile(List<Integer> numbers, String inputFileName, String algorithm) {
        String outputFileName = inputFileName.replace(".txt", "_" + algorithm + ".txt");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFileName))) {
            for (int number : numbers) {
                bw.write(number + " ");
            }
            bw.newLine();
            System.out.println("Números ordenados com " + algorithm + " foram salvos em: " + outputFileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
