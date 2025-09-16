// ------------------------------------------------------------------------
// Classe ListaDuplaEncadeada
// Implementa a interface ListaDuplaEncadeadaInterface
// ------------------------------------------------------------------------

using System;

namespace Estruturas
{
   public class ListaDuplaEncadeada : ListaDuplaEncadeadaInterface
   {
      private Node head;
      private Node tail;
      private int tamanho;

      public ListaDuplaEncadeada()
      {
         head = null;
         tail = null;
         tamanho = 0;
      }

      public bool InserirNoInicio(string codigo, string nome, int cargaHoraria)
      {
         try
         {
            Node novo = new Node(codigo, nome, cargaHoraria);
            if (EstaVazia())
            {
               head = tail = novo;
            }
            else
            {
               novo.NoProximo = head;
               head.NoAnterior = novo;
               head = novo;
            }
            tamanho++;
            return true;
         }
         catch
         {
            return false;
         }
      }

      public bool InserirNoFim(string codigo, string nome, int cargaHoraria)
      {
         try
         {
            Node novo = new Node(codigo, nome, cargaHoraria);
            if (EstaVazia())
            {
               head = tail = novo;
            }
            else
            {
               tail.NoProximo = novo;
               novo.NoAnterior = tail;
               tail = novo;
            }
            tamanho++;
            return true;
         }
         catch
         {
            return false;
         }
      }

      public bool InserirNaPosicao(string codigo, string nome, int cargaHoraria, int posicao)
      {
         if (posicao < 0 || posicao > tamanho) return false;
         if (posicao == 0) return InserirNoInicio(codigo, nome, cargaHoraria);
         if (posicao == tamanho) return InserirNoFim(codigo, nome, cargaHoraria);

         try
         {
            Node novo = new Node(codigo, nome, cargaHoraria);
            Node atual = head;
            for (int i = 0; i < posicao - 1; i++)
               atual = atual.NoProximo;

            Node proximo = atual.NoProximo;
            novo.NoProximo = proximo;
            novo.NoAnterior = atual;
            atual.NoProximo = novo;
            if (proximo != null)
               proximo.NoAnterior = novo;

            tamanho++;
            return true;
         }
         catch
         {
            return false;
         }
      }

      public bool RemoverPorCodigo(string codigo)
      {
         if (EstaVazia()) return false;

         Node atual = head;
         while (atual != null && atual.CodigoDisciplina != codigo)
            atual = atual.NoProximo;

         if (atual == null) return false;

         if (atual == head)
         {
            head = atual.NoProximo;
            if (head != null) head.NoAnterior = null;
            else tail = null;
         }
         else if (atual == tail)
         {
            tail = atual.NoAnterior;
            if (tail != null) tail.NoProximo = null;
            else head = null;
         }
         else
         {
            atual.NoAnterior.NoProximo = atual.NoProximo;
            atual.NoProximo.NoAnterior = atual.NoAnterior;
         }

         tamanho--;
         return true;
      }

      public Node BuscarPorCodigo(string codigo)
      {
         Node atual = head;
         while (atual != null)
         {
            if (atual.CodigoDisciplina == codigo)
               return atual;
            atual = atual.NoProximo;
         }
         return null;
      }

      public bool AtualizarDisciplina(string codigo, string novoNome, int novaCarga)
      {
         Node alvo = BuscarPorCodigo(codigo);
         if (alvo != null)
         {
            alvo.NomeDisciplina = novoNome;
            alvo.CargaHoraria = novaCarga;
            return true;
         }
         return false;
      }

      public void ImprimirLista()
      {
         Console.WriteLine("---- Conteúdo da Lista ----");
         Node atual = head;
         int idx = 0;
         while (atual != null)
         {
            Console.WriteLine($"[{idx}] Código: {atual.CodigoDisciplina} | Nome: {atual.NomeDisciplina} | Carga Horária: {atual.CargaHoraria}");
            atual = atual.NoProximo;
            idx++;
         }
         Console.WriteLine("---------------------------");
      }

      public bool EstaVazia() => tamanho == 0;

      public int Tamanho() => tamanho;
   }
}
