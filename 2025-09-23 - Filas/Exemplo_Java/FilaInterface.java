// ------------------------------------------------------------------------
// FilaInterface.java
// Interface que define as operações básicas da fila.
// ------------------------------------------------------------------------
public interface FilaInterface {
   boolean enqueue(Node novo);
   Node dequeue();
   Node front();
   boolean isEmpty();
   int tamanho();
   void imprimirLista();
   Node buscarPorCodigo(String codigoDisciplina);
   boolean contains(String codigoDisciplina);
   boolean atualizar(String codigoDisciplina, String novoNome, int novaCarga);
   boolean removerPorCodigo(String codigoDisciplina);
   void clear();
}
