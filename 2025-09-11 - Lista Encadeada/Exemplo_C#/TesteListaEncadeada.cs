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
   lista.inserirNoInicio("TEC.0007", "Programação de Computadores", 120);
   lista.inserirNoFim("TEC.0027", "Estrutura de Dados Não-Lineares", 80);
   lista.inserirNoFim("TEC.0142", "Programação para Redes", 120);
   lista.inserirNoInicio("TEC.0022", "Bancos de Dados", 80);

      // Inserção em posição
      Console.WriteLine("--- Inserindo disciplina em posição 2 ---");
      lista.inserirNaPosicao(2, "TEC.0014", "Programação Orientada a Objetos", 80);

      // Impressão da lista
      lista.imprimirLista();
      Console.WriteLine("Tamanho após inserções: " + lista.tamanho() + "\n");

      // Busca
      Console.WriteLine("--- Buscando disciplina TEC.0027 ---");
      bool encontrado = lista.buscarPorCodigo("TEC.0027");
      Console.WriteLine("Encontrado? " + encontrado);
      Console.WriteLine("Tamanho atual: " + lista.tamanho() + "\n");

      // Atualização
      Console.WriteLine("--- Atualizando carga horária de TEC.0014 ---");
      bool atualizado = lista.atualizarDisciplina("TEC.0014", "Programação Orientada a Objetos", 120);
      Console.WriteLine("Atualizado? " + atualizado);
      lista.imprimirLista();
      Console.WriteLine("Tamanho após atualização: " + lista.tamanho() + "\n");

      // Remoção
      Console.WriteLine("--- Removendo disciplina TEC.0022 ---");
      bool removido = lista.removerPorCodigo("TEC.0022");
      Console.WriteLine("Removido? " + removido);
      lista.imprimirLista();
      Console.WriteLine("Tamanho após remoção: " + lista.tamanho() + "\n");

      // Remover outra disciplina
      Console.WriteLine("--- Removendo disciplina TEC.0015 ---");
      removido = lista.removerPorCodigo("TEC.0015");
      Console.WriteLine("Removido? " + removido);
      lista.imprimirLista();
      Console.WriteLine("Tamanho final da lista: " + lista.tamanho());
   }
}
