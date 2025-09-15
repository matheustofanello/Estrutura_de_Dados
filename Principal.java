public class Principal {
    public static void main(String[] args) {
        Fila<String> fila = new Fila<String>("Fila de Alunos");
        Pilha<String> pilha = new Pilha<String>("Pilha de Linguagens"); 
        ListaDupla<String> lista = new ListaDupla<String>("Produtos");

        /*fila.enfileirar("Victor");
        fila.enfileirar("Maria");
        fila.enfileirar("João");
        fila.enfileirar("Ana");
        fila.enfileirar("Pedro");

        fila.imprimeFila();

        System.out.println("Dado " + fila.desenfileirar() + " removido da fila.");

        fila.imprimeFila();*/

        /*pilha.push("Java");
        pilha.push("Python");
        pilha.push("HTML");

        pilha.imprimePilha();

        String removido = pilha.pop();

        System.out.println("\nDado " + removido + " removido da pilha.\n");

        pilha.imprimePilha();

        pilha.push("CSS");
        pilha.push("C++");
        pilha.push("JavaScript");

        pilha.imprimePilha(); */

       
        lista.addInicio("Mouse");
        lista.addFinal("Teclado");
        lista.addPosicao(1, "Monitor");

        lista.imprimeLista();

        lista.removePosicao(1);

        lista.imprimeLista();

        lista.addFinal("Headset");

        lista.imprimeLista();


    }
}