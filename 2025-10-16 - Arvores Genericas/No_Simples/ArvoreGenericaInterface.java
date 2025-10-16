/*
   Arquivo...: ArvoreGenericaInterface.java
   Finalidade: Define a interface para uma árvore genérica,
               especificando todos os métodos públicos essenciais
               para as operações de caminhamento.
*/
public interface ArvoreGenericaInterface<T> {

   // ------------------------------------------------------------
   // --- MÉTODOS DE CAMINHAMENTO ---

   /**
      Inicia o caminhamento em Pré-Ordem (Raiz -> Filhos).
      A implementação deve percorrer a árvore visitando o nó
      atual antes de seus filhos.
   */
   void imprimirPreOrdem();

   /**
      Inicia o caminhamento em Pós-Ordem (Filhos -> Raiz).
      A implementação deve percorrer a árvore visitando os filhos
      de um nó antes do próprio nó.
   */
   void imprimirPosOrdem();

   /**
      Inicia o caminhamento "Em Ordem".
      Para uma árvore genérica, uma convenção comum é:
         1. Visitar a subárvore do primeiro filho.
         2. Visitar a Raiz.
         3. Visitar as subárvores dos filhos restantes.
         Este método deve imprimir os nós em uma única linha.
   */
   void imprimirNaOrdem();

   
   // ------------------------------------------------------------
   // --- MÉTODOS DE BUSCA E INFORMAÇÃO ---

   /**
      Busca por um nó na árvore que contenha o dado especificado.

      @param dado O valor a ser procurado na árvore.
      
      @return O primeiro {@code No<T>} encontrado com o dado,
      ou {@code null} se não for encontrado.
   */
   No<T> buscar(T dado);

   /**
      Calcula a altura da árvore.
      A altura é o comprimento do caminho mais longo da raiz até uma folha.
      Uma árvore com apenas a raiz tem altura 0.
   
      @return Um inteiro representando a altura da árvore.
   */
   int getAltura();

   /**
      Calcula o número total de nós na árvore.
   
      @return O número total de nós.
   */
   int getTamanho();

   /**
      Retorna o nó raiz da árvore.

      @return O nó raiz {@code No<T>}.
   */
   No<T> getRaiz();

   /**
      Verifica se a árvore está vazia (não possui raiz).
   
      @return {@code true} se a árvore estiver vazia, {@code false} caso contrário.
   */
   boolean isVazia();
}