// ------------------------------------------------------------------------
// Interface da Lista Simplesmente Encadeada
// Define os métodos que a implementação deve possuir
// ------------------------------------------------------------------------
public interface ListaEncadeadaInterface
{
   // ---------------------------------------------------------------------
   // Inserções
   void inserirNoInicio(int valor);
   void inserirNoFim(int valor);
   void inserirNaPosicao(int valor, int posicao);

   // ---------------------------------------------------------------------
   // Remoções
   void removerInicio();
   void removerPorValor(int valor);
   void removerNaPosicao(int posicao);

   // ---------------------------------------------------------------------
   // Buscas
   boolean buscarPorValor(int valor);
   Integer obterNaPosicao(int posicao);

   // ---------------------------------------------------------------------
   // Atualizações
   void atualizarPorValor(int valorAntigo, int novoValor);
   void atualizarNaPosicao(int posicao, int novoValor);

   // ---------------------------------------------------------------------
   // Impressão
   void imprimirLista();
}
