// ------------------------------------------------------------------------
// Programa de Teste da Lista Simplesmente Encadeada
// Demonstra as operações de inserção, atualização, remoção e impressão
// ------------------------------------------------------------------------
using System;

public class TesteListaEncadeada
{
   public static void Main()
   {
      ListaEncadeadaInterface lista = new ListaEncadeada();

      // Inserções
      lista.InserirNoInicio(10);
      lista.InserirNoFim(5);
      lista.InserirNaPosicao(20, 1); // insere na posição 1
      lista.ImprimirLista(); // 10 -> 20 -> 5 -> null

      // Atualizações
      lista.AtualizarPorValor(20, 25);
      lista.ImprimirLista(); // 10 -> 25 -> 5 -> null

      lista.AtualizarNaPosicao(2, 15);
      lista.ImprimirLista(); // 10 -> 25 -> 15 -> null

      // Remoções
      lista.RemoverInicio();
      lista.ImprimirLista(); // 25 -> 15 -> null

      lista.RemoverPorValor(25);
      lista.ImprimirLista(); // 15 -> null

      lista.RemoverNaPosicao(0);
      lista.ImprimirLista(); // null
   }
}
