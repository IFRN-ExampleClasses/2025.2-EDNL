// ------------------------------------------------------------------------
// Fila.java
// Implementação de uma fila encadeada (FIFO) em Java.
// Mantém atributo tamanho otimizado.
// ------------------------------------------------------------------------
public class Fila implements FilaInterface {
   private Node frente;
   private Node tras;
   private int tamanho;

   public Fila() {
      this.frente = null;
      this.tras = null;
      this.tamanho = 0;
   }

   // ---------------------------------------------------------------------
   // enqueue: insere no final da fila
   // ---------------------------------------------------------------------
   @Override
   public boolean enqueue(Node novo) {
      if (novo == null) return false;
      if (tras == null) {
         frente = tras = novo;
      } else {
         tras.setNext(novo);
         tras = novo;
      }
      tamanho++;
      return true;
   }

   // ---------------------------------------------------------------------
   // dequeue: remove e retorna o nó da frente
   // ---------------------------------------------------------------------
   @Override
   public Node dequeue() {
      if (isEmpty()) return null;
      Node removido = frente;
      frente = frente.getNext();
      if (frente == null) tras = null;
      removido.setNext(null);
      tamanho--;
      return removido;
   }

   @Override
   public Node front() {
      return frente;
   }

   @Override
   public boolean isEmpty() {
      return frente == null;
   }

   @Override
   public int tamanho() {
      return tamanho;
   }

   // ---------------------------------------------------------------------
   @Override
   public void imprimirLista() {
      System.out.println("------ FILA (frente -> trás) ------");
      Node atual = frente;
      while (atual != null) {
         System.out.println(atual);
         atual = atual.getNext();
      }
      System.out.println("------ FIM DA FILA ------");
   }

   @Override
   public Node buscarPorCodigo(String codigoDisciplina) {
      Node atual = frente;
      while (atual != null) {
         if (atual.getCodigoDisciplina().equals(codigoDisciplina)) {
            return atual;
         }
         atual = atual.getNext();
      }
      return null;
   }

   @Override
   public boolean contains(String codigoDisciplina) {
      return buscarPorCodigo(codigoDisciplina) != null;
   }

   @Override
   public boolean atualizar(String codigoDisciplina, String novoNome, int novaCarga) {
      Node alvo = buscarPorCodigo(codigoDisciplina);
      if (alvo == null) return false;
      alvo.setNomeDisciplina(novoNome);
      alvo.setCargaHoraria(novaCarga);
      return true;
   }

   // ---------------------------------------------------------------------
   // removerPorCodigo: remove um nó específico (não apenas a frente)
   // ---------------------------------------------------------------------
   @Override
   public boolean removerPorCodigo(String codigoDisciplina) {
      if (isEmpty()) return false;

      // Se é o primeiro
      if (frente.getCodigoDisciplina().equals(codigoDisciplina)) {
         dequeue();
         return true;
      }

      Node anterior = frente;
      Node atual = frente.getNext();
      while (atual != null) {
         if (atual.getCodigoDisciplina().equals(codigoDisciplina)) {
            anterior.setNext(atual.getNext());
            if (atual == tras) tras = anterior;
            atual.setNext(null);
            tamanho--;
            return true;
         }
         anterior = atual;
         atual = atual.getNext();
      }
      return false;
   }

   @Override
   public void clear() {
      while (!isEmpty()) {
         dequeue();
      }
   }
}
