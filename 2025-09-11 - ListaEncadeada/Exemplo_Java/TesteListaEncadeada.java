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
      lista.inserirNoInicio("MAT101", "Matemática", 60);
      lista.inserirNoFim("FIS101", "Física", 45);
      lista.inserirNoFim("QUI101", "Química", 50);
      lista.inserirNoInicio("POR101", "Português", 40);

      // Inserção em posição
      System.out.println("--- Inserindo disciplina em posição 2 ---");
      lista.inserirNaPosicao(2, "BIO101", "Biologia", 55);

      // Impressão da lista
      lista.imprimirLista();
      System.out.println("Tamanho após inserções: " + lista.tamanho() + "\n");

      // Busca
      System.out.println("--- Buscando disciplina MAT101 ---");
      boolean encontrado = lista.buscarPorCodigo("MAT101");
      System.out.println("Encontrado? " + encontrado);
      System.out.println("Tamanho atual: " + lista.tamanho() + "\n");

      // Atualização
      System.out.println("--- Atualizando carga horária de FIS101 ---");
      boolean atualizado = lista.atualizarDisciplina("FIS101", "Física", 60);
      System.out.println("Atualizado? " + atualizado);
      lista.imprimirLista();
      System.out.println("Tamanho após atualização: " + lista.tamanho() + "\n");

      // Remoção
      System.out.println("--- Removendo disciplina QUI101 ---");
      boolean removido = lista.removerPorCodigo("QUI101");
      System.out.println("Removido? " + removido);
      lista.imprimirLista();
      System.out.println("Tamanho após remoção: " + lista.tamanho() + "\n");

      // Remover outra disciplina
      System.out.println("--- Removendo disciplina POR101 ---");
      lista.removerPorCodigo("POR101");
      lista.imprimirLista();
      System.out.println("Tamanho final da lista: " + lista.tamanho());
   }
}
