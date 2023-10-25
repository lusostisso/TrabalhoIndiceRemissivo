package src;

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
    LinkedListOfString linkedListOfString = new LinkedListOfString();



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
/*
    public void addPalavra (String palavra) {

        Palavra aux = containsElement(palavra); // verifica se ja contem element para não inserir duplicado
        if (aux == null) {  // se nao contem element, insere
            Palavra n = new Palavra(palavra);

            if (primeira.next == ultima) {
                // se a lista está vazia
                n.prev = primeira;
                n.next = ultima;
                ultima.prev = n;
                primeira.next = n;

            }
            else if (palavra.compareTo(primeira.next.s)<0) {
                // se for menor que o primeiro, insere no inicio
                n.next = primeira.next;
                n.prev = primeira;
                primeira.next = n;
                n.next.prev = n;
            }
            else if (palavra.compareTo(ultima.prev.s)>0) {
                // se for maior que o ultimo, insere no final
                n.next = ultima;
                n.prev = ultima.prev;
                ultima.prev.next = n;
                ultima.prev = n;
            }
            else {
                // senao procura a posicao correta para insercao
                aux = primeira.next;
                boolean inseriu=false;
                while (aux!=ultima && !inseriu) {
                    if (palavra.compareTo(aux.s)<0) {
                        inseriu = true;
                        n.next = aux;
                        n.prev=aux.prev;
                        aux.prev.next = n;
                        aux.prev = n;
                    }
                    aux = aux.next;
                }
            }
            count++;
        }
    }

*/

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

    public boolean contains (String palavra){
        Palavra aux = primeira;
        for (int i=0; i<count; i++){
            if (palavra.equals(aux.s)){
                return true;
            }
            aux = aux.next;
        }
        return false;
    }

    public void addPagina (String palavra, int pg){
        Palavra aux = getPalavra(palavra);
        aux.listaOcorrencias.add(pg);
    }

    public boolean getOcorrencia (String palavra, int pg){
        Palavra aux = getPalavra(palavra);
        return aux.listaOcorrencias.contains(pg);
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
