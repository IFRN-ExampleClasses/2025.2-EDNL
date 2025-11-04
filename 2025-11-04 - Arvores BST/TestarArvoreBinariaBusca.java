import java.util.InputMismatchException;
import java.util.Scanner;

public class TestarArvoreBinariaBusca {

   public static void exibirMenu() {
      System.out.println("\n--- Menu Árvore Binária de Busca (BST) ---");
      System.out.println("1. Criar Árvore Padrão (Números)");
      System.out.println("2. Inserir Nó (Teste)");
      System.out.println("3. Excluir Nó (Teste - Folha)");
      System.out.println("4. Excluir Nó (Teste - 1 Filho)");
      System.out.println("5. Excluir Nó (Teste - 2 Filhos)");
      System.out.println("6. Buscar Nó (Teste)");
      System.out.println("7. Imprimir em Pré-Ordem");
      System.out.println("8. Imprimir em Pós-Ordem");
      System.out.println("9. Imprimir em Em-Ordem (Ordenado)");
      System.out.println("0. Sair");
      System.out.print("Escolha uma opção: ");
  }

  public static void main(String[] args) {

      // Usaremos <Integer> que já implementa Comparable
      ArvoreBinariaBusca<Integer> arvoreBst = null;
      int opcao = -1;

      try (Scanner scanner = new Scanner(System.in)) {
         while (opcao != 0) {
            exibirMenu();
            try {
               opcao = scanner.nextInt();
               scanner.nextLine(); // Consome o "Enter"
               if (arvoreBst == null && opcao != 1 && opcao != 0) {
                  System.out.println("\nERRO: Nenhuma árvore foi criada. Use a opção 1.");
                  continue;
               }

               switch (opcao) {
                  case 1: // Criar Árvore
                     System.out.println("\n--- Criando Árvore Padrão ---");
                     arvoreBst = new ArvoreBinariaBusca<>();
                     // Valores de exemplo para construir a árvore do Cenário 3
                     int[] valores = { 50, 30, 70, 20, 40, 60, 80 };
                           
                     for (int valor : valores) {
                        System.out.println("Inserindo: " + valor);
                        arvoreBst.inserirNo(valor);
                     }
                        System.out.println("Árvore criada. Impressão Pré-Ordem:");
                        arvoreBst.imprimirPreOrdem();
                        break;

                  case 2: // Inserir Nó
                     System.out.println("(Script de Teste: Inserindo 25)");
                     arvoreBst.inserirNo(25);
                     arvoreBst.imprimirPreOrdem();
                     break;
                        
                  case 3: // Excluir Nó (Folha)
                     System.out.println("(Script de Teste: Excluindo 20 - Cenário 1: Folha)");
                     arvoreBst.excluirNo(20);
                     arvoreBst.imprimirPreOrdem();
                     break;

                  case 4: // Excluir Nó (1 Filho)
                     System.out.println("(Script de Teste: Excluindo 30 - Cenário 2: 1 Filho)");
                     // Nota: Insira 25 (opção 2) antes de rodar este teste
                     arvoreBst.excluirNo(30);
                     arvoreBst.imprimirPreOrdem();
                     break;

                  case 5: // Excluir Nó (2 Filhos)
                     System.out.println("(Script de Teste: Excluindo 70 - Cenário 3: 2 Filhos)");
                     arvoreBst.excluirNo(70); // Sucessor é 80
                     arvoreBst.imprimirPreOrdem();
                     break;

                  case 6: // Buscar Nó
                     System.out.println("(Script de Teste: Buscando 40)");
                     NoBinario<Integer> no = arvoreBst.buscarNo(40);
                     if (no != null) {
                        System.out.println("Nó " + no.getDado() + " encontrado!");
                     } else {
                        System.out.println("Nó não encontrado.");
                     }
                     break;

                  case 7:
                     System.out.println("\n--- Impressão Pré-Ordem ---");
                     arvoreBst.imprimirPreOrdem();
                     break;

                  case 8:
                     System.out.println("\n--- Impressão Pós-Ordem ---");
                     arvoreBst.imprimirPosOrdem();
                     break;

                  case 9:
                     System.out.println("\n--- Impressão Em-Ordem (Ordenada) ---");
                     arvoreBst.imprimirNaOrdem();
                     break;

                  case 0: // Sair
                     System.out.println("Saindo...");
                     break;

                  default: // Opção Inválida
                     System.out.println("\nERRO: Opção inválida.");
                     break;
                  }

            } catch (InputMismatchException e) {
               System.out.println("\nERRO: Por favor, digite apenas um número.");
               scanner.nextLine(); // Limpa a entrada inválida
               opcao = -1; // Garante que o loop continue
            } catch (Exception e) {
               System.out.println("\nERRO NA OPERAÇÃO DA ÁRVORE: " + e.getMessage());
           }
         } // Fim do while

      } // Fim do try-with-resources

      System.out.println("\n--- Programa Finalizado ---");
    }
}