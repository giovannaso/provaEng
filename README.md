#prova

Carlos Kalam Siu, Giovanna Silva de Oliveira
Documentação

Nos foi proposta a criação de uma aplicação que, de forma simples e de rápida execução, criasse arquivos de texto derivados de um arquivo extraído do SO Linux, cada qual 
com suas características próprias. 

Para isso utilizamos as linguagens Java e Scala, juntas ao modelo de Arquitetura de Atores (mestre e escravo), devido a sua simplicidade e rápida execução comparada a arquitetura 
de Cliente Servidor ou Dutos e Filtros. Sendo assim, nossos conectores passam a ser as mensagens entre os atores, estes responsáveis por gerir os componentes.
Ao iniciar a implementação pensamos em diferentes formas de tratar o arquivo e a forma com qual trabalhamos com os atores, cada qual testada e substituída por uma solução melhor e/ou 
mais ágil, processo conhecido como “erosão”. Algumas das ideias anteriores foram:

Criar 8 atores para executar cada arquivo, desistimos da ideia por complicações na execução dos comandos.
Tentamos também mapear os arquivos textos, comandos testados: 
•	.getLines
•	.grouped
•	.map
•	.filter
•	.foreach
Leitura da direita para esquerda, falha na busca do comando.

Na versão apresentada, com apenas um ator e um mestre, dividimos o arquivo base, “pimpar”, em oito arquivos derivados, todos os usuários com seus respectivos nomes, 
número de processo, quantidade de CPU, porcentagem de memória gasta e tempo gasto, utilizando o comendo “write” validado por um If que tinha como condição o “line.startsWith”. 
Em seguida, precisamos trabalhar com cada coluna de forma isolada. Para isso importamos a biblioteca “Scanner” do Java, definindo um espaço em branco como delimitador, e salvando cada 
setor em um Array independente.

Para realizar os cálculos devemos transformar os itens das listas, originalmente Strings, para tipo Double, além de substituir os dois pontos da coluna de tempo de execução para 
ponto comum. Devido erros na utilização da biblioteca Scanner, não foi possível realizar a conversão, logo, mesmo com as colunas separadas, não foi possível atender o exercício e 
calcular a média.

Tentativas de separar arquivos (ex1)
1.	 Métodos de atores: separar por linhas cada usuário
2.	Separar por colunas cada usuário
3.	Encontrar a biblioteca correta
4.	Tentativas de usar next.int/Scanner em scala

Dessa forma, para versões futuras, devemos realizar a conversão dos arquivos, aumentar o número de Scanners, para que avalie cada usuário de forma isolada e procurar formas de reduzir 
ainda mais o tempo de execução.


Links:
www.scala-lang.org/
https://stackoverflow.com/questions/21918283/java-copy-specific-rows-from-a-file-to-another-file
https://alvinalexander.com/scala/how-to-open-read-text-files-in-scala-cookbook-examples

