// ------------------------------------------------------------------------
// Interface da Lista Simplesmente Encadeada
// Define os métodos que a implementação deve possuir
// ------------------------------------------------------------------------
public interface ListaEncadeadaInterface
{
   // Inserções
   void InserirNoInicio(int valor);
   void InserirNoFim(int valor);
   void InserirNaPosicao(int valor, int posicao);

   // Remoções
   void RemoverInicio();
   void RemoverPorValor(int valor);
   void RemoverNaPosicao(int posicao);

   // Buscas
   bool BuscarPorValor(int valor);
   int? ObterNaPosicao(int posicao);

   // Atualizações
   void AtualizarPorValor(int valorAntigo, int novoValor);
   void AtualizarNaPosicao(int posicao, int novoValor);

   // Impressão
   void ImprimirLista();
}
