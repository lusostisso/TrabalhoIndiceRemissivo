# TrabalhoIndiceRemissivo
**ENUNCIADO**

É necessário realizar a leitura de um arquivo texto, e trabalhar com o armazenamento das palavras do 
texto em estruturas encadeadas para gerar o índice remissivo. 

Ao final do processamento o programa deverá apresentar a lista de palavras do texto ordenadas em ordem alfabética 
crescente e apresentando as páginas onde a palavra ocorreu no texto. Para facilitar, será considerado que a cada 40 
linhas começa uma nova página. O exemplo a seguir ilustra como a estrutura da figura anterior deve ser apresentada:

    alice: 1, 8, 16, 24, 53.
    
    head: 27, 38.
    
    queen: 8, 14, 17, 23.
    
    time: 5, 25, 35.

O primeiro passo para a realização desse trabalho é ler o arquivo e obrigatoriamente criar estruturas encadeadas, 
capazes de guardar as palavras presentes no arquivo, juntamente com os números das páginas em que cada palavra
aparece. O código para leitura de arquivos do tipo texto está disponível no Moodle, sendo necessário integrá-lo à sua 
solução. 


Stopwords são palavras que podem ser consideradas irrelevantes para o resultado esperado. Por exemplo, no índice 
remissivo que será gerado não se espera encontrar palavras como “a”, “and”, “etc”, “my” e “the”.

É importante lembrar que se deve projetar uma forma de armazenamento das palavras que permita um rápido acesso 
a cada palavra, uma vez que antes de incluir cada palavra deve-se verificar se ela já não foi armazenada. Caso 
a palavra já exista, o programa deve apenas acrescentar mais um número de página onde ela aparece.

Lembre que uma palavra pode aparecer mais de uma vez em uma página, mas no índice remissivo não pode aparecer 
o mesmo número de página duas vezes. 

Ao ser iniciado, o programa deverá solicitar o nome do arquivo de texto a ser processado. Ao concluir a leitura do 
arquivo, deve apresentar as funcionalidades a seguir em um menu em modo texto para o usuário:

1. Exibir todo o índice remissivo (em ordem alfabética);
2. Exibir o percentual de stopwords do texto (quanto % do texto é formado por stopwords);
3. Encontrar a palavra mais frequente, isto é, com maior número de ocorrências;
4. Pesquisar palavras, isto é, o usuário informa uma palavra e o programa lista os números das páginas em 
que a palavra ocorre; 
5. Encerrar o programa.
O programa deve permitir que usuário execute qualquer das funções novamente, até que seja encerrado.

**IMPLEMENTAÇÃO**

Todas as classes foram desenvolvidas com base na estrutura de uma linked list.

Classe *ListaOrdenadaDePalavras* que armazena objetos da classe Palavra

- Faz suas buscas pelo algoritmo de busca binária (divide repetidamente a lista considerando a metade que deve conter o item procurado, até reduzir as localizações possíveis a apenas uma)
        
Classe *Palavra* em LinkedList armazena a String lida pelo txt e uma instância de ListaDeOcorrencias

Classe *ListaDeOcorrencias* armazena os números de páginas em ordem crescente 

Durante a leitura, foi implementado:
-  Converter todas as palavras para minúsculas, para evitar duplicações desnecessárias;
- Remover qualquer sinal de pontuação no momento de armazenar a palavra;
- Identificar as stopwords e não armazená-las na lista;
-  Inserir a ocorrência da palavra na lista e a página onde ocorreu.
