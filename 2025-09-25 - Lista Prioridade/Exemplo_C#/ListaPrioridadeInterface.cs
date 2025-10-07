// ------------------------------------------------------------------------
// ListaPrioridadeInterface.cs
// Interface que define os métodos públicos da lista de prioridade
// ------------------------------------------------------------------------
public interface ListaPrioridadeInterface
{
    bool inserir(Node novoNode);
    bool remover(string codigoDisciplina);
    Node buscar(string codigoDisciplina);
    bool atualizar(Node nodeAtualizado);
    void imprimirLista();
    int tamanho();
}