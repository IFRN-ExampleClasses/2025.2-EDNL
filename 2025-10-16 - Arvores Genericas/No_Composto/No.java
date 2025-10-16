/*
   Arquivo...: No.java
   Finalidade: Representa um nó em uma árvore genérica.
               Cada nó pode ter múltiplos filhos.
*/
import java.util.ArrayList;
import java.util.List;

public class No<T> {
   private T dado;
   private List<No<T>> filhos;

   public No(T dado) {
      this.dado = dado;
      this.filhos = new ArrayList<>();
   }

   public void adicionarFilho(No<T> noFilho) {
      this.filhos.add(noFilho);
   }

   public T getDado() {
      return dado;
   }

   public List<No<T>> getFilhos() {
      return filhos;
   }
}