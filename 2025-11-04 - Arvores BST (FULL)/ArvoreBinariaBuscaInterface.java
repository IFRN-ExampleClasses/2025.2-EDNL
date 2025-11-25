// A interface agora exige que <T> seja comparável
public interface ArvoreBinariaBuscaInterface<T extends Comparable<T>> {

   // Inserção simplificada: a árvore decide onde inserir
   void inserirNo(T dado);

   // Busca (a implementação será mais rápida)
   NoBinario<T> buscarNo(T dado);

   // Exclusão (a implementação será mais complexa)
   void excluirNo(T dado);

   // Caminhamentos permanecem iguais
   void imprimirPreOrdem();
   void imprimirPosOrdem();
   void imprimirNaOrdem(); 

   NoBinario<T> getRaiz();
   boolean isVazia();
}