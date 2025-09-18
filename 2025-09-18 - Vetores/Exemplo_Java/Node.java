// ------------------------------------------------------------------------
// Node.java
// Classe que representa o elemento do vetor
// Campos: codigoDisciplina (String), nomeDisciplina (String), cargaHoraria (int)
// Atributos privados com getters e setters
// ------------------------------------------------------------------------
public class Node {
   // Atributos privados
   private String codigoDisciplina;
   private String nomeDisciplina;
   private int cargaHoraria;

   // Construtor padrão
   public Node() {
      this.codigoDisciplina = "";
      this.nomeDisciplina = "";
      this.cargaHoraria = 0;
   }

   // Construtor com parâmetros
   public Node(String codigoDisciplina, String nomeDisciplina, int cargaHoraria) {
      this.codigoDisciplina = codigoDisciplina;
      this.nomeDisciplina = nomeDisciplina;
      this.cargaHoraria = cargaHoraria;
   }

   // ---------------------------------------------------------------------
   // Getters e Setters
   // ---------------------------------------------------------------------
   public String getCodigoDisciplina() {
      return this.codigoDisciplina;
   }

   public void setCodigoDisciplina(String codigoDisciplina) {
      this.codigoDisciplina = codigoDisciplina;
   }

   public String getNomeDisciplina() {
      return this.nomeDisciplina;
   }

   public void setNomeDisciplina(String nomeDisciplina) {
      this.nomeDisciplina = nomeDisciplina;
   }

   public int getCargaHoraria() {
      return this.cargaHoraria;
   }

   public void setCargaHoraria(int cargaHoraria) {
      this.cargaHoraria = cargaHoraria;
   }

   // Representação em texto do node (útil para imprimir)
   @Override
   public String toString() {
      return "Node{codigo='" + codigoDisciplina + "', nome='" + nomeDisciplina + "', carga=" + cargaHoraria + "}";
   }
}
