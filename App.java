public class App {
    public static void main(String[] args) {
        ListaOrdenadaDePalavras listaOrdenadaDePalavras = new ListaOrdenadaDePalavras();
        listaOrdenadaDePalavras.addPalavra("Pedra");

        listaOrdenadaDePalavras.addPagina((listaOrdenadaDePalavras.getPalavra("Pedra")), 2);

        listaOrdenadaDePalavras.addPagina((listaOrdenadaDePalavras.getPalavra("Pedra")), 7);


        System.out.println(listaOrdenadaDePalavras);
    }


}
