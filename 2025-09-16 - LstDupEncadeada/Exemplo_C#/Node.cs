// ------------------------------------------------------------------------
// Classe Node
// Representa um nó da lista duplamente encadeada
// ------------------------------------------------------------------------

using System;

namespace Estruturas
{
   public class Node
   {
      // Atributos privados
      private string codigoDisciplina;
      private string nomeDisciplina;
      private int cargaHoraria;

      private Node noProximo;
      private Node noAnterior;

      // Construtor
      public Node(string codigoDisciplina, string nomeDisciplina, int cargaHoraria)
      {
         this.codigoDisciplina = codigoDisciplina;
         this.nomeDisciplina = nomeDisciplina;
         this.cargaHoraria = cargaHoraria;
         this.noProximo = null;
         this.noAnterior = null;
      }

      // Propriedades públicas (getters e setters)
      public string CodigoDisciplina
      {
         get { return codigoDisciplina; }
         set { codigoDisciplina = value; }
      }

      public string NomeDisciplina
      {
         get { return nomeDisciplina; }
         set { nomeDisciplina = value; }
      }

      public int CargaHoraria
      {
         get { return cargaHoraria; }
         set { cargaHoraria = value; }
      }

      public Node NoProximo
      {
         get { return noProximo; }
         set { noProximo = value; }
      }

      public Node NoAnterior
      {
         get { return noAnterior; }
         set { noAnterior = value; }
      }
   }
}
