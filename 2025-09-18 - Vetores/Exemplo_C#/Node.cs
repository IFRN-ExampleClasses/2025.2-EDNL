// ------------------------------------------------------------------------
// Node.cs
// Classe que representa o elemento do vetor
// Campos: codigoDisciplina (string), nomeDisciplina (string), cargaHoraria (int)
// ------------------------------------------------------------------------
public class Node
{
   private string codigoDisciplina;
   private string nomeDisciplina;
   private int cargaHoraria;

   public Node() { }

   public Node(string codigoDisciplina, string nomeDisciplina, int cargaHoraria)
   {
      this.codigoDisciplina = codigoDisciplina;
      this.nomeDisciplina = nomeDisciplina;
      this.cargaHoraria = cargaHoraria;
   }

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

   public override string ToString()
   {
      return $"Node{{codigo='{codigoDisciplina}', nome='{nomeDisciplina}', carga={cargaHoraria}}}";
   }
}
