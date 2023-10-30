package src;
import java.util.Scanner;

import javax.print.DocFlavor.STRING;

/**
 * Classe que inicializa a execução da aplicacao.
 * @author Isabel H. Manssour
 */
public class Main {

    static LinhaTexto linha = new LinhaTexto(); // objeto que gerencia uma linha
    public static void main(String[] args) {
        ArquivoTexto arquivo = new ArquivoTexto();
        int nLinha = 0;
        int nPagina = 1;
        int qtdPalavras = 0;
        int qtdStopwords = 0;
        double porcentagemStopwords = 0;

        ListaOrdenadaDePalavras listaOrdenadaDePalavras = new ListaOrdenadaDePalavras();
        String l;
        Scanner in = new Scanner(System.in);
        System.out.println("POR FAVOR, DIGITE O NOME DO ARQUIVO A SER ACESSADO:");
        String acessaString = in.nextLine();

        System.out.println("PROCESSANDO...");

        arquivo.open(acessaString);

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
            }

            linha.setLine(l); // define o texto da linha
            do // laco que passa em cada palavra de uma linha
            {
                String palavra = (linha.getNextWord()); // obtem a proxima palavra da linha
                if (palavra != null) {
                    palavra = palavra.toLowerCase();
                    palavra = removerPontuacao(palavra);
                    if ((!(isStopWord(palavra))) && palavra.length()>3) { // arquivo exemplo fala que as palavras devem ter mais de 3
                        if (listaOrdenadaDePalavras.contains(palavra)) {
                            if (!listaOrdenadaDePalavras.getOcorrencia(palavra, nPagina)) {
                                listaOrdenadaDePalavras.addPagina(palavra, nPagina);
                            }
                        } else {
                            listaOrdenadaDePalavras.addPalavra(palavra);
                            listaOrdenadaDePalavras.addPagina(palavra, nPagina);
                        }
                        qtdPalavras++;
                    }
                    else{
                        if(isStopWord(palavra)){
                            qtdStopwords++;
                            qtdPalavras++;
                        }
                    }
                } else {
                    break; //acabou a linha
                }
             } while (true);

        } while (true);

            arquivo.close();
            porcentagemStopwords = ((double)qtdStopwords / (double)qtdPalavras) * 100;

        boolean encerrarPrograma = false;
        int opcao;
        /* MENU */
        // abrirMenu();   
        do{
            abrirOpcoes();
            opcao = in.nextInt();
            switch(opcao){
                case 1: 
                    System.out.println("opcao 1");
                    System.out.println(listaOrdenadaDePalavras);
                    break;
                case 2:
                    System.out.println("opcao 2");
                    System.out.printf("%.2f%%\n",porcentagemStopwords);
                    break;
                case 3: 
                    String maisOcorrencias;
                    maisOcorrencias = listaOrdenadaDePalavras.maisOcorre();
                    System.out.println(maisOcorrencias);
                    System.out.println("opcao 3");

                    break;            
                case 4: 
                    System.out.println("opcao 4"); 
                    System.out.println("DIGITE A PALAVRA PARA VER QUAIS PAGINAS ELA ESTA:");
                    String pala;
                    in.nextLine();// limpando o buffer
                    pala = in.nextLine();
                    ListaDeOcorrencias lista = listaOrdenadaDePalavras.encontrarPalavra(pala);
                    if(lista.size()!=0){
                        System.out.println("LISTA DAS PAGINAS:");
                        System.out.println(listaOrdenadaDePalavras.encontrarPalavra(pala));
                    }
                    else{
                        System.out.println("PALAVRA NAO ENCONTRADA NO TEXTO.");
                    }    
                    break;
                case 5: 
                    encerrarPrograma = true;
                    System.out.println("...ENCERRANDO O PROGRAMA...");
                    break;
                default:
                    System.out.println("OPCAO INVALIDA");
            }
        }while(!encerrarPrograma);
        in.close();
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

    public static String removerPontuacao(String str){
        StringBuilder palavra = new StringBuilder();
        for(int i=0;i<str.length();i++){
            char aux = str.charAt(i);
            if(aux!= '.' && aux!= '!' &&
               aux!= ',' && aux!= '?' &&
               aux!= '*' && aux!= ')' &&
               aux!= '(' && aux!= '"' &&
               aux!= '-' && aux!= '"' &&
               aux!= '_' && aux!= ':' &&
               aux!= ';' && aux!= '&'){
                if((i==0 || i == str.length()-1)&& aux== '\''){
                }
                else{
                    palavra.append(aux);
                }
            }
        }
        return palavra.toString();
    }

    public static void abrirOpcoes(){
        System.out.println("\t=====MENU=====");
        System.out.println("1 - EXIBIR INDICE REMISSIVO");
        System.out.println("2 - EXIBIR PERCENTUAL DE STOPWORDS");
        System.out.println("3 - EXIBIR PALAVRA MAIS FREQUENTE");
        System.out.println("4 - PROCURAR UMA PALAVRA");
        System.out.println("5 - ENCERRAR O PROGRAMA");
    }

    
}
    


