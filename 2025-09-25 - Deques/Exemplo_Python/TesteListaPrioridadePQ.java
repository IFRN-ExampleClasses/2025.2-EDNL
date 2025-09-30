// ------------------------------------------------------------------------
// TesteListaPrioridadePQ.java
// Demonstra todas as operações da lista de prioridade usando PriorityQueue
// ------------------------------------------------------------------------
public class TesteListaPrioridadePQ {

   public static void main(String[] args) {
      ListaPrioridadePQ lista = new ListaPrioridadePQ();

      // Inserção de elementos
      lista.inserir(new Node("TEC.0007", "Programação de Computadores", 120, 1));
      lista.inserir(new Node("TEC.0020", "Estrutura de Dados Lineares", 80, 2));
      lista.inserir(new Node("TEC.0027", "Estrutura de Dados Não-Lineares", 80, 3));
      lista.inserir(new Node("TEC.0142", "Programação para Redes", 120, 3));
      lista.inserir(new Node("TEC.0022", "Bancos de Dados", 80, 1));

      // Imprimir lista
      lista.imprimirLista();
      System.out.println("Tamanho da lista: " + lista.tamanho());
      System.out.println("--------------------------------------");

      // Buscar elemento
      Node busca = lista.buscar("TEC.0020");
      if (busca != null) {
         System.out.println("Disciplina encontrada: " + busca.getNomeDisciplina());
      } else {
         System.out.println("Disciplina não encontrada.");
      }
      System.out.println("--------------------------------------");

      // Atualizar disciplina
      lista.atualizar(new Node("TEC.0020", "Estrutura de Dados Lineares Avançada", 100, 2));
      lista.imprimirLista();
      System.out.println("Tamanho da lista após atualização: " + lista.tamanho());
      System.out.println("--------------------------------------");

      // Remover disciplina
      lista.remover("TEC.0007");
      lista.imprimirLista();
      System.out.println("Tamanho da lista após remoção: " + lista.tamanho());
   }
}
