// ------------------------------------------------------------------------
// Interface ListaDuplaEncadeadaInterface
// Define as operações públicas esperadas para a lista duplamente encadeada.
// ------------------------------------------------------------------------

public interface ListaDuplaEncadeadaInterface {

   boolean inserirNoInicio(String codigo, String nome, int cargaHoraria);

   boolean inserirNoFim(String codigo, String nome, int cargaHoraria);

   boolean inserirNaPosicao(String codigo, String nome, int cargaHoraria, int posicao);

   boolean removerPorCodigo(String codigo);

   Node buscarPorCodigo(String codigo);

   boolean atualizarDisciplina(String codigo, String novoNome, int novaCarga);

   void imprimirLista();

   boolean estaVazia();

   int tamanho();
}
