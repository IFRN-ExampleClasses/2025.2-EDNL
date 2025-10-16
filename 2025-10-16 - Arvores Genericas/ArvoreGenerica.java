/*
   Arquivo...: ArvoreGenerica.java
   Finalidade: Representa uma árvore genérica onde cada nó 
               pode ter múltiplos filhos.
               Gerencia a árvore como um todo, começando pela raiz.
*/
public class ArvoreGenerica<T> implements ArvoreGenericaInterface<T> {
   private No<T> raiz;

   public ArvoreGenerica(No<T> raiz) {
      this.raiz = raiz;
   }

   // ------------------------------------------------------------
   // Inicia o caminhamento em Pré-Ordem (Raiz -> Filhos)
   @Override
   public void imprimirPreOrdem() {
      System.out.println("--- Caminhamento em Pré-Ordem ---");
      if (isVazia()) {
         System.out.println("Árvore vazia.");
      } else {
         imprimirPreOrdemRecursivo(this.raiz, 0);
      }      
   }

   private void imprimirPreOrdemRecursivo(No<T> noAtual, int nivel) {
      System.out.println("  ".repeat(nivel) + "|- " + noAtual.getDado());
      for (No<T> filho : noAtual.getFilhos()) {
         imprimirPreOrdemRecursivo(filho, nivel + 1);
      }
   }

   // ------------------------------------------------------------
   // Inicia o caminhamento em Pós-Ordem (Filhos -> Raiz)
   @Override
   public void imprimirPosOrdem() {
      System.out.println("\n--- Caminhamento em Pós-Ordem ---");
      if (isVazia()) {
         System.out.println("Árvore vazia.");
      } else {
         imprimirPosOrdemRecursivo(this.raiz, 0);
      }
   }

   private void imprimirPosOrdemRecursivo(No<T> noAtual, int nivel) {
      for (No<T> filho : noAtual.getFilhos()) {
         imprimirPosOrdemRecursivo(filho, nivel + 1);
      }
      System.out.println("  ".repeat(nivel) + "|- " + noAtual.getDado());
   }

   // ------------------------------------------------------------
   // Verifica se a árvore está vazia (não possui raiz)
   @Override
   public boolean isVazia() {
      return this.raiz == null;
   }
}