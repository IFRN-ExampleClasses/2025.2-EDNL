// ------------------------------------------------------------------------
// VetorInterface.java
// Interface que declara os métodos públicos esperados para a estrutura Vetor
// ------------------------------------------------------------------------
public interface VetorInterface {
   boolean inserir(Node item);
   boolean inserirEm(Node item, int pos);
   boolean removerPorCodigo(String codigo);
   boolean removerPorPosicao(int pos);
   Node buscarPorCodigo(String codigo);
   boolean atualizarPorCodigo(String codigo, Node novo);
   void imprimirVetor();
   int tamanho();
   boolean estaVazio();
}
