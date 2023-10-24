/**
 * Esta classe guarda as palavra do indice remissivo em ordem alfabetica.
 * @author Isabel H. Manssour
 */

public class ListaOrdenadaDePalavras {
    // Classe interna 
    private class Palavra {
        public String s;
        public ListaDeOcorrencias listaOcorrencias;
        public Palavra next;    
        public Palavra(String str) {
            s = str;
            next = null;
            listaOcorrencias = new ListaDeOcorrencias();
        }
        // Metodos

        public void addPagina (int pagina) {
            listaOcorrencias.add(pagina);
        }

        @Override
        public String toString() {
            return "Palavra" + s +
                    ", listaOcorrencias=" + listaOcorrencias;
        }
    }

    // Atributos
    private Palavra primeira;
    private Palavra ultima;
    private Integer count;



    // Metodos

    ListaOrdenadaDePalavras () {
        this.primeira = null;
        this.ultima = null;
        this.count = 0;
    }

    public void addPalavra (String palavra){
        Palavra novo = new Palavra(palavra);
        if (primeira == null){
            primeira = novo;
        } else {
            ultima.next = novo;
        }
        ultima = novo;
        count++;
    }

    public Palavra getPalavra (String palavra) {
        Palavra aux = primeira;
        for (int i=0; i<count; i++){
            if (palavra.equals(aux.s)){
                return aux;
            }
            aux = aux.next;
        }
        return null;
    }

    public void addPagina (Palavra palavra, int pg){
        palavra.addPagina(pg);
    }


    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        Palavra aux = primeira;

        while (aux != null) {
            s.append("palavra = ");
            s.append(aux.s);
            s.append(", ocorrencias = ");
            s.append(aux.listaOcorrencias);
            s.append("\n");
            aux = aux.next;
        }

        return s.toString();
    }



}
