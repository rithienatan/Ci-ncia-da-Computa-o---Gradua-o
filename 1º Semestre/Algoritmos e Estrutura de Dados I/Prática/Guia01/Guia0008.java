/**
 * Guia0008
 *
 * Trabalho Pratico: Guia 01
 *
 * Nome: Rithie Natan   Vers�o: 0.1
 * Matr�cula: 541488    Data: 14/02/2016
 * 
 *@version 08
*/

import jkarel.World;
import jkarel.Robot;
/**
 * Exemplo de programa para uso com a classe JKarel.
 */
public class Guia0008 extends Robot
{
/**
 * construtor padrao da classe Guia00.
 * @param avenue - uma das coordenadas da posicao inicial
 * @param street - outra das coordenadas da posicao inicial
 * @param direction - direcao inicial
 * @param beepers - quantidade inicial de marcadores
 */
   public Guia0008( int avenue, int street, int direction, int beepers )
   {
   // metodo para repassar dados
   // ao construtor padrao da classe original (Robot)
      super( avenue, street, direction, beepers );
   } // end Guia0008( )
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
   // para colocar marcador(es)
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
 * metodo para mover varios passos.
 * @param steps - passos a serem dados.
 */
   public void moveN( int steps )
   {
   // definir dado local
      int step; // contador de passos
   // repetir enquanto
   // contador nao atingir a quantidade
      step = 1;
      while ( step <= steps )
      {
      // dar um passo
         move( );
      // contar mais um passo dado
         step = step + 1;
      } // end while
   } // end moveN( )
/**
 * metodo para especificar parte de uma tarefa.
 */
   public void doPartialTask( )
   {
   // especificar acoes dessa parte da tarefa
      moveN( 3 );
      turnLeft( );
   } // end doPartialTask( )
/**
 * metodo para especificar parte de uma tarefa.
 */
   public void doTask( )
   {
   // especificar acoes da tarefa
      doPartialTask( );
      doPartialTask( );
   // testar se ha' marcador antes ...
      if ( nextToABeeper( ) )
      {
      // ... de tentar carrega-lo
         pickBeeper( );
      } // end if
      doPartialTask( );
   // testar se a quantidade do que
   // carrega e' maior que zero antes ...
      if ( beepers( ) > 0 )
      {
      // ... de tentar descarregar
         putBeeper( );
      } // end if
      doPartialTask( );
      turnLeft( );
   } // end doTask( )
 /**
 * Acao principal: executar a tarefa descrita acima.
 */
   public static void main( String [ ] args )
   {
   // criar o ambiente com escada
   // OBS.: executar pelo menos uma vez,
   // antes de qualquer outra coisa
   // (depois de criado, podera' ser comentado)
      createWorld( "Guia0008.txt" );
   // comandos para tornar o mundo visivel
      World.reset( ); // limpar configuracoes
      World.setSpeed ( 7 ); // escolher velocidade
      World.readWorld( "Guia0008.txt" ); // ler configuracao do ambiente
   // definir o objeto particular para executar as acoes (agente)
      Guia0008 JK = new Guia0008( 1, 1, World.EAST, 0 );
   // executar acoes
      JK.doTask( );
   } // end main( )
} // end class
// ---------------------------------------------- testes
//
// Versao Teste
// 0.1 01. ( OK ) teste inicial
// 0.2 01. ( OK ) teste da tarefa
// 0.3 01. ( OK ) teste da tarefa parcial
// 0.4 01. ( OK ) teste do apanhar marcador
// 0.5 01. ( OK ) teste do colocar marcador
// 0.6 01. ( OK ) teste da repeticao do movimento
// 0.7 01. ( OK ) teste com marcador na posicao (4,4)
// 02. ( OK ) teste com marcador na posicao (4,4)
// 0.8 01. ( OK ) teste com a quantidade de marcadores