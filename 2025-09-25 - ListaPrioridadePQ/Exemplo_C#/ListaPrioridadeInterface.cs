// ------------------------------------------------------------------------
// ListaPrioridadeInterface.cs
// Interface que define os métodos da lista de prioridade
// ------------------------------------------------------------------------
public interface ListaPrioridadeInterface
{
    bool inserir(Node novoNode);                  // Inserir mantendo a prioridade
    bool remover(string codigoDisciplina);        // Remover por código da disciplina
    Node buscar(string codigoDisciplina);         // Buscar por código
    bool atualizar(Node nodeAtualizado);          // Atualizar disciplina existente
    void imprimirLista();                         // Imprimir todos os elementos
    int tamanho();                                // Retorna o tamanho da lista
}
