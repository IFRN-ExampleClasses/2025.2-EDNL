public class NoBinario<T> {

   private T dado;
   private NoBinario<T> pai;
   private NoBinario<T> esquerda;
   private NoBinario<T> direita;

   // Construtor
   public NoBinario(T dado) {
       this.setDado(dado);
       // pai, esquerda e direita são 'null' por padrão
   }

   // Retorna o dado armazenado neste nó.
   public T getDado() { return this.dado; }

   // Define o dado armazenado neste nó.
   public void setDado(T dado) {
      if (dado == null) {
         throw new IllegalArgumentException("Os dados do nó não podem ser nulos.");
      }
      // Validação de String em branco (similar ao original)
      if (dado instanceof String) {
         if (((String) dado).trim().isEmpty()) {
            throw new IllegalArgumentException("Os dados do nó não podem ser em branco.");
         }
     }
     this.dado = dado;
   }

   // Retorna o nó pai.
   public NoBinario<T> getPai() { return this.pai; }

   // Define o nó pai. (Usado internamente pelos setters)
   private void setPai(NoBinario<T> pai) { this.pai = pai; }

   // Retorna o filho da esquerda.
   public NoBinario<T> getEsquerda() { return this.esquerda; }

   // Define o filho da esquerda.
   public void setEsquerda(NoBinario<T> filho) {
      this.esquerda = filho;
      if (filho != null) {
         filho.setPai(this); // "Ligação de baixo para cima"
      }
   }

   // Retorna o filho da direita.
   public NoBinario<T> getDireita() { return this.direita; }

   // Define o filho da direita.
   public void setDireita(NoBinario<T> filho) {
      this.direita = filho;
      if (filho != null) {
         filho.setPai(this); // "Ligação de baixo para cima"
      }
   }
}