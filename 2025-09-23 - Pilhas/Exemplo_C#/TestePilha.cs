// ------------------------------------------------------------------------
// TestePilha.cs
// Programa principal que demonstra todas as operações da pilha.
// Usa a variável pilhaDisciplinas e as disciplinas fornecidas.
// ------------------------------------------------------------------------
using System;

public class TestePilha
{
   public static void Main(string[] args)
   {
      // ------------------------------------------------------------------
      // Cria a pilha
      // ------------------------------------------------------------------
      Pilha pilhaDisciplinas = new Pilha();

      // ------------------------------------------------------------------
      // Inserções (push)
      // ------------------------------------------------------------------
      Console.WriteLine("Inserindo elementos na pilha...");
      pilhaDisciplinas.Push(new Node("TEC.0007", "Programação de Computadores", 120));
      pilhaDisciplinas.Push(new Node("TEC.0027", "Estrutura de Dados Não-Lineares", 80));
      pilhaDisciplinas.Push(new Node("TEC.0142", "Programação para Redes", 120));
      pilhaDisciplinas.Push(new Node("TEC.0022", "Bancos de Dados", 80));
      pilhaDisciplinas.ImprimirLista();
      Console.WriteLine("Tamanho após inserções: " + pilhaDisciplinas.Tamanho());
      Console.WriteLine();

      // Peek
      Console.WriteLine("Peek (topo atual): " + pilhaDisciplinas.Peek());
      Console.WriteLine("Tamanho permanece: " + pilhaDisciplinas.Tamanho());
      Console.WriteLine();

      // Pop
      Console.WriteLine("Removendo (pop) elemento do topo...");
      Node removido = pilhaDisciplinas.Pop();
      Console.WriteLine("Elemento removido: " + removido);
      Console.WriteLine("Tamanho após pop: " + pilhaDisciplinas.Tamanho());
      Console.WriteLine();

      // Busca por código
      string codigoBusca = "TEC.0027";
      Console.WriteLine("Buscando código " + codigoBusca + "...");
      Node encontrado = pilhaDisciplinas.BuscarPorCodigo(codigoBusca);
      Console.WriteLine(encontrado != null
         ? "Encontrado: " + encontrado
         : "Código " + codigoBusca + " não encontrado.");
      Console.WriteLine();

      // Atualização
      Console.WriteLine("Atualizando TEC.0027 (novo nome e nova carga)...");
      bool atualizado = pilhaDisciplinas.Atualizar(
         "TEC.0027",
         "Estrutura de Dados Não-Lineares - Avançado",
         96
      );
      Console.WriteLine("Atualizado com sucesso? " + atualizado);
      pilhaDisciplinas.ImprimirLista();
      Console.WriteLine("Tamanho: " + pilhaDisciplinas.Tamanho());
      Console.WriteLine();

      // Remoção por código
      Console.WriteLine("Removendo por código TEC.0007...");
      bool removidoPorCodigo = pilhaDisciplinas.RemoverPorCodigo("TEC.0007");
      Console.WriteLine("Removido TEC.0007? " + removidoPorCodigo);
      pilhaDisciplinas.ImprimirLista();
      Console.WriteLine("Tamanho: " + pilhaDisciplinas.Tamanho());
      Console.WriteLine();

      // Contains
      Console.WriteLine("Verificando se existe TEC.0022: " + pilhaDisciplinas.Contains("TEC.0022"));
      Console.WriteLine("Verificando se existe TEC.0007: " + pilhaDisciplinas.Contains("TEC.0007"));
      Console.WriteLine();

      // Clear
      Console.WriteLine("Esvaziando a pilha...");
      pilhaDisciplinas.Clear();
      Console.WriteLine("Pilha vazia? " + pilhaDisciplinas.IsEmpty());
      Console.WriteLine("Tamanho final: " + pilhaDisciplinas.Tamanho());
   }
}
