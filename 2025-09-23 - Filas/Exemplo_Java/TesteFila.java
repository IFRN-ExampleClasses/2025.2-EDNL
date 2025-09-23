// ------------------------------------------------------------------------
// TesteFila.java
// Programa principal que demonstra todas as operações da fila.
// ------------------------------------------------------------------------
public class TesteFila {
   public static void main(String[] args) {
      Fila filaDisciplinas = new Fila();

      // Inserções
      System.out.println("Enfileirando disciplinas...");
      filaDisciplinas.enqueue(new Node("TEC.0007", "Programação de Computadores", 120));
      filaDisciplinas.enqueue(new Node("TEC.0027", "Estrutura de Dados Não-Lineares", 80));
      filaDisciplinas.enqueue(new Node("TEC.0142", "Programação para Redes", 120));
      filaDisciplinas.enqueue(new Node("TEC.0022", "Bancos de Dados", 80));
      filaDisciplinas.imprimirLista();
      System.out.println("Tamanho após inserções: " + filaDisciplinas.tamanho() + "\n");

      // Frente
      System.out.println("Elemento da frente: " + filaDisciplinas.front());
      System.out.println("Tamanho permanece: " + filaDisciplinas.tamanho() + "\n");

      // Dequeue
      System.out.println("Desenfileirando elemento da frente...");
      Node removido = filaDisciplinas.dequeue();
      System.out.println("Removido: " + removido);
      filaDisciplinas.imprimirLista();
      System.out.println("Tamanho após dequeue: " + filaDisciplinas.tamanho() + "\n");

      // Busca
      System.out.println("Buscando TEC.0027...");
      Node encontrado = filaDisciplinas.buscarPorCodigo("TEC.0027");
      System.out.println((encontrado != null ? "Encontrado: " + encontrado : "Não encontrado") + "\n");

      // Atualizar
      System.out.println("Atualizando TEC.0027...");
      boolean ok = filaDisciplinas.atualizar("TEC.0027",
         "Estrutura de Dados Não-Lineares - Avançado", 96);
      System.out.println("Atualizado? " + ok);
      filaDisciplinas.imprimirLista();
      System.out.println("Tamanho: " + filaDisciplinas.tamanho() + "\n");

      // Remover por código
      System.out.println("Removendo por código TEC.0142...");
      ok = filaDisciplinas.removerPorCodigo("TEC.0142");
      System.out.println("Removido TEC.0142? " + ok);
      filaDisciplinas.imprimirLista();
      System.out.println("Tamanho: " + filaDisciplinas.tamanho() + "\n");

      // Contains
      System.out.println("Fila contém TEC.0022? " + filaDisciplinas.contains("TEC.0022"));
      System.out.println("Fila contém TEC.0142? " + filaDisciplinas.contains("TEC.0142") + "\n");

      // Limpar
      System.out.println("Esvaziando fila...");
      filaDisciplinas.clear();
      System.out.println("Fila vazia? " + filaDisciplinas.isEmpty());
      System.out.println("Tamanho final: " + filaDisciplinas.tamanho());
   }
}
