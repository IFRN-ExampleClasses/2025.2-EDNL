using System;
using System.Collections.Generic;

// ------------------------------------------------------------------------
// listaPrioridadePQ.cs
// Implementação da lista de prioridade usando PriorityQueue
// Todos os métodos e variáveis em camelCase
// ------------------------------------------------------------------------
public class ListaPrioridadePQ : ListaPrioridadeInterface
{
    private PriorityQueue<Node, int> pq;

    // Construtor
    public ListaPrioridadePQ()
    {
        pq = new PriorityQueue<Node, int>();
    }

    // ---------------------------------------------------------------------
    // Inserir elemento mantendo a prioridade (menor semestre = maior prioridade)
    // ---------------------------------------------------------------------
    public bool inserir(Node novoNode)
    {
        if (novoNode == null) return false;
        if (buscar(novoNode.codigoDisciplinaProp) != null) return false; // evita duplicidade
        pq.Enqueue(novoNode, novoNode.semestreProp);
        return true;
    }

    // ---------------------------------------------------------------------
    // Remover elemento pelo código da disciplina
    // ---------------------------------------------------------------------
    public bool remover(string codigoDisciplina)
    {
        List<(Node, int)> temp = new List<(Node, int)>();
        bool encontrado = false;

        while (pq.Count > 0)
        {
            pq.TryDequeue(out Node node, out int prioridade);
            if (node.codigoDisciplinaProp == codigoDisciplina)
            {
                encontrado = true;
                continue; // remove este elemento
            }
            temp.Add((node, prioridade));
        }

        foreach (var item in temp)
        {
            pq.Enqueue(item.Item1, item.Item2);
        }

        return encontrado;
    }

    // ---------------------------------------------------------------------
    // Buscar elemento pelo código da disciplina
    // ---------------------------------------------------------------------
    public Node buscar(string codigoDisciplina)
    {
        List<(Node, int)> temp = new List<(Node, int)>();
        Node encontrado = null;

        while (pq.Count > 0)
        {
            pq.TryDequeue(out Node node, out int prioridade);
            if (node.codigoDisciplinaProp == codigoDisciplina)
            {
                encontrado = node;
            }
            temp.Add((node, prioridade));
        }

        foreach (var item in temp)
        {
            pq.Enqueue(item.Item1, item.Item2);
        }

        return encontrado;
    }

    // ---------------------------------------------------------------------
    // Atualizar disciplina existente
    // ---------------------------------------------------------------------
    public bool atualizar(Node nodeAtualizado)
    {
        if (nodeAtualizado == null) return false;
        if (remover(nodeAtualizado.codigoDisciplinaProp))
        {
            return inserir(nodeAtualizado);
        }
        return false;
    }

    // ---------------------------------------------------------------------
    // Imprimir lista completa (ordenada por semestre)
    // ---------------------------------------------------------------------
    public void imprimirLista()
    {
        List<(Node, int)> temp = new List<(Node, int)>();

        Console.WriteLine("Lista de Prioridade (ordenada por semestre):");
        while (pq.Count > 0)
        {
            pq.TryDequeue(out Node node, out int prioridade);
            Console.WriteLine(node.toStringNode());
            temp.Add((node, prioridade));
        }

        foreach (var item in temp)
        {
            pq.Enqueue(item.Item1, item.Item2);
        }
    }

    // ---------------------------------------------------------------------
    // Retornar tamanho da lista
    // ---------------------------------------------------------------------
    public int tamanho()
    {
        return pq.Count;
    }
}
