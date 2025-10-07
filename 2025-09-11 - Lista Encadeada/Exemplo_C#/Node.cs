// ------------------------------------------------------------------------
// Classe Node (Nó) para a Lista Encadeada
// Campos: codigoDisciplina, nomeDisciplina, cargaHoraria
// Referência: noProximo (próximo nó da lista)
// Atributos privados e propriedades públicas (getters/setters)
// ------------------------------------------------------------------------
public class Node
{
   private string codigoDisciplina;
   private string nomeDisciplina;
   private int cargaHoraria;
   private Node noProximo;

   // Construtor
   public Node(string codigoDisciplina, string nomeDisciplina, int cargaHoraria)
   {
      this.codigoDisciplina = codigoDisciplina;
      this.nomeDisciplina = nomeDisciplina;
      this.cargaHoraria = cargaHoraria;
      this.noProximo = null;
   }

   // Propriedades (getters/setters)
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
}
