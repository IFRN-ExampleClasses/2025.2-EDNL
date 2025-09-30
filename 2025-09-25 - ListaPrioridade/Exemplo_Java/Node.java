// ------------------------------------------------------------------------
// Node.java
// Classe que representa um nó da lista de prioridade
// Cada nó possui código, nome, carga horária e semestre (que define a prioridade)
// ------------------------------------------------------------------------
public class Node {
   // ---------------------------------------------------------------------
   // Atributos privados
   // ---------------------------------------------------------------------
   private String codigoDisciplina;
   private String nomeDisciplina;
   private int cargaHoraria;
   private int semestre;
   private Node proximo; // referência para o próximo nó

   // ---------------------------------------------------------------------
   // Construtor
   // ---------------------------------------------------------------------
   public Node(String codigoDisciplina, String nomeDisciplina, int cargaHoraria, int semestre) {
      this.codigoDisciplina = codigoDisciplina;
      this.nomeDisciplina = nomeDisciplina;
      this.cargaHoraria = cargaHoraria;
      this.semestre = semestre;
      this.proximo = null;
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

   public int getSemestre() {
      return semestre;
   }

   public void setSemestre(int semestre) {
      this.semestre = semestre;
   }

   public Node getProximo() {
      return proximo;
   }

   public void setProximo(Node proximo) {
      this.proximo = proximo;
   }
}
