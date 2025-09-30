// ------------------------------------------------------------------------
// Node.java
// Classe que representa o nó da Deque (lista duplamente ligada)
// Campos: codigoDisciplina (String), nomeDisciplina (String), cargaHoraria (int)
// Atributos privados com getters e setters
// ------------------------------------------------------------------------
public class Node {
   // ------------------------------------------------------------------------
   // Atributos privados do nó
   // ------------------------------------------------------------------------
   private String codigoDisciplina;
   private String nomeDisciplina;
   private int cargaHoraria;

   // Referências para a deque (duplamente ligada)
   private Node anterior;
   private Node proximo;

   // ------------------------------------------------------------------------
   // Construtores
   // ------------------------------------------------------------------------
   public Node(String codigoDisciplina, String nomeDisciplina, int cargaHoraria) {
      this.codigoDisciplina = codigoDisciplina;
      this.nomeDisciplina = nomeDisciplina;
      this.cargaHoraria = cargaHoraria;
      this.anterior = null;
      this.proximo = null;
   }

   // ------------------------------------------------------------------------
   // Getters e Setters
   // ------------------------------------------------------------------------
   public String getCodigoDisciplina() {
      return codigoDisciplina;
   }

   public void setCodigoDisciplina(String codigoDisciplina) {
      this.codigoDisciplina = codigoDisciplina;
   }

   public String getNomeDisciplina() {
      return nomeDisciplina;
   }

   public void setNomeDisciplina(String nomeDisciplina) {
      this.nomeDisciplina = nomeDisciplina;
   }

   public int getCargaHoraria() {
      return cargaHoraria;
   }

   public void setCargaHoraria(int cargaHoraria) {
      this.cargaHoraria = cargaHoraria;
   }

   public Node getAnterior() {
      return anterior;
   }

   public void setAnterior(Node anterior) {
      this.anterior = anterior;
   }

   public Node getProximo() {
      return proximo;
   }

   public void setProximo(Node proximo) {
      this.proximo = proximo;
   }

   // ------------------------------------------------------------------------
   // Representação em string do nó (para facilitar impressão)
   // ------------------------------------------------------------------------
   @Override
   public String toString() {
      return codigoDisciplina + " – " + nomeDisciplina + " (" + cargaHoraria + "h)";
   }
}
