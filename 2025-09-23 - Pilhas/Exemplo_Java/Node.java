// ------------------------------------------------------------------------
// Node.java
// Representa um nó/elemento da pilha contendo dados da disciplina.
// Campos: codigoDisciplina, nomeDisciplina, cargaHoraria
// Atributos privados com getters e setters.
// Contém referência para o próximo nó (next) para permitir encadeamento.
// ------------------------------------------------------------------------
public class Node {
   // ---------------------------------------------------------------------
   // Atributos privados
   // ---------------------------------------------------------------------
   private String codigoDisciplina;
   private String nomeDisciplina;
   private int cargaHoraria;
   private Node next; // referência para o próximo nó (pilha encadeada)

   // ---------------------------------------------------------------------
   // Construtores
   // ---------------------------------------------------------------------
   public Node() {
      this.codigoDisciplina = "";
      this.nomeDisciplina = "";
      this.cargaHoraria = 0;
      this.next = null;
   }

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
   // toString
   // Representação textual do nó (útil para imprimir)
   // ---------------------------------------------------------------------
   @Override
   public String toString() {
      return String.format("[codigo:%s | nome:%s | carga:%d]",
         codigoDisciplina, nomeDisciplina, cargaHoraria);
   }
}