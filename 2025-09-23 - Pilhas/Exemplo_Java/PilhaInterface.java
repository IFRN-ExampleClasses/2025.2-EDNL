// ------------------------------------------------------------------------
// PilhaInterface.java
// Interface que declara os métodos públicos esperados para a pilha.
// ------------------------------------------------------------------------
public interface PilhaInterface {
   // Insere um nó no topo da pilha. Retorna true se inserido com sucesso.
   public boolean push(Node novo);

   // Remove e retorna o nó do topo da pilha. Retorna null se estiver vazia.
   public Node pop();

   // Retorna o nó do topo sem removê-lo. Retorna null se vazia.
   public Node peek();

   // Verifica se a pilha está vazia.
   public boolean isEmpty();

   // Retorna o tamanho (número de elementos) da pilha.
   public int tamanho();

   // Imprime a pilha (do topo para o fundo).
   public void imprimirLista();

   // Busca pelo código da disciplina; retorna o nó encontrado ou null.
   public Node buscarPorCodigo(String codigoDisciplina);

   // Verifica se existe uma disciplina com o código informado.
   // Retorna true se encontrado, false caso contrário.
   public boolean contains(String codigoDisciplina);

   // Atualiza os dados de uma disciplina identificada pelo código.
   // Retorna true se a atualização foi feita, false se não encontrou.
   public boolean atualizar(String codigoDisciplina, String novoNome, int novaCarga);

   // Remove a primeira ocorrência com o código informado. Retorna true se removido.
   public boolean removerPorCodigo(String codigoDisciplina);

   // Remove todos os elementos da pilha (esvaziar).
   public void clear();
}
