public class ListaDupla<T> {
    private NoDuplo<T> primeiroNo;
    private NoDuplo<T> ultimoNo;
    private String nomeLista;
    private int tamanho;

    public ListaDupla(String nomeLista){
        this.nomeLista = nomeLista;
        primeiroNo = null;
        ultimoNo = null;
        tamanho = 0;
    } 
    
    public ListaDupla(){
        this("");
    }

    public void atualizaIndice() {
        NoDuplo<T> atual = primeiroNo;
        int indice = 0;
        while(atual != null) {
            atual.setIndice(indice);
            atual = atual.getProximoNo();
            indice++;
        }
    }

    public void addInicio(T dado){
        NoDuplo<T> novoNo = new NoDuplo<T>(dado);
        if (primeiroNo == null) {
            primeiroNo = novoNo;
            ultimoNo = novoNo;
        } else {
            novoNo.setProximoNo(primeiroNo);
            primeiroNo.setAnteriorNo(novoNo);
            primeiroNo = novoNo;
        }
        atualizaIndice();
    }

    public void addFinal(T dado){
        NoDuplo<T> novoNo =new NoDuplo<T>(dado);
        if (ultimoNo == null){
            primeiroNo = novoNo;
            ultimoNo = novoNo;
        } else {
            novoNo.setAnteriorNo(ultimoNo);
            ultimoNo.setProximoNo(novoNo);
            ultimoNo = novoNo;
        }
        ultimoNo.setIndice(tamanho);
        tamanho++;
        
    }

    public void imprimeLista() {
        if (primeiroNo == null) {
            System.out.println("Lista vazia!");
        } else {
            System.out.println("Dados da Lista" + nomeLista);
            NoDuplo<T> aux = primeiroNo;
            while ( aux != null) {
                System.out.printf(" %s ", aux.toString());
                aux = aux.getProximoNo();
            }
            System.out.println();
        }
    }
    public T removeInicio(){
        if(primeiroNo == null){
            System.out.println("Lista vazia!");
        }else{
            System.out.println("Dado: " + primeiroNo.getDado() + " removido.");
            //T dadoTemp = primeiroNo.getDado();
            primeiroNo = primeiroNo.getProximoNo();
            if(primeiro != null){
                primeiroNo.setAnteriorNo(null);
            }else{
                ultimoNo = null;
                }
            }
        atualizaIndice();
        tamanho++;
        }
    public T removeFinal(){
        if(ultimoNo == null){
            System.out.println("Lista vazia!");
        }else{
            System.out.println("Dado: " + ultimoNo.getDado() + " removido.");
            ultimoNo = ultimoNo.getAnteriorNo();
            if(ultimo != null){
                ultimoNo.setProximoNo(null);
            }else{
                primeiroNo = null;
            }
         }
        }
    }
