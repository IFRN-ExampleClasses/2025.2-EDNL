using System;

// ------------------------------------------------------------------------
// ListaPrioridade.cs
// Implementação da Lista de Prioridade baseada no semestre
// ------------------------------------------------------------------------
public class ListaPrioridade : ListaPrioridadeInterface
{
    private Node inicio;
    private int tamanhoLista;

    public ListaPrioridade()
    {
        this.inicio = null;
        this.tamanhoLista = 0;
    }

    public bool inserir(Node novoNode)
    {
        if (novoNode == null) return false;
        if (buscar(novoNode.codigoDisciplina) != null) return false;

        if (inicio == null || novoNode.semestre < inicio.semestre)
        {
            novoNode.proximo = inicio;
            inicio = novoNode;
        }
        else
        {
            Node atual = inicio;
            while (atual.proximo != null && atual.proximo.semestre <= novoNode.semestre)
            {
                atual = atual.proximo;
            }
            novoNode.proximo = atual.proximo;
            atual.proximo = novoNode;
        }

        tamanhoLista++;
        return true;
    }

    public bool remover(string codigoDisciplina)
    {
        if (inicio == null || codigoDisciplina == null) return false;

        if (inicio.codigoDisciplina.Equals(codigoDisciplina))
        {
            inicio = inicio.proximo;
            tamanhoLista--;
            return true;
        }

        Node atual = inicio;
        while (atual.proximo != null && !atual.proximo.codigoDisciplina.Equals(codigoDisciplina))
        {
            atual = atual.proximo;
        }

        if (atual.proximo != null)
        {
            atual.proximo = atual.proximo.proximo;
            tamanhoLista--;
            return true;
        }

        return false;
    }

    public Node buscar(string codigoDisciplina)
    {
        Node atual = inicio;
        while (atual != null)
        {
            if (atual.codigoDisciplina.Equals(codigoDisciplina)) return atual;
            atual = atual.proximo;
        }
        return null;
    }

    public bool atualizar(Node nodeAtualizado)
    {
        if (nodeAtualizado == null) return false;

        Node atual = inicio;
        Node anterior = null;
        while (atual != null)
        {
            if (atual.codigoDisciplina.Equals(nodeAtualizado.codigoDisciplina))
            {
                if (anterior == null)
                {
                    inicio = atual.proximo;
                }
                else
                {
                    anterior.proximo = atual.proximo;
                }
                tamanhoLista--;
                return inserir(nodeAtualizado);
            }
            anterior = atual;
            atual = atual.proximo;
        }

        return false;
    }

    public void imprimirLista()
    {
        Node atual = inicio;
        Console.WriteLine("Lista de Prioridade:");
        while (atual != null)
        {
            Console.WriteLine(atual.codigoDisciplina + " – " + atual.nomeDisciplina +
                " (" + atual.cargaHoraria + "h) - Semestre " + atual.semestre);
            atual = atual.proximo;
        }
    }

    public int tamanho()
    {
        return tamanhoLista;
    }
}