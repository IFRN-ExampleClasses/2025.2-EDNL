// ------------------------------------------------------------------------
// DequeInterface.java
// Interface que declara as operações públicas esperadas para a Deque
// Agora, as operações lançam exceções em casos de erro
// ------------------------------------------------------------------------
public interface DequeInterface {
   // Inserção no início (lança IllegalArgumentException se código duplicado)
   void inserirNoInicio(String codigoDisciplina, String nomeDisciplina, int cargaHoraria);

   // Inserção no fim (lança IllegalArgumentException se código duplicado)
   void inserirNoFim(String codigoDisciplina, String nomeDisciplina, int cargaHoraria);

   // Remoção do início (lança NoSuchElementException se vazio)
   void removerDoInicio();

   // Remoção do fim (lança NoSuchElementException se vazio)
   void removerDoFim();

   // Remoção por código (lança NoSuchElementException se não existir)
   void removerPorCodigo(String codigoDisciplina);

   // Busca por código (retorna Node ou lança NoSuchElementException se não existir)
   Node buscarPorCodigo(String codigoDisciplina);

   // Atualização por código (lança NoSuchElementException se não existir)
   void atualizarPorCodigo(String codigoDisciplina, String novoNome, int novaCarga);

   // Imprime a deque
   void imprimirDeque();

   // Retorna o tamanho atual
   int tamanho();

   // Verifica se está vazia
   boolean estaVazio();
}
