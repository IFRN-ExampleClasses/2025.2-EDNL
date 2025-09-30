// ------------------------------------------------------------------------
// Deque.cs
// Implementação de uma Deque (fila dupla) usando lista duplamente ligada
// Implementa IDeque
// ------------------------------------------------------------------------
using System;
using System.Collections.Generic;

public class Deque : DequeInterface {
   private Node inicio;
   private Node fim;
   private int tamanho;

   public Deque() {
      inicio = null;
      fim = null;
      tamanho = 0;
   }

   // ---------------------------------------------------------------------
   // Método utilitário: verifica se código já existe
   // ---------------------------------------------------------------------
   private bool ExisteCodigo(string codigoDisciplina) {
      Node atual = inicio;
      while (atual != null) {
         if (atual.CodigoDisciplina == codigoDisciplina) {
            return true;
         }
         atual = atual.Proximo;
      }
      return false;
   }

   // ---------------------------------------------------------------------
   // Inserção no início
   // ---------------------------------------------------------------------
   public void InserirNoInicio(string codigoDisciplina, string nomeDisciplina, int cargaHoraria) {
      if (ExisteCodigo(codigoDisciplina)) {
         throw new ArgumentException($"Código duplicado: {codigoDisciplina}");
      }
      Node novo = new Node(codigoDisciplina, nomeDisciplina, cargaHoraria);
      if (EstaVazio()) {
         inicio = fim = novo;
      } else {
         novo.Proximo = inicio;
         inicio.Anterior = novo;
         inicio = novo;
      }
      tamanho++;
   }

   // ---------------------------------------------------------------------
   // Inserção no fim
   // ---------------------------------------------------------------------
   public void InserirNoFim(string codigoDisciplina, string nomeDisciplina, int cargaHoraria) {
      if (ExisteCodigo(codigoDisciplina)) {
         throw new ArgumentException($"Código duplicado: {codigoDisciplina}");
      }
      Node novo = new Node(codigoDisciplina, nomeDisciplina, cargaHoraria);
      if (EstaVazio()) {
         inicio = fim = novo;
      } else {
         fim.Proximo = novo;
         novo.Anterior = fim;
         fim = novo;
      }
      tamanho++;
   }

   // ---------------------------------------------------------------------
   // Remover do início
   // ---------------------------------------------------------------------
   public void RemoverDoInicio() {
      if (EstaVazio()) {
         throw new InvalidOperationException("Deque vazia, não é possível remover do início.");
      }
      if (inicio == fim) {
         inicio = fim = null;
      } else {
         inicio = inicio.Proximo;
         inicio.Anterior = null;
      }
      tamanho--;
   }

   // ---------------------------------------------------------------------
   // Remover do fim
   // ---------------------------------------------------------------------
   public void RemoverDoFim() {
      if (EstaVazio()) {
         throw new InvalidOperationException("Deque vazia, não é possível remover do fim.");
      }
      if (inicio == fim) {
         inicio = fim = null;
      } else {
         fim = fim.Anterior;
         fim.Proximo = null;
      }
      tamanho--;
   }

   // ---------------------------------------------------------------------
   // Remover por código
   // ---------------------------------------------------------------------
   public void RemoverPorCodigo(string codigoDisciplina) {
      if (EstaVazio()) {
         throw new InvalidOperationException("Deque vazia, não é possível remover.");
      }
      Node atual = inicio;
      while (atual != null) {
         if (atual.CodigoDisciplina == codigoDisciplina) {
            if (atual == inicio) {
               RemoverDoInicio();
               return;
            }
            if (atual == fim) {
               RemoverDoFim();
               return;
            }
            Node ant = atual.Anterior;
            Node prox = atual.Proximo;
            ant.Proximo = prox;
            prox.Anterior = ant;
            tamanho--;
            return;
         }
         atual = atual.Proximo;
      }
      throw new KeyNotFoundException($"Código não encontrado: {codigoDisciplina}");
   }

   // ---------------------------------------------------------------------
   // Buscar por código
   // ---------------------------------------------------------------------
   public Node BuscarPorCodigo(string codigoDisciplina) {
      Node atual = inicio;
      while (atual != null) {
         if (atual.CodigoDisciplina == codigoDisciplina) {
            return atual;
         }
         atual = atual.Proximo;
      }
      throw new KeyNotFoundException($"Código não encontrado: {codigoDisciplina}");
   }

   // ---------------------------------------------------------------------
   // Atualizar por código
   // ---------------------------------------------------------------------
   public void AtualizarPorCodigo(string codigoDisciplina, string novoNome, int novaCarga) {
      Node encontrado = BuscarPorCodigo(codigoDisciplina);
      encontrado.NomeDisciplina = novoNome;
      encontrado.CargaHoraria = novaCarga;
   }

   // ---------------------------------------------------------------------
   // Imprimir
   // ---------------------------------------------------------------------
   public void ImprimirDeque() {
      Console.WriteLine("Deque (início -> fim):");
      if (EstaVazio()) {
         Console.WriteLine("   [vazia]");
         return;
      }
      Node atual = inicio;
      while (atual != null) {
         Console.WriteLine("   " + atual.ToString());
         atual = atual.Proximo;
      }
   }

   // ---------------------------------------------------------------------
   // Tamanho e estado
   // ---------------------------------------------------------------------
   public int Tamanho() {
      return tamanho;
   }

   public bool EstaVazio() {
      return tamanho == 0;
   }
}
