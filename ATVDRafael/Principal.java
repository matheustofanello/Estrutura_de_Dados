public class Principal {
    public static void main(String[] args) {
        Fila<String> fila = new Fila<String>("Fila de Alunos");
        Pilha<String> pilha = new Pilha<String>("Pilha de Linguagens"); 
        ListaDupla<String> lista = new ListaDupla<String>("Produtos");

        fila.enfileirar("Rafael");
        fila.enfileirar("Matheus");
        fila.enfileirar("Vera");
        fila.enfileirar("Ana Laura");
        fila.enfileirar("Mauro");

        fila.imprimeFila();

        System.out.println("Dado " + fila.desenfileirar() + " removido da fila.");

        fila.imprimeFila();

        pilha.push("Java");
        pilha.push("TypeScript");
        pilha.push("HTML");

        pilha.imprimePilha();

       String removido = pilha.pop();

        System.out.println("\nDado " + removido + " removido da pilha.\n");

        pilha.imprimePilha();

        pilha.push("CSS");
        pilha.push("JavaScript");

        pilha.imprimePilha(); 

       
        lista.addInicio("Cadeira Gamer");
        lista.addFinal("Mouse pad");
        lista.addPosicao(1, "Gabinete");

        lista.imprimeLista();

        lista.removePosicao(1);

        lista.imprimeLista();

        lista.addFinal("Fone de Ouvidos");

        lista.imprimeLista(); 


    }
}