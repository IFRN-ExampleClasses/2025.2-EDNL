// ------------------------------------------------------------------------
// TesteFila.cs
// Programa principal que demonstra todas as operações da fila.
// ------------------------------------------------------------------------
using System;

public class TesteFila
{
    public static void Main(string[] args)
    {
        Fila filaDisciplinas = new Fila();

        // Inserções
        Console.WriteLine("Enfileirando disciplinas...");
        filaDisciplinas.Enqueue(new Node("TEC.0007", "Programação de Computadores", 120));
        filaDisciplinas.Enqueue(new Node("TEC.0027", "Estrutura de Dados Não-Lineares", 80));
        filaDisciplinas.Enqueue(new Node("TEC.0142", "Programação para Redes", 120));
        filaDisciplinas.Enqueue(new Node("TEC.0022", "Bancos de Dados", 80));
        filaDisciplinas.ImprimirLista();
        Console.WriteLine($"Tamanho após inserções: {filaDisciplinas.Tamanho()}\n");

        // Frente
        Console.WriteLine($"Elemento da frente: {filaDisciplinas.Front()}");
        Console.WriteLine($"Tamanho permanece: {filaDisciplinas.Tamanho()}\n");

        // Dequeue
        Console.WriteLine("Desenfileirando elemento da frente...");
        Node removido = filaDisciplinas.Dequeue();
        Console.WriteLine($"Removido: {removido}");
        filaDisciplinas.ImprimirLista();
        Console.WriteLine($"Tamanho após dequeue: {filaDisciplinas.Tamanho()}\n");

        // Busca
        Console.WriteLine("Buscando TEC.0027...");
        Node encontrado = filaDisciplinas.BuscarPorCodigo("TEC.0027");
        Console.WriteLine(encontrado != null ? $"Encontrado: {encontrado}" : "Não encontrado");
        Console.WriteLine();

        // Atualizar
        Console.WriteLine("Atualizando TEC.0027...");
        bool ok = filaDisciplinas.Atualizar("TEC.0027",
            "Estrutura de Dados Não-Lineares - Avançado", 96);
        Console.WriteLine($"Atualizado? {ok}");
        filaDisciplinas.ImprimirLista();
        Console.WriteLine($"Tamanho: {filaDisciplinas.Tamanho()}\n");

        // Remover por código
        Console.WriteLine("Removendo por código TEC.0142...");
        ok = filaDisciplinas.RemoverPorCodigo("TEC.0142");
        Console.WriteLine($"Removido TEC.0142? {ok}");
        filaDisciplinas.ImprimirLista();
        Console.WriteLine($"Tamanho: {filaDisciplinas.Tamanho()}\n");

        // Contains
        Console.WriteLine($"Fila contém TEC.0022? {filaDisciplinas.Contains("TEC.0022")}");
        Console.WriteLine($"Fila contém TEC.0142? {filaDisciplinas.Contains("TEC.0142")}\n");

        // Limpar
        Console.WriteLine("Esvaziando fila...");
        filaDisciplinas.Clear();
        Console.WriteLine($"Fila vazia? {filaDisciplinas.IsEmpty()}");
        Console.WriteLine($"Tamanho final: {filaDisciplinas.Tamanho()}");
    }
}
