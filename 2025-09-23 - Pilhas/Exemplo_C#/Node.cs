// ------------------------------------------------------------------------
// Node.cs
// Representa um nó/elemento da pilha contendo dados da disciplina.
// ------------------------------------------------------------------------
public class Node
{
   // ---------------------------------------------------------------------
   // Atributos privados
   // ---------------------------------------------------------------------
   private string codigoDisciplina;
   private string nomeDisciplina;
   private int cargaHoraria;
   private Node next; // referência para o próximo nó

   // ---------------------------------------------------------------------
   // Construtores
   // ---------------------------------------------------------------------
   public Node()
   {
      codigoDisciplina = "";
      nomeDisciplina = "";
      cargaHoraria = 0;
      next = null;
   }

   public Node(string codigoDisciplina, string nomeDisciplina, int cargaHoraria)
   {
      this.codigoDisciplina = codigoDisciplina;
      this.nomeDisciplina = nomeDisciplina;
      this.cargaHoraria = cargaHoraria;
      this.next = null;
   }

   // ---------------------------------------------------------------------
   // Propriedades (getters e setters)
   // ---------------------------------------------------------------------
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

   public Node Next
   {
      get { return next; }
      set { next = value; }
   }

   // ---------------------------------------------------------------------
   // ToString: representação textual do nó
   // ---------------------------------------------------------------------
   public override string ToString()
   {
      return $"[codigo:{codigoDisciplina} | nome:{nomeDisciplina} | carga:{cargaHoraria}]";
   }
}
