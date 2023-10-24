/**
 * Classe que inicializa a execução da aplicacao.
 * @author Isabel H. Manssour
 */
public class Main {
    public static void main(String[] args) {
        
    int nLinha = 0;
    int nPagina = 0;
    
    ArquivoTexto arquivo = new ArquivoTexto(); // objeto que gerencia o arquivo
    LinhaTexto linha = new LinhaTexto(); // objeto que gerencia uma linha
    String l;

    ArquivoTexto stopWords = new ArquivoTexto();

    stopWords.open("/srx/StopWords-EN.txt");

    arquivo.open("src/ArquivoExemplo.txt");
    
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
            String palavra = linha.getNextWord(); // obtem a proxima palavra da linha
            if (palavra != null) {
                palavra = palavra.toLowerCase();
                System.out.println("-" + palavra + "-");
            } else {
                break; //acabou a linha
            }
         } while (true);

    } while (true);
    
    arquivo.close();        
    }
}
