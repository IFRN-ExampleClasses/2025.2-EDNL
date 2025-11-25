import java.util.InputMismatchException;
import java.util.Scanner;

public class TestarArvoreBinaria {

   // Método de ajuda para exibir o menu
   public static void exibirMenu() {
      System.out.println("\n--- Menu Árvore Binária (Expressão) ---");
      System.out.println("1. Criar Árvore Padrão (Expressão)");
      System.out.println("2. Inserir Nó (Teste)");
      System.out.println("3. Excluir Nó (Teste)");
      System.out.println("4. Buscar Nó (Teste)");
      System.out.println("5. Imprimir Árvore em Pré-Ordem");
      System.out.println("6. Imprimir Árvore em Pós-Ordem");
      System.out.println("7. Imprimir Árvore em Em-Ordem");
      System.out.println("0. Sair");
      System.out.print("Escolha uma opção: ");
   }

   public static void main(String[] args) { //

      ArvoreBinária<String> arvoreExpressao = null; //
      int opcao = -1; //

      // try-with-resources fecha o scanner automaticamente
      try (Scanner scanner = new Scanner(System.in)) { 

         // Loop principal do menu
         while (opcao != 0) {
            exibirMenu(); // Chama o método de ajuda local

            try {
               opcao = scanner.nextInt(); //
               scanner.nextLine(); // Consome o "Enter"

               // Verifica se a árvore é nula antes de tentar usá-la
               if (arvoreExpressao == null && opcao != 1 && opcao != 0) {
                  System.out.println("\nERRO: Nenhuma árvore foi criada. Por favor, use a opção 1 primeiro.");
                  continue; //
               }

               // Seleciona a ação com base na opção
               switch (opcao) {
                  case 1: // Criar Árvore
                     // Define os argumentos (Pai, Filho, Lado)
                     String nomeRaiz = "*";
                     String[][] tuplas = {
                        { "*", "+", "E" },
                        { "*", "C", "D" },
                        { "+", "A", "E" },
                        { "+", "B", "D" }
                     };
                            
                     System.out.println("\n--- Criando Árvore Padrão ---");
                     // 1. Cria a raiz
                     NoBinario<String> noRaiz = new NoBinario<>(nomeRaiz);
                     // 2. Cria a árvore
                     arvoreExpressao = new ArvoreBinaria<>(noRaiz);
                            
                     // 3. Loop de criação da árvore (Pai, Filho, Lado)
                     for (String[] tupla : tuplas) {
                        // Chama o método DIRETAMENTE no objeto da árvore
                        arvoreExpressao.inserirNo(tupla[0], tupla[1], tupla[2].charAt(0)); 
                     }
                     System.out.println("Árvore inicial construída com sucesso.");
                     arvoreExpressao.imprimirPreOrdem();
                     break;

                     // Os casos a seguir usam valores "hardcoded" para teste
                     case 2: // Inserir Nó (Teste)
                        System.out.println("(Script de Teste: Inserindo 'D' em 'C' na esquerda)");
                        arvoreExpressao.inserirNo("C", "D", 'E'); // Chamada direta
                        break;
                     case 3: // Excluir Nó (Teste)
                        System.out.println("(Script de Teste: Excluindo 'B')");
                        arvoreExpressao.excluirNo("B"); // Chamada direta
                        break;
                     case 4: // Buscar Nó (Teste)
                        System.out.println("(Script de Teste: Buscando '+')");
                        String dadoBusca = "+";
                        NoBinario<String> noEncontrado = arvoreExpressao.buscarNo(dadoBusca);

                        // A lógica de exibição do resultado da busca fica aqui
                        if (noEncontrado != null) { 
                           System.out.println("Nó " + dadoBusca + " encontrado!");
                           String pai = (noEncontrado.getPai() == null) 
                              ? "NENHUM (é a raiz)" 
                              : noEncontrado.getPai().getDado();
                           String esq = (noEncontrado.getEsquerda() == null) ? "null" : noEncontrado.getEsquerda().getDado();
                           String dir = (noEncontrado.getDireita() == null) ? "null" : noEncontrado.getDireita().getDado();

                           System.out.println("Pai: " + pai);
                           System.out.println("Filho Esquerda: " + esq);
                           System.out.println("Filho Direita: " + dir);
                        } else {
                           System.out.println("Nó " + dadoBusca + " não encontrado na árvore."); 
                        }
                        break;

                     // Casos de Impressão (já eram chamadas diretas)
                     case 5:
                        arvoreExpressao.imprimirPreOrdem(); //
                        break;
                     case 6:
                        arvoreExpressao.imprimirPosOrdem(); //
                        break;
                     case 7:
                        arvoreExpressao.imprimirNaOrdem(); //
                        break;
                     case 0: // Sair
                        System.out.println("Saindo..."); //
                        break;
                     default: // Opção Inválida
                        System.out.println("\nERRO: Opção inválida. Tente novamente."); //
                        break;
              }

            } catch (InputMismatchException e) { // Pega erro se digitar "abc"
               System.out.println("\nERRO: Por favor, digite apenas um número (de 0 a 7).");
               scanner.nextLine(); // Limpa a entrada inválida
               opcao = -1; // Garante que o loop continue
            } catch (Exception e) { // Pega erros da Árvore (ex: "Pai não encontrado")
               System.out.println("\nERRO NA OPERAÇÃO DA ÁRVORE: " + e.getMessage());
            }
         } // Fim do while

      } // Fim do try-with-resources

      System.out.println("\n--- Programa Finalizado ---"); //
   }
}