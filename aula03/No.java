public class No<T>{

    private T dado;
    private No<T> nextNo;

// Construtores
    public No(T dado){
        this(dado, null);
    }

    public No(T dado, No<T> nextNo){
        this.dado = dado;
        this.nextNo = nextNo;
    }

// getters e setters

    public T getDado(){
        return dado;
    }

    public void setDado(T dado){
        this.dado = dado;
    }

    public No<T> getNextNo(){
        return this.nextNo;
    }

    public void setNextNo(No <T> nextNo){
        this.nextNo = nextNo;
    }

    @Override
    public String toString(){
        return "Dado{" + getDado() + "}";
    }
}