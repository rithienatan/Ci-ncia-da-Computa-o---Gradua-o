/**
 * Estudo Dirigido 11
 *
 *
 * Nome: Rithie Natan   Vers�o: 0.1
 * Matr�cula: 541488    Data: 30/04/2016
 
   Exemplo0209
 
 *@version 01
*
*/

/**
 * Exemplo0209
 *
 * @author
 * @version 01
 */
// ---------------------------------------------- dependencias
import IO.*;
// ---------------------------------------------- definicao de classe auxiliar
/**
 * Classe para tratar matriz de objetos.
 */
class Matriz
{
 /**
 * armazenador generico dos dados
 */
   public Object [ ][ ] tabela;
 /**
 * construtor padrao
 */
   public Matriz ( )
   {
      tabela = null;
   } // fim construtor padrao
   
   /**
 * construtor alternativo.
 */
   public Matriz ( int linhas, int colunas )
   {
      if ( linhas <= 0 || colunas <= 0 )
      {
         IO.println ( "ERRO: quantidade invalida." );
      }
      else
      {
         tabela = new Object [ linhas ][ colunas ];
      } // fim se
   } // fim construtor alternativo
 /**
 * informar a quantidade de posicoes reservadas (linhas).
 */
   public int lines ( )
   {
      int linhas = 0;
   
      if ( tabela != null )
      {
         linhas = tabela.length;
      }
      return ( linhas );
   } // fim lines ( )
 /**
 * informar a quantidade de posicoes reservadas (colunas).
 */
   public int columns ( )
   {
      int colunas = 0;
   
      if ( tabela != null )
      {
         colunas = tabela[0].length;
      }
      return ( colunas );
   } // fim columns ( )
   
/**
 * exibir dados em matriz.
 */
   public void printMatrix ( )
   {
   // definir dados
      int x, y,
         linhas, colunas;
   // identificar
      IO.println ( );
   // testar se a matriz foi montada
      if ( tabela == null )
      {
         IO.println ( "ERRO: Matriz vazia." );
      }
      else
      {
      // obter dimensoes da matriz
         linhas = lines( );
         colunas = columns( );
      // mostrar matriz
         IO.println ( "Matriz com "+linhas+"x"+colunas+" posicoes:" );
      // repetir para cada posicao na matriz
         for ( x = 0; x < linhas; x = x + 1 )
         {
            for ( y = 0; y < colunas; y = y + 1 )
            {
            // mostrar o valor armazenado
               IO.print ( "\t"+tabela [ x ][ y ] );
            } // fim repetir
            IO.println ( );
         } // fim repetir
      } // fim se
   } // fim printMatrix ( )

/**
 * ler valores do teclado e guardar em uma matriz.
 * @param message - com texto a ser mostrado na tela
 */
   public void readMatrix ( String message )
   {
   // definir dados
      int x, y,
         linhas = lines( ),
         colunas = columns( );
      String linha;
   // testar se quantidade valida
      if ( linhas <= 0 || colunas <= 0 )
      {
         IO.println ( "ERRO: Tamanho invalido." );
      }
      else
      {
      // mostrar mensagem antes de ler dados
         IO.println ( message );
      // obter o tamanho da matriz
         linhas = this.lines ( );
         colunas = this.columns ( );
      // repetir para cada posicao na matriz
         for ( x = 0; x < linhas; x = x + 1 )
         {
            for ( y = 0; y < colunas; y = y + 1 )
            {
            // ler linha do teclado
               linha = IO.readln ( );
            // armazenar em um posicao da matriz
            // como objeto em String
               tabela [ x ][ y ] = linha;
            } // fim repetir
         } // fim repetir
      } // fim se
   } // fim readMatrix ( )

 /**
 * ler valores inteiros e guardar em uma tabela.
 * @param message - com texto a ser mostrado na tela
 * @param n - quantidade de dados a serem lidos
 */
   public void readIntMatrix ( String message, int m, int n )
   {
   // definir dados
      int x, y,
         linhas = lines( ),
         colunas = columns( ) ;
      String linha;
   // testar se quantidade valida
      if ( linhas <= 0 || colunas <= 0 ||
      m <= 0 || m > linhas ||
      n <= 0 || n > colunas )
      {
         IO.println ( "ERRO: Quantidade invalida." );
      }
      else
      {
      // mostrar mensagem antes de ler dados
         IO.println ( message );
      // repetir para cada posicao na matriz
         for ( x = 0; x < m; x = x + 1 )
         {
            for ( y = 0; y < n; y = y + 1 )
            {
            // ler linha do teclado
               linha = IO.readln ( );
            // armazenar em um posicao da tabela
            // valor convertido para inteiro
               tabela [ x ][ y ] = IO.getint ( linha );
            } // fim repetir
         } // fim repetir
      } // fim se
   } // fim readIntMatrix ( )

/**
 * exibir certa quantidade de dados em tabela.
 * @param n - quantidade de dados a serem mostrados
 */
   public void printIntMatrix ( int m, int n )
   {
   // definir dados
      int x, y,
         linhas = lines( ),
         colunas = columns( ) ;
      String linha;
   // testar se quantidade valida
      if ( linhas <= 0 || colunas <= 0 ||
      m <= 0 || m > linhas ||
      n <= 0 || n > colunas )
      {
         IO.println ( "ERRO: Tabela vazia ou quantidade invalida." );
      }
      else
      {
      // mostrar tabela
         IO.println ( "Tabela com "+linhas+"x"+colunas+" posicoes:" );
      // repetir para cada posicao na tabela
         for ( x = 0; x < m; x = x + 1 )
         {
            for ( y = 0; y < n; y = y + 1 )
            {
            // mostrar o valor armazenado
               IO.print ( "\t"+(int) tabela [ x ][ y ] );
            } // fim repetir
            IO.println ( );
         } // fim repetir
      } // fim se
   } // fim printIntMatrix ( )

