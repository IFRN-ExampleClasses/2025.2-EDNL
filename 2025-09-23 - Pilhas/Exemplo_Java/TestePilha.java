// ------------------------------------------------------------------------
// TestePilha.java
// Programa principal que demonstra todas as operações básicas da pilha:
// Inserção (push), Remoção (pop), Busca, Atualização, Impressão e Tamanho.
// ------------------------------------------------------------------------
public class TestePilha {
   public static void main(String[] args) {
      // ------------------------------------------------------------------
      // Cria a pilha
      // ------------------------------------------------------------------
      Pilha pilhaDisciplinas = new Pilha();

      // ------------------------------------------------------------------
      // Inserções (push) com as disciplinas solicitadas
      // ------------------------------------------------------------------
      System.out.println("Inserindo elementos na pilha...");
      pilhaDisciplinas.push(new Node("TEC.0007", "Programação de Computadores", 120));
      pilhaDisciplinas.push(new Node("TEC.0027", "Estrutura de Dados Não-Lineares", 80));
      pilhaDisciplinas.push(new Node("TEC.0142", "Programação para Redes", 120));
      pilhaDisciplinas.push(new Node("TEC.0022", "Bancos de Dados", 80));
      pilhaDisciplinas.imprimirLista();
      System.out.println("Tamanho após inserções: " + pilhaDisciplinas.tamanho());
      System.out.println();

      // ------------------------------------------------------------------
      // Peek (ver topo sem remover)
      // ------------------------------------------------------------------
      System.out.println("Peek (topo atual): " + pilhaDisciplinas.peek());
      System.out.println("Tamanho permanece: " + pilhaDisciplinas.tamanho());
      System.out.println();

      // ------------------------------------------------------------------
      // Pop (remover do topo)
      // ------------------------------------------------------------------
      System.out.println("Removendo (pop) elemento do topo...");
      Node removido = pilhaDisciplinas.pop();
      System.out.println("Elemento removido: " + removido);
      System.out.println("Tamanho após pop: " + pilhaDisciplinas.tamanho());
      System.out.println();

      // ------------------------------------------------------------------
      // Busca por código
      // ------------------------------------------------------------------
      String codigoBusca = "TEC.0027";
      System.out.println("Buscando código " + codigoBusca + "...");
      Node encontrado = pilhaDisciplinas.buscarPorCodigo(codigoBusca);
      if (encontrado != null) {
         System.out.println("Encontrado: " + encontrado);
      } else {
         System.out.println("Código " + codigoBusca + " não encontrado.");
      }
      System.out.println();

      // ------------------------------------------------------------------
      // Atualização
      // ------------------------------------------------------------------
      System.out.println("Atualizando TEC.0027 (novo nome e nova carga)...");
      boolean atualizado = pilhaDisciplinas.atualizar(
            "TEC.0027",
            "Estrutura de Dados Não-Lineares - Avançado",
            96
      );
      System.out.println("Atualizado com sucesso? " + atualizado);
      pilhaDisciplinas.imprimirLista();
      System.out.println("Tamanho: " + pilhaDisciplinas.tamanho());
      System.out.println();

      // ------------------------------------------------------------------
      // Remoção por código (não necessariamente topo)
      // ------------------------------------------------------------------
      System.out.println("Removendo por código TEC.0007...");
      boolean removidoPorCodigo = pilhaDisciplinas.removerPorCodigo("TEC.0007");
      System.out.println("Removido TEC.0007? " + removidoPorCodigo);
      pilhaDisciplinas.imprimirLista();
      System.out.println("Tamanho: " + pilhaDisciplinas.tamanho());
      System.out.println();

      // ------------------------------------------------------------------
      // Verificação contains()
      // ------------------------------------------------------------------
      System.out.println("Verificando se existe TEC.0022: " + pilhaDisciplinas.contains("TEC.0022"));
      System.out.println("Verificando se existe TEC.0007: " + pilhaDisciplinas.contains("TEC.0007"));
      System.out.println();

      // ------------------------------------------------------------------
      // Limpar a pilha (clear)
      // ------------------------------------------------------------------
      System.out.println("Esvaziando a pilha...");
      pilhaDisciplinas.clear();
      System.out.println("Pilha vazia? " + pilhaDisciplinas.isEmpty());
      System.out.println("Tamanho final: " + pilhaDisciplinas.tamanho());
   }
}
