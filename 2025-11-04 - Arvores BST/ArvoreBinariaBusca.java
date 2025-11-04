// Note que a classe exige <T extends Comparable<T>>
public class ArvoreBinariaBusca<T extends Comparable<T>> implements ArvoreBinariaBuscaInterface<T> {

   private NoBinario<T> raiz;

   // Construtor
   public ArvoreBinariaBusca() {
      this.raiz = null;
   }

   @Override
   public void inserirNo(T dado) {

   } 

   @Override
   public NoBinario<T> buscarNo(T dado) {

   }

   @Override
   public void excluirNo(T dado) {

   }

   @Override
   public void imprimirPreOrdem() {

   }

   @Override
   public void imprimirPosOrdem() {

   }

   @Override
   public void imprimirNaOrdem() {

   }

   @Override
   public NoBinario<T> getRaiz() { 

   }

   @Override
   public boolean isVazia() { 

   }
}