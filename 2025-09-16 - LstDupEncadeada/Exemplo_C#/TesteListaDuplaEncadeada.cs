// ------------------------------------------------------------------------
// Programa principal para demonstrar todas as operações
// ------------------------------------------------------------------------

using System;
using Estruturas;

namespace Estruturas
{
   class Program
   {
      static void Main(string[] args)
      {
         ListaDuplaEncadeada lista = new ListaDuplaEncadeada();

         Console.WriteLine("== Inserções ==");
         lista.InserirNoInicio("INF101", "Algoritmos", 60);
         lista.InserirNoFim("INF102", "Estruturas de Dados", 80);
         lista.InserirNoFim("INF103", "Banco de Dados", 70);
         lista.ImprimirLista();

         Console.WriteLine("\n== Inserir em posições específicas ==");
         lista.InserirNaPosicao("INF150", "Lógica", 40, 1);
         lista.InserirNaPosicao("INF100", "Introdução", 30, 0);
         lista.InserirNaPosicao("INF200", "Redes", 50, lista.Tamanho());
         lista.ImprimirLista();

         Console.WriteLine("\n== Atualização e remoção ==");
         Console.WriteLine("Atualizar INF103: " +
            lista.AtualizarDisciplina("INF103", "Banco Avançado", 90));
         Console.WriteLine("Remover INF100: " + lista.RemoverPorCodigo("INF100"));
         lista.ImprimirLista();
      }
   }
}
