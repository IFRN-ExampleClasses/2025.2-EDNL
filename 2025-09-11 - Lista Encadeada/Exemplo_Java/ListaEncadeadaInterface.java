// ------------------------------------------------------------------------
// Interface da Lista Encadeada
// Todos os métodos retornam booleano (exceto imprimirLista e tamanho)
// ------------------------------------------------------------------------
public interface ListaEncadeadaInterface {
   boolean inserirNoInicio(String codigoDisciplina, String nomeDisciplina, int cargaHoraria);
   boolean inserirNoFim(String codigoDisciplina, String nomeDisciplina, int cargaHoraria);
   boolean inserirNaPosicao(int posicao, String codigoDisciplina, String nomeDisciplina, int cargaHoraria);
   boolean removerPorCodigo(String codigoDisciplina);
   boolean buscarPorCodigo(String codigoDisciplina);
   boolean atualizarDisciplina(String codigoDisciplina, String novoNome, int novaCargaHoraria);
   void imprimirLista();
   int tamanho();
   boolean estaVazia();
}
