// ------------------------------------------------------------------------
// Implementação da Lista Simplesmente Encadeada
// Implementa todos os métodos definidos em ListaEncadeadaInterface
// ------------------------------------------------------------------------
using System;

public class ListaEncadeada : ListaEncadeadaInterface
{
   private No cabeca; // início da lista

   // ---------------------------------------------------------------------
   // Inserções
   public void InserirNoInicio(int valor)
   {
      No novoNo = new No(valor);
      novoNo.Proximo = cabeca;
      cabeca = novoNo;
   }

   public void InserirNoFim(int valor)
   {
      No novoNo = new No(valor);
      if (cabeca == null)
      {
         cabeca = novoNo;
         return;
      }
      No atual = cabeca;
      while (atual.Proximo != null)
      {
         atual = atual.Proximo;
      }
      atual.Proximo = novoNo;
   }

   public void InserirNaPosicao(int valor, int posicao)
   {
      if (posicao < 0)
      {
         Console.WriteLine("Posição inválida");
         return;
      }
      if (posicao == 0)
      {
         InserirNoInicio(valor);
         return;
      }

      No atual = cabeca;
      int indice = 0;
      while (atual != null && indice < posicao - 1)
      {
         atual = atual.Proximo;
         indice++;
      }

      if (atual == null)
      {
         Console.WriteLine("Posição fora do alcance");
         return;
      }

      No novoNo = new No(valor);
      novoNo.Proximo = atual.Proximo;
      atual.Proximo = novoNo;
   }

   // ---------------------------------------------------------------------
   // Remoções
   public void RemoverInicio()
   {
      if (cabeca != null)
         cabeca = cabeca.Proximo;
   }

   public void RemoverPorValor(int valor)
   {
      if (cabeca == null) return;
      if (cabeca.Dado == valor)
      {
         cabeca = cabeca.Proximo;
         return;
      }
      No atual = cabeca;
      while (atual.Proximo != null && atual.Proximo.Dado != valor)
      {
         atual = atual.Proximo;
      }
      if (atual.Proximo != null)
      {
         atual.Proximo = atual.Proximo.Proximo;
      }
   }

   public void RemoverNaPosicao(int posicao)
   {
      if (cabeca == null || posicao < 0) return;
      if (posicao == 0)
      {
         cabeca = cabeca.Proximo;
         return;
      }

      No atual = cabeca;
      int indice = 0;
      while (atual.Proximo != null && indice < posicao - 1)
      {
         atual = atual.Proximo;
         indice++;
      }

      if (atual.Proximo != null)
      {
         atual.Proximo = atual.Proximo.Proximo;
      }
   }

   // ---------------------------------------------------------------------
   // Buscas
   public bool BuscarPorValor(int valor)
   {
      No atual = cabeca;
      while (atual != null)
      {
         if (atual.Dado == valor) return true;
         atual = atual.Proximo;
      }
      return false;
   }

   public int? ObterNaPosicao(int posicao)
   {
      if (posicao < 0) return null;
      No atual = cabeca;
      int indice = 0;
      while (atual != null && indice < posicao)
      {
         atual = atual.Proximo;
         indice++;
      }
      if (atual == null) return null;
      return atual.Dado;
   }

   // ---------------------------------------------------------------------
   // Atualizações
   public void AtualizarPorValor(int valorAntigo, int novoValor)
   {
      No atual = cabeca;
      while (atual != null)
      {
         if (atual.Dado == valorAntigo)
         {
            atual.Dado = novoValor;
            return;
         }
         atual = atual.Proximo;
      }
      Console.WriteLine($"Valor {valorAntigo} não encontrado.");
   }

   public void AtualizarNaPosicao(int posicao, int novoValor)
   {
      if (posicao < 0)
      {
         Console.WriteLine("Posição inválida");
         return;
      }
      No atual = cabeca;
      int indice = 0;
      while (atual != null && indice < posicao)
      {
         atual = atual.Proximo;
         indice++;
      }
      if (atual == null)
      {
         Console.WriteLine("Posição fora do alcance");
         return;
      }
      atual.Dado = novoValor;
   }

   // ---------------------------------------------------------------------
   // Impressão
   public void ImprimirLista()
   {
      No atual = cabeca;
      while (atual != null)
      {
         Console.Write(atual.Dado + " -> ");
         atual = atual.Proximo;
      }
      Console.WriteLine("null");
   }
}
