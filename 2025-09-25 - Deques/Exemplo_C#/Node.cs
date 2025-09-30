// ------------------------------------------------------------------------
// Node.cs
// Classe que representa o nó da Deque (lista duplamente ligada)
// ------------------------------------------------------------------------
public class Node {
   // ---------------------------------------------------------------------
   // Atributos privados
   // ---------------------------------------------------------------------
   private string codigoDisciplina;
   private string nomeDisciplina;
   private int cargaHoraria;

   private Node anterior;
   private Node proximo;

   // ---------------------------------------------------------------------
   // Construtor
   // ---------------------------------------------------------------------
   public Node(string codigoDisciplina, string nomeDisciplina, int cargaHoraria) {
      this.codigoDisciplina = codigoDisciplina;
      this.nomeDisciplina = nomeDisciplina;
      this.cargaHoraria = cargaHoraria;
      this.anterior = null;
      this.proximo = null;
   }

   // ---------------------------------------------------------------------
   // Propriedades (Getters e Setters)
   // ---------------------------------------------------------------------
   public string CodigoDisciplina {
      get { return codigoDisciplina; }
      set { codigoDisciplina = value; }
   }

   public string NomeDisciplina {
      get { return nomeDisciplina; }
      set { nomeDisciplina = value; }
   }

   public int CargaHoraria {
      get { return cargaHoraria; }
      set { cargaHoraria = value; }
   }

   public Node Anterior {
      get { return anterior; }
      set { anterior = value; }
   }

   public Node Proximo {
      get { return proximo; }
      set { proximo = value; }
   }

   // ---------------------------------------------------------------------
   // Representação em string do nó
   // ---------------------------------------------------------------------
   public override string ToString() {
      return $"{codigoDisciplina} – {nomeDisciplina} ({cargaHoraria}h)";
   }
}
