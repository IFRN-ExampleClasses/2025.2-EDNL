// ------------------------------------------------------------------------
// PilhaInterface.cs
// Interface que declara os métodos públicos esperados para a pilha.
// ------------------------------------------------------------------------
public interface PilhaInterface
{
   bool Push(Node novo);                          // insere no topo
   Node Pop();                                    // remove do topo
   Node Peek();                                   // retorna o topo sem remover
   bool IsEmpty();                                // verifica se está vazia
   int Tamanho();                                 // retorna tamanho
   void ImprimirLista();                          // imprime pilha
   Node BuscarPorCodigo(string codigoDisciplina);  // busca nó
   bool Contains(string codigoDisciplina);         // verifica existência
   bool Atualizar(string codigoDisciplina, string novoNome, int novaCarga);
   bool RemoverPorCodigo(string codigoDisciplina);
   void Clear();                                  // esvaziar pilha
}
