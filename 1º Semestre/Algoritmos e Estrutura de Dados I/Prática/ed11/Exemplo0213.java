/**
 * Estudo Dirigido 11
 *
 *
 * Nome: Rithie Natan   Vers�o: 0.1
 * Matr�cula: 541488    Data: 30/04/2016
 
   Exemplo0213
 
 *@version 01
*
*/
import IO.*;

class Matriz
{
   public Object [ ][ ] tabela;
   
   public Matriz( )
   {
      tabela = null;
   }
   
   public Matriz ( int l, int c )
   {
      if( l <= 0 || c <= 0 )
      {
         IO.println( "Tamanho inv�lido!" );
      }
      else
      {
         tabela = new Object[ l ][ c ];
      }
   }
   
   public int linha( )
   {
      int linha = 0;
      if( tabela != null )
      {
         linha = tabela.length;
      }
      return( linha );
   }
   
   public int coluna( )
   {
      int coluna = 0;
      if( tabela != null )
      {
         coluna = tabela[0].length;
      }
      return( coluna );
   }
   
   public void readIntMatriz( String msn, int l, int c, int olinha, int ocoluna )// o = onde
   {
      int x, y, linha = linha( ), coluna = coluna( );
      String lin;
      
      if( linha <= 0 || coluna <= 0 || 
          l <= 0 || c <= 0 || 
          l > linha || c > coluna )
      {
         IO.println( "ERRO: Quantidade invalida." );
      }
      else
      {
         IO.println( msn );
         for( x = 0; x < linha; x = x + 1 )
         { 
            for( y = 0; y < coluna; y = y + 1 )
            {
               if( x >= olinha )
               {
                  if( y >= ocoluna )
                  {
                     lin = IO.readln( );
                     tabela[ x ][ y ] = IO.getint( lin );
                  }
               }
            }
         }
      }
   }
   
   public void printIntMatriz( int l, int c, int olinha, int ocoluna )
   {
      int x, y, linha = linha( ), coluna = coluna( );
      
      if ( linha <= 0 || coluna <= 0 ||
      l <= 0 || l > linha ||
      c <= 0 || c > coluna )
      {
         IO.println ( "ERRO: Tabela vazia ou quantidade invalida." );
      }
      else
      {
         for( x = 0; x < linha; x = x + 1 )
         {
            for( y = 0; y < coluna; y = y + 1 )
            {
               if( x >= olinha )
               {
                  if( y >= ocoluna )
                  {
                     IO.print( "\t"+tabela[ x ][ y ] );
                  }
               }
            }
            IO.println( );
         }
      }
   }
   
   public void printMatriz( )
   {
      int x, y, linha = linha( ), coluna = coluna( );
      
      if ( linha <= 0 || coluna <= 0 )
      {
         IO.println ( "ERRO: Tabela vazia ou quantidade invalida." );
      }
      else
      {
         for( x = 0; x < linha; x = x + 1 )
         {
            for( y = 0; y < coluna; y = y + 1 )
            {
               IO.print( "\t"+tabela[ x ][ y ] );
            }
            IO.println( );
         }
      }
   }
   
   public void fromFile( String nome )
   {
      FILE arquivo = new FILE( FILE.INPUT, nome );
      int linha, coluna, x, y;
      String dado;
      
      dado = arquivo.readln( );
      
      if( dado == null )
      {
         IO.println( "Arquivo sem dados!" );
      }
      else
      {
         dado = arquivo.readln( );
         linha = linha( );
         coluna = coluna( );
         if ( linha <= 0 || coluna <= 0 )
         {
            IO.println ( "ERRO: Tamanho invalido." );
         }
         else
         {
            for( x = 0; x < linha; x = x + 1 )
            {
               for( y = 0; y < coluna; y = y + 1 )
               {
                  dado = arquivo.readln( );
                  tabela[ x ][ y ] = dado;
               }
            }
         }
      }   
      arquivo.close( );
   }
}

public class Exemplo0213
{
   public static void acao( )
   {
      FILE arquivo = new FILE( FILE.INPUT, "Arquivo1.txt" );
      Matriz teste = null;
      String dado;
      int linha = 0, coluna = 0;
      
      dado = arquivo.readln( );
      if( dado == null )
      {
         IO.println( "Arquivo sem dados!" );
      }
      else
      {
         linha = IO.getint( dado );
         dado = arquivo.readln( );
         coluna = IO.getint( dado );
      }
      teste = new Matriz( linha, coluna );
      teste.fromFile( "Arquivo1.txt" );
      teste.printMatriz( );
   
      arquivo.close( );
   }
   
   public static void main( String[ ]args )
   {
      acao( );
   }
}