public interface ArvoreGenericaInterface<T> {

   // Método público para buscar um nó.
   NoArvore<T> buscarNo(T dado);
   
   // Método para inserir um novo nó como filho de um nó existente.
   void inserirNo(T dadosPai, T dadosFilho) throws Exception;

   // Método para excluir um nó existente.
   boolean excluirNo(T dado);

   // Método para editar o dado de um nó existente.
   boolean editarNo(T dadoAntigo, T dadoNovo);

   // Método para imprimir a árvore em Pré-Ordem.
   void imprimirPreOrdem();

   // Método para imprimir a árvore em Pós-Ordem.
   void imprimirPosOrdem();

   // Método para imprimir a árvore em Em-Ordem.
   void imprimirNaOrdem();

   // Método para obter o tamanho da árvore (número de nós).
   int getTamanho();

   // Método para obter a altura da árvore.
   int getAltura();

   // Método para obter a referência ao nó raiz.
   NoArvore<T> getRaiz();
   
   // Método para verificar se a árvore está vazia.
   boolean isVazia();
}