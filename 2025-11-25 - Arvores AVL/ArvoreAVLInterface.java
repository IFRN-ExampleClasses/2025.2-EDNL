// A interface agora exige que <T> seja comparável
public interface ArvoreAVLInterface<T extends Comparable<T>> {

   // Inserção simplificada: a árvore decide onde inserir
   void inserirNo(T dado);

   // Busca (a implementação será mais rápida)
   NoBinario<T> buscarNo(T dado);

   // Exclusão (a implementação será mais complexa)
   void excluirNo(T dado);

   // Métodos de Caminhamentos
   void imprimirPreOrdem();
   void imprimirPosOrdem();
   void imprimirNaOrdem(); 

   // Métodos de balanceamento -  FALTA IMPLEMENTAR

   // Métodos de exibição da árvore - FALTA IMPLEMENTAR
   void exibirArvoreTerminal();
   void exibirArvoreGrafica();

   // Métodos diversos
   NoBinario<T> getRaiz();
   boolean isVazia();
}