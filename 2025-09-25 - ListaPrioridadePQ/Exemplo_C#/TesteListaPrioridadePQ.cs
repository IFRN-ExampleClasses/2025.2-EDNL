using System;

// ------------------------------------------------------------------------
// TesteListaPrioridadePQ.cs
// Programa principal para demonstrar todas as operações da lista de prioridade
// ------------------------------------------------------------------------
class TesteListaPrioridadePQ
{
    static void Main(string[] args)
    {
        ListaPrioridadePQ lista = new ListaPrioridadePQ();

        // -----------------------------------------------------------------
        // Inserção de elementos
        // -----------------------------------------------------------------
        lista.inserir(new Node("TEC.0007", "Programação de Computadores", 120, 1));
        lista.inserir(new Node("TEC.0020", "Estrutura de Dados Lineares", 80, 2));
        lista.inserir(new Node("TEC.0027", "Estrutura de Dados Não-Lineares", 80, 3));
        lista.inserir(new Node("TEC.0142", "Programação para Redes", 120, 3));
        lista.inserir(new Node("TEC.0022", "Bancos de Dados", 80, 1));

        // -----------------------------------------------------------------
        // Imprimir lista
        // -----------------------------------------------------------------
        lista.imprimirLista();
        Console.WriteLine("Tamanho da lista: " + lista.tamanho());
        Console.WriteLine("--------------------------------------");

        // -----------------------------------------------------------------
        // Buscar elemento
        // -----------------------------------------------------------------
        Node busca = lista.buscar("TEC.0020");
        if (busca != null)
        {
            Console.WriteLine("Disciplina encontrada: " + busca.nomeDisciplinaProp);
        }
        else
        {
            Console.WriteLine("Disciplina não encontrada.");
        }
        Console.WriteLine("--------------------------------------");

        // -----------------------------------------------------------------
        // Atualizar disciplina
        // -----------------------------------------------------------------
        lista.atualizar(new Node("TEC.0020", "Estrutura de Dados Lineares Avançada", 100, 2));
        lista.imprimirLista();
        Console.WriteLine("Tamanho da lista após atualização: " + lista.tamanho());
        Console.WriteLine("--------------------------------------");

        // -----------------------------------------------------------------
        // Remover disciplina
        // -----------------------------------------------------------------
        lista.remover("TEC.0007");
        lista.imprimirLista();
        Console.WriteLine("Tamanho da lista após remoção: " + lista.tamanho());
    }
}
