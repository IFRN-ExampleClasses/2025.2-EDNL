// Arquivo: ArvoreGenerica.java
/**
 * Gerencia a árvore como um todo, começando pela raiz.
 */
public class ArvoreGenerica<T> {
   private No<T> raiz;

   public ArvoreGenerica(No<T> raiz) {
      this.raiz = raiz;
   }

   /**
    * Inicia o caminhamento em Pré-Ordem (Raiz -> Filhos).
    */
   public void imprimirPreOrdem() {
      System.out.println("--- Caminhamento em Pré-Ordem ---");
      imprimirPreOrdemRecursivo(this.raiz, 0);
   }

   private void imprimirPreOrdemRecursivo(No<T> noAtual, int nivel) {
      System.out.println("  ".repeat(nivel) + "|- " + noAtual.getDado());
      for (No<T> filho : noAtual.getFilhos()) {
         imprimirPreOrdemRecursivo(filho, nivel + 1);
      }
   }

   /**
    * Inicia o caminhamento em Pós-Ordem (Filhos -> Raiz).
    */
   public void imprimirPosOrdem() {
      System.out.println("\n--- Caminhamento em Pós-Ordem ---");
      imprimirPosOrdemRecursivo(this.raiz, 0);
   }

   private void imprimirPosOrdemRecursivo(No<T> noAtual, int nivel) {
      for (No<T> filho : noAtual.getFilhos()) {
         imprimirPosOrdemRecursivo(filho, nivel + 1);
      }
      System.out.println("  ".repeat(nivel) + "|- " + noAtual.getDado());
   }
}