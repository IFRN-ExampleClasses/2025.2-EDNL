using System;

// ------------------------------------------------------------------------
// TesteListaPrioridade.cs
// Programa principal para demonstrar todas as operações da lista de prioridade
// ------------------------------------------------------------------------
public class TesteListaPrioridade
{
    public static void Main(string[] args)
    {
        ListaPrioridade lista = new ListaPrioridade();

        lista.inserir(new Node("TEC.0007", "Programação de Computadores", 120, 1));
        lista.inserir(new Node("TEC.0020", "Estrutura de Dados Lineares", 80, 2));
        lista.inserir(new Node("TEC.0027", "Estrutura de Dados Não-Lineares", 80, 3));
        lista.inserir(new Node("TEC.0142", "Programação para Redes", 120, 3));
        lista.inserir(new Node("TEC.0022", "Bancos de Dados", 80, 1));

        lista.imprimirLista();
        Console.WriteLine("Tamanho da lista: " + lista.tamanho());
        Console.WriteLine("--------------------------------------");

        Node busca = lista.buscar("TEC.0020");
        if (busca != null)
        {
            // Alterado para usar a propriedade .nomeDisciplina
            Console.WriteLine("Disciplina encontrada: " + busca.nomeDisciplina);
        }
        else
        {
            Console.WriteLine("Disciplina não encontrada.");
        }
        Console.WriteLine("--------------------------------------");

        lista.atualizar(new Node("TEC.0020", "Estrutura de Dados Lineares Avançada", 100, 2));
        lista.imprimirLista();
        Console.WriteLine("Tamanho da lista após atualização: " + lista.tamanho());
        Console.WriteLine("--------------------------------------");

        lista.remover("TEC.0007");
        lista.imprimirLista();
        Console.WriteLine("Tamanho da lista após remoção: " + lista.tamanho());
    }
}