// ------------------------------------------------------------------------
// Interface ListaDuplaEncadeadaInterface
// Define os métodos públicos esperados
// ------------------------------------------------------------------------

using System;

namespace Estruturas
{
   public interface ListaDuplaEncadeadaInterface
   {
      bool InserirNoInicio(string codigo, string nome, int cargaHoraria);
      bool InserirNoFim(string codigo, string nome, int cargaHoraria);
      bool InserirNaPosicao(string codigo, string nome, int cargaHoraria, int posicao);
      bool RemoverPorCodigo(string codigo);
      Node BuscarPorCodigo(string codigo);
      bool AtualizarDisciplina(string codigo, string novoNome, int novaCarga);
      void ImprimirLista();
      bool EstaVazia();
      int Tamanho();
   }
}
