/**
 * Arquivo...: TestarArvoreCompleta.java
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

      // 1. Inicializar o Scanner
      try (Scanner scanner = new Scanner(System.in)) {

         // 2. Loop principal do menu
         while (opcao != 0) {
            
            // 2.1. Exibir o menu
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
            
            // 2.2. Ler e tratar a entrada
            try {
               opcao = scanner.nextInt();
               scanner.nextLine(); // Limpa o buffer

               // 2.3. Verificar se a árvore existe (guarda-chuva)
               if (arvoreLinux == null && (opcao != 1 && opcao != 0)) {
                  System.out.println("\nERRO: Nenhuma árvore foi criada. Por favor, use a opção 1 primeiro.");
                  continue; // Volta ao início do loop
               }

               // 2.4. Processar a opção
               switch (opcao) {
                  case 1:
                     // sobrescrever se a árvore já existir
                     if (arvoreLinux != null) {
                        String sobrescrever = "S";
                        if (!sobrescrever.equals("S")) {
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
                     MenuArvore.executarInserirNo(arvoreLinux, "home", "user4");
                     break;
                  case 3:
                     MenuArvore.executarExcluirNo(arvoreLinux, "user4");
                     break;
                  case 4:
                     MenuArvore.executarEditarNo(arvoreLinux, "user3", "ednl");
                     break;
                  case 5:
                     MenuArvore.executarBuscarNo(arvoreLinux, "ednl");
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
               scanner.nextLine(); // Limpa o buffer
               opcao = -1;
            }
         }
         
      } // Fim do try
      
      System.out.println("\n--- Programa Finalizado ---");
   }
}