// ------------------------------------------------------------------------
// ListaPrioridade.java
// Implementação da Lista de Prioridade baseada no semestre
// ------------------------------------------------------------------------
public class ListaPrioridade implements ListaPrioridadeInterface {

   private Node inicio;   // Primeiro nó da lista
   private int tamanho;   // Controle do tamanho da lista

   // ---------------------------------------------------------------------
   // Construtor
   // ---------------------------------------------------------------------
   public ListaPrioridade() {
      this.inicio = null;
      this.tamanho = 0;
   }

   // ---------------------------------------------------------------------
   // Inserir nó mantendo a prioridade (menor semestre = maior prioridade)
   // ---------------------------------------------------------------------
   @Override
   public boolean inserir(Node novoNode) {
      if (novoNode == null) return false;

      // Evitar duplicidade de código
      if (buscar(novoNode.getCodigoDisciplina()) != null) return false;

      // Inserção no início se lista vazia ou prioridade maior
      if (inicio == null || novoNode.getSemestre() < inicio.getSemestre()) {
         novoNode.setProximo(inicio);
         inicio = novoNode;
      } else {
         Node atual = inicio;
         while (atual.getProximo() != null && atual.getProximo().getSemestre() <= novoNode.getSemestre()) {
            atual = atual.getProximo();
         }
         novoNode.setProximo(atual.getProximo());
         atual.setProximo(novoNode);
      }

      tamanho++;
      return true;
   }

   // ---------------------------------------------------------------------
   // Remover nó pelo código da disciplina
   // ---------------------------------------------------------------------
   @Override
   public boolean remover(String codigoDisciplina) {
      if (inicio == null || codigoDisciplina == null) return false;

      if (inicio.getCodigoDisciplina().equals(codigoDisciplina)) {
         inicio = inicio.getProximo();
         tamanho--;
         return true;
      }

      Node atual = inicio;
      while (atual.getProximo() != null && !atual.getProximo().getCodigoDisciplina().equals(codigoDisciplina)) {
         atual = atual.getProximo();
      }

      if (atual.getProximo() != null) {
         atual.setProximo(atual.getProximo().getProximo());
         tamanho--;
         return true;
      }

      return false; // Não encontrado
   }

   // ---------------------------------------------------------------------
   // Buscar nó pelo código da disciplina
   // ---------------------------------------------------------------------
   @Override
   public Node buscar(String codigoDisciplina) {
      Node atual = inicio;
      while (atual != null) {
         if (atual.getCodigoDisciplina().equals(codigoDisciplina)) return atual;
         atual = atual.getProximo();
      }
      return null;
   }

   // ---------------------------------------------------------------------
   // Atualizar disciplina existente
   // ---------------------------------------------------------------------
   @Override
   public boolean atualizar(Node nodeAtualizado) {
      if (nodeAtualizado == null) return false;

      Node atual = inicio;
      Node anterior = null;
      while (atual != null) {
         if (atual.getCodigoDisciplina().equals(nodeAtualizado.getCodigoDisciplina())) {
            // Remover o nó atual
            if (anterior == null) {
               inicio = atual.getProximo();
            } else {
               anterior.setProximo(atual.getProximo());
            }
            tamanho--;
            // Reinsere para manter prioridade
            return inserir(nodeAtualizado);
         }
         anterior = atual;
         atual = atual.getProximo();
      }

      return false; // Não encontrado
   }

   // ---------------------------------------------------------------------
   // Imprimir lista completa
   // ---------------------------------------------------------------------
   @Override
   public void imprimirLista() {
      Node atual = inicio;
      System.out.println("Lista de Prioridade:");
      while (atual != null) {
         System.out.println(atual.getCodigoDisciplina() + " – " + atual.getNomeDisciplina() +
            " (" + atual.getCargaHoraria() + "h) - Semestre " + atual.getSemestre());
         atual = atual.getProximo();
      }
   }

   // ---------------------------------------------------------------------
   // Retornar tamanho da lista
   // ---------------------------------------------------------------------
   @Override
   public int tamanho() {
      return tamanho;
   }
}
