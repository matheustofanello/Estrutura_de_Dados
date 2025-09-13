public class Principal{

    public static void main(String[] args) {
        ListaDupla<String> lista = new ListaDupla<String>("Alunos");
        lista.addInicio("Matheus");
        lista.addInicio("Ferreira");
        lista.addFinal("Tofanello");

        lista.imprimeLista();

        lista.removeInicio();
        lista.imprimeInicio();

        lista.removeFinal();
    }
}