 /**
 * copiar tabela.
 * @return nova tabela com dados copiados
 */
   public Matriz clone ( )
   {
   // definir dados
      int x,y,
         linhas, colunas;
      Matriz nova = null;
   // testar existencia de dados
      if ( tabela == null )
      {
         IO.println ( "ERRO: Tabela vazia." );
      }
      else
      {
      // obter as dimensoes da tabela original
         linhas = lines( );
         colunas = columns( );
      // reservar espaco para a nova tabela
         nova = new Matriz ( linhas, colunas );
      // testar a existencia de dados
         if ( nova == null )
         {
            IO.println ( "ERRO: Nao ha' espaco." );
         }
         else
         {
         // repetir para cada posicao na tabela original
            for ( x = 0; x < nova.lines( ); x = x + 1 )
            {
               for ( y = 0; y < nova.columns( ); y = y + 1 )
               {
               // copiar dado de uma posicao
                  nova.tabela [ x ][ y ] = tabela [ x ][ y ];
               } // fim repetir
            } // fim repetir
         } // fim se
      } // fim se
   // retornar nova tabela
      return ( nova );
   } // fim clone ( )

 /**
 * copiar certa quantidade de dados em tabela.
 * @return nova tabela com dados copiados
 * @param n - quantidade de dados
 */
   public Matriz copyMatrix ( int m, int n )
   {
   // definir dados
      int x, y,
         linhas = lines( ),
         colunas = columns( );
      Matriz nova = null;
   // testar existencia de dados
      if ( tabela == null ||
      m <= 0 || m > linhas ||
      n <= 0 || n > colunas )
      {
         IO.println ( "ERRO: Tabela vazia." );
      }
      else
      {
      // reservar espaco para a nova tabela
         nova = new Matriz ( m, n );
      // testar a existencia de dados
         if ( nova == null )
         {
            IO.println ( "ERRO: Nao ha' espaco." );
         }
         else
         {
         // repetir para cada posicao na tabela original
            for ( x = 0; x < nova.lines( ); x = x + 1 )
            {
               for ( y = 0; y < nova.columns( ); y = y + 1 )
               {
               // copiar dado de uma posicao
                  nova.tabela [ x ][ y ] = tabela [ x ][ y ];
               } // fim repetir
            } // fim repetir
         } // fim se
      } // fim se
   // retornar nova tabela
      return ( nova );
   } // fim copyMatrix ( )

} // fim da classe Matriz

// ---------------------------------------------- definicao da classe principal
public class Exemplo0209
{
// ---------------------------------------------- definicao de metodo auxiliar
/**
 * Testar entrada e saida de dados em matriz usando classe.
 */
   public static void metodo09 ( )
   {
   // 1. definir dados
      Matriz a2 = null;
      Matriz a3 = new Matriz ( 3, 3 );
   // 2. identificar
      IO.println ( );
      IO.println ( "Entrada e saida em matriz" );
      IO.println ( );
   // 3. testar entrada e saida em matriz
      if ( a3 == null )
      {
         IO.println ( "Matriz a3 nula" );
      }
      else
      {
      // mostrar informacoes sobre matriz
         IO.println ( "Matriz a3 nao nula com "+a3.lines( )+"x"+a3.columns( )+" posicoes." );
      // ler dados e guardar na matriz
         a3.readIntMatrix ( "Entrar com dados na matriz:", 3, 3 );
      // tornar matrizs identicos
         a2 = a3.copyMatrix ( 2, 2 );
      // mostrar dados na matriz copiada
         IO.println ( "Mostrar dados copiados:" );
         a2.printIntMatrix ( 2, 2 );
      // mostrar dados na matriz original
         IO.println ( "Mostrar dados lidos e armazenados:" );
         a3.printMatrix ( );
      } // fim se
   // 4. encerrar
      IO.println ( );
      IO.pause ( "Apertar ENTER para continuar." );
   } // fim metodo09( ) 
     

// ---------------------------------------------- definicao do metodo principal
 /**
 * main() � metodo principal
 */
   public static void main ( String [ ] args )
   {
   // identificar
      IO.println ( "EXEMPLO0209 - Programa em Java" );
      IO.println ( "Autor: ________________________" );
   // executar o metodo auxiliar
      metodo09( );
   // encerrar
      IO.pause ( "Apertar ENTER para terminar." );
   } // fim main( )
} // fim class Exemplo0209