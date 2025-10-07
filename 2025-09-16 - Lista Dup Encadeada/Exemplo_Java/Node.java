// ------------------------------------------------------------------------
// Classe Node
// Representa um nó da lista duplamente encadeada, armazenando dados
// da disciplina e referências para o próximo e o anterior.
// ------------------------------------------------------------------------

public class Node {

   // Campos de dados
   private String codigoDisciplina;
   private String nomeDisciplina;
   private int cargaHoraria;

   // Referências para os nós vizinhos
   private Node noProximo;
   private Node noAnterior;

   // Construtor
   public Node(String codigoDisciplina, String nomeDisciplina, int cargaHoraria) {
      this.codigoDisciplina = codigoDisciplina;
      this.nomeDisciplina = nomeDisciplina;
      this.cargaHoraria = cargaHoraria;
      this.noProximo = null;
      this.noAnterior = null;
   }

   // Métodos getters e setters
   public String getCodigoDisciplina() { return codigoDisciplina; }
   public void setCodigoDisciplina(String codigoDisciplina) { this.codigoDisciplina = codigoDisciplina; }

   public String getNomeDisciplina() { return nomeDisciplina; }
   public void setNomeDisciplina(String nomeDisciplina) { this.nomeDisciplina = nomeDisciplina; }

   public int getCargaHoraria() { return cargaHoraria; }
   public void setCargaHoraria(int cargaHoraria) { this.cargaHoraria = cargaHoraria; }

   public Node getNoProximo() { return noProximo; }
   public void setNoProximo(Node noProximo) { this.noProximo = noProximo; }

   public Node getNoAnterior() { return noAnterior; }
   public void setNoAnterior(Node noAnterior) { this.noAnterior = noAnterior; }
}
