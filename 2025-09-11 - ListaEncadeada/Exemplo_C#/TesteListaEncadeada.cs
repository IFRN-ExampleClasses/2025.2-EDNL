// ------------------------------------------------------------------------
// Programa principal para testar todas as operações da lista encadeada
// Inclui inserção em posição específica
// ------------------------------------------------------------------------
using System;

public class TesteListaEncadeada
{
   public static void Main(string[] args)
   {
      ListaEncadeada lista = new ListaEncadeada();

      Console.WriteLine("A lista está vazia? " + lista.estaVazia());
      Console.WriteLine("Tamanho inicial: " + lista.tamanho() + "\n");

      // Inserções
      Console.WriteLine("--- Inserindo disciplinas ---");
      lista.inserirNoInicio("MAT101", "Matemática", 60);
      lista.inserirNoFim("FIS101", "Física", 45);
      lista.inserirNoFim("QUI101", "Química", 50);
      lista.inserirNoInicio("POR101", "Português", 40);

      // Inserção em posição
      Console.WriteLine("--- Inserindo disciplina em posição 2 ---");
      lista.inserirNaPosicao(2, "BIO101", "Biologia", 55);

      // Impressão da lista
      lista.imprimirLista();
      Console.WriteLine("Tamanho após inserções: " + lista.tamanho() + "\n");

      // Busca
      Console.WriteLine("--- Buscando disciplina MAT101 ---");
      bool encontrado = lista.buscarPorCodigo("MAT101");
      Console.WriteLine("Encontrado? " + encontrado);
      Console.WriteLine("Tamanho atual: " + lista.tamanho() + "\n");

      // Atualização
      Console.WriteLine("--- Atualizando carga horária de FIS101 ---");
      bool atualizado = lista.atualizarDisciplina("FIS101", "Física", 60);
      Console.WriteLine("Atualizado? " + atualizado);
      lista.imprimirLista();
      Console.WriteLine("Tamanho após atualização: " + lista.tamanho() + "\n");

      // Remoção
      Console.WriteLine("--- Removendo disciplina QUI101 ---");
      bool removido = lista.removerPorCodigo("QUI101");
      Console.WriteLine("Removido? " + removido);
      lista.imprimirLista();
      Console.WriteLine("Tamanho após remoção: " + lista.tamanho() + "\n");

      // Remover outra disciplina
      Console.WriteLine("--- Removendo disciplina POR101 ---");
      lista.removerPorCodigo("POR101");
      lista.imprimirLista();
      Console.WriteLine("Tamanho final da lista: " + lista.tamanho());
   }
}
