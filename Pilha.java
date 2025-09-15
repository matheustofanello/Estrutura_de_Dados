public class Pilha<T> {
    private String nomePilha;
    private No<T> topo;

    public Pilha() {
        this("");
    }

    public Pilha(String nomePilha) {
        this.nomePilha = nomePilha;
        this.topo = null;
    }

    public void push(T dado) {
        No<T> novoNo = new No<T>(dado);
        
        if (topo == null) {
            topo = novoNo;
        } else {
            novoNo.setNextNo(topo);
            topo = novoNo;
        }
    }

    public T peek() {
        if (topo == null) {
            System.out.println("Pilha vazia!");
            return null;
        } else {
            return topo.getDado();     
        }
    }

    public T pop() {
        if (topo == null) {
            System.out.println("Pilha vazia!");
            return null;
        } else {
            T dadoTemp = topo.getDado();
            topo = topo.getNextNo();
            return dadoTemp;
        }
    }

    public void imprimePilha(){
        if (topo == null) {
            System.out.println("Pilha vazia!");
        } else {
            System.out.println("\nDados da Pilha ");
            No<T> aux = topo;
            while (aux != null) {
                System.out.println(aux.getDado());
                aux = aux.getNextNo();
            }
        }
    }
}