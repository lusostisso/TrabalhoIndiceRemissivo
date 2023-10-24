package src;

/**
 * Classe que inicializa a execução da aplicacao.
 * @author Isabel H. Manssour
 */
public class Main {

    static LinhaTexto linha = new LinhaTexto(); // objeto que gerencia uma linha
    public static void main(String[] args) {
        ArquivoTexto arquivo = new ArquivoTexto();
        int nLinha = 0;
        int nPagina = 0;

        ListaOrdenadaDePalavras listaOrdenadaDePalavras = new ListaOrdenadaDePalavras();
        String l;
        arquivo.open("./cocoaandchocolate.txt");

        do  // laco que passa em cada linha do arquivo
        {
            l = arquivo.getNextLine();
            if (l==null) // acabou o arquivo?
               break;
            nLinha++; // conta mais uma linha lida do arquivo
            if (nLinha == 40) // chegou ao fim da pagina?
            {
                nLinha = 0;
                nPagina++;
                //System.out.println("Pagina " + nPagina + ":");
            }
            System.out.println("Linha " + nLinha + ":");

            linha.setLine(l); // define o texto da linha
            do // laco que passa em cada palavra de uma linha
            {
                String palavra = (linha.getNextWord()); // obtem a proxima palavra da linha
                if (palavra != null) {
                    palavra = palavra.toLowerCase();
                    if (!isStopWord(palavra)) {
                        if (listaOrdenadaDePalavras.contains(palavra)) {
                            if (!listaOrdenadaDePalavras.getOcorrencia(palavra, nPagina)) {
                                listaOrdenadaDePalavras.addPagina(palavra, nPagina);
                            }

                        } else {
                            listaOrdenadaDePalavras.addPalavra(palavra);
                            listaOrdenadaDePalavras.addPagina(palavra, nPagina);
                        }
                        System.out.println("-" + palavra + "-");
                    }
                } else {
                    break; //acabou a linha
                }
             } while (true);

        } while (true);

            arquivo.close();

            System.out.println(listaOrdenadaDePalavras);
    }


    public static boolean isStopWord (String palavra) {
        ArquivoTexto arquivo = new ArquivoTexto();
        arquivo.open("./StopWords-EN.txt");
        String l;

        do  // laco que passa em cada linha do arquivo
        {
            l = arquivo.getNextLine();
            if (palavra.equals(l)){
                return true;
            }
            if (l==null)
                break;
        } while(true);
        return false;
    }


}
