// ------------------------------------------------------------------------
// Interface da Lista Encadeada
// Todos os métodos retornam bool (exceto imprimirLista e tamanho)
// ------------------------------------------------------------------------
public interface ListaEncadeadaInterface
{
   bool inserirNoInicio(string codigoDisciplina, string nomeDisciplina, int cargaHoraria);
   bool inserirNoFim(string codigoDisciplina, string nomeDisciplina, int cargaHoraria);
   bool inserirNaPosicao(int posicao, string codigoDisciplina, string nomeDisciplina, int cargaHoraria);
   bool removerPorCodigo(string codigoDisciplina);
   bool buscarPorCodigo(string codigoDisciplina);
   bool atualizarDisciplina(string codigoDisciplina, string novoNome, int novaCargaHoraria);
   void imprimirLista();
   int tamanho();
   bool estaVazia();
}
