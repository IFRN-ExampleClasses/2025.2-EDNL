// ------------------------------------------------------------------------
// TesteDeque.cs
// Programa principal que demonstra todas as operações da Deque
// ------------------------------------------------------------------------
using System;
using System.Collections.Generic;

public class TesteDeque {
   public static void Main(string[] args) {
      Deque deque = new Deque();

      Console.WriteLine("=== Inserções iniciais ===");
      try {
         deque.InserirNoFim("TEC.0007", "Programação de Computadores", 120);
         Console.WriteLine("Inserido TEC.0007 no fim.");
         deque.InserirNoFim("TEC.0027", "Estrutura de Dados Não-Lineares", 80);
         Console.WriteLine("Inserido TEC.0027 no fim.");
         deque.InserirNoInicio("TEC.0142", "Programação para Redes", 120);
         Console.WriteLine("Inserido TEC.0142 no início.");
         deque.InserirNoFim("TEC.0022", "Bancos de Dados", 80);
         Console.WriteLine("Inserido TEC.0022 no fim.");
      } catch (Exception e) {
         Console.WriteLine("Erro: " + e.Message);
      }

      Console.WriteLine();
      deque.ImprimirDeque();
      Console.WriteLine("Tamanho: " + deque.Tamanho());
      Console.WriteLine();

      Console.WriteLine("=== Tentativa de duplicado TEC.0027 ===");
      try {
         deque.InserirNoFim("TEC.0027", "Duplicado", 90);
      } catch (ArgumentException e) {
         Console.WriteLine("Erro: " + e.Message);
      }
      Console.WriteLine();

      Console.WriteLine("=== Busca TEC.0142 ===");
      try {
         Node n = deque.BuscarPorCodigo("TEC.0142");
         Console.WriteLine("Encontrado: " + n.ToString());
      } catch (KeyNotFoundException e) {
         Console.WriteLine("Erro: " + e.Message);
      }
      Console.WriteLine();

      Console.WriteLine("=== Atualização TEC.0022 ===");
      try {
         deque.AtualizarPorCodigo("TEC.0022", "Bancos de Dados Avançados", 90);
         Console.WriteLine("Atualizado TEC.0022 com sucesso.");
      } catch (KeyNotFoundException e) {
         Console.WriteLine("Erro: " + e.Message);
      }
      Console.WriteLine();

      deque.ImprimirDeque();
      Console.WriteLine("Tamanho: " + deque.Tamanho());
      Console.WriteLine();

      Console.WriteLine("=== Remoções início e fim ===");
      try {
         deque.RemoverDoInicio();
         Console.WriteLine("Removido do início.");
         deque.RemoverDoFim();
         Console.WriteLine("Removido do fim.");
      } catch (InvalidOperationException e) {
         Console.WriteLine("Erro: " + e.Message);
      }
      Console.WriteLine();

      deque.ImprimirDeque();
      Console.WriteLine("Tamanho: " + deque.Tamanho());
      Console.WriteLine();

      Console.WriteLine("=== Remoção por código TEC.0027 ===");
      try {
         deque.RemoverPorCodigo("TEC.0027");
         Console.WriteLine("Removido TEC.0027 com sucesso.");
      } catch (KeyNotFoundException e) {
         Console.WriteLine("Erro: " + e.Message);
      }
      Console.WriteLine();

      deque.ImprimirDeque();
      Console.WriteLine("Tamanho: " + deque.Tamanho());
      Console.WriteLine();

      Console.WriteLine("=== Esvaziamento total ===");
      while (!deque.EstaVazio()) {
         try {
            deque.RemoverDoInicio();
         } catch (InvalidOperationException e) {
            Console.WriteLine("Erro: " + e.Message);
         }
      }
      Console.WriteLine("Deque esvaziada. Tamanho: " + deque.Tamanho());
      deque.ImprimirDeque();
   }
}
