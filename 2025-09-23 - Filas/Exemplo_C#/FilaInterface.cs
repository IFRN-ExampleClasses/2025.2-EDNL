// ------------------------------------------------------------------------
// FilaInterface.cs
// Interface que define as operações básicas da fila.
// ------------------------------------------------------------------------
public interface FilaInterface
{
    bool Enqueue(Node novo);
    Node Dequeue();
    Node Front();
    bool IsEmpty();
    int Tamanho();
    void ImprimirLista();
    Node BuscarPorCodigo(string codigoDisciplina);
    bool Contains(string codigoDisciplina);
    bool Atualizar(string codigoDisciplina, string novoNome, int novaCarga);
    bool RemoverPorCodigo(string codigoDisciplina);
    void Clear();
}
