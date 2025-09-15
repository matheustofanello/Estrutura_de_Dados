public class Fila<T> {
    private No<T> primeiroNo;
    private No<T> ultimoNo;
    private String nomeFila;
    
    public Fila(){
        this("");
    }

    public Fila(String nomeFila) {
        this.nomeFila = nomeFila;
        primeiroNo = null;
        ultimoNo = null;
    }

    public void enfileirar(T dado) {
        No<T> novoNo = new No<T>(dado);
        if (ultimoNo == null) {
            primeiroNo = ultimoNo = novoNo;
        } else {
            ultimoNo.setNextNo(novoNo);
            ultimoNo = novoNo;
        }
    }

    public T desenfileirar() {
        if (ultimoNo == null) {
            System.out.println("Fila vazia");
            return null;
        }
        T dadoTemp = primeiroNo.getDado();
        primeiroNo = primeiroNo.getNextNo();
        return dadoTemp;
    }

    public void imprimeFila(){
        if (ultimoNo == null) {
            System.out.println("Fila vazia!");
        } else {
            System.out.println("Dados da fila: ");
            No<T> aux = primeiroNo;
            while (aux != null) {
                System.out.printf("| %s |", aux.toString());
                aux = aux.getNextNo();
            }
            System.out.println();
        }
    }
}