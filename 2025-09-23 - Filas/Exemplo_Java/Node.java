// ------------------------------------------------------------------------
// Node.java
// Nó da fila, representando uma disciplina.
// ------------------------------------------------------------------------
public class Node {
   private String codigoDisciplina;
   private String nomeDisciplina;
   private int cargaHoraria;
   private Node next;

   // ---------------------------------------------------------------------
   // Construtor
   // ---------------------------------------------------------------------
   public Node(String codigoDisciplina, String nomeDisciplina, int cargaHoraria) {
      this.codigoDisciplina = codigoDisciplina;
      this.nomeDisciplina = nomeDisciplina;
      this.cargaHoraria = cargaHoraria;
      this.next = null;
   }

   // ---------------------------------------------------------------------
   // Getters e Setters
   // ---------------------------------------------------------------------
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

   public Node getNext() {
      return next;
   }
   public void setNext(Node next) {
      this.next = next;
   }

   // ---------------------------------------------------------------------
   @Override
   public String toString() {
      return "[codigo:" + codigoDisciplina +
             " | nome:" + nomeDisciplina +
             " | carga:" + cargaHoraria + "]";
   }
}
