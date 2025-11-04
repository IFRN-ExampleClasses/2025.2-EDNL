// Note que a classe exige <T extends Comparable<T>>
public class ArvoreBinariaBusca<T extends Comparable<T>> implements ArvoreBinariaBuscaInterface<T> {

   private NoBinario<T> raiz;

   // Construtor
   public ArvoreBinariaBusca() {
      this.raiz = null;
   }

   // Implementação do método que insere um nó
   @Override
   public void inserirNo(T dado) {

   } 

   // Implementação do método que busca um nó
   @Override
   public NoBinario<T> buscarNo(T dado) {

   }

   // Implementação do método que exclui um nó
   @Override
   public void excluirNo(T dado) {

   }

   // Implementação do método que imprime a árvore em pré-ordem
   @Override
   public void imprimirPreOrdem() {

   }

   // Implementação do método que imprime a árvore em pós-ordem
   @Override
   public void imprimirPosOrdem() {

   }

   // Implementação do método que imprime a árvore em ordem
   @Override
   public void imprimirNaOrdem() {

   }

   // Implementação do método que retorna a raiz da árvore
   @Override
   public NoBinario<T> getRaiz() { 

   }

   // Implementação do método que verifica se a árvore está vazia
   @Override
   public boolean isVazia() { 

   }
}