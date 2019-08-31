public class Main {
    public static void main(String args[]){
        Estados percurso = new Estados();
        try {
            AFD afdTeste = new AFD();
            percurso = afdTeste.percusoNoAFD("001001010");
            percurso.imprimirEstados();
            System.out.println(afdTeste.pertenceAoAFD(percurso.ultimoEstado()));
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
