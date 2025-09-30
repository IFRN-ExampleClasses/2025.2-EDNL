// ------------------------------------------------------------------------
// TesteDeque.java
// Programa principal que demonstra todas as operações básicas da Deque
// Agora com tratamento de exceções (try/catch)
// ------------------------------------------------------------------------
import java.util.NoSuchElementException;

public class TesteDeque {
   public static void main(String[] args) {
      Deque deque = new Deque();

      System.out.println("=== Inserções iniciais ===");
      try {
         deque.inserirNoFim("TEC.0007", "Programação de Computadores", 120);
         System.out.println("Inserido TEC.0007 no fim.");
      } catch (IllegalArgumentException e) {
         System.out.println("Erro: " + e.getMessage());
      }

      try {
         deque.inserirNoFim("TEC.0027", "Estrutura de Dados Não-Lineares", 80);
         System.out.println("Inserido TEC.0027 no fim.");
      } catch (IllegalArgumentException e) {
         System.out.println("Erro: " + e.getMessage());
      }

      try {
         deque.inserirNoInicio("TEC.0142", "Programação para Redes", 120);
         System.out.println("Inserido TEC.0142 no início.");
      } catch (IllegalArgumentException e) {
         System.out.println("Erro: " + e.getMessage());
      }

      try {
         deque.inserirNoFim("TEC.0022", "Bancos de Dados", 80);
         System.out.println("Inserido TEC.0022 no fim.");
      } catch (IllegalArgumentException e) {
         System.out.println("Erro: " + e.getMessage());
      }

      System.out.println();
      deque.imprimirDeque();
      System.out.println("Tamanho: " + deque.tamanho());
      System.out.println();

      // ---------------------------------------------------------------------
      // Tentativa de inserir duplicado
      // ---------------------------------------------------------------------
      System.out.println("=== Tentativa de inserir duplicado TEC.0027 ===");
      try {
         deque.inserirNoFim("TEC.0027", "Estrutura de Dados Não-Lineares (duplicado)", 80);
      } catch (IllegalArgumentException e) {
         System.out.println("Erro: " + e.getMessage());
      }
      System.out.println();

      // ---------------------------------------------------------------------
      // Busca
      // ---------------------------------------------------------------------
      System.out.println("=== Busca por código TEC.0142 ===");
      try {
         Node buscado = deque.buscarPorCodigo("TEC.0142");
         System.out.println("Encontrado: " + buscado.toString());
      } catch (NoSuchElementException e) {
         System.out.println("Erro: " + e.getMessage());
      }
      System.out.println();

      // ---------------------------------------------------------------------
      // Atualização
      // ---------------------------------------------------------------------
      System.out.println("=== Atualização TEC.0022 ===");
      try {
         deque.atualizarPorCodigo("TEC.0022", "Bancos de Dados Avançados", 90);
         System.out.println("Atualizado TEC.0022 com sucesso.");
      } catch (NoSuchElementException e) {
         System.out.println("Erro: " + e.getMessage());
      }
      System.out.println();

      deque.imprimirDeque();
      System.out.println("Tamanho: " + deque.tamanho());
      System.out.println();

      // ---------------------------------------------------------------------
      // Remoções início e fim
      // ---------------------------------------------------------------------
      System.out.println("=== Remoções do início e do fim ===");
      try {
         deque.removerDoInicio();
         System.out.println("Removido do início.");
      } catch (NoSuchElementException e) {
         System.out.println("Erro: " + e.getMessage());
      }

      try {
         deque.removerDoFim();
         System.out.println("Removido do fim.");
      } catch (NoSuchElementException e) {
         System.out.println("Erro: " + e.getMessage());
      }

      System.out.println();
      deque.imprimirDeque();
      System.out.println("Tamanho: " + deque.tamanho());
      System.out.println();

      // ---------------------------------------------------------------------
      // Remoção por código
      // ---------------------------------------------------------------------
      System.out.println("=== Remoção por código TEC.0027 ===");
      try {
         deque.removerPorCodigo("TEC.0027");
         System.out.println("Removido TEC.0027 com sucesso.");
      } catch (NoSuchElementException e) {
         System.out.println("Erro: " + e.getMessage());
      }
      System.out.println();

      deque.imprimirDeque();
      System.out.println("Tamanho: " + deque.tamanho());
      System.out.println();

      // ---------------------------------------------------------------------
      // Esvaziamento total
      // ---------------------------------------------------------------------
      System.out.println("=== Esvaziamento total ===");
      while (!deque.estaVazio()) {
         try {
            deque.removerDoInicio();
         } catch (NoSuchElementException e) {
            System.out.println("Erro: " + e.getMessage());
         }
      }
      System.out.println("Deque esvaziada. Tamanho: " + deque.tamanho());
      deque.imprimirDeque();
   }
}
