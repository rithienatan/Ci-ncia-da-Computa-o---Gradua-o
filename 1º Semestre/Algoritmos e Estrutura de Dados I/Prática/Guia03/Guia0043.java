/**
 * Guia 0043
 *
 * Trabalho Pratico: Guia 03
 *
 * Nome: Rithie Natan   Vers�o: 0.1
 * Matr�cula: 541488    Data: 28/02/2016
 *
 *@version 0043
*/

/**
 * Guia0043
 *
 * @author
 * @version 01
 */
//
// Lista de dependencias
//
import jkarel.World;
import jkarel.Robot;
import IO.*;
/**
 * Exemplo de programa para uso com a classe JKarel.
 */
public class Guia0043 extends Robot
{
/**
 * construtor padrao da classe Guia00.
 * @param avenue - uma das coordenadas da posicao inicial
 * @param street - outra das coordenadas da posicao inicial
 * @param direction - direcao inicial
 * @param beepers - quantidade inicial de marcadores
 */
   public Guia0043( int avenue, int street, int direction, int beepers )
   {
   // metodo para repassar dados
   // ao construtor padrao da classe original (Robot)
      super( avenue, street, direction, beepers );
   } // end Guia0043( )
/**
 * metodo para criar configuracoes do ambiente.
 * @param nome do arquivo onde guardar a configuracao
 */
   public static void createWorld( String nome )
   {
   // o executor deste metodo (World - agente)
   // ja' foi definido na classe original (Robot)
      World.reset( ); // limpar configuracoes
   // para nao exibir os passos de criacao do ambiente
      World.setTrace( false ); // (opcional)
   // para criar obstaculos
   // Guia0-001.txt
      World.placeNSWall( 1, 1, 1 ); // espelho do degrau 1
      World.placeEWWall( 2, 1, 1 ); // patamar do degrau 1
      World.placeNSWall( 2, 2, 1 ); // espelho do degrau 2
      World.placeEWWall( 3, 2, 1 ); // patamar do degrau 2
      World.placeNSWall( 3, 3, 1 ); // espelho do degrau 3
      World.placeEWWall( 4, 3, 1 ); // patamar do degrau 4
      World.placeNSWall( 4, 1, 3 ); // apoio da escada 'a direita
   // para colocar marcadores
      World.placeBeepers( 4, 4, 1 );// marcador no topo da escada
   // para guardar em arquivo
      World.saveWorld( nome ); // gravar configuracao
   } // end createWorld( )
/**
 * metodo para virar 'a direita.
 */
   public void turnRight( )
   {
   // o executor deste metodo
   // deve virar tres vezes 'a esquerda
      turnLeft( );
      turnLeft( );
      turnLeft( );
   } // end turnRight( )

/**
 * metodo para contar comandos de arquivo.
 *@return quantidade de comandos
 *@param filename - nome do arquivo
 */
   public int countCommands( String filename )
   {
   // definir dados
      int length;
      FILE archive = new FILE ( FILE.INPUT, filename );
      String line;
   // repetir enquanto houver dados
      length = 0;
      line = archive.readln ( );
      while ( ! archive.eof( ) )
      {
      // contar mais um comando
         length = length + 1;
      // tentar ler a proxima linha
         line = archive.readln( );
      } // end while
   // fechar o arquivo
      archive.close( );
   // retornar a quantidade de comandos guardados
      return length;
   } // end countCommands( )   

/**
 * metodo para receber comandos de arquivo.
 * @return grupo formado por todos os comandos
 * @param filename - nome do arquivo
 */
   public int [ ] readCommands( String filename )
   {
   // definir dados
      int [ ] commands; // para armazenar comandos
      int length;
      int option;
      FILE archive = new FILE ( FILE.INPUT, filename );
      String line;
      int x;
   // obter a quantidade de comandos
      length = countCommands ( filename );
   // criar um armazenador para os comandos
   // INDISPENSAVEL reservar o espaco para guardar
      commands = new int [ length ];
   // repetir para a quantidade de comandos
      for ( x=0; x<length; x=x+1 )
      {
      // tentar ler a proxima linha
         line = archive.readln( );
      // decodificar a linha
      // e obter o codigo do comando
         option = IO.getint( line );
      // guardar um comando
      // na posicao (x) do armazenador
         commands [ x ] = option;
      } // end for
   // fechar o arquivo
   // INDISPENSAVEL para a gravacao
      archive.close( );
   // retornar os comandos guardados
      return commands;
   } // end readCommands( )    
 
 /**
 * Acao principal: executar a tarefa descrita acima.
 */
   public static void main( String [ ] args )
   {
   // criar o ambiente com escada
   // OBS.: executar pelo menos uma vez,
   // antes de qualquer outra coisa
   // (depois de criado, podera' ser comentado)
      createWorld( "Guia0043.txt" );
   // comandos para tornar o mundo visivel
      World.reset( ); // limpar configuracoes
      World.setSpeed ( 6 ); // escolher velocidade
      World.readWorld( "Guia0043.txt" ); // ler configuracao do ambiente
   // definir o objeto particular para executar as acoes (agente)
      Guia0043 JK = new Guia0043( 1, 1, World.EAST, 0 );
   
   // definir dado local
      int n; // para a quantidade de comandos
      int [ ] cmd; // para guardar os comandos
      int k; // indice do comando
   // executar acoes
   // obter a quantidade de comandos
      n = JK.countCommands( "Tarefa0001.txt" );
   // informar a quantidade de comandos
      IO.println ( "File Tarefa0001.txt has " +
         "" + n + " commands." );
   // ler todos os comandos do arquivo
      cmd = JK.readCommands ( "Tarefa0001.txt" );
   // mostrar os comandos guardados, um por vez
      for ( k=0; k<n; k=k+1 )
      {
         IO.println ( "" + k + "\t" + cmd[k] );
      } // fim repetir      
   } // end main( )
} // end class
// ---------------------------------------------- testes
/*
 Versao Teste
 0.1 01. ( ) - teste inicial
*/