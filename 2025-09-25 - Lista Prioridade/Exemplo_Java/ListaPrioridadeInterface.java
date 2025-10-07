// ------------------------------------------------------------------------
// ListaPrioridadeInterface.java
// Interface que define os métodos públicos da lista de prioridade
// ------------------------------------------------------------------------
public interface ListaPrioridadeInterface {
   boolean inserir(Node novoNode);      // Inserir mantendo a prioridade
   boolean remover(String codigoDisciplina); // Remover por código da disciplina
   Node buscar(String codigoDisciplina);    // Buscar por código
   boolean atualizar(Node nodeAtualizado);  // Atualizar disciplina existente
   void imprimirLista();                   // Imprimir todos os elementos
   int tamanho();                          // Retorna o tamanho da lista
}
