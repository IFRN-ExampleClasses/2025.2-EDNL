// ------------------------------------------------------------------------
// ListaPrioridadePQ.java
// Implementação da Lista de Prioridade usando PriorityQueue
// ------------------------------------------------------------------------
import java.util.PriorityQueue;
import java.util.Iterator;

public class ListaPrioridadePQ implements ListaPrioridadeInterface {

   private PriorityQueue<Node> pq;

   // ---------------------------------------------------------------------
   // Construtor
   // ---------------------------------------------------------------------
   public ListaPrioridadePQ() {
      this.pq = new PriorityQueue<>();
   }

   // ---------------------------------------------------------------------
   // Inserir elemento
   // ---------------------------------------------------------------------
   @Override
   public boolean inserir(Node novoNode) {
      if (novoNode == null) return false;
      // Evitar duplicidade
      if (buscar(novoNode.getCodigoDisciplina()) != null) return false;
      return pq.offer(novoNode);
   }

   // ---------------------------------------------------------------------
   // Remover por código da disciplina
   // ---------------------------------------------------------------------
   @Override
   public boolean remover(String codigoDisciplina) {
      Node node = buscar(codigoDisciplina);
      if (node != null) {
         return pq.remove(node);
      }
      return false;
   }

   // ---------------------------------------------------------------------
   // Buscar por código da disciplina
   // ---------------------------------------------------------------------
   @Override
   public Node buscar(String codigoDisciplina) {
      for (Node node : pq) {
         if (node.getCodigoDisciplina().equals(codigoDisciplina)) return node;
      }
      return null;
   }

   // ---------------------------------------------------------------------
   // Atualizar disciplina existente
   // ---------------------------------------------------------------------
   @Override
   public boolean atualizar(Node nodeAtualizado) {
      if (nodeAtualizado == null) return false;
      if (remover(nodeAtualizado.getCodigoDisciplina())) {
         return inserir(nodeAtualizado);
      }
      return false;
   }

   // ---------------------------------------------------------------------
   // Imprimir lista completa
   // ---------------------------------------------------------------------
   @Override
   public void imprimirLista() {
      // Como PriorityQueue não garante ordem na iteração,
      // copiamos para um array e ordenamos para exibir
      PriorityQueue<Node> copia = new PriorityQueue<>(pq);
      System.out.println("Lista de Prioridade (ordenada por semestre):");
      while (!copia.isEmpty()) {
         System.out.println(copia.poll());
      }
   }

   // ---------------------------------------------------------------------
   // Retornar tamanho
   // ---------------------------------------------------------------------
   @Override
   public int tamanho() {
      return pq.size();
   }
}
