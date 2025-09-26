public class ListaCircular<T>{
    private No<T> primeiroNo;
    private No<T> ultimoNo;
    private int tamanho;
    private String nomeLista;

    public ListaCircular(String nomeLista){
        this.primeiroNo = null;
        this.ultimoNo = null;
        this.tamanho = 0;
        this.nomeLista = nomeLista;
    }


    public int tamanhoLista(){
        return tamanho;
    }


    public void addInicio(T dado){
        No<T> novoNo = new No<T>(dado);
        
        if(primeiroNo == null){
            primeiroNo = novoNo;
            ultimoNo = novoNo;
            novoNo.setNextNo(novoNo);
        } else {
            novoNo.setNextNo(primeiroNo);
            ultimoNo.setNextNo(novoNo);
            primeiroNo = novoNo;
        }
        tamanho++;
    }

    public void addFinal(T dado){
        No<T> novoNo = new No<T>(dado);

        if(ultimoNo == null){
            ultimoNo = novoNo;
            primeiroNo = novoNo;
            novoNo.setNextNo(novoNo);
        } else {
            novoNo.setNextNo(primeiroNo);
            ultimoNo.setNextNo(novoNo);
            ultimoNo = novoNo;
        }
        tamanho++;
    }

    public T removeInicio(){
        if(primeiroNo == null){
            System.out.println("Lista vazia!");
            return null;
        } else {
            T dadoTemp = primeiroNo.getDado();
            if(primeiroNo == primeiroNo.getNextNo()){
                primeiroNo = null;
                ultimoNo = null;
                return dadoTemp;
            } else{
                primeiroNo = primeiroNo.getNextNo();
                ultimoNo.setNextNo(primeiroNo);
                tamanho--;
                return dadoTemp;
            }
        tamanho--;
        }
    }

    public T removeFinal(){
        if(ultimoNo == null){
            System.out.println("Lista vazia!");
            return null;
        } else {
            T dadoTemp = ultimo.getDado();
            if(ultimoNo == ultimoNo.getNextNo()){
                primeiroNo = null;
                ultimoNo = null;
                tamanho--;
                return dadoTemp;
            }
            No<T> aux = primeiroNo;
            while(aux.getNextNo() != ultimoNo){
                aux = aux.getNextNo();
            }
            aux.setNextNo(primeiroNo);
            ultimoNo = aux;
            tamanho--;
            return dadoTemp;
        }
    }




}