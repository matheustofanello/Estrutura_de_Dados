public class Deque{
    private NoDuplo<T> primeiroNo;
    private NoDuplo<T> ultimoNo;
    private int tamanho;
    private String nomeDeque;

    public Deque(String nomeDeque) {
        this.primeiroNo = null;
        this.ultimoNo = null;
        this.tamanho = 0;
        this.nomeDeque = nomeDeque;
    }

    public void addInicio(T dado){
        NoDuplo<T> novoNo = new NoDuplo<T>(dado);

        if(primeiroNo == null){
            primeiroNo = novoNo;
            ultimoNo = novoNo;
        }else{
            novoNo.setProximoNo(primeiroNo);
            primeiroNo.setAnteriorNo(novoNo);
            primeiroNo = novoNo;
        }
        tamanho++;
        atualizaIndice();
    }

    public void addFinal(T dado){
        NoDuplo<T> novoNo = new NoDuplo<T>(dado);

        if(ultimoNo == null){
            ultimoNo = novoNo;
            primeiroNo = novoNo;
        }else{
            novoNo.setAnteriorNo(ultimoNo);
            ultimoNo.setProximoNo(novoNo);
            novoNo = ultimoNo;
        }
        tamanho++;
        atualizaIndice();
    }

    public void removeInicio(T dado){
        if(primeiroNo == null){
            System.out.println("Lista vazia");
        }else{
            System.out.println("Dado: " + primeiroNo.getDado() + " removido.");
            primeiroNo = primeiroNo.getProximoNo();
            if(primeiroNo != null) {
                primeiroNo.setAnteriorNo(null);
            } else {
                ultimoNo = null;
            }
        }
        tamanho--;
        atualizaIndice();
    }

    public void removeFinal(T dado){
        if(ultimoNo == null){
            System.out.println("Lista vazia");
        }else{
            System.out.println("Dado: " + ultimoNo.getDado() + " removido.");
            ultimoNo = ultimoNo.getAnteriorNo();
            if(ultimoNo != null){
                ultimoNo.setProximoNo(null);
            }else{
                primeiroNo = null;
            }
        tamanho--;
        atualizaIndice();
        }
    }
    
    public void imprimeDeque() {
        if (primeiroNo == null) {
            System.out.println("Lista vazia!");
        } else {
            System.out.println("Dados da Lista " + nomeLista);
            NoDuplo<T> aux = primeiroNo;
            while ( aux != null) {
                System.out.printf(" %s ", aux.toString());
                aux = aux.getProximoNo();
            }
            System.out.println();
        }
    }

    public T peekInicio(){
        if(primeiroNo == null){
            System.out.println("Deque vazio!");
            return null;
        } else {
            return primeiroNo.getDado();
        }
    }

    public T peekFinal(){
        if(ultimoNo == null){
            System.out.println("Deque vazio!");
            return null;
        } else {
            return ultimoNo.getDado();
        }
    }

    public void atualizaIndice(){
        NoDuplo<T> atual = primeiroNo;
        int indice = 0;
        while(atual != null){
            atual.setIndice(indice);
            atual = atual.getProximoNo();
            indice++;
        }
    }

    public int tamanhoDeque(){
        if(ultimoNo == null){
            return 0;
        } else {
            return ultimoNo.getIndice() + 1;
        }
    }

    public void destruirDeque(){
        primeiroNo = null;
        ultimoNo = null;
    }
}