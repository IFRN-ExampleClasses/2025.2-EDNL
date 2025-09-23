// ------------------------------------------------------------------------
// Fila.cs
// Implementação de uma fila encadeada (FIFO) em C#.
// Mantém atributo tamanho otimizado.
// ------------------------------------------------------------------------
public class Fila : FilaInterface
{
    private Node frente;
    private Node tras;
    private int tamanho;

    public Fila()
    {
        frente = null;
        tras = null;
        tamanho = 0;
    }

    // ---------------------------------------------------------------------
    // Enqueue: insere no final da fila
    // ---------------------------------------------------------------------
    public bool Enqueue(Node novo)
    {
        if (novo == null) return false;

        if (tras == null)
        {
            frente = tras = novo;
        }
        else
        {
            tras.Next = novo;
            tras = novo;
        }
        tamanho++;
        return true;
    }

    // ---------------------------------------------------------------------
    // Dequeue: remove e retorna o nó da frente
    // ---------------------------------------------------------------------
    public Node Dequeue()
    {
        if (IsEmpty()) return null;

        Node removido = frente;
        frente = frente.Next;
        if (frente == null) tras = null;
        removido.Next = null;
        tamanho--;
        return removido;
    }

    public Node Front()
    {
        return frente;
    }

    public bool IsEmpty()
    {
        return frente == null;
    }

    public int Tamanho()
    {
        return tamanho;
    }

    // ---------------------------------------------------------------------
    public void ImprimirLista()
    {
        Console.WriteLine("------ FILA (frente -> trás) ------");
        Node atual = frente;
        while (atual != null)
        {
            Console.WriteLine(atual);
            atual = atual.Next;
        }
        Console.WriteLine("------ FIM DA FILA ------");
    }

    public Node BuscarPorCodigo(string codigoDisciplina)
    {
        Node atual = frente;
        while (atual != null)
        {
            if (atual.CodigoDisciplina == codigoDisciplina)
                return atual;
            atual = atual.Next;
        }
        return null;
    }

    public bool Contains(string codigoDisciplina)
    {
        return BuscarPorCodigo(codigoDisciplina) != null;
    }

    public bool Atualizar(string codigoDisciplina, string novoNome, int novaCarga)
    {
        Node alvo = BuscarPorCodigo(codigoDisciplina);
        if (alvo == null) return false;
        alvo.NomeDisciplina = novoNome;
        alvo.CargaHoraria = novaCarga;
        return true;
    }

    // ---------------------------------------------------------------------
    // RemoverPorCodigo: remove um nó específico (não apenas a frente)
    // ---------------------------------------------------------------------
    public bool RemoverPorCodigo(string codigoDisciplina)
    {
        if (IsEmpty()) return false;

        if (frente.CodigoDisciplina == codigoDisciplina)
        {
            Dequeue();
            return true;
        }

        Node anterior = frente;
        Node atual = frente.Next;
        while (atual != null)
        {
            if (atual.CodigoDisciplina == codigoDisciplina)
            {
                anterior.Next = atual.Next;
                if (atual == tras) tras = anterior;
                atual.Next = null;
                tamanho--;
                return true;
            }
            anterior = atual;
            atual = atual.Next;
        }
        return false;
    }

    public void Clear()
    {
        while (!IsEmpty())
        {
            Dequeue();
        }
    }
}
