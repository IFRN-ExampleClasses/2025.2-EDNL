// ------------------------------------------------------------------------
// Classe TesteListaDuplaEncadeada
// Demonstra o uso da ListaDuplaEncadeada executando as operações básicas.
// Inclui testes para inserirNaPosicao (início, meio, fim e inválido).
// ------------------------------------------------------------------------

public class TesteListaDuplaEncadeada {
   public static void main(String[] args) {
      ListaDuplaEncadeada lista = new ListaDuplaEncadeada();

      System.out.println("== Inserções iniciais ==");
      System.out.println("Inserir INF101 no início: " + lista.inserirNoInicio("INF101", "Algoritmos", 60));
      System.out.println("Inserir INF102 no fim: " + lista.inserirNoFim("INF102", "Estruturas de Dados", 80));
      System.out.println("Inserir INF103 no fim: " + lista.inserirNoFim("INF103", "Banco de Dados", 70));
      lista.imprimirLista();

      System.out.println("\n== Inserir na posição ==");
      System.out.println("Inserir INF150 na pos 1: " + lista.inserirNaPosicao("INF150", "Lógica de Programação", 40, 1));
      System.out.println("Inserir INF100 na pos 0: " + lista.inserirNaPosicao("INF100", "Introdução à Computação", 30, 0));
      System.out.println("Inserir INF200 na pos tamanho: " + lista.inserirNaPosicao("INF200", "Redes", 50, lista.tamanho()));
      lista.imprimirLista();

      System.out.println("\n== Tentativas inválidas ==");
      System.out.println("Inserir em pos -1 (inválido): " + lista.inserirNaPosicao("X", "Inválido", 10, -1));
      System.out.println("Inserir em pos tamanho+1 (inválido): " + lista.inserirNaPosicao("Y", "Inválido", 10, lista.tamanho() + 1));

      System.out.println("\n== Testes de busca/atualização/remoção ==");
      Node buscado = lista.buscarPorCodigo("INF102");
      System.out.println("Busca INF102 encontrada? " + (buscado != null));
      System.out.println("Atualizar INF103: " + lista.atualizarDisciplina("INF103", "Banco de Dados Avançado", 90));
      lista.imprimirLista();

      System.out.println("Remover INF100 (início): " + lista.removerPorCodigo("INF100"));
      System.out.println("Remover INF200 (fim): " + lista.removerPorCodigo("INF200"));
      lista.imprimirLista();

      System.out.println("Tamanho atual da lista: " + lista.tamanho());
   }
}
