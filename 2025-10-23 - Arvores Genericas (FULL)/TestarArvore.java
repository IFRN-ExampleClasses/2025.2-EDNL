/**
 * Arquivo...: TestarArvore.java
 * Finalidade: Ponto de entrada principal da aplicação.
 * Contém o loop do menu, coleta a entrada do usuário
 * e chama a classe MenuArvore para executar as ações.
 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class TestarArvore {

   public static void main(String[] args) {
      
      ArvoreGenerica<String> arvoreLinux = null;
      int opcao = -1;
      
      // Variáveis temporárias para leitura
      String pai, filho, dadoAntigo, dadoNovo, dado;

      // Inicializar o Scanner
      try (Scanner scanner = new Scanner(System.in)) {

         // Loop principal do menu
         while (opcao != 0) {
            
            // Exibir o menu
            System.out.println("\n--- Menu de Opções da Árvore ---");
            System.out.println("1. Criar Árvore Padrão (Organograma)");
            System.out.println("2. Inserir Nó");
            System.out.println("3. Excluir Nó");
            System.out.println("4. Editar Nó");
            System.out.println("5. Buscar Nó");
            System.out.println("6. Exibir em Pré-Ordem");
            System.out.println("7. Exibir em Pós-Ordem");
            System.out.println("8. Exibir Em-Ordem (Adaptado)");
            System.out.println("9. Exibir Informações (Tamanho, Altura)");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            
            // Ler e tratar a entrada
            try {
               opcao = scanner.nextInt();
               scanner.nextLine(); // Limpa o buffer

               // Verificar se a árvore existe (guarda-chuva)
               if (arvoreLinux == null && (opcao != 1 && opcao != 0)) {
                  System.out.println("\nERRO: Nenhuma árvore foi criada. Por favor, use a opção 1 primeiro.");
                  continue; // Volta ao início do loop
               }

               // Processar a opção
               switch (opcao) {
                  case 1:
                     // Pergunta ao usuário sobre sobrescrever
                     if (arvoreLinux != null) {
                        System.out.print("Atenção: A árvore atual será perdida. Deseja continuar? (S/N): ");
                        String confirmacao = scanner.nextLine().trim().toUpperCase();
                        if (!confirmacao.equals("S")) {
                           System.out.println("Criação cancelada.");
                           break;
                        }
                     }
                     // Define os argumentos para o método de criação
                     String nomeRaiz = "/";
                     String[][] tuplas = {
                        {"/", "home"}, {"/", "etc"}, {"/", "bin"}, {"/", "usr"},
                        {"home", "user1"}, {"home", "user2"}, {"home", "user3"},
                        {"usr", "bin"}, {"usr", "local"}, {"usr", "sbin"}, {"usr", "tmp"}
                     };
                     // Chama o método de serviço e atualiza a árvore
                     arvoreLinux = MenuArvore.executarCriarArvore(nomeRaiz, tuplas);
                     break;
                  case 2:
                     // Chama o método de serviço
                     MenuArvore.executarInserirNo(arvoreLinux, "home", "user4");
                     break;
                  case 3:
                     // Chama o método de serviço
                     MenuArvore.executarExcluirNo(arvoreLinux, "user2");
                     break;
                  case 4:
                     // Chama o método de serviço
                     MenuArvore.executarEditarNo(arvoreLinux, "user4", "newUser4");
                     break;
                  case 5:
                     // Chama o método de serviço
                     MenuArvore.executarBuscarNo(arvoreLinux, "user4");
                     break;
                  case 6:
                     arvoreLinux.imprimirPreOrdem();
                     break;
                  case 7:
                     arvoreLinux.imprimirPosOrdem();
                     break;
                  case 8:
                     arvoreLinux.imprimirNaOrdem();
                     break;
                  case 9:
                     MenuArvore.executarExibirInformacoes(arvoreLinux);
                     break;
                  case 0:
                     System.out.println("Saindo...");
                     break;
                  default:
                     System.out.println("\nERRO: Opção inválida. Tente novamente.");
               }
               
            } catch (InputMismatchException e) {
               System.out.println("\nERRO: Por favor, digite apenas um número (de 0 a 9).");
               scanner.nextLine(); // Limpa a entrada inválida
               opcao = -1; // Reseta a opção para continuar no loop
            }
         }
         
      } // O scanner é fechado automaticamente aqui
      
      System.out.println("\n--- Programa Finalizado ---");
   }
}