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
        public int ocorrencias;
        public Palavra(String str) {
            s = str;
            next = null;
            listaOcorrencias = new ListaDeOcorrencias();
            ocorrencias = 0;
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


    // Metodos

    ListaOrdenadaDePalavras () {
        this.primeira = null;
        this.ultima = null;
        this.count = 0;
    }

    public void incrOcorrencias(String str){
        Palavra aux = getPalavra(str);
        aux.ocorrencias++;
    }

    public void addPalavra(String palavra) {
        Palavra novo = new Palavra(palavra);
        if (primeira == null) {
            primeira = novo;
            ultima = novo;
        } else {
            if (primeira.s.compareTo(palavra) > 0) {
                novo.next = primeira;
                primeira = novo;
            } else if (ultima.s.compareTo(palavra) < 0) {
                ultima.next = novo;
                ultima = novo;
            } else {
                Palavra aux = primeira;
                boolean inseriu = false;
                while (aux.next != null  && !inseriu) {
                    if (palavra.compareTo(aux.next.s) < 0) {
                        inseriu = true;
                        novo.next = aux.next;
                        aux.next = novo;

                    }
                    aux = aux.next;
                }
                if (!inseriu) {
                    ultima.next = novo;
                    ultima = novo;
                }
            }
        }
        count++;
    }

    public Palavra getPalavra(String palavra) {
        int esquerda = 0;
        int direita = this.count - 1;
        Palavra aux = primeira;

        while (esquerda <= direita) {
            int mid = esquerda + (direita - esquerda) / 2;
            for (int i = 0; i < mid; i++) {
                aux = aux.next;
            }
            int resulCompareTo = palavra.compareTo(aux.s);

            if (resulCompareTo == 0) {
                return aux;
            } else if (resulCompareTo < 0) {
                direita = mid - 1;
                aux = primeira; // Reinicia o aux para a primeira palavra
            } else {
                esquerda = mid + 1;
                aux = primeira; // Reinicia o aux para a primeira palavra
            }
        }

        return null;
    }


    public boolean contains(String palavra) {
        int esquerda = 0;
        int direita = this.count - 1;

        while (esquerda <= direita) {
            int mid = esquerda + (direita - esquerda) / 2;
            Palavra aux = primeira;
            for (int i = 0; i < mid; i++) {
                aux = aux.next;
            }
            int resulCompareTo = palavra.compareTo(aux.s);

            if (resulCompareTo == 0) {
                return true;
            } else if (resulCompareTo < 0) {
                direita = mid - 1;
            } else {
                esquerda = mid + 1;
            }
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
            s.append(", num pag = ");
            s.append(aux.listaOcorrencias);
            s.append("\n");
            aux = aux.next;
        }

        return s.toString();
    }

    public String maisOcorre(){
        Palavra maisOcorre, aux2;
        maisOcorre = this.primeira;
        aux2 = this.primeira.next;
        for(int i=0;i<this.count-1;i++){
            if(aux2.ocorrencias > maisOcorre.ocorrencias){
                maisOcorre = aux2;
            }
            aux2 = aux2.next;
        }
        return maisOcorre.s;
    }


    public ListaDeOcorrencias encontrarPalavra(String palavra) {
        int esquerda = 0;
        int direita = this.count - 1;

        while (esquerda <= direita) {
            int mid = esquerda + (direita - esquerda) / 2;
            Palavra aux = primeira;
            for (int i = 0; i < mid; i++) {
                aux = aux.next;
            }
            int resulCompareTo = palavra.compareTo(aux.s);

            if (resulCompareTo == 0) {
                return aux.listaOcorrencias;
            } else if (resulCompareTo < 0) {
                direita = mid - 1;
            } else {
                esquerda = mid + 1;
            }
        }
        return null;

    }
/*
    public ListaDeOcorrencias encontrarPalavra(String pala){
        Palavra aux;
        aux = this.primeira;
        ListaDeOcorrencias paginas = new ListaDeOcorrencias();
        for(int i = 0; i<count;i++){
            if(aux.s.equals(pala)){
                paginas = aux.listaOcorrencias;
                break;
            }
            else{
                aux = aux.next;
            }
        }
        if(paginas!= null){
            return paginas;
        }
        return null;
    }*/
}
