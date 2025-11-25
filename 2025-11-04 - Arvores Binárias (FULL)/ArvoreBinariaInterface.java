public interface ArvoreBinariaInterface<T> {

   // Método público para buscar um nó.
   NoBinario<T> buscarNo(T dado);

   // Método para inserir um novo nó.
   // Precisa saber o pai, o filho, e o LADO ('E' ou 'D')
   void inserirNo(T dadosPai, T dadosFilho, char lado) throws Exception;

   // Método para excluir um nó existente.
   boolean excluirNo(T dado);

   // Método para imprimir a árvore em Pré-Ordem.
   void imprimirPreOrdem();

   // Método para imprimir a árvore em Pós-Ordem.
   void imprimirPosOrdem();

   // Método para imprimir a árvore Em-Ordem.
   void imprimirNaOrdem();

   // Método para obter a referência ao nó raiz.
   NoBinario<T> getRaiz();

   // Método para verificar se a árvore está vazia.
   boolean isVazia();
}