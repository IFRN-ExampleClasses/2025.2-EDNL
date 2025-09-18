// ------------------------------------------------------------------------
// Programa principal para testar todas as operações da lista encadeada
// Inclui inserção em posição específica
// ------------------------------------------------------------------------
public class TesteListaEncadeada {
   public static void main(String[] args) {
      ListaEncadeada lista = new ListaEncadeada();

      System.out.println("A lista está vazia? " + lista.estaVazia());
      System.out.println("Tamanho inicial: " + lista.tamanho() + "\n");

      // Inserções
      System.out.println("--- Inserindo disciplinas ---");
      lista.inserirNoInicio("TEC.0007", "Programação de Computadores", 120);
      lista.inserirNoFim("TEC.0027", "Estrutura de Dados Não-Lineares", 80);
      lista.inserirNoFim("TEC.0142", "Programação para Redes", 120);
      lista.inserirNoInicio("TEC.0022", "Bancos de Dados", 80);

      // Inserção em posição
      System.out.println("--- Inserindo disciplina em posição 2 ---");
      lista.inserirNaPosicao(2, "TEC.0014", "Programação Orientada a Objetos", 80);

      // Impressão da lista
      lista.imprimirLista();
      System.out.println("Tamanho após inserções: " + lista.tamanho() + "\n");

      // Busca
      System.out.println("--- Buscando disciplina TEC.0027 ---");
      boolean encontrado = lista.buscarPorCodigo("TEC.0027");
      System.out.println("Encontrado? " + encontrado);
      System.out.println("Tamanho atual: " + lista.tamanho() + "\n");

      // Atualização
      System.out.println("--- Atualizando carga horária de TEC.0014 ---");
      boolean atualizado = lista.atualizarDisciplina("TEC.0014", "Programação Orientada a Objetos", 120);
      System.out.println("Atualizado? " + atualizado);
      lista.imprimirLista();
      System.out.println("Tamanho após atualização: " + lista.tamanho() + "\n");

      // Remoção
      System.out.println("--- Removendo disciplina TEC.0022 ---");
      boolean removido = lista.removerPorCodigo("TEC.0022");
      System.out.println("Removido? " + removido);
      lista.imprimirLista();
      System.out.println("Tamanho após remoção: " + lista.tamanho() + "\n");

      // Remover outra disciplina
      System.out.println("--- Removendo disciplina TEC.0015 ---");
      removido = lista.removerPorCodigo("TEC.0015");
      System.out.println("Removido? " + removido);
      lista.imprimirLista();
      System.out.println("Tamanho final da lista: " + lista.tamanho());
   }
}
