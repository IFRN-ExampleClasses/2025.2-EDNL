import java.util.ArrayList;
import java.util.List;

public class NoArvore<T> {

   private T dado;
   private NoArvore<T> pai;
   private List<NoArvore<T>> filhos;

   // Construtor
   public NoArvore(T dado) {
      this.setDado(dado);
      this.filhos = new ArrayList<>();
   }

   // Retorna o dado armazenado neste nó.
   public T getDado() { return this.dado; }

   // Define o dado armazenado neste nó.
   public void setDado(T dado) {
      if (dado == null) {
         throw new IllegalArgumentException("Os dados do nó não podem ser nulos.");
      }
      if (dado instanceof String) {
         if (((String) dado).trim().isEmpty()) {
            throw new IllegalArgumentException("Os dados do nó não podem ser em branco.");
         }
      }
      this.dado = dado;
   }

   // Retorna o nó pai.
   public NoArvore<T> getPai() { return this.pai; }

   // Define o nó pai.
   public void setPai(NoArvore<T> pai) { this.pai = pai; }

   // Retorna a lista de nós filhos.
   public List<NoArvore<T>> getFilhos() { return this.filhos; }
   
   // Adiciona um nó à lista de filhos.
   public void adicionarFilho(NoArvore<T> filho) {
      filho.setPai(this);
      this.filhos.add(filho);
   }
   
   // Remove um nó da lista de filhos.
   public void removerFilho(NoArvore<T> filho) { this.filhos.remove(filho); }
}