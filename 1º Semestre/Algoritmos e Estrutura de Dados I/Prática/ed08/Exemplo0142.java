/**
 * Estudi Dirigido 08
 *
 *
 * Nome: Rithie Natan   Vers�o: 0.1
 * Matr�cula: 541488    Data: 10/04/2016

 *@version 01
*
*/

/**
 * Exemplo0142
 *
 * @author
 * @version 01
 */
// ---------------------------------------------- dependencias
import IO.*;
// ---------------------------------------------- definicao da classe principal
public class Exemplo0142
{
// ---------------------------------------------- definicao de metodo auxiliar
 /**
 * ler valores inteiros de arquivo e guardar em arranjo.
 * @return tabela com os valores lidos de arquivo
 * @param nome do arquivo com os dados
 */
   public static int [ ] lerDoArquivo ( String nome )
   {
   // definir dados
      FILE arquivo = new FILE ( FILE.INPUT, nome );
      int tamanho;
      int x;
      int [ ] tabela = null;
      String linha;
   // identificar
      IO.println ( "Montar arranjo com valores lidos de arquivo" );
   // tentar ler uma linha do arquivo
      linha = arquivo.readln ( );
   // testar a disponibilidade de dados
      if ( linha == null )
      {
         IO.println ( "ERRO: Nao ha' dados no arquivo." );
      }
      else
      {
      // tentar obter a quantidade de dados
         tamanho = IO.getint ( linha );
      // testar se quantidade valida
         if ( tamanho <= 0 )
         {
            IO.println ( "ERRO: Tamanho invalido." );
         }
         else
         {
         // reservar espaco para os dados
            tabela = new int [ tamanho ];
         // repetir para cada dado no arquivo
            for ( x = 0; x < tamanho; x = x + 1 )
            {
            // ler linha do arquivo
               linha = arquivo.readln ( );
            // armazenar em uma posicao do arranjo
            // valor convertido para inteiro
               tabela [ x ] = IO.getint ( linha );
            } // fim for
         } // fim se
      } // fim se
   // fechar arquivo
      arquivo.close ( );
   // retornar dados lidos
      return ( tabela );
   } // fim lerDoArquivo ( )
 /**
 * recuperar dados de arquivo.
 */
   public static void teste01 ( )
   {
   // 1. definir dados
      int [ ] tabela = null;
   // 2. identificar
      IO.println ( );
      IO.println ( "Recuperar dados de arquivo" );
      IO.println ( );
   // 3. montar dados
      tabela = lerDoArquivo ( "DADOS.TXT" );
   // 4. testar a existencia de dados
      if ( tabela == null )
      {
         IO.println ( "ERRO: Arranjo nulo." );
      }
      else
      {
         if ( tabela.length == 0 )
         {
            IO.println ( "ERRO: Arranjo vazio." );
         }
         else
         {
            IO.println ( "Arranjo montado com " +
               tabela.length + " dados." );
         } // fim se
      } // fim se
   // 5. encerrar
      IO.println ( );
      IO.pause ( "Apertar ENTER para continuar." );
   } // fim teste01 ( )

// ---------------------------------------------- definicao de metodo auxiliar
/**
 * exibir dados em arranjo.
 * @param tabela - arranjo com dados
 */
   public static void mostrar ( int [ ] tabela )
   {
   // definir dados
      int tamanho;
      int x;
   // identificar
      IO.println ( );
   // testar se a arranjo foi montado
      if ( tabela == null )
      {
         IO.println ( "ERRO: Tabela vazia." );
      }
      else
      {
      // verificar se tamanho valido
         tamanho = tabela.length;
         if ( tamanho <= 0 )
         {
            IO.println ( "ERRO: Arranjo vazio." );
         }
         else
         {
         // mostrar arranjo
            IO.println ( "Arranjo montado com " +
               tamanho + " dados." );
         // repetir para cada dado no arranjo
            for ( x = 0; x < tamanho; x = x + 1 )
            {
            // mostrar dado em um posicao da arranjo
            // convertido para inteiro
               IO.print ( " " + tabela [ x ] );
            } // fim for
         // mudar de linha
            IO.println ( );
         } // fim se
      } // fim se
   } // fim mostrar ( )
 /**
 * recuperar e mostrar dados de arquivo.
 */
   public static void teste02 ( )
   {
   // 1. definir dados
      int [ ] tabela = null;
   // 2. identificar
      IO.println ( );
      IO.println ( "Recuperar e mostrar dados de arquivo" );
      IO.println ( );
   // 3. montar dados
      tabela = lerDoArquivo ( "DADOS.TXT" );
   // 4. testar a existencia de dados
      if ( tabela == null )
      {
         IO.println ( "ERRO: Arranjo nulo." );
      }
      else
      {
         if ( tabela.length == 0 )
         {
            IO.println ( "ERRO: Arranjo vazio." );
         }
         else
         {
            mostrar ( tabela );
         } // fim se
      } // fim se
   // 5. encerrar
      IO.println ( );
      IO.pause ( "Apertar ENTER para continuar." );
   } // fim teste02 ( )

// ---------------------------------------------- definicao do metodo principal
 /**
 * main() � metodo principal
 */
   public static void main ( String [ ] args )
   {
   // identificar
      IO.println ( "EXEMPLO0142 - Programa em Java" );
      IO.println ( "Autor: ________________________" );
   // executar o metodo auxiliar
      teste02 ( );
   // encerrar
      IO.pause ( "Apertar ENTER para terminar." );
   } // fim main( )
} // fim class Exemplo0142