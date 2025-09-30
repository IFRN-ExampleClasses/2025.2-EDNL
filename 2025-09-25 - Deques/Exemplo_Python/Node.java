// ------------------------------------------------------------------------
// Node.java
// Classe que representa um nó da lista de prioridade
// Implementa Comparable para ser usada em PriorityQueue
// ------------------------------------------------------------------------
public class Node implements Comparable<Node> {

   private String codigoDisciplina;
   private String nomeDisciplina;
   private int cargaHoraria;
   private int semestre;

   // ---------------------------------------------------------------------
   // Construtor
   // ---------------------------------------------------------------------
   public Node(String codigoDisciplina, String nomeDisciplina, int cargaHoraria, int semestre) {
      this.codigoDisciplina = codigoDisciplina;
      this.nomeDisciplina = nomeDisciplina;
      this.cargaHoraria = cargaHoraria;
      this.semestre = semestre;
   }

   // ---------------------------------------------------------------------
   // Getters e Setters
   // ---------------------------------------------------------------------
   public String getCodigoDisciplina() { return codigoDisciplina; }
   public void setCodigoDisciplina(String codigoDisciplina) { this.codigoDisciplina = codigoDisciplina; }

   public String getNomeDisciplina() { return nomeDisciplina; }
   public void setNomeDisciplina(String nomeDisciplina) { this.nomeDisciplina = nomeDisciplina; }

   public int getCargaHoraria() { return cargaHoraria; }
   public void setCargaHoraria(int cargaHoraria) { this.cargaHoraria = cargaHoraria; }

   public int getSemestre() { return semestre; }
   public void setSemestre(int semestre) { this.semestre = semestre; }

   // ---------------------------------------------------------------------
   // Implementação do Comparable para prioridade (menor semestre = maior prioridade)
   // ---------------------------------------------------------------------
   @Override
   public int compareTo(Node outro) {
      return Integer.compare(this.semestre, outro.semestre);
   }

   @Override
   public String toString() {
      return codigoDisciplina + " – " + nomeDisciplina + " (" + cargaHoraria + "h) - Semestre " + semestre;
   }
}
