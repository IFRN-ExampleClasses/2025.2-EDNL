// ------------------------------------------------------------------------
// Pilha.cs
// Implementação da pilha encadeada (LIFO) que implementa PilhaInterface.
// Mantém atributo 'tamanho' otimizado.
// ------------------------------------------------------------------------
using System;

public class Pilha : PilhaInterface
{
   // ---------------------------------------------------------------------
   // Atributos privados
   // ---------------------------------------------------------------------
   private Node topo;
   private int tamanho;

   // ---------------------------------------------------------------------
   // Construtor
   // ---------------------------------------------------------------------
   public Pilha()
   {
      topo = null;
      tamanho = 0;
   }

   // ---------------------------------------------------------------------
   // Push: insere no topo da pilha
   // ---------------------------------------------------------------------
   public bool Push(Node novo)
   {
      if (novo == null) return false;
      novo.Next = topo;
      topo = novo;
      tamanho++;
      return true;
   }

   // ---------------------------------------------------------------------
   // Pop: remove e retorna o nó do topo
   // ---------------------------------------------------------------------
   public Node Pop()
   {
      if (IsEmpty()) return null;
      Node removido = topo;
      topo = topo.Next;
      removido.Next = null;
      tamanho--;
      return removido;
   }

   // ---------------------------------------------------------------------
   // Peek: retorna o topo sem remover
   // ---------------------------------------------------------------------
   public Node Peek()
   {
      return topo;
   }

   // ---------------------------------------------------------------------
   // IsEmpty: verifica se a pilha está vazia
   // ---------------------------------------------------------------------
   public bool IsEmpty()
   {
      return topo == null;
   }

   // ---------------------------------------------------------------------
   // Tamanho: retorna o atributo tamanho
   // ---------------------------------------------------------------------
   public int Tamanho()
   {
      return tamanho;
   }

   // ---------------------------------------------------------------------
   // ImprimirLista: imprime a pilha do topo para o fundo
   // ---------------------------------------------------------------------
   public void ImprimirLista()
   {
      Console.WriteLine("------ PILHA (topo -> fundo) ------");
      Node atual = topo;
      while (atual != null)
      {
         Console.WriteLine(atual.ToString());
         atual = atual.Next;
      }
      Console.WriteLine("------ FIM DA PILHA ------");
   }

   // ---------------------------------------------------------------------
   // BuscarPorCodigo
   // ---------------------------------------------------------------------
   public Node BuscarPorCodigo(string codigoDisciplina)
   {
      Node atual = topo;
      while (atual != null)
      {
         if (atual.CodigoDisciplina.Equals(codigoDisciplina))
            return atual;
         atual = atual.Next;
      }
      return null;
   }

   // ---------------------------------------------------------------------
   // Contains
   // ---------------------------------------------------------------------
   public bool Contains(string codigoDisciplina)
   {
      return BuscarPorCodigo(codigoDisciplina) != null;
   }

   // ---------------------------------------------------------------------
   // Atualizar
   // ---------------------------------------------------------------------
   public bool Atualizar(string codigoDisciplina, string novoNome, int novaCarga)
   {
      Node alvo = BuscarPorCodigo(codigoDisciplina);
      if (alvo == null) return false;
      alvo.NomeDisciplina = novoNome;
      alvo.CargaHoraria = novaCarga;
      return true;
   }

   // ---------------------------------------------------------------------
   // RemoverPorCodigo
   // ---------------------------------------------------------------------
   public bool RemoverPorCodigo(string codigoDisciplina)
   {
      if (IsEmpty()) return false;

      if (topo.CodigoDisciplina.Equals(codigoDisciplina))
      {
         Node removido = Pop();
         return removido != null;
      }

      Node anterior = topo;
      Node atual = topo.Next;
      while (atual != null)
      {
         if (atual.CodigoDisciplina.Equals(codigoDisciplina))
         {
            anterior.Next = atual.Next;
            atual.Next = null;
            tamanho--;
            return true;
         }
         anterior = atual;
         atual = atual.Next;
      }
      return false;
   }

   // ---------------------------------------------------------------------
   // Clear
   // ---------------------------------------------------------------------
   public void Clear()
   {
      while (!IsEmpty())
      {
         Pop();
      }
   }
}
