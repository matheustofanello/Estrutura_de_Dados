public class Fila<T>{
    private No<T> primeiroNo;
    private No<T> ultimoNo;
    private String nomeFila;

    public Fila(){
        this("");
    }

    public Fila(String nomeFila){
        this.nomeFila = nomeFila;
        primeiroNo = null;
        ultimoNo = null;
    }

    public void enfileirar(T dado){
        No<T> novoNo = new No<T>(dado);

        if (ultimoNo == null){
            primeiroNo = novoNo;
            ultimoNo = novoNo;
        }else{
            ultimoNo.setNextNo(novoNo);
            ultimoNo = novoNo;
        }
    }

    public void imprimeFila(){
        if(primeiroNo == null){
            System.out.println("Fila vazia");
        }else {
            System.out.println("Dados da Fila: ");
            No<T> aux = primeiroNo;
            while(aux != null){
                System.out.printf("( %s )", aux.getDado());
                aux = aux.getNextNo();
            }
            System.out.println();
        }
    }

    public T desenfileirar(){
        if(primeiroNo == null){
            System.out.println("Fila vazia!");
            return null;
        }
         T dadoTemp = primeiroNo.getDado();
         primeiroNo = primeiroNo.getNextNo();
         if(primeiroNo == null){
            ultimoNo = null;
         }
         return dadoTemp;
    }
}