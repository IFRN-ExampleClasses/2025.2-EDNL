// ------------------------------------------------------------------------
// Classe Node (Nó) para a Lista Encadeada
// Campos: codigoDisciplina, nomeDisciplina, cargaHoraria
// Referência: noProximo (próximo nó da lista)
// Atributos privados e métodos getters e setters
// ------------------------------------------------------------------------
public class Node {
   private String codigoDisciplina;
   private String nomeDisciplina;
   private int cargaHoraria;
   private Node noProximo;

   // Construtor
   public Node(String codigoDisciplina, String nomeDisciplina, int cargaHoraria) {
      this.codigoDisciplina = codigoDisciplina;
      this.nomeDisciplina = nomeDisciplina;
      this.cargaHoraria = cargaHoraria;
      this.noProximo = null;
   }

   // Getters e Setters
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

   public Node getNoProximo() {
      return noProximo;
   }

   public void setNoProximo(Node noProximo) {
      this.noProximo = noProximo;
   }
}
