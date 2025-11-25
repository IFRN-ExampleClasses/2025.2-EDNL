/**
 * Arquivo...: ArvoreGenericaInterface.java
 * Finalidade: Interface (Contrato) que define as operações
 * de uma Árvore Genérica.
 *
 * Contém métodos para:
 * - Manipulação (inserir, excluir, editar)
 * - Consulta (buscar, getTamanho, getAltura, getRaiz, isVazia)
 * - Caminhamento (imprimirPreOrdem, imprimirPosOrdem, imprimirNaOrdem)
 */
public interface ArvoreGenericaInterface<T> {

   /**
    * Busca um nó na árvore a partir do seu dado.
    * @param dado O dado a ser buscado.
    * @return O objeto NoArvore se for encontrado, ou null se não for.
    */
   NoArvore<T> buscarNo(T dado);
   
   /**
    * Insere um novo nó (filho) associado a um nó já existente (pai).
    * @param dadosPai O dado do nó pai onde o novo nó será inserido.
    * @param dadosFilho O dado do novo nó a ser criado e inserido.
    * @throws Exception Se o nó pai não for encontrado ou os dados do filho
    * forem inválidos (nulos/brancos).
    */
   void inserirNo(T dadosPai, T dadosFilho) throws Exception;

   /**
    * Exclui um nó (e todos os seus descendentes) da árvore.
    * @param dado O dado do nó a ser excluído.
    * @return true se o nó foi encontrado e excluído, false caso contrário.
    */
   boolean excluirNo(T dado);

   /**
    * Altera o dado de um nó já existente.
    * @param dadoAntigo O dado atual do nó que será editado.
    * @param dadoNovo O novo dado para este nó.
    * @return true se o nó foi encontrado e editado, false caso contrário.
    */
   boolean editarNo(T dadoAntigo, T dadoNovo);

   /**
    * Exibe a árvore navegando em "Pré-Ordem".
    */
   void imprimirPreOrdem();

   /**
    * Exibe a árvore navegando em "Pós-Ordem".
    */
   void imprimirPosOrdem();

   /**
    * Exibe a árvore navegando "Em-Ordem" (Adaptado).
    */
   void imprimirNaOrdem();

   /**
    * Retorna a quantidade total de nós na árvore.
    */
   int getTamanho();

   /**
    * Retorna a altura total da árvore.
    */
   int getAltura();

   /**
    * Retorna o nó raiz da árvore.
    */
   NoArvore<T> getRaiz();
   
   /**
    * Verifica se a árvore está vazia (não possui raiz).
    */
   boolean isVazia();
}