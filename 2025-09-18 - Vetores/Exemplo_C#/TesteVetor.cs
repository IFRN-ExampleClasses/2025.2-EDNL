// ------------------------------------------------------------------------
// TesteVetor.cs
// Programa principal para demonstrar todas as operações
// ------------------------------------------------------------------------

using System;
using Estruturas;

namespace Estruturas

public class TesteVetor
{
   public static void Main()
   {
      Vetor vetor = new Vetor(2);
      Console.WriteLine("=== Teste da estrutura Vetor ===");

      vetor.inserir(new Node("TEC.0007", "Programação de Computadores", 120));
      vetor.inserir(new Node("TEC.0027", "Estrutura de Dados Não-Lineares", 80));
      vetor.inserir(new Node("TEC.0142", "Programação para Redes", 120));
      vetor.inserir(new Node("TEC.0022", "Bancos de Dados", 80));
      vetor.imprimirVetor();

      Console.WriteLine("\n-- Inserção duplicada --");
      Console.WriteLine(vetor.inserir(new Node("TEC.0027", "Duplicado", 30)));
      vetor.imprimirVetor();

      Console.WriteLine("\n-- Inserir em posição 1 --");
      vetor.inserirEm(new Node("TEC.0014", "Programação Orientada a Objetos", 80), 1);
      vetor.imprimirVetor();

      Console.WriteLine("\n-- Atualização válida --");
      vetor.atualizarPorCodigo("TEC.0014",
         new Node("TEC.0014", "Programação Orientada a Objetos", 120));
      vetor.imprimirVetor();

      Console.WriteLine("\n-- Remover por código (TEC.0022) --");
      vetor.removerPorCodigo("TEC.0022");
      vetor.imprimirVetor();

      Console.WriteLine("\n-- Remover por posição 1 --");
      vetor.removerPorPosicao(1);
      vetor.imprimirVetor();

      Console.WriteLine($"\nTamanho final: {vetor.tamanho()}");
      Console.WriteLine($"Está vazio? {vetor.estaVazio()}");
   }
}
