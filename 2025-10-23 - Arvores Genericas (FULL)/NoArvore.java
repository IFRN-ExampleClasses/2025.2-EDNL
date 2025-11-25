/**
 * Arquivo...: NoArvore.java
 * Finalidade: Representa um Nó (ou "folha") da árvore.
 * Cada nó contém um dado (valor) e uma lista de nós filhos.
 * Usamos Generics <T> para que o nó possa armazenar qualquer tipo de dado.
 */
import java.util.ArrayList;
import java.util.List;

public class NoArvore<T> {

   // --- ATRIBUTOS ---
   // O dado armazenado neste nó (ex: "home")
   private T dado;

   // Referência para o nó "pai" (o nó que está acima deste)
   private NoArvore<T> pai;

   // Lista de nós "filhos" (os nós que estão abaixo deste)
   private List<NoArvore<T>> filhos;

   // --- CONSTRUTOR ---
   /**
    * Cria um novo nó.
    * @param dado O dado a ser armazenado no nó.
    * @throws IllegalArgumentException Se o dado for nulo ou em branco.
    */
   public NoArvore(T dado) {
      // Chama o método 'setDado' para validar e armazenar o dado.
      this.setDado(dado);
      
      // Inicializa a lista de filhos como uma lista vazia.
      this.filhos = new ArrayList<>();
   }

   // --- MÉTODOS GETTERS E SETTERS ---

   /**
    * Retorna o dado armazenado neste nó.
    */
   public T getDado() {
      return this.dado;
   }

   /**
    * Altera o dado armazenado neste nó.
    * Inclui validação para não aceitar valores nulos ou em branco.
    * @param dado O novo dado a ser armazenado.
    * @throws IllegalArgumentException Se o dado for nulo ou em branco.
    */
   public void setDado(T dado) {
      // Verifica se o dado é nulo (inválido)
      if (dado == null) {
         throw new IllegalArgumentException("Os dados do nó não podem ser nulos.");
      }
      
      // Verificação específica se o dado for uma String
      if (dado instanceof String) {
         if (((String) dado).trim().isEmpty()) {
            throw new IllegalArgumentException("Os dados do nó não podem ser em branco.");
         }
      }
      
      // Se passou nas verificações, armazena o dado.
      this.dado = dado;
   }

   /**
    * Retorna o nó pai.
    */
   public NoArvore<T> getPai() {
      return this.pai;
   }

   /**
    * Define quem é o nó pai.
    */
   public void setPai(NoArvore<T> pai) {
      this.pai = pai;
   }

   /**
    * Retorna a lista de nós filhos.
    */
   public List<NoArvore<T>> getFilhos() {
      return this.filhos;
   }
   
   // --- MÉTODOS AUXILIARES ---
   
   /**
    * Adiciona um novo nó à lista de filhos deste nó.
    * @param filho O nó a ser adicionado.
    */
   public void adicionarFilho(NoArvore<T> filho) {
      // Define o "pai" do nó filho como sendo o nó atual ("this")
      filho.setPai(this);
      // Adiciona o filho à lista
      this.filhos.add(filho);
   }
   
   /**
    * Remove um nó da lista de filhos.
    * @param filho O nó a ser removido.
    */
   public void removerFilho(NoArvore<T> filho) {
      // Remove o filho da lista
      this.filhos.remove(filho);
   }
}