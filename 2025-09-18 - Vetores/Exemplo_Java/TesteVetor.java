// ------------------------------------------------------------------------
// TesteVetor.java
// Programa principal para demonstrar todas as operações da estrutura Vetor
// Inclui testes de códigos duplicados
// ------------------------------------------------------------------------
public class TesteVetor {
   public static void main(String[] args) {
      Vetor vetor = new Vetor(2);

      System.out.println("=== Teste da estrutura Vetor ===");

      // Inserções iniciais
      vetor.inserir(new Node("TEC.0007", "Programação de Computadores", 120));
      vetor.inserir(new Node("TEC.0027", "Estrutura de Dados Não-Lineares", 80));
      vetor.inserir(new Node("TEC.0142", "Programação para Redes", 120));
      vetor.inserir(new Node("TEC.0022", "Bancos de Dados", 80));
      vetor.imprimirVetor();

      // Tentativa de inserir código duplicado
      System.out.println("\n-- Tentativa de inserção duplicada --");
      boolean dup = vetor.inserir(new Node("TEC.0027", "Duplicado", 30));
      System.out.println("Inserção duplicada aceita? " + dup);
      vetor.imprimirVetor();

      // Inserir em posição específica
      System.out.println("\n-- Inserção em posição (1) --");
      vetor.inserirEm(new Node("TEC.0014", "Programação Orientada a Objetos", 80), 1);
      vetor.imprimirVetor();

      // Atualização com novo código duplicado
      System.out.println("\n-- Tentativa de atualização com código duplicado --");
      boolean atualDup = vetor.atualizarPorCodigo("TEC.0027",
            new Node("TEC.0007", "Teste Dup", 120));
      System.out.println("Atualização duplicada aceita? " + atualDup);
      vetor.imprimirVetor();

      // Atualização válida
      System.out.println("\n-- Atualização válida --");
      vetor.atualizarPorCodigo("TEC.0014",
            new Node("TEC.0014", "Programação Orientada a Objetos", 120));
      vetor.imprimirVetor();

      // Remoção por código
      System.out.println("\n-- Remoção por código (TEC.0022) --");
      vetor.removerPorCodigo("TEC.0022");
      vetor.imprimirVetor();

      // Remoção por posição
      System.out.println("\n-- Remoção por posição (1) --");
      vetor.removerPorPosicao(1);
      vetor.imprimirVetor();

      // Verificação final
      System.out.println("\nTamanho final: " + vetor.tamanho());
      System.out.println("Está vazio? " + vetor.estaVazio());
   }
}
