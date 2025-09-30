// ------------------------------------------------------------------------
// IDeque.cs
// Interface que declara as operações públicas esperadas para a Deque
// Agora lançando exceções em vez de retornar booleanos
// ------------------------------------------------------------------------
public interface DequeInterface {
   void InserirNoInicio(string codigoDisciplina, string nomeDisciplina, int cargaHoraria);
   void InserirNoFim(string codigoDisciplina, string nomeDisciplina, int cargaHoraria);

   void RemoverDoInicio();
   void RemoverDoFim();
   void RemoverPorCodigo(string codigoDisciplina);

   Node BuscarPorCodigo(string codigoDisciplina);
   void AtualizarPorCodigo(string codigoDisciplina, string novoNome, int novaCarga);

   void ImprimirDeque();
   int Tamanho();
   bool EstaVazio();
}
