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
        tamanho++;
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
            System.out.println("Dados da Lista " + nomeLista);
            NoDuplo<T> aux = primeiroNo;
            while ( aux != null) {
                System.out.printf(" %s ", aux.toString());
                aux = aux.getProximoNo();
            }
            System.out.println();
        }
    }

    public void removeInicio() {
        if (primeiroNo == null) {
            System.out.println("Lista Vazia!");
        } else {
            System.out.println("Dado: " + primeiroNo.getDado() + " removido.");
            //T dadoTemp = primeiroNo.getDado();
            primeiroNo = primeiroNo.getProximoNo();
            if(primeiroNo != null) {
                primeiroNo.setAnteriorNo(null);
            } else {
                ultimoNo = null;
            }

        }
        atualizaIndice();
        tamanho--;
    }

    public void removeFinal() {
        if (primeiroNo == null) {
            System.out.println("Lista vazia!");
        } else  {
            System.out.println("Dado: " + ultimoNo.getDado() + " removido.");
            ultimoNo = ultimoNo.getAnteriorNo();
            if (ultimoNo != null) {
                ultimoNo.setProximoNo(null);
            } else {
                primeiroNo = null;
            }
        }
    }

    public void addPosicao(int indice, T dado) {
        if (indice < 0 || indice > tamanho) {
            System.out.println("Indice inválido");
        } else if ( indice == tamanho){
            addFinal(dado);
        } else {
            NoDuplo<T> novoNo = new NoDuplo<T>(dado);
            NoDuplo<T> atual = primeiroNo;

            int i = 0;

            while (i < indice) {
                atual = atual.getProximoNo();
                i++;
            }

            NoDuplo<T> anterior = atual.getAnteriorNo();

            if (anterior != null) {
            anterior.setProximoNo(novoNo);
            }

            novoNo.setAnteriorNo(anterior);
            novoNo.setProximoNo(atual);
            atual.setAnteriorNo(novoNo);

            tamanho++;
            atualizaIndice();

        }
    }

    public void removePosicao(int indice) {
        if (primeiroNo == null) {
            System.out.println("Lista vazia!");
        } else if (indice < 0 || indice > tamanho) {
            System.out.println("Índice invalido!");
        } else if (indice == 0) {
            removeInicio();
        } else if (indice == tamanho - 1) {
            removeFinal();
        } else {
            NoDuplo<T> atual = primeiroNo;
            int i = 0;
            while (i < indice) {
                atual = atual.getProximoNo();
                i++;
            }

            NoDuplo<T> anterior = atual.getAnteriorNo();
            NoDuplo<T> proximo = atual.getProximoNo();

            anterior.setProximoNo(proximo);
            proximo.setAnteriorNo(anterior);

            if (anterior != null) {
                anterior.setProximoNo(proximo);
            }
            if (proximo != null) {
                proximo.setAnteriorNo(anterior);
            }

            System.out.println("Dado: " + atual.getDado() + " removido da posição " + indice + ".");

            tamanho--;
            atualizaIndice();

        }
    }

    

}