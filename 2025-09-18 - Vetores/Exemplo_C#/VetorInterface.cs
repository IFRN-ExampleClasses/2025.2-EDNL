// ------------------------------------------------------------------------
// VetorInterface.cs
// Interface que declara os métodos em camelCase
// ------------------------------------------------------------------------
public interface VetorInterface
{
   bool inserir(Node item);
   bool inserirEm(Node item, int pos);
   bool removerPorCodigo(string codigo);
   bool removerPorPosicao(int pos);
   Node? buscarPorCodigo(string codigo);
   bool atualizarPorCodigo(string codigo, Node novo);
   void imprimirVetor();
   int tamanho();
   bool estaVazio();
}
